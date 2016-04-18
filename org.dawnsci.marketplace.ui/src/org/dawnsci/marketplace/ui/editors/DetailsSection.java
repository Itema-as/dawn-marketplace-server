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
package org.dawnsci.marketplace.ui.editors;

import java.util.Iterator;

import org.dawnsci.marketplace.MarketplaceFactory;
import org.dawnsci.marketplace.MarketplacePackage.Literals;
import org.dawnsci.marketplace.Node;
import org.dawnsci.marketplace.Tag;
import org.dawnsci.marketplace.Tags;
import org.dawnsci.marketplace.core.MarketplaceUtility;
import org.eclipse.core.databinding.DataBindingContext;
import org.eclipse.core.databinding.UpdateValueStrategy;
import org.eclipse.core.databinding.conversion.Converter;
import org.eclipse.core.databinding.observable.value.IObservableValue;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.databinding.EMFObservables;
import org.eclipse.jface.databinding.swt.WidgetProperties;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;
import org.eclipse.ui.forms.SectionPart;
import org.eclipse.ui.forms.widgets.FormToolkit;
import org.eclipse.ui.forms.widgets.Section;

public class DetailsSection extends SectionPart {

	private Text name;
	private Text organization;
	private Text owner;
	private Text websiteUrl;
	private Text supportUrl;
	private Text tags;
	private Combo status;
	private Combo license;

	private Node solution;
	
	public class CommaSeparatedListToTagsConverter extends Converter {
		
		public CommaSeparatedListToTagsConverter() {
			super(String.class, Tags.class);
		}

		@Override
		public Object convert(Object input) {
			Tags tagsCollection = MarketplaceFactory.eINSTANCE.createTags();
			String[] tags = ((String)input).split(",");
			for (String string : tags) {
				Tag tag = MarketplaceFactory.eINSTANCE.createTag();
				tag.setName(string.trim());
				tagsCollection.getItems().add(tag);
			}
			return tagsCollection;
		}
		
	}
	
	public class TagsToCommaSeparatedListConverter extends Converter {

		public TagsToCommaSeparatedListConverter() {
			super(Tags.class, String.class);
		}

		@Override
		public Object convert(Object input) {
			StringBuilder list = new StringBuilder();
			EList<Tag> tags = ((Tags)input).getItems();
			for (Iterator<Tag> iterator = tags.iterator(); iterator.hasNext();) {
				Tag tag = iterator.next();
				list.append(tag.getName());
				if (iterator.hasNext()){
					list.append(", ");
				}
			}
			return list.toString();
		}
		
	}

	public DetailsSection(Composite parent, FormToolkit toolkit, int style) {
		super(parent, toolkit, style);
		createClient(getSection(), toolkit);
	}

