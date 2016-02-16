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

import java.io.File;
import java.io.IOException;

import javax.servlet.http.HttpServletRequest;

import org.apache.tika.Tika;
import org.dawnsci.marketplace.services.FileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.FileSystemResource;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.util.AntPathMatcher;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.HandlerMapping;

/**
 * Handles file resources under "/files/".
 * 
 * @author Torkild U. Resheim, Itema AS
 */
@Controller
@RequestMapping(value = "/files")
public class FileController {
	
	@Autowired
	private FileService fileService;

	private Tika tika;

	public FileController() {
		tika = new Tika();
	}

	@RequestMapping(value = "/{solution}/**", method = {RequestMethod.GET, RequestMethod.HEAD})
	@ResponseBody
	public ResponseEntity<FileSystemResource> getFile(@PathVariable("solution") String solution,
			HttpServletRequest request) {
		String path = (String) request.getAttribute(HandlerMapping.PATH_WITHIN_HANDLER_MAPPING_ATTRIBUTE);
		String bestMatchPattern = (String ) request.getAttribute(HandlerMapping.BEST_MATCHING_PATTERN_ATTRIBUTE);
	    AntPathMatcher apm = new AntPathMatcher();
	    path = apm.extractPathWithinPattern(bestMatchPattern, path);
	    File file = fileService.getFile(solution, path);
		if (file.exists() && file.isFile()) {
			try {
				String detect = tika.detect(file);
				MediaType mediaType = MediaType.parseMediaType(detect);
				return ResponseEntity.ok().contentLength(file.length()).contentType(mediaType)
						.body(new FileSystemResource(file));
			} catch (IOException e) {
				e.printStackTrace();
			}
		} else {
            throw new ResourceNotFoundException(); 
        }		
		return null;
	}
}