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
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.IEditorSite;
import org.eclipse.ui.forms.IManagedForm;
import org.eclipse.ui.forms.editor.FormEditor;
import org.eclipse.ui.forms.editor.FormPage;
import org.eclipse.ui.forms.widgets.FormToolkit;
import org.eclipse.ui.forms.widgets.ScrolledForm;
import org.eclipse.ui.forms.widgets.Section;

public class DescriptionPage extends FormPage {

	private Node solution;
	private IEditorSite site;

	public DescriptionPage(String id, String title) {
		super(id, title);
	}

	public DescriptionPage(FormEditor editor, String id, String title, Node solution, IEditorSite site) {
		super(editor, id, title);
		this.solution = solution;
		this.site = site;
	}

	@Override
	public boolean isEditor() {
		return true;
	}

	@Override
	protected void createFormContent(IManagedForm managedForm) {
		FormToolkit toolkit = managedForm.getToolkit();
		ScrolledForm form = managedForm.getForm();
		form.setText("Description");
		Composite body = form.getBody();
		toolkit.decorateFormHeading(form.getForm());
		toolkit.paintBordersFor(body);		
		
		body.setLayout(new FillLayout());

		DescriptionSection detailsSection = new DescriptionSection(managedForm.getForm().getBody(), toolkit, Section.NO_TITLE, site);
		detailsSection.setFormInput(solution);
				
	}
}
