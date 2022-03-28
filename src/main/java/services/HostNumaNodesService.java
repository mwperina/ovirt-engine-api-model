/*
Copyright (c) 2015 Red Hat, Inc.

Licensed under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at

  https://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License.
*/

package services;

import annotations.Area;
import mixins.Follow;
import org.ovirt.api.metamodel.annotations.In;
import org.ovirt.api.metamodel.annotations.Out;
import org.ovirt.api.metamodel.annotations.Service;
import types.NumaNode;

@Service
@Area("SLA")
public interface HostNumaNodesService {
    /**
     * Returns the list of NUMA nodes of the host.
     *
     * The order of the returned list of NUMA nodes isn't guaranteed.
     *
     * @author Juan Hernandez <juan.hernandez@redhat.com>
     * @date 15 Arp 2017
     * @status added
     */
    interface List extends Follow {
        @Out NumaNode[] nodes();

        /**
         * Sets the maximum number of nodes to return. If not specified all the nodes are returned.
         */
        @In Integer max();
    }

    @Service HostNumaNodeService node(String id);
}
