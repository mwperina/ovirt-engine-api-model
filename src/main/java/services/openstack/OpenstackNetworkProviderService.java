/*
Copyright (c) 2015 Red Hat, Inc.

Licensed under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at

  http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License.
*/

package services.openstack;

import annotations.Area;
import org.ovirt.api.metamodel.annotations.In;
import org.ovirt.api.metamodel.annotations.Out;
import org.ovirt.api.metamodel.annotations.Service;
import services.ExternalProviderService;
import types.OpenStackNetworkProvider;

/**
 * This service manages OpenStack network provider.
 *
 * @author Mor Kalfon <mkalfon@redhat.com>
 * @date 12 Dec 2016
 * @status added
 */
@Service
@Area("Network")
public interface OpenstackNetworkProviderService extends ExternalProviderService {
    /**
     * Returns the representation of the object managed by this service.
     *
     * For example, to get the OpenStack network provider with identifier `1234` from send a request like this:
     *
     * [source]
     * ----
     * GET /ovirt-engine/api/openstacknetworkproviders/1234
     * ----
     *
     * @author Mor Kalfon <mkalfon@redhat.com>
     * @date 14 Dec 2016
     * @status added
     */
    interface Get {
        @Out OpenStackNetworkProvider provider();
    }

    /**
     * Updates the provider.
     *
     * For example, to update `provider_name`, `requires_authentication`, `url`, `tenant_name` and `type` properties,
     * for the OpenStack network provider with identifier `1234`, send a request like this:
     *
     * [source]
     * ----
     * PUT /ovirt-engine/api/openstacknetworkproviders/1234
     * ----
     *
     * With a request body like this:
     *
     * [source,xml]
     * ----
     * <openstack_network_provider>
     *   <name>ovn-network-provider</name>
     *   <requires_authentication>false</requires_authentication>
     *   <url>http://some_server_url.domain.com:9696</url>
     *   <tenant_name>oVirt</tenant_name>
     *   <type>external</type>
     * </openstack_network_provider>
     * ----
     *
     * @author Mor Kalfon <mkalfon@redhat.com>
     * @date 14 Dec 2016
     * @status added
     */
    interface Update {
        /**
         * The provider to update.
         *
         * @author Mor Kalfon <mkalfon@redhat.com>
         * @date 14 Dec 2016
         * @status added
         */
        @In @Out OpenStackNetworkProvider provider();

        /**
         * Indicates if the update should be performed asynchronously.
         */
        @In Boolean async();
    }

    /**
     * Removes the provider.
     *
     * For example, to remove the OpenStack network provider with identifier `1234` send a request like this:
     *
     * [source]
     * ----
     * DELETE /ovirt-engine/api/openstacknetworkproviders/1234
     * ----
     *
     * @author Mor Kalfon <mkalfon@redhat.com>
     * @date 14 Dec 2016
     * @status added
     */
    interface Remove {
        /**
         * Indicates if the remove should be performed asynchronously.
         *
         * @author Mor Kalfon <mkalfon@redhat.com>
         * @date 14 Dec 2016
         * @status added
         */
        @In Boolean async();
    }

    /**
     * Reference to OpenStack networks service.
     *
     * @author Mor Kalfon <mkalfon@redhat.com>
     * @date 12 Dec 2016
     * @status added
     */
    @Service OpenstackNetworksService networks();
}
