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

package im.turms.turms.task;

import com.google.common.annotations.Beta;
import com.hazelcast.core.IExecutorService;
import com.hazelcast.core.Member;
import im.turms.turms.cluster.TurmsClusterManager;
import im.turms.turms.common.ReactorUtil;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Flux;

import java.util.Map;
import java.util.concurrent.Callable;
import java.util.concurrent.Future;

@Component
@Beta
public class TurmsTaskExecutor {
    private final TurmsClusterManager turmsClusterManager;
    private IExecutorService executor;

    public TurmsTaskExecutor(TurmsClusterManager turmsClusterManager) {
        this.turmsClusterManager = turmsClusterManager;
        executor = this.turmsClusterManager.getExecutor();
    }

    public <T> Flux<T> callAll(Callable<T> task) {
        Map<Member, Future<T>> futureMap = executor.submitToAllMembers(task);
        return ReactorUtil.futures2Flux(futureMap.values());
    }
}
