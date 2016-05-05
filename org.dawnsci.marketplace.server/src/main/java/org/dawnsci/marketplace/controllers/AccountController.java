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
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;
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
import org.dawnsci.marketplace.social.account.UsernameAlreadyInUseException;
import org.eclipse.emf.ecore.util.FeatureMap;
import org.eclipse.emf.ecore.util.FeatureMapUtil;
import org.eclipse.emf.ecore.util.FeatureMapUtil.FeatureEList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.actuate.autoconfigure.EndpointAutoConfiguration.GitInfo;
import org.springframework.boot.autoconfigure.social.FacebookProperties;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
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
 * CRUD controller for user accounts.
 * 
 * @author Torkild U. Resheim, Itema AS
 */
@SuppressWarnings("unused")
@Controller
public class AccountController extends AbstractController {
	
	@Autowired
	private MarketplaceDAO marketplaceDAO;

	@Inject
	public AccountController(AccountRepository accountRepository) {
		super(accountRepository);
	}

	@PreAuthorize("hasRole('ADMIN')")
	@RequestMapping(value = "/accounts", method = RequestMethod.GET)
	public String getAccounts(ModelMap map, Principal principal) {
		addCommonItems(map, principal);
		map.addAttribute("page", accountRepository.findAll(new PageRequest(0, 15)));
		return "accounts";
	}
	
	/**
	 * Page numbers start from one.
	 */
	@PreAuthorize("hasRole('ADMIN')")
	@RequestMapping(value = "/accounts/{page}", method = RequestMethod.GET)
	public String getAccountsPaged(ModelMap map, Principal principal, @PathVariable("page") int page) {
		addCommonItems(map, principal);
		map.addAttribute("page", accountRepository.findAll(new PageRequest(page-1, 15)));
		return "accounts";
	}
	
	@PreAuthorize("hasRole('ADMIN')")
	@RequestMapping(value = "/account/{username}", method = RequestMethod.GET)
	public String getAccount(ModelMap map, Principal principal, @PathVariable("username") String username) {
		addCommonItems(map, principal);
		List<Long> idsByUsername = accountRepository.findSolutionIdsByUsername(username);
		List<Node> solutions = new ArrayList<>();
		for (Long id : idsByUsername) {
			solutions.add(marketplaceDAO.getSolution(id));			
		}
		map.addAttribute("content", accountRepository.findOne(username));
		map.addAttribute("solutions", solutions);
		map.addAttribute("role_administrator", accountRepository.isAdministrator(username));
		map.addAttribute("role_user", accountRepository.isUser(username));
		map.addAttribute("role_upload", accountRepository.isUpload(username));
		return "account";
	}

	@PreAuthorize("hasRole('ADMIN')")
	@RequestMapping(value = "/account", method = RequestMethod.POST)
	public String updateAccount(ModelMap map, Principal principal, 
			@ModelAttribute Account account,
			@RequestParam(value="role_administrator", required=false) boolean administrator,
			@RequestParam(value="role_user", required=false) boolean user,
			@RequestParam(value="role_upload", required=false) boolean upload) {
		accountRepository.save(account);
		accountRepository.setAdministrator(account.getUsername(), administrator);
		accountRepository.setUser(account.getUsername(), user);
		accountRepository.setUpload(account.getUsername(), upload);
		return "redirect:/account/"+account.getUsername();
	}

	@PreAuthorize("hasRole('ADMIN')")
	@RequestMapping(value = "/delete-account/{username}", method = RequestMethod.GET)
	public String deleteAccount(ModelMap map, Principal principal, 
			@PathVariable("username") String username) {
		accountRepository.delete(username);
		return "redirect:/accounts";
	}
}
