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

import org.dawnsci.marketplace.MarketplacePackage.Literals;
import org.dawnsci.marketplace.Node;
import org.eclipse.core.databinding.DataBindingContext;
import org.eclipse.core.databinding.observable.value.IObservableValue;
import org.eclipse.emf.databinding.EMFObservables;
import org.eclipse.jface.databinding.swt.WidgetProperties;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Text;
import org.eclipse.ui.forms.SectionPart;
import org.eclipse.ui.forms.widgets.FormToolkit;
import org.eclipse.ui.forms.widgets.Section;

public class ShortDescriptionSection extends SectionPart {

	private Text txtShortDescription;
	private Node solution;

	public ShortDescriptionSection(Composite parent, FormToolkit toolkit, int style) {
		super(parent, toolkit, style);
		createClient(getSection(), toolkit);
	}

	private void createClient(Section section, FormToolkit toolkit) {
		section.setText("Short description");
		Composite container = toolkit.createComposite(section);

		section.setClient(container);
		
		container.setLayout(new GridLayout());

		// short description
		txtShortDescription = toolkit.createText(container, "", SWT.WRAP | SWT.V_SCROLL | SWT.MULTI);
		GridData gridData = new GridData(SWT.FILL, SWT.FILL, true, true);		
		gridData.widthHint=200; // must be set to some value for the wrap to work
		txtShortDescription.setLayoutData(gridData);
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
		IObservableValue observeTextTextObserveWidget = WidgetProperties.text(SWT.Modify).observe(txtShortDescription);
		IObservableValue solutionShortdescriptionObserveValue = EMFObservables.observeValue(solution, Literals.NODE__RAW_SHORTDESCRIPTION);
		bindingContext.bindValue(observeTextTextObserveWidget, solutionShortdescriptionObserveValue, null, null);
		//
		return bindingContext;
	}

}
