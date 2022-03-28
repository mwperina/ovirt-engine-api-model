/*
Copyright (c) 2020 Red Hat, Inc.

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

import org.ovirt.api.metamodel.annotations.In;
import org.ovirt.api.metamodel.annotations.Out;
import org.ovirt.api.metamodel.annotations.Service;

import annotations.Area;
import mixins.Follow;
import types.Disk;

@Service
@Area("Storage")
public interface VmCheckpointDisksService {
    /**
     * Returns the list of disks in checkpoint.
     *
     * @author Eyal Shenitzky <eshenitz@redhat.com>
     * @date 3 Jun 2020
     * @status added
     * @since 4.4
     */
    interface List extends Follow {
        /**
         * The list of retrieved disks.
         *
         * @author Eyal Shenitzky <eshenitz@redhat.com>
         * @date 3 Jun 2020
         * @status added
         * @since 4.4
         */
        @Out Disk[] disks();

        /**
         * Sets the maximum number of disks to return. If not specified, all the disks are returned.
         */
        @In Integer max();
    }

    /**
     * A reference to the service that manages a specific disk.
     *
     * @author Eyal Shenitzky <eshenitz@redhat.com>
     * @date 3 Jun 2020
     * @status added
     * @since 4.4
     */
    @Service VmCheckpointDiskService disk(String id);
}
