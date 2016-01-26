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
import javax.ws.rs.Produces;

import org.dawnsci.marketplace.Marketplace;
import org.eclipse.emf.ecore.resource.URIConverter;
import org.eclipse.emf.ecore.xmi.XMLResource;
import org.eclipse.emf.ecore.xmi.impl.XMLResourceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@Path("/mpc")
public class MarketplaceEndpoint  {
	
	@Autowired
	private CatalogService catalogService;
	
	/**
	 * http://marketplace.eclipse.org/catalogs/api/p
	 * 
	 * @param id
	 * @return
	 */
	@GET
	@Path("catalogs/api/p") 
	public String getCatalogs() {
		return serialize(catalogService.getCatalogs());
	}

	@GET
	@Path("catalogs") 
	@Produces("application/json")
	public Marketplace getJsonCatalogs() {
		return catalogService.getCatalogs();
	}
	
	/**
	 * http://marketplace.eclipse.org/node/[node id]/api/p
	 * 
	 * @param id
	 * @return
	 */
	@GET
	@Path("node/{id}/api/p") 
	public String getNode(@PathParam("id") String id){
		return serialize(catalogService.getMarketplace());
	}

	private String serialize(Marketplace rootElement) {
		Map<String, Object> saveOptions = new HashMap<String, Object>();
		saveOptions.put(XMLResource.OPTION_EXTENDED_META_DATA, Boolean.TRUE);
		XMLResource resource = new XMLResourceImpl();
		resource.getContents().add(rootElement);
		StringWriter stringWriter = new StringWriter();
		try {
			resource.save(new URIConverter.WriteableOutputStream(stringWriter, resource.getEncoding()), saveOptions);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return stringWriter.getBuffer().toString();
	}
	
}