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
package org.dawnsci.marketplace.controllers;

import java.security.Principal;

import org.dawnsci.marketplace.services.DataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Controller for viewing public marketplace information.
 * 
 * @author Torkild U. Resheim, Itema AS
 */
@Controller
@RequestMapping(value = "/", produces = MediaType.TEXT_HTML_VALUE, method = RequestMethod.GET)
public class NodeListController {
	
	@Autowired
	private DataService dataService;

	@RequestMapping(value = "/")
	public String showMainView(ModelMap map, Principal principal ) {
		map.addAttribute("featured", dataService.getFeatured());
		map.addAttribute("updated", dataService.getUpdated());
		return "main";
	}
}
