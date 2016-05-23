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
import java.util.Collection;
import java.util.Date;
import java.util.Locale;

import javax.inject.Inject;
import javax.inject.Provider;
import javax.naming.NamingException;

import org.dawnsci.marketplace.ForbiddenException;
import org.dawnsci.marketplace.Marketplace;
import org.dawnsci.marketplace.impl.MarketplaceImpl;
import org.dawnsci.marketplace.MarketplaceFactory;
import org.dawnsci.marketplace.Node;
import org.dawnsci.marketplace.NodeProxy;
import org.dawnsci.marketplace.NotFoundException;
import org.dawnsci.marketplace.Platform;
import org.dawnsci.marketplace.services.MarketplaceDAO;
import org.dawnsci.marketplace.core.MarketplaceSerializer;
import org.dawnsci.marketplace.core.MarketplaceUtility;
import org.dawnsci.marketplace.services.FileService;
import org.dawnsci.marketplace.social.account.Account;
import org.dawnsci.marketplace.social.account.AccountRepository;
import org.eclipse.emf.ecore.util.FeatureMap;
import org.eclipse.emf.ecore.util.FeatureMapUtil;
import org.eclipse.emf.ecore.util.FeatureMapUtil.FeatureEList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.actuate.autoconfigure.EndpointAutoConfiguration.GitInfo;
import org.springframework.boot.autoconfigure.social.FacebookProperties;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.AccessDecisionManager;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.social.connect.ConnectionFactoryLocator;
import org.springframework.social.connect.ConnectionRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.HandlerMapping;

/**
 * CRUD controller for solutions a.k.a. plug-ins and features.
 *
 * @author Torkild U. Resheim, Itema AS
 */
@SuppressWarnings("unused")
@Controller
public class SolutionController extends AbstractController {

	@Autowired
	private MarketplaceDAO marketplaceDAO;

	@Autowired
	private FileService fileService;

	@Inject
	public SolutionController(AccountRepository accountRepository) {
		super(accountRepository);
	}

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String showMainView(ModelMap map, Principal principal) {
		addCommonItems(map, principal);
		map.addAttribute("featured", marketplaceDAO.getFeatured());
		map.addAttribute("recent", marketplaceDAO.getRecent());
		Path path = fileService.getPageFile("welcome.md").toPath();
		map.addAttribute("text", PageController.parse(path));
		return "main";
	}

	/**
	 * Performs a search for solutions which the matching parameters. Note
	 * that that only the <b>term</b> tag is defined and used by the Eclipse
	 * marketplace implementation.
	 */
	@RequestMapping(value = "/search", method = RequestMethod.GET)
	public String showSearchView(ModelMap map, Principal principal,
			@RequestParam(value = "term", required = false) String term,
			@RequestParam(value = "tag", required = false) String tag) {
		addCommonItems(map, principal);
		if (term != null) {
			map.addAttribute("solutions", marketplaceDAO.getSearchResult(term));
			map.addAttribute("query", "term \""+term+"\".");
		}
		if (tag != null) {
			map.addAttribute("solutions", marketplaceDAO.getSolutionsWithTag(tag));
			map.addAttribute("query", "tag \""+tag+"\".");
		}
		return "list";
	}

	/**
	 * Shows the solution with the given identifier. If it does not exist a 404
	 * error will be returned.
	 */
	@RequestMapping(value = "/content/{identifier}", method = RequestMethod.GET)
	public String showSolution(ModelMap map, Principal principal, @PathVariable Long identifier) {
		addCommonItems(map, principal);
		Marketplace content = marketplaceDAO.getContent(identifier);
		if (content.getNode()==null) {
			throw new NotFoundException();
		}
		map.addAttribute("content", content);
		map.addAttribute("editable", marketplaceDAO.canEdit(identifier));
		return "solution";
	}

