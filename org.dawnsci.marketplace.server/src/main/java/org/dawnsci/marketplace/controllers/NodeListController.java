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
import java.util.Date;

import org.dawnsci.marketplace.MarketplaceFactory;
import org.dawnsci.marketplace.Platform;
import org.dawnsci.marketplace.services.DataService;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.util.FeatureMap;
import org.eclipse.emf.ecore.util.FeatureMapUtil;
import org.eclipse.emf.ecore.util.FeatureMapUtil.FeatureEList;
import org.eclipse.emf.ecore.xml.type.XMLTypePackage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Controller for viewing public marketplace information.
 * 
 * @author Torkild U. Resheim, Itema AS
 */
@SuppressWarnings("unused")
@Controller
public class NodeListController {

	private static final TypeUtilities DATE_UTILS = new TypeUtilities();
	private static final EStructuralFeature TEXT = XMLTypePackage.eINSTANCE.getXMLTypeDocumentRoot_Text();

	public static class TypeUtilities {
		
		public static Date getDate(long timestamp) {
			return new Date(timestamp);
		}

		@SuppressWarnings("rawtypes")
		public static String getText(Platform p) {
			Object o = p.getMixed().get(TEXT, false);
			if (o instanceof FeatureEList) {
				if (((FeatureEList) o).size() > 0) {
					return ((FeatureEList) o).get(0).toString();
				}
			}
			return null;
		}		
		
	}

	@Autowired
	private DataService dataService;

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String showMainView(ModelMap map, Principal principal) {
		map.addAttribute("featured", dataService.getFeatured());
		map.addAttribute("updated", dataService.getUpdated());
		map.addAttribute("typeUtilities", DATE_UTILS);
		return "main";
	}

	@RequestMapping(value = "/content/{identifier}", method = RequestMethod.GET)
	public String showSolution(ModelMap map, Principal principal, @PathVariable int identifier) {
		map.addAttribute("content", dataService.getContent(identifier));
		map.addAttribute("typeUtilities", DATE_UTILS);
		return "solution";
	}
}
