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

import org.dawnsci.marketplace.MarketplacePackage.Literals;
import org.dawnsci.marketplace.Node;
import org.eclipse.core.databinding.DataBindingContext;
import org.eclipse.core.databinding.observable.value.IObservableValue;
import org.eclipse.emf.databinding.EMFObservables;
import org.eclipse.jface.databinding.swt.WidgetProperties;
import org.eclipse.jface.resource.JFaceResources;
import org.eclipse.jface.text.Document;
import org.eclipse.jface.text.source.AnnotationModel;
import org.eclipse.jface.text.source.IAnnotationAccess;
import org.eclipse.jface.text.source.ISourceViewer;
import org.eclipse.mylyn.commons.workbench.editors.CommonTextSupport;
import org.eclipse.mylyn.wikitext.core.parser.markup.MarkupLanguage;
import org.eclipse.mylyn.wikitext.markdown.core.MarkdownLanguage;
import org.eclipse.mylyn.wikitext.ui.editor.MarkupSourceViewer;
import org.eclipse.mylyn.wikitext.ui.editor.MarkupSourceViewerConfiguration;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.DisposeEvent;
import org.eclipse.swt.events.DisposeListener;
import org.eclipse.swt.graphics.Font;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.IEditorSite;
import org.eclipse.ui.editors.text.EditorsUI;
import org.eclipse.ui.forms.SectionPart;
import org.eclipse.ui.forms.widgets.FormToolkit;
import org.eclipse.ui.forms.widgets.Section;
import org.eclipse.ui.handlers.IHandlerService;
import org.eclipse.ui.texteditor.AnnotationPreference;
import org.eclipse.ui.texteditor.DefaultMarkerAnnotationAccess;
import org.eclipse.ui.texteditor.MarkerAnnotationPreferences;
import org.eclipse.ui.texteditor.SourceViewerDecorationSupport;

public class DescriptionSection extends SectionPart {

	private MarkupSourceViewer markupViewer;
	private IEditorSite site;
	private Node solution;

	public DescriptionSection(Composite parent, FormToolkit toolkit, int style, IEditorSite site) {
		super(parent, toolkit, style);
		this.site = site;
		createClient(getSection(), toolkit);
	}

	/**
	 * Fill the section.
	 */
	private void createClient(Section section, FormToolkit toolkit) {
		Composite container = toolkit.createComposite(section);

		section.setClient(container);

		container.setLayout(new GridLayout());

		MarkupLanguage language = new MarkdownLanguage();
		markupViewer = new MarkupSourceViewer(container, null, SWT.WRAP | SWT.V_SCROLL, language);
		GridData gridData = new GridData(SWT.FILL, SWT.FILL, true, true, 1, 1);
		markupViewer.getControl().setLayoutData(gridData);

		MarkupSourceViewerConfiguration configuration = new MarkupSourceViewerConfiguration(EditorsUI.getPreferenceStore());

		Font font = JFaceResources.getTextFont();
		markupViewer.getTextWidget().setFont(font);

		configuration.setMarkupLanguage(language);
		markupViewer.configure(configuration);
		markupViewer.setEditable(true);

		markupViewer.getTextWidget().setData("textViewer", markupViewer);
		markupViewer.getTextWidget().setData(MarkupLanguage.class.getName(), language);
		markupViewer.getTextWidget().setData(ISourceViewer.class.getName(), markupViewer);

		// install common text support such as content assist
		IHandlerService handlerService = (IHandlerService) getSite().getService(IHandlerService.class);
		CommonTextSupport textSupport = new CommonTextSupport(handlerService);
		textSupport.install(markupViewer, true);

		getSite().setSelectionProvider(markupViewer.getSelectionProvider());
		configure(markupViewer, new Document());
	}
	
	private void configure(MarkupSourceViewer viewer, Document document) {
		AnnotationModel annotationModel = new AnnotationModel();
		viewer.showAnnotations(false);
		viewer.showAnnotationsOverview(false);
		IAnnotationAccess annotationAccess = new DefaultMarkerAnnotationAccess();
		final SourceViewerDecorationSupport support = new SourceViewerDecorationSupport(viewer, null, annotationAccess,
				EditorsUI.getSharedTextColors());
		Iterator<?> e = new MarkerAnnotationPreferences().getAnnotationPreferences().iterator();
		while (e.hasNext()) {
			support.setAnnotationPreference((AnnotationPreference) e.next());
		}
		support.install(EditorsUI.getPreferenceStore());
		viewer.getTextWidget().addDisposeListener(new DisposeListener() {
			@Override
			public void widgetDisposed(DisposeEvent e) {
				support.uninstall();
			}
		});
		viewer.setDocument(document, annotationModel);
	}
	
	private IEditorSite getSite() {
		return site;
	}
	
	@Override
	public boolean setFormInput(Object input) {
		this.solution = (Node) input;
		initDataBindings();
		return true;
	}

	protected DataBindingContext initDataBindings() {
		DataBindingContext bindingContext = new DataBindingContext();
		//
		IObservableValue observeTextTxtLogoFilePathObserveWidget = WidgetProperties.text(SWT.Modify).observe(markupViewer.getTextWidget());
		IObservableValue solutionImageObserveValue = EMFObservables.observeValue(solution, Literals.NODE__RAW_BODY);
		bindingContext.bindValue(observeTextTxtLogoFilePathObserveWidget, solutionImageObserveValue, null, null);
		//
		return bindingContext;
	}

}
