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

package im.turms.turms.access.web.controller.user;

import im.turms.turms.access.web.util.ResponseFactory;
import im.turms.turms.annotation.web.RequiredPermission;
import im.turms.turms.common.PageUtil;
import im.turms.turms.pojo.domain.UserPermissionGroup;
import im.turms.turms.pojo.dto.*;
import im.turms.turms.service.user.UserPermissionGroupService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.Collection;
import java.util.Collections;
import java.util.Map;
import java.util.Set;

import static im.turms.turms.constant.AdminPermission.*;

@RestController
@RequestMapping("/users/permission-groups")
public class UserPermissionGroupController {
    private final UserPermissionGroupService userPermissionGroupService;
    private final PageUtil pageUtil;

    public UserPermissionGroupController(UserPermissionGroupService userPermissionGroupService, PageUtil pageUtil) {
        this.userPermissionGroupService = userPermissionGroupService;
        this.pageUtil = pageUtil;
    }

    @PostMapping
    @RequiredPermission(USER_PERMISSION_GROUP_CREATE)
    public Mono<ResponseEntity<ResponseDTO<UserPermissionGroup>>> addUserPermissionGroup(@RequestBody AddUserPermissionGroupDTO addUserPermissionGroupDTO) {
        Set<Long> creatableGroupTypesIds = addUserPermissionGroupDTO.getCreatableGroupTypeIds();
        creatableGroupTypesIds = creatableGroupTypesIds != null ? creatableGroupTypesIds : Collections.emptySet();
        Map<Long, Integer> groupTypeLimits = addUserPermissionGroupDTO.getGroupTypeLimits();
        groupTypeLimits = groupTypeLimits != null ? groupTypeLimits : Collections.emptyMap();
        Mono<UserPermissionGroup> userPermissionGroupMono = userPermissionGroupService.addUserPermissionGroup(
                addUserPermissionGroupDTO.getId(),
                creatableGroupTypesIds,
                addUserPermissionGroupDTO.getOwnedGroupLimit(),
                addUserPermissionGroupDTO.getOwnedGroupLimitForEachGroupType(),
                groupTypeLimits);
        return ResponseFactory.okIfTruthy(userPermissionGroupMono);
    }

    @GetMapping
    @RequiredPermission(USER_PERMISSION_GROUP_QUERY)
    public Mono<ResponseEntity<ResponseDTO<Collection<UserPermissionGroup>>>> queryUserPermissionGroups(
            @RequestParam(required = false) Integer size) {
        size = pageUtil.getSize(size);
        Flux<UserPermissionGroup> groupTypesFlux = userPermissionGroupService.queryUserPermissionGroups(0, size);
        return ResponseFactory.okIfTruthy(groupTypesFlux);
    }

    @GetMapping("/page")
    @RequiredPermission(USER_PERMISSION_GROUP_QUERY)
    public Mono<ResponseEntity<ResponseDTO<PaginationDTO<UserPermissionGroup>>>> queryUserPermissionGroups(
            @RequestParam(defaultValue = "0") Integer page,
            @RequestParam(required = false) Integer size) {
        size = pageUtil.getSize(size);
        Mono<Long> count = userPermissionGroupService.countUserPermissionGroups();
        Flux<UserPermissionGroup> groupTypesFlux = userPermissionGroupService.queryUserPermissionGroups(page, size);
        return ResponseFactory.page(count, groupTypesFlux);
    }

    @PutMapping
    @RequiredPermission(USER_PERMISSION_GROUP_UPDATE)
    public Mono<ResponseEntity<ResponseDTO<AcknowledgedDTO>>> updateUserPermissionGroup(
            @RequestParam Set<Long> ids,
            @RequestBody UpdateUserPermissionGroupDTO updateUserPermissionGroupDTO) {
        Mono<Boolean> updated = userPermissionGroupService.updateUserPermissionGroups(
                ids,
                updateUserPermissionGroupDTO.getCreatableGroupTypeIds(),
                updateUserPermissionGroupDTO.getOwnedGroupLimit(),
                updateUserPermissionGroupDTO.getOwnedGroupLimitForEachGroupType(),
                updateUserPermissionGroupDTO.getGroupTypeLimits());
        return ResponseFactory.acknowledged(updated);
    }

    @DeleteMapping
    @RequiredPermission(USER_PERMISSION_GROUP_DELETE)
    public Mono<ResponseEntity<ResponseDTO<AcknowledgedDTO>>> deleteUserPermissionGroup(@RequestParam Set<Long> ids) {
        Mono<Boolean> deleted = userPermissionGroupService.deleteUserPermissionGroups(ids);
        return ResponseFactory.acknowledged(deleted);
    }
}
