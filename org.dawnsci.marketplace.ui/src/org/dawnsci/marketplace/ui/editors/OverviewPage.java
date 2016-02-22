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

import org.dawnsci.marketplace.Node;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.forms.IManagedForm;
import org.eclipse.ui.forms.editor.FormEditor;
import org.eclipse.ui.forms.editor.FormPage;
import org.eclipse.ui.forms.widgets.FormToolkit;
import org.eclipse.ui.forms.widgets.ScrolledForm;
import org.eclipse.ui.forms.widgets.Section;

public class OverviewPage extends FormPage {

	private Node solution;

	public OverviewPage(String id, String title) {
		super(id, title);
	}

	public OverviewPage(FormEditor editor, String id, String title, Node solution) {
		super(editor, id, title);
		this.solution = solution;
	}

	@Override
	protected void createFormContent(IManagedForm managedForm) {
		FormToolkit toolkit = managedForm.getToolkit();
		ScrolledForm form = managedForm.getForm();
		form.setText("Overview");
		Composite body = form.getBody();
		toolkit.decorateFormHeading(form.getForm());
		toolkit.paintBordersFor(body);

		body.setLayout(new GridLayout(2, false));

		DetailsSection detailsSection = new DetailsSection(managedForm.getForm().getBody(), toolkit, Section.TITLE_BAR);
		detailsSection.initialize(managedForm);
		GridData gdDetails = new GridData(GridData.FILL, GridData.FILL, true, true);
		gdDetails.verticalAlignment = SWT.BEGINNING;
		gdDetails.widthHint=300;
		detailsSection.getSection().setLayoutData(gdDetails);
		detailsSection.setFormInput(solution);

		ShortDescriptionSection descriptionSection = new ShortDescriptionSection(managedForm.getForm().getBody(),
				toolkit, Section.TITLE_BAR);
		descriptionSection.initialize(managedForm);
		GridData gdDescription = new GridData(GridData.FILL, GridData.FILL, true, true);
		descriptionSection.getSection().setLayoutData(gdDescription);
		descriptionSection.setFormInput(solution);

		ImagesSection imagesSection = new ImagesSection(managedForm.getForm().getBody(), toolkit, Section.TITLE_BAR);
		imagesSection.initialize(managedForm);
		GridData gdImages = new GridData(GridData.FILL, GridData.FILL, true, true);
		gdImages.verticalAlignment = SWT.BEGINNING;
		gdImages.horizontalSpan = 2;
		imagesSection.getSection().setLayoutData(gdImages);
		imagesSection.setFormInput(solution);
	}
}
