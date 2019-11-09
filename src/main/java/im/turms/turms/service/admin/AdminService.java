/*
 * Copyright (C) 2019 The Turms Project
 * https://github.com/turms-im/turms
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package im.turms.turms.service.admin;

import com.hazelcast.replicatedmap.ReplicatedMap;
import com.mongodb.client.result.DeleteResult;
import com.mongodb.client.result.UpdateResult;
import im.turms.turms.annotation.cluster.PostHazelcastInitialized;
import im.turms.turms.cluster.TurmsClusterManager;
import im.turms.turms.common.*;
import im.turms.turms.constant.AdminPermission;
import im.turms.turms.exception.TurmsBusinessException;
import im.turms.turms.pojo.domain.Admin;
import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.data.mongodb.core.ReactiveMongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import javax.annotation.Nullable;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.function.Function;

import static im.turms.turms.common.Constants.*;

@Service
public class AdminService {
    private static final String DESC_ACCOUNT = "Account";
    private static final String DESC_RAW_PASSWORD = "Raw Password";
    //Account -> Admin
    private static ReplicatedMap<String, Admin> admins;
    private final TurmsClusterManager turmsClusterManager;
    private final TurmsPasswordUtil turmsPasswordUtil;
    private final ReactiveMongoTemplate mongoTemplate;
    private final AdminRoleService adminRoleService;

    public AdminService(TurmsClusterManager turmsClusterManager, TurmsPasswordUtil turmsPasswordUtil, ReactiveMongoTemplate mongoTemplate, AdminRoleService adminRoleService) {
        this.turmsClusterManager = turmsClusterManager;
        this.turmsPasswordUtil = turmsPasswordUtil;
        this.mongoTemplate = mongoTemplate;
        this.adminRoleService = adminRoleService;
    }

    @PostHazelcastInitialized
    public Function<TurmsClusterManager, Void> initAdminsCache() {
        return turmsClusterManager -> {
            admins = turmsClusterManager.getHazelcastInstance().getReplicatedMap(HAZELCAST_ADMINS_MAP);
            if (admins.size() == 0) {
                loadAllAdmins();
            }
            countRootAdmins().subscribe(number -> {
                if (number == 0) {
                    String account = RandomStringUtils.randomAlphabetic(16);
                    String rawPassword = RandomStringUtils.randomAscii(32);
                    Map<String, String> map = new HashMap<>(2);
                    map.put(DESC_ACCOUNT, account);
                    map.put(DESC_RAW_PASSWORD, rawPassword);
                    TurmsLogger.logJson("Root admin", map);
                    addAdmin(account,
                            rawPassword,
                            ADMIN_ROLE_ROOT_ID,
                            RandomStringUtils.randomAlphabetic(8),
                            new Date(),
                            false)
                            .subscribe();
                }
            });
            return null;
        };
    }

    public Mono<Long> countRootAdmins() {
        Query query = new Query()
                .addCriteria(Criteria.where(Admin.Fields.roleId).is(ADMIN_ROLE_ROOT_ID));
        return mongoTemplate.count(query, Admin.class);
    }

    public Mono<Admin> addAdmin(
            @Nullable String account,
            @Nullable String rawPassword,
            @NotNull Long roleId,
            @Nullable String name,
            @Nullable Date registrationDate,
            boolean upsert) {
        Admin admin = new Admin();
        admin.setAccount(account != null ? account : RandomStringUtils.randomAlphabetic(16));
        admin.setName(name != null && !name.isBlank() ? name : RandomStringUtils.randomAlphabetic(8));
        String password = rawPassword != null && !rawPassword.isBlank() ?
                turmsPasswordUtil.encodeAdminPassword(rawPassword) :
                turmsPasswordUtil.encodeAdminPassword(RandomStringUtils.randomAlphabetic(10));
        admin.setPassword(password);
        admin.setRegistrationDate(registrationDate != null ? registrationDate : new Date());
        admin.setRoleId(roleId);
        if (upsert) {
            return mongoTemplate.save(admin).doOnSuccess(result -> admins.put(account, admin));
        } else {
            return mongoTemplate.insert(admin).doOnSuccess(result -> admins.put(account, admin));
        }
    }

    public Mono<Long> queryRoleId(@NotNull String account) {
        Admin admin = admins.get(account);
        if (admin != null) {
            return Mono.just(admin.getRoleId());
        } else {
            Query query = new Query().addCriteria(Criteria.where(ID).is(account));
            query.fields().include(Admin.Fields.roleId);
            return mongoTemplate.findOne(query, Admin.class)
                    .map(administrator -> {
                        admins.put(account, administrator);
                        return administrator.getRoleId();
                    });
        }
    }

    public Mono<Boolean> isAdminAuthorized(@NotNull String account, @NotNull AdminPermission permission) {
        return queryRoleId(account)
                .flatMap(roleId -> adminRoleService.hasPermission(roleId, permission))
                .switchIfEmpty(Mono.just(false));
    }

    public Mono<Boolean> authenticate(@NotNull String account, @NotNull String rawPassword) {
        String password = turmsPasswordUtil.encodeAdminPassword(rawPassword);
        Query query = new Query()
                .addCriteria(Criteria.where(ID).is(account))
                .addCriteria(Criteria.where(Admin.Fields.password).is(password));
        return mongoTemplate.exists(query, Admin.class);
    }

    public Mono<Boolean> deleteAdmin(@NotNull String account) {
        Query query = new Query().addCriteria(Criteria.where(ID).is(account));
        return mongoTemplate.remove(query, Admin.class).map(result -> {
            admins.remove(account);
            return result.wasAcknowledged();
        });
    }

    public Mono<Boolean> authAndDeleteAdmin(@NotNull String requesterAccount, @NotNull String deleteAccount) {
        return isAdminAuthorized(requesterAccount, AdminPermission.ADMIN_DELETE)
                .flatMap(authorized -> {
                    if (authorized != null && authorized) {
                        Query query = new Query().addCriteria(Criteria.where(ID).is(deleteAccount));
                        return mongoTemplate.remove(query, Admin.class).map(DeleteResult::wasAcknowledged);
                    } else {
                        return Mono.error(TurmsBusinessException.get(TurmsStatusCode.UNAUTHORIZED));
                    }
                });
    }

    public Mono<Admin> queryAdmin(@NotNull String account, boolean withPassword) {
        Query query = new Query().addCriteria(Criteria.where(ID).is(account));
        if (!withPassword) {
            query.fields().exclude(Admin.Fields.password);
        }
        return mongoTemplate.findById(account, Admin.class);
    }

    public void loadAllAdmins() {
        mongoTemplate.find(new Query(), Admin.class)
                .doOnNext(admin -> admins.put(admin.getAccount(), admin))
                .subscribe();
    }

    public Flux<Admin> queryAdmins(
            @Nullable Set<String> accounts,
            @Nullable String role,
            boolean withPassword,
            int page,
            int size) {
        Query query = QueryBuilder.newBuilder()
                .addIfNotNull(Criteria.where(Admin.Fields.roleId).is(role), role)
                .paginateIfNotNull(page, size);
        if (accounts != null && !accounts.isEmpty()) {
            query.addCriteria(Criteria.where(ID).in(accounts));
        }
        if (!withPassword) {
            query.fields().exclude(Admin.Fields.password);
        }
        return mongoTemplate.find(query, Admin.class);
    }

    public Mono<Boolean> deleteAdmins(@NotEmpty Set<String> accounts) {
        Query query = new Query()
                .addCriteria(Criteria.where(ID).in(accounts));
        return mongoTemplate.remove(query, Admin.class).map(result -> {
            for (String account : accounts) {
                admins.remove(account);
            }
            return result.wasAcknowledged();
        });
    }

    public Mono<Boolean> updateAdmins(
            @NotEmpty Set<String> targetAccounts,
            @Nullable String password,
            @Nullable String name,
            @Nullable Long roleId) {
        Query query = new Query();
        query.addCriteria(Criteria.where(ID).in(targetAccounts));
        Update update = UpdateBuilder
                .newBuilder()
                .setIfNotNull(Admin.Fields.password, password)
                .setIfNotNull(Admin.Fields.name, name)
                .setIfNotNull(Admin.Fields.roleId, roleId)
                .build();
        return mongoTemplate.updateMulti(query, update, Admin.class).map(UpdateResult::wasAcknowledged);
    }

    public Mono<Long> countAdmins(@Nullable Set<String> accounts, @Nullable String role) {
        Query query = QueryBuilder.newBuilder()
                .addIfNotNull(Criteria.where(Admin.Fields.roleId).is(role), role)
                .buildQuery();
        if (accounts != null && !accounts.isEmpty()) {
            query.addCriteria(Criteria.where(ID).in(accounts));
        }
        return mongoTemplate.count(query, Admin.class);
    }
}
