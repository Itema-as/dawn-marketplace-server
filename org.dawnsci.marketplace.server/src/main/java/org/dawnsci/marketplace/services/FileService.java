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
package org.dawnsci.marketplace.services;

import java.io.File;
import java.nio.file.Path;

import org.springframework.stereotype.Service;

/**
 * Keeps track of files belonging to the various solutions on the marketplace.
 * 
 * @author Torkild U. Resheim, Itema AS
 */
@Service
public class FileService {

	private static Path solutionsRoot;

	private static Path pagesRoot;

	public FileService() {
		solutionsRoot = new File(System.getProperty("user.dir"),"solutions").toPath();
		if (!solutionsRoot.toFile().exists()) {
			solutionsRoot.toFile().mkdirs();
		}
		pagesRoot = new File(System.getProperty("user.dir"),"pages").toPath();
		if (!pagesRoot.toFile().exists()) {
			pagesRoot.toFile().mkdirs();
		}
	}
	
	public File getPageFile(String path){
		if (path.startsWith("pages/")){
			path = path.substring(path.indexOf("/")+1);
		}
		return pagesRoot.resolve(path).toFile();
	}
	
	public File getSolutionFile(String path){
		// TODO: make sure solution exists
		// TODO: filename must only be one segment
		return solutionsRoot.resolve(path).toFile();
	}

	public File getFile(String solution, String filename){
		// TODO: make sure solution exists
		// TODO: filename must only be one segment
		File file = solutionsRoot.resolve(solution).resolve(filename).toFile();
		// some safety measures
		if (file.isDirectory()){
			return null;
		}
		return file;
	}

}
