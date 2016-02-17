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

import java.nio.file.Path;
import java.security.Principal;
import java.util.Date;
import java.util.Locale;

import javax.inject.Inject;
import javax.inject.Provider;

import org.dawnsci.marketplace.MarketplaceFactory;
import org.dawnsci.marketplace.Platform;
import org.dawnsci.marketplace.services.DataService;
import org.dawnsci.marketplace.services.FileService;
import org.dawnsci.marketplace.social.account.Account;
import org.dawnsci.marketplace.social.account.AccountRepository;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.util.FeatureMap;
import org.eclipse.emf.ecore.util.FeatureMapUtil;
import org.eclipse.emf.ecore.util.FeatureMapUtil.FeatureEList;
import org.eclipse.emf.ecore.xml.type.XMLTypePackage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.actuate.autoconfigure.EndpointAutoConfiguration.GitInfo;
import org.springframework.boot.autoconfigure.social.FacebookProperties;
import org.springframework.social.connect.Connection;
import org.springframework.social.connect.ConnectionFactoryLocator;
import org.springframework.social.connect.ConnectionRepository;
import org.springframework.social.github.api.GitHub;
import org.springframework.social.google.api.Google;
import org.springframework.social.twitter.api.Twitter;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.HandlerMapping;

/**
 * Controller for viewing public marketplace information.
 * 
 * @author Torkild U. Resheim, Itema AS
 */
@SuppressWarnings("unused")
@Controller
public class SolutionController {

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
	
	private static final TypeUtilities DATE_UTILS = new TypeUtilities();
	private static final EStructuralFeature TEXT = XMLTypePackage.eINSTANCE.getXMLTypeDocumentRoot_Text();

	private final AccountRepository accountRepository;

	@Inject
	private ConnectionRepository connectionRepository;

	private final Provider<ConnectionRepository> connectionRepositoryProvider;

	@Autowired
	private DataService dataService;

	@Autowired
	private FileService fileService;

	@Inject
	public SolutionController(Provider<ConnectionRepository> connectionRepositoryProvider,
			AccountRepository accountRepository) {
		this.connectionRepositoryProvider = connectionRepositoryProvider;
		this.accountRepository = accountRepository;
	}

	private void addProfile(ModelMap map, Principal principal) {
		if (principal!=null){
			Connection<?> connection = null;
			connection = connectionRepository.findPrimaryConnection(Twitter.class);
			if (connection == null)
				connection = connectionRepository.findPrimaryConnection(Google.class);
			if (connection == null)
				connection = connectionRepository.findPrimaryConnection(GitHub.class);
			if (connection != null) {
				map.addAttribute("profileImage",connection.getImageUrl());
				map.addAttribute("profile",connection.getProfileUrl());
			}
			Account findAccountByUsername = accountRepository.findAccountByUsername(principal.getName());
			map.addAttribute(findAccountByUsername);
		}
	}

	private ConnectionRepository getConnectionRepository() {
		return connectionRepositoryProvider.get();
	}

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String showMainView(ModelMap map, Principal principal) {
		map.addAttribute("connectionsToProviders", getConnectionRepository().findAllConnections());
		map.addAttribute("featured", dataService.getFeatured());
		map.addAttribute("updated", dataService.getUpdated());
		map.addAttribute("typeUtilities", DATE_UTILS);
		Path path = fileService.getPageFile("welcome.md").toPath();			
		map.addAttribute("text", PageController.parse(path));
		addProfile(map, principal);
		return "main";
	}
	
	@RequestMapping(value = "/search", method = RequestMethod.GET)
	public String showSearchView(ModelMap map, Principal principal, @RequestParam(value = "term", required = true) String term) {
		map.addAttribute("connectionsToProviders", getConnectionRepository().findAllConnections());
		map.addAttribute("solutions", dataService.getSearchResult(term));
		map.addAttribute("typeUtilities", DATE_UTILS);
		addProfile(map, principal);
		return "list";
	}

	@RequestMapping(value = "/content/{identifier}", method = RequestMethod.GET)
	public String showSolution(ModelMap map, Principal principal, @PathVariable int identifier) {
		map.addAttribute("content", dataService.getContent(identifier));
		map.addAttribute("typeUtilities", DATE_UTILS);
		addProfile(map, principal);
		return "solution";
	}
}