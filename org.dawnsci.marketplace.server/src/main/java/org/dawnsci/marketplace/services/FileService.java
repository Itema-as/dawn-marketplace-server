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
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Path;

import org.apache.commons.io.FileUtils;
import org.dawnsci.marketplace.InternalErrorException;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.zeroturnaround.zip.ZipUtil;

/**
 * Keeps track of files belonging to the various solutions on the marketplace.
 * 
 * @author Torkild U. Resheim, Itema AS
 */
@Service
public class FileService {

	private static Path solutionsRoot;

	private static Path pagesRoot;
	
	public FileService(Environment environment) {
		solutionsRoot = new File(System.getProperty("user.dir"), environment.getProperty("marketplace.solutions-folder")).toPath();
		if (!solutionsRoot.toFile().exists()) {
			solutionsRoot.toFile().mkdirs();
		}
		pagesRoot = new File(System.getProperty("user.dir"), environment.getProperty("marketplace.pages-folder")).toPath();
		if (!pagesRoot.toFile().exists()) {
			pagesRoot.toFile().mkdirs();
		}
		// make sure that the required file resources are present
		try {
			copyRequiredFile("welcome.md");
			copyRequiredFile("marketplace-icon.png");
			copyRequiredFile("catalog-icon.png");
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	private void copyRequiredFile(String filename) throws IOException {
		File file = getPageFile(filename);
		if (file.exists()) {
			return;
		}
		FileUtils.copyInputStreamToFile(getInputStream("data/pages/" + filename), file);
	}

	private InputStream getInputStream(String filename) {
		try {
			InputStream is = MarketplaceDAO.class.getClassLoader().getResource(filename).openStream();
			return is;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public File getPageFile(String path) {
		if (path.startsWith("pages/")) {
			path = path.substring(path.indexOf("/") + 1);
		}
		return pagesRoot.resolve(path).toFile();
	}

	public File saveSolutionFile(Long solution, MultipartFile file) {
		String fileName = file.getOriginalFilename();
		byte[] buffer = new byte[1000];
		File outputFile = getFile(solution.toString(), fileName);
		outputFile.getParentFile().mkdirs();

		try (InputStream reader = file.getInputStream();
				FileOutputStream writer = new FileOutputStream(outputFile)) {
			outputFile.createNewFile();
			while ((reader.read(buffer)) != -1) {
				writer.write(buffer);
			}
			return outputFile;
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}

	public File getSolutionFile(String path) {
		return solutionsRoot.resolve(path).toFile();
	}

	public File getFile(String solution, String filename) {
		File file = solutionsRoot.resolve(solution).resolve(filename).toFile();
		// some safety measures
		if (file.isDirectory()) {
			return null;
		}
		return file;
	}

	public void deleteSolution(Long id) {
		 File file = solutionsRoot.resolve(id.toString()).toFile();
		 try {
			FileUtils.forceDelete(file);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	public void uploadRepository(Long id, MultipartFile file) {
		try {
			File saveSolutionFile = saveSolutionFile(id, file);
			// the p2-repository will be unpacked into the solution root folder
			File p2repo = getSolutionFile(id.toString());
			// delete the old stuff
			FileUtils.deleteDirectory(new File(p2repo, "features"));
			FileUtils.deleteDirectory(new File(p2repo, "plugins"));
			FileUtils.deleteQuietly(new File(p2repo, "content.jar"));
			FileUtils.deleteQuietly(new File(p2repo, "artifacts.jar"));
			// unpack to root folder
			ZipUtil.unpack(saveSolutionFile, p2repo);
			// and delete the uploaded zip-file
			FileUtils.deleteQuietly(saveSolutionFile);
		} catch (Exception e) {
			throw new InternalErrorException(e);
		}
	}

}