	private void createClient(Section section, FormToolkit toolkit) {
		
		section.setText("Details");
		
		Composite container = toolkit.createComposite(section);
		section.setClient(container);
		
		container.setLayout(new GridLayout(2, false));
		
		// plug-in name
		
		Label lblName = toolkit.createLabel(container, "Name:", SWT.NONE);
		lblName.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false, 1, 1));
		
		name = toolkit.createText(container, "", SWT.NONE);
		GridData gd_txtName = new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1);
		gd_txtName.minimumWidth = 150;
		name.setLayoutData(gd_txtName);
		
		// owner name
		
		Label lblOwner = toolkit.createLabel(container, "Owner:", SWT.NONE);
		lblOwner.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false, 1, 1));
		
		owner = toolkit.createText(container, "", SWT.NONE);
		GridData gd_txtOwner = new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1);
		gd_txtOwner.minimumWidth = 150;
		owner.setLayoutData(gd_txtOwner);
		
		// organization name
		
		Label lblOrganisation = toolkit.createLabel(container, "Organisation:", SWT.NONE);
		lblOrganisation.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false, 1, 1));
		
		organization = toolkit.createText(container, "", SWT.NONE);
		organization.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
		
		// sorting tags
		
		Label lblTags = toolkit.createLabel(container, "Tags:", SWT.NONE);
		lblTags.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false, 1, 1));
				
		tags = toolkit.createText(container, "", SWT.NONE);
		tags.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));

		// license combo
		
		Label lblLicense = toolkit.createLabel(container, "License:", SWT.NONE);
		lblLicense.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false, 1, 1));
		
		license = new Combo(container, SWT.READ_ONLY);
		license.setItems(MarketplaceUtility.LICENSES);		
		
		license.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
		toolkit.adapt(license);
		toolkit.paintBordersFor(license);
		
		// status combo
		
		Label lblStatus = toolkit.createLabel(container, "Status:", SWT.NONE);
		lblStatus.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false, 1, 1));
		
		status = new Combo(container, SWT.READ_ONLY);
		status.setItems(MarketplaceUtility.STATUS);
		status.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
		toolkit.adapt(status);
		toolkit.paintBordersFor(status);
		
		// website url
		
		Label lblWebsiteUrl = toolkit.createLabel(container, "Website URL:", SWT.NONE);
		lblWebsiteUrl.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false, 1, 1));
		
		websiteUrl = toolkit.createText(container, "", SWT.NONE);
		websiteUrl.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
		
		// support url
		
		Label lblSupportUrl = toolkit.createLabel(container, "Support URL:", SWT.NONE);
		lblSupportUrl.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false, 1, 1));
		
		supportUrl = toolkit.createText(container, "", SWT.NONE);
		supportUrl.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
				
	}
	
	@Override
	public boolean setFormInput(Object input) {
		this.solution = (Node)input;
		initDataBindings();
		return true;
	}
	
	protected DataBindingContext initDataBindings() {
		DataBindingContext bindingContext = new DataBindingContext();
		//
		IObservableValue observeNameObserveWidget = WidgetProperties.text(SWT.Modify).observe(name);
		IObservableValue solutionNameObserveValue = EMFObservables.observeValue(solution, Literals.NODE__NAME);
		bindingContext.bindValue(observeNameObserveWidget, solutionNameObserveValue, null, null);
		//
		IObservableValue observeOrganisationObserveWidget = WidgetProperties.text(SWT.Modify).observe(organization);
		IObservableValue solutionCompanynameObserveValue = EMFObservables.observeValue(solution, Literals.NODE__COMPANYNAME);
		bindingContext.bindValue(observeOrganisationObserveWidget, solutionCompanynameObserveValue, null, null);
		//
		IObservableValue observeOwnerObserveWidget = WidgetProperties.text(SWT.Modify).observe(owner);
		IObservableValue solutionOwnerObserveValue = EMFObservables.observeValue(solution, Literals.NODE__OWNER);
		bindingContext.bindValue(observeOwnerObserveWidget, solutionOwnerObserveValue, null, null);
		//
		IObservableValue observeWebsiteUrlObserveWidget = WidgetProperties.text(SWT.Modify).observe(websiteUrl);
		IObservableValue solutionUrlObserveValue = EMFObservables.observeValue(solution, Literals.NODE__URL);
		bindingContext.bindValue(observeWebsiteUrlObserveWidget, solutionUrlObserveValue, null, null);
		//
		IObservableValue observeSupportUrlObserveWidget = WidgetProperties.text(SWT.Modify).observe(supportUrl);
		IObservableValue solutionSupporturlObserveValue = EMFObservables.observeValue(solution, Literals.NODE__SUPPORTURL);
		bindingContext.bindValue(observeSupportUrlObserveWidget, solutionSupporturlObserveValue, null, null);
		//
		IObservableValue observeStatusObserveWidget = WidgetProperties.text().observe(status);
		IObservableValue solutionStatusObserveValue = EMFObservables.observeValue(solution, Literals.NODE__STATUS);
		bindingContext.bindValue(observeStatusObserveWidget, solutionStatusObserveValue, null, null);
		//
		IObservableValue observeLicenseObserveWidget = WidgetProperties.text().observe(license);
		IObservableValue solutionLicenseObserveValue = EMFObservables.observeValue(solution, Literals.NODE__LICENSE);
		bindingContext.bindValue(observeLicenseObserveWidget, solutionLicenseObserveValue, null, null);
		//
		IObservableValue observeTagsObserveWidget = WidgetProperties.text(SWT.Modify).observe(tags);
		IObservableValue solutionTagsObserveValue = EMFObservables.observeValue(solution, Literals.NODE__TAGS);
		UpdateValueStrategy solutionTagsToModelStrategy = new UpdateValueStrategy();
		solutionTagsToModelStrategy.setConverter(new CommaSeparatedListToTagsConverter());
		UpdateValueStrategy solutionModelToTagsStrategy = new UpdateValueStrategy();
		solutionModelToTagsStrategy.setConverter(new TagsToCommaSeparatedListConverter());
		bindingContext.bindValue(observeTagsObserveWidget, solutionTagsObserveValue, solutionTagsToModelStrategy, solutionModelToTagsStrategy);
		//
		return bindingContext;
	}

}
