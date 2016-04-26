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
package org.dawnsci.marketplace;

import java.io.IOException;
import java.io.StringReader;
import java.io.StringWriter;
import java.util.Iterator;

import org.eclipse.emf.common.util.EList;
import org.eclipse.mylyn.wikitext.core.parser.MarkupParser;
import org.eclipse.mylyn.wikitext.core.parser.builder.HtmlDocumentBuilder;
import org.eclipse.mylyn.wikitext.markdown.core.MarkdownLanguage;
import org.springframework.web.multipart.MultipartFile;

/**
 * This type serves as a proxy to {@link org.dawnsci.marketplace.Node} which
 * cannot easily be used in web forms. Where possible methods map 1-1 however
 * in cases where {@link org.dawnsci.marketplace.Node} expects a list of child
 * elements we treat these differently.
 * 
 * @author Torkild U. Resheim, Itema AS
 */
public class NodeProxy {

	private Node node;
	private MultipartFile screenshotfile;
	private MultipartFile imagefile;
	private MultipartFile repositoryfile;
	
	public NodeProxy(Node node) {
		this.setNode(node);
	}

	public NodeProxy() {
		this.setNode(MarketplaceFactory.eINSTANCE.createNode());;
	}

	public Long getId() {
		return getNode().getId();
	}

	public void setId(Long value) {
		getNode().setId(value);
	}

	public String getName() {
		return getNode().getName();
	}

	public void setName(String value) {
		getNode().setName(value);
	}

	public Integer getFavorited() {
		return getNode().getFavorited();
	}

	public void setFavorited(Integer value) {
		getNode().setFavorited(value);
	}

	public Integer getInstallstotal() {
		return getNode().getInstallstotal();
	}

	public void setInstallstotal(Integer value) {
		getNode().setInstallstotal(value);
	}

	public Integer getInstallsrecent() {
		return getNode().getInstallsrecent();
	}

	public void setInstallsrecent(Integer value) {
		getNode().setInstallsrecent(value);
	}

	public String getShortdescription() {
		return getNode().getShortdescription();
	}

	public void setShortdescription(String value) {
		getNode().setShortdescription(value);
	}

	public String getBody() {
		return getNode().getBody();
	}

	public void setBody(String value) {
		getNode().setBody(value);
	}

	public Long getCreated() {
		return getNode().getCreated();
	}

	public void setCreated(Long value) {
		getNode().setCreated(value);
	}

	public Long getChanged() {
		return getNode().getChanged();
	}

	public void setChanged(Long value) {
		getNode().setChanged(value);
	}

	public Integer getFoundationmember() {
		return getNode().getFoundationmember();
	}

	public void setFoundationmember(Integer value) {
		getNode().setFoundationmember(value);
	}

	public String getHomepageurl() {
		return getNode().getHomepageurl();
	}

	public void setHomepageurl(String value) {
		getNode().setHomepageurl(value);
	}

	public String getImage() {
		return getNode().getImage();
	}

	public void setImage(String value) {
		if (value.contains("/")) {
			value = value.substring(value.lastIndexOf('/')+1);
		}
		getNode().setImage(value);
	}

	public String getLicense() {
		return getNode().getLicense();
	}

	public void setLicense(String value) {
		getNode().setLicense(value);
	}

	public String getCompanyname() {
		return getNode().getCompanyname();
	}

	public void setCompanyname(String value) {
		getNode().setCompanyname(value);
	}

	public String getStatus() {
		return getNode().getStatus();
	}

	public void setStatus(String value) {
		getNode().setStatus(value);
	}

	public String getSupporturl() {
		return getNode().getSupporturl();
	}

	public void setSupporturl(String value) {
		getNode().setSupporturl(value);
	}

	public String getVersion() {
		return getNode().getVersion();
	}

	public void setVersion(String value) {
		getNode().setVersion(value);
	}

	public String getEclipseversion() {
		return getNode().getEclipseversion();
	}

	public void setEclipseversion(String value) {
		getNode().setEclipseversion(value);
	}

	public String getUpdateurl() {
		return getNode().getUpdateurl();
	}

