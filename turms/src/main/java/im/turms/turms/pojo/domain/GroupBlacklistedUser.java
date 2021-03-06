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

package im.turms.turms.pojo.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.FieldNameConstants;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.PersistenceConstructor;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;
import java.util.List;

@Data
@Document
@FieldNameConstants
@AllArgsConstructor(onConstructor = @__(@PersistenceConstructor))
public final class GroupBlacklistedUser {
    @Id
    private final Key key;

    @Indexed
    private final Date blockDate;

    @Indexed
    private final Long requesterId;

    public GroupBlacklistedUser(Long groupId, Long userId, Date blockDate, Long requesterId) {
        this.key = new Key(groupId, userId);
        this.blockDate = blockDate;
        this.requesterId = requesterId;
    }

    @Data
    @AllArgsConstructor
    @EqualsAndHashCode
    public static final class Key {
        private final Long groupId;

        @Indexed
        private final Long userId;
    }

    @Data
    @AllArgsConstructor
    public static final class KeyList {
        private final List<Key> keys;
    }
}