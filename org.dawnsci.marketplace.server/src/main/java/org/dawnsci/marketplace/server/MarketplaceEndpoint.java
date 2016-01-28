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
package org.dawnsci.marketplace.server;

import java.io.IOException;
import java.io.StringWriter;
import java.util.HashMap;
import java.util.Map;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;

import org.dawnsci.marketplace.Marketplace;
import org.eclipse.emf.ecore.resource.URIConverter;
import org.eclipse.emf.ecore.xmi.XMLResource;
import org.eclipse.emf.ecore.xmi.impl.XMLResourceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@Path("/mpc")
public class MarketplaceEndpoint {

	@Autowired
	private CatalogService catalogService;

	/**
	 * http://marketplace.eclipse.org/api/p
	 * 
	 * @return
	 */
	@GET
	@Path("api/p")
	public String getMarkets() throws Exception {
		return serialize(catalogService.getMarkets());
	}

	/**
	 * http://marketplace.eclipse.org/catalogs/api/p
	 * 
	 * @return
	 */
	@GET
	@Path("catalogs/api/p")
	public String getCatalogs() throws Exception {
		return serialize(catalogService.getCatalogs());
	}

	/**
	 * http://marketplace.eclipse.org/node/[node id]/api/p
	 * 
	 * @param id
	 *            content identifier
	 * @return
	 */
	@GET
	@Path("node/{id}/api/p")
	public String getNode(@PathParam("id") String id) throws Exception {
		return serialize(catalogService.getContent(id));
	}

	/**
	 * http://marketplace.eclipse.org/content/[node id]/api/p
	 * 
	 * @param id
	 *            content identifier
	 * @return
	 */
	@GET
	@Path("content/{id}/api/p")
	public String getContent(@PathParam("id") String id) throws Exception {
		return serialize(catalogService.getContent(id));
	}

	private String serialize(Marketplace rootElement) throws IOException {
		Map<String, Object> saveOptions = new HashMap<String, Object>();
		saveOptions.put(XMLResource.OPTION_EXTENDED_META_DATA, Boolean.TRUE);
		XMLResource resource = new XMLResourceImpl();
		resource.getContents().add(rootElement);
		StringWriter stringWriter = new StringWriter();
		resource.save(new URIConverter.WriteableOutputStream(stringWriter, resource.getEncoding()), saveOptions);
		return stringWriter.getBuffer().toString();
	}

}