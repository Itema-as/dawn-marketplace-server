/*****************************************************************************
 * Copyright (c) 2016 Diamond Light Source Ltd.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Torkild U. Resheim - initial API and implementation
 ****************************************************************************/
package org.dawnsci.marketplace;

import javax.ws.rs.ApplicationPath;

import org.dawnsci.marketplace.endpoints.MarketplaceEndpoint;
import org.glassfish.jersey.server.ResourceConfig;
import org.springframework.stereotype.Component;
/**
 * REST server entry point. All calls to the REST server must be prefixed by "/mpc".
 *
 * @author Torkild U. Resheim, Itema AS
 */
@Component
@ApplicationPath("/mpc")
public class RestConfiguration extends ResourceConfig {
	
	public RestConfiguration() {
		register(MarketplaceEndpoint.class);
	}
}
