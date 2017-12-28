/*
 * Copyright 2017 flow.ci
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.flow.platform.core.queue;

import com.flow.platform.core.context.ContextEvent;
import com.flow.platform.queue.InMemoryQueue;
import java.util.Comparator;
import java.util.concurrent.Executor;

/**
 * @author yang
 */
public class MemoryQueue extends InMemoryQueue<PriorityMessage> implements ContextEvent {

    private static class PriorityMessageComparator implements Comparator<PriorityMessage> {

        @Override
        public int compare(PriorityMessage o1, PriorityMessage o2) {
            return o1.compareTo(o2);
        }
    }

    public MemoryQueue(Executor executor, int maxSize, String name) {
        super(executor, maxSize, name, new PriorityMessageComparator());
    }
}