	public void setUpdateurl(String value) {
		getNode().setUpdateurl(value);
	}

	public Ius getIus() {
		return getNode().getIus();
	}

	public void setIus(Ius value) {
		getNode().setIus(value);
	}

	public Platforms getPlatforms() {
		return getNode().getPlatforms();
	}

	public void setPlatforms(Platforms value) {
		getNode().setPlatforms(value);
	}

	public String getUrl() {
		return getNode().getUrl();
	}

	public void setUrl(String value) {
		getNode().setUrl(value);
	}

	public String getScreenshot() {
		return getNode().getScreenshot();
	}

	public void setScreenshot(String value) {
		if (value.contains("/")) {
			value = value.substring(value.lastIndexOf('/')+1);
		}
		getNode().setScreenshot(value);
	}

	public String getType() {
		return getNode().getType();
	}

	public void setType(String value) {
		getNode().setType(value);
	}

	public Categories getCategories() {
		return getNode().getCategories();
	}

	public void setCategories(Categories value) {
		getNode().setCategories(value);
	}

	/**
	 * Returns the tags as a list of comma-separated keywords.
	 * 
	 * @return a list of tags
	 */
	public String getTags() {
		StringBuilder list = new StringBuilder();
		if (node.getTags()!=null) {
			EList<Tag> tags = node.getTags().getItems();
			for (Iterator<Tag> iterator = tags.iterator(); iterator.hasNext();) {
				Tag tag = iterator.next();
				list.append(tag.getName());
				if (iterator.hasNext()){
					list.append(", ");
				}
			}
		}
		return list.toString();
	}

	/**
	 * Sets the tags, created from a list of comma-separated keywords.
	 * 
	 * @param value a list of tags
	 */
	public void setTags(String value) {
		Tags tags = MarketplaceFactory.eINSTANCE.createTags();
		String[] tagsList = value.split(",");
		for (String string : tagsList) {
			Tag tag = MarketplaceFactory.eINSTANCE.createTag();
			tag.setName(string.trim());
			tags.getItems().add(tag);
		}
		getNode().setTags(tags);
	}

	public String getOwner() {
		return getNode().getOwner();
	}

	public void setOwner(String value) {
		getNode().setOwner(value);
	}

	public Node getNode() {
		return node;
	}

	public void setNode(Node node) {
		this.node = node;
	}
	
	public MultipartFile getScreenshotfile() {
		return screenshotfile;
	}
	
	public void setScreenshotfile(MultipartFile screenshotfile) {
		this.screenshotfile = screenshotfile;
	}

	public MultipartFile getImagefile() {
		return imagefile;
	}
	
	public void setImagefile(MultipartFile imagefile) {
		this.imagefile = imagefile;
	}

	public MultipartFile getRepositoryfile() {
		return repositoryfile;
	}
	
	public void setRepositoryfile(MultipartFile repositoryfile) {
		this.repositoryfile = repositoryfile;
	}
	
	public String getRawBody() {
		if (node.getRawBody() == null) {
			return node.getBody();
		}
		return node.getRawBody();
	}

	public void setRawBody(String value) {
		node.setRawBody(value);
		node.setBody(toHtml(value));
	}

	public String getRawShortdescription() {
		if (node.getRawShortdescription() == null) {
			return node.getShortdescription();
		}
		return node.getRawShortdescription();
	}

	public void setRawShortdescription(String value) {
		node.setRawShortdescription(value);
		node.setShortdescription(toHtml(value));
	}

	static String toHtml(String markdown) {
		if (markdown == null) {
			return "";
		}
		StringWriter sw = new StringWriter();
		MarkupParser parser = new MarkupParser();
		parser.setMarkupLanguage(new MarkdownLanguage());
		HtmlDocumentBuilder builder = new HtmlDocumentBuilder(sw);
		builder.setEmitAsDocument(false);
		parser.setBuilder(builder);
		try {
			parser.parse(new StringReader(markdown));
		} catch (IOException e) {
			e.printStackTrace();
		}
		return sw.toString();
	}
		
}
