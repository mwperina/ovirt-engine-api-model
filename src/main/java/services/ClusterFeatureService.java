/*
Copyright (c) 2017 Red Hat, Inc.

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

import mixins.Follow;
import org.ovirt.api.metamodel.annotations.Out;
import org.ovirt.api.metamodel.annotations.Service;

import types.ClusterFeature;

/**
 * Represents a feature enabled for the cluster level
 *
 * @author Sahina Bose <sabose@redhat.com>
 * @date 04 Aug 2017
 * @status added
 * @since 4.1.6
 */
@Service
public interface ClusterFeatureService {
    /**
     * Provides the information about the a cluster feature supported by a cluster level.
     *
     * For example, to find details of the cluster feature `456` for cluster level 4.1, send a request like this:
     *
     * [source]
     * ----
     * GET /ovirt-engine/api/clusterlevels/4.1/clusterfeatures/456
     * ----
     *
     * That will return a <<types/cluster_feature, ClusterFeature>> object containing the name:
     *
     * [source,xml]
     * ----
     * <cluster_feature id="456">
     *   <name>libgfapi_supported</name>
     * </cluster_feature>
     * ----
     *
     * @author Sahina Bose <sabose@redhat.com>
     * @date 04 Aug 2017
     * @status added
     * @since 4.1.6
     */
    interface Get extends Follow {
        /**
         * Retrieved cluster feature.
         *
         * @author Sahina Bose <sabose@redhat.com>
         * @date 04 Aug 2017
         * @status added
         * @since 4.1.6
         */
        @Out ClusterFeature feature();
    }
}