	/**
	 * Deletes the solution from the database. The logged in user must be the
	 * owner or an 403 error will be returned.
	 */
	@PreAuthorize("hasRole('UPLOAD')")
	@RequestMapping(value = "/delete-solution/{identifier}", method = RequestMethod.GET)
	public String deleteSolution(ModelMap map, Principal principal, @PathVariable int identifier) {
		Account account = accountRepository.findOne(principal.getName());
		marketplaceDAO.deleteSolution(account, Long.valueOf(identifier));
		return "redirect:/";
	}
	/**
	 * Open the solution editing form for creating a new instance.
	 */
	@PreAuthorize("hasRole('UPLOAD')")
	@RequestMapping(value = "/edit-solution", method = RequestMethod.GET)
	public String showNewSolutionForm(ModelMap map, Principal principal) {
		addCommonItems(map, principal);
		Node node = MarketplaceFactory.eINSTANCE.createNode();
		map.addAttribute("content", new NodeProxy(node));
		// add list of available licenses and statuses
		map.addAttribute("licenses", MarketplaceUtility.LICENSES);
		map.addAttribute("status", MarketplaceUtility.STATUS);
		map.addAttribute("editable", marketplaceDAO.canEdit(node.getId()));
		return "edit-solution";
	}

	/**
	 * Open the solution editing form for modifying an existing instance.
	 */
	@PreAuthorize("hasRole('UPLOAD')")
	@RequestMapping(value = "/edit-solution/{identifier}", method = RequestMethod.GET)
	public String showEditSolutionForm(ModelMap map, Principal principal, @PathVariable Long identifier) {
		addCommonItems(map, principal);
		map.addAttribute("content", new NodeProxy(marketplaceDAO.getContent(identifier).getNode()));
		// add list of available licenses and statuses
		map.addAttribute("licenses", MarketplaceUtility.LICENSES);
		map.addAttribute("status", MarketplaceUtility.STATUS);
		map.addAttribute("editable" ,marketplaceDAO.canEdit(identifier));
		return "edit-solution";
	}

	/**
	 * Store changes
	 */
	@PreAuthorize("hasRole('UPLOAD')")
	@RequestMapping(value = "/edit-solution", method = RequestMethod.POST)
	public String postSolution(ModelMap map, Principal principal,
			@ModelAttribute NodeProxy content) {
		addCommonItems(map, principal);
		// try to store the node
		Account account = accountRepository.findOne(principal.getName());
		Node node = content.getNode();
		// make sure it can be installed
		if (node.getEclipseversion()==null || node.getEclipseversion().isEmpty()){
			node.setEclipseversion("4.4, 4.5, 4.6, 4.7");
		}
		Object result = marketplaceDAO.saveOrUpdateSolution(node, account);
		if (result instanceof Node) {
			node = (Node) result;
			content.setNode(node);
			Long id = node.getId();
			if (content.getScreenshotfile() != null && !content.getScreenshotfile().isEmpty()) {
				fileService.saveSolutionFile(id, content.getScreenshotfile());
				node.setScreenshot(content.getScreenshotfile().getOriginalFilename());
				Object o = marketplaceDAO.saveOrUpdateSolution(node, account);
				if (o instanceof Node) node = (Node) o;
			}
			if (content.getImagefile() !=null && !content.getImagefile().isEmpty()) {
				fileService.saveSolutionFile(id, content.getImagefile());
				node.setImage(content.getImagefile().getOriginalFilename());
				Object o = marketplaceDAO.saveOrUpdateSolution(node, account);
				if (o instanceof Node) node = (Node) o;
			}
			if (content.getRepositoryfile() !=null && !content.getRepositoryfile().isEmpty()) {
				 // if a p2-repository is uploaded for the solution, the URL to the update
				 // site will be overwritten with a new value pointing to this server.
				fileService.uploadRepository(id, content.getRepositoryfile());
				node.setUpdateurl("/files/"+id+"/");
				Object o = marketplaceDAO.saveOrUpdateSolution(node, account);
			}
		}
		return "redirect:/content/"+content.getNode().getId();
	}

}
