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
package org.dawnsci.marketplace.endpoints;

import java.io.IOException;
import java.io.StringWriter;
import java.util.HashMap;
import java.util.Map;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import org.dawnsci.marketplace.Marketplace;
import org.dawnsci.marketplace.services.MarketplaceDAO;
import org.eclipse.emf.ecore.resource.URIConverter;
import org.eclipse.emf.ecore.xmi.XMLResource;
import org.eclipse.emf.ecore.xmi.impl.XMLResourceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author Torkild U. Resheim, Itema AS
 */
@Path("/")
@Component
@Produces("text/xml")
public class MarketplaceEndpoint {

	@Autowired 
	private MarketplaceDAO marketplaceDAO;
	
	@GET
	@Path("api/p")
	public String getMarkets() throws Exception {
		return serialize(marketplaceDAO.getMarkets());
	}

	@GET
	@Path("api/p/search/apachesolr_search/{term}")
	public String getSearchResult(@PathParam("term") String term) throws Exception {
		return serialize(marketplaceDAO.getSearchResult(term));
	}

	@GET
	@Path("catalogs/api/p")
	public String getCatalogs() throws Exception {
		return serialize(marketplaceDAO.getCatalogs());
	}

	@GET
	@Path("featured/api/p")
	public String getFeatured() throws Exception {
		Marketplace featured = marketplaceDAO.getFeatured();
		return serialize(featured);
	}


	@GET
	@Path("node/{id}/api/p")
	public String getNode(@PathParam("id") int id) throws Exception {
		return serialize(marketplaceDAO.getContent(id));
	}

	@GET
	@Path("content/{id}/api/p")
	public String getContent(@PathParam("id") int id) throws Exception {
		return serialize(marketplaceDAO.getContent(id));
	}

	@GET
	@Path("recent/api/p")
	public String getRecent() throws Exception {
		return serialize(marketplaceDAO.getRecent());
	}

	@GET
	@Path("marketplace-client-intro?mpc_install={id}")
	public String getInstall(@PathParam("id") String id) throws Exception {
		return "test";
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