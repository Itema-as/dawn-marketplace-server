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

import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServletRequest;

import org.dawnsci.marketplace.Node;
import org.dawnsci.marketplace.core.MarketplaceSerializer;
import org.dawnsci.marketplace.services.FileService;
import org.dawnsci.marketplace.services.MarketplaceDAO;
import org.dawnsci.marketplace.social.account.Account;
import org.dawnsci.marketplace.social.account.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.web.csrf.CsrfToken;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

/**
 * This controller handles the extended REST API for uploading and modifying
 * solutions. Note that this API cannot be accessed by an administrator - the
 * client must be logged in as a user, and will also have to own the solution in
 * order to modify it.
 */
@Controller
@RestController
@MultipartConfig(fileSizeThreshold = 4_194_304)
public class ExtendedRestApiController {
	
	@Autowired 
	private MarketplaceDAO marketplaceDAO;
	
	@Autowired
	private AccountRepository accountRepository;
	
	@Autowired 
	protected FileService fileService;

	/**
	 * Used by the client software to obtain a CSRF token to use in further
	 * communication with the server.
	 */
	@ResponseBody
	@RequestMapping(value = "/token")
	public ResponseEntity<String> login(HttpServletRequest request) {
		CsrfToken token = (CsrfToken) request.getAttribute(CsrfToken.class.getName());
		HttpHeaders headers = new HttpHeaders();
		headers.add(token.getHeaderName(), token.getToken());
		return new ResponseEntity<>("you got your token", headers, HttpStatus.OK);
	}
	
	@PreAuthorize("hasRole('USER')")
	@RequestMapping(value = "/upload", method = RequestMethod.POST)
	public ResponseEntity<String> postSolution(Principal principal, @RequestBody String solution) throws Exception {
		Account account = accountRepository.findOne(principal.getName());
		Node node = MarketplaceSerializer.deSerializeSolution(solution);
		Object result = marketplaceDAO.saveOrUpdateSolution(node, account);
		if (result instanceof Node) {
			return new ResponseEntity<String>(MarketplaceSerializer.serialize((Node) result),HttpStatus.OK);
		} else {
			if (result instanceof Exception){
				((Exception) result).printStackTrace();
				String message = ((Exception) result).getMessage();
				return new ResponseEntity<String>(message,HttpStatus.INTERNAL_SERVER_ERROR);
			} else return new ResponseEntity<String>(result.toString(), HttpStatus.FORBIDDEN);
		}
	}
	
	@PreAuthorize("hasRole('USER')")
	@RequestMapping(value = "/upload-p2repo")
	public ResponseEntity<String> uploadRepository(
			Principal principal,
			@RequestParam("id") Long id,
			@RequestParam("file") MultipartFile file) throws Exception {
		// verify that we have the correct owner
		Account account = accountRepository.findOne(principal.getName());
		Account a = accountRepository.findAccountBySolutionId(id); 
		if (!account.getUsername().equals(a.getUsername())) {
			return new ResponseEntity<String>("Logged in user is not the owner of the solution", HttpStatus.FORBIDDEN);
		}
		fileService.uploadRepository(id, file);
		// return the solution, the default value for update site will work just fine
		Node node = marketplaceDAO.getSolution(id);
		return new ResponseEntity<String>(MarketplaceSerializer.serialize((Node) node),HttpStatus.OK);
	}

	/**
	 * Uploads a screenshot to the solution and updates the solution data with
	 * the name of the file being uploaded. returns a <b>403 Forbidden</b> if
	 * the logged in user is not the owner of the solution.
	 */
	@PreAuthorize("hasRole('USER')")
	@RequestMapping(value = "/upload-screenshot")
	public ResponseEntity<String> uploadScreenshot(
			Principal principal,
			@RequestParam("id") Long id,
			@RequestParam("file") MultipartFile file) throws Exception {
		// verify that we have the correct owner
		Account account = accountRepository.findOne(principal.getName());
		if (!canEdit(principal, id)) {
			return new ResponseEntity<String>("Logged in user is not the owner of the solution", HttpStatus.FORBIDDEN);
		}
		fileService.saveSolutionFile(id, file);
		// get solution and update with new information
		Node node = marketplaceDAO.getSolution(id);
		node.setScreenshot(file.getOriginalFilename());
		Object result = marketplaceDAO.saveOrUpdateSolution(node,account);
		if (result instanceof Node) {
			return new ResponseEntity<String>(MarketplaceSerializer.serialize((Node) result),HttpStatus.OK);
		} else {
			return new ResponseEntity<String>((String) result,HttpStatus.INTERNAL_SERVER_ERROR);
		}		
	}
	
	/**
	 * Uploads a image to the solution and updates the solution data with
	 * the name of the file being uploaded. returns a <b>403 Forbidden</b> if
	 * the logged in user is not the owner of the solution.
	 */
	@PreAuthorize("hasRole('USER')")
	@RequestMapping(value = "/upload-image")
	public ResponseEntity<String> uploadImage (
			Principal principal,
			@RequestParam("id") Long id,
			@RequestParam("file") MultipartFile file) throws Exception {
		// verify that we have the correct owner
		Account account = accountRepository.findOne(principal.getName());
		if (!canEdit(principal, id)) {
			return new ResponseEntity<String>("Logged in user is not the owner of the solution", HttpStatus.FORBIDDEN);
		}
		fileService.saveSolutionFile(id, file);
		// get solution and update with new information
		Node node = marketplaceDAO.getSolution(id);
		node.setImage(file.getOriginalFilename());
		Object result = marketplaceDAO.saveOrUpdateSolution(node,account);
		if (result instanceof Node) {
			return new ResponseEntity<String>(MarketplaceSerializer.serialize((Node) result),HttpStatus.OK);
		} else {
			return new ResponseEntity<String>((String) result,HttpStatus.INTERNAL_SERVER_ERROR);
		}		
	}
	
	private boolean canEdit(Principal principal, Long identifier) {
		Account account = accountRepository.findOne(principal.getName());
		Account a = accountRepository.findAccountBySolutionId(identifier);
		if (account.getUsername().equals(a.getUsername())) {
			return true;
		}
		return false;		
	}
}
