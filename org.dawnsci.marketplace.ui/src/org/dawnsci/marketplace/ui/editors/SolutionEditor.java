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

import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.StringWriter;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import org.dawnsci.marketplace.MarketplaceFactory;
import org.dawnsci.marketplace.MarketplacePackage;
import org.dawnsci.marketplace.Node;
import org.dawnsci.marketplace.util.MarketplaceResourceFactoryImpl;
import org.dawnsci.marketplace.util.MarketplaceResourceImpl;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IResourceChangeEvent;
import org.eclipse.core.resources.IResourceChangeListener;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.common.util.Diagnostic;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.URIConverter;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.util.Diagnostician;
import org.eclipse.emf.ecore.util.EContentAdapter;
import org.eclipse.emf.ecore.xmi.XMLResource;
import org.eclipse.emf.ecore.xmi.impl.XMLResourceImpl;
import org.eclipse.swt.custom.CTabFolder;
import org.eclipse.swt.widgets.Display;
import org.eclipse.ui.IEditorInput;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.IEditorSite;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.actions.ActionFactory;
import org.eclipse.ui.actions.ActionFactory.IWorkbenchAction;
import org.eclipse.ui.forms.editor.FormEditor;
import org.eclipse.ui.part.FileEditorInput;

public class SolutionEditor extends FormEditor implements IResourceChangeListener {

	private Node node = null;
	boolean dirty = false;
	private IWorkbenchAction fSaveAction;

	public SolutionEditor() {
		super();
		ResourcesPlugin.getWorkspace().addResourceChangeListener(this);		
	}
	
	public void dispose() {
		ResourcesPlugin.getWorkspace().removeResourceChangeListener(this);
		fSaveAction.dispose();		
		super.dispose();
	}

	/**
	 * Closes all project files on project close.
	 */
	public void resourceChanged(final IResourceChangeEvent event) {
		if (event.getType() == IResourceChangeEvent.PRE_CLOSE) {
			Display.getDefault().asyncExec(new Runnable() {
				public void run() {
					IWorkbenchPage[] pages = getSite().getWorkbenchWindow().getPages();
					for (int i = 0; i < pages.length; i++) {
						// if(((FileEditorInput)editor.getEditorInput()).getFile().getProject().equals(event.getResource())){
						// IEditorPart editorPart =
						// pages[i].findEditor(editor.getEditorInput());
						// pages[i].closeEditor(editorPart,true);
						// }
					}
				}
			});
		}
	}

	private Node loadSerialized(File file) {
		ResourceSet rs = new ResourceSetImpl();
		rs.getPackageRegistry().put(null, MarketplacePackage.eINSTANCE);
		try {
			Resource resource = rs.createResource(URI.createFileURI(file.getName()));
			resource.load(new FileInputStream(file), rs.getLoadOptions());
			return (Node) resource.getContents().get(0);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * Registers a new resource factory for the data structures. This is
	 * normally done through Eclipse extension points but we also need to be
	 * able to create this factory without the Eclipse runtime.
	 */
	static {
		// register package so that it is available even without the Eclipse
		// runtime
		@SuppressWarnings("unused")
		MarketplacePackage packageInstance = MarketplacePackage.eINSTANCE;
		// register the resource factory
		Resource.Factory.Registry.INSTANCE.getExtensionToFactoryMap().put("*", new MarketplaceResourceFactoryImpl() {
			@Override
			public Resource createResource(URI uri) {
				// create the new resource implementation
				MarketplaceResourceImpl xmiResource = new MarketplaceResourceImpl(uri);
				// obtain options
				Map<Object, Object> loadOptions = xmiResource.getDefaultLoadOptions();
				Map<Object, Object> saveOptions = xmiResource.getDefaultSaveOptions();
				// use extended metadata for both loading and saving
				saveOptions.put(XMLResource.OPTION_EXTENDED_META_DATA, Boolean.TRUE);
				loadOptions.put(XMLResource.OPTION_EXTENDED_META_DATA, Boolean.TRUE);
				// Treat "href" attributes as features
				loadOptions.put(XMLResource.OPTION_USE_ENCODED_ATTRIBUTE_STYLE, Boolean.TRUE);
				// required in order to correctly read in attributes
				loadOptions.put(XMLResource.OPTION_LAX_FEATURE_PROCESSING, Boolean.TRUE);
				// We UTF-8 encoding
				loadOptions.put(XMLResource.OPTION_ENCODING, "UTF-8");
				saveOptions.put(XMLResource.OPTION_ENCODING, "UTF-8");
				// do not download any external DTDs.
				Map<String, Object> parserFeatures = new HashMap<String, Object>();
				parserFeatures.put("http://xml.org/sax/features/validation", Boolean.FALSE); //$NON-NLS-1$
				parserFeatures.put("http://apache.org/xml/features/nonvalidating/load-external-dtd", //$NON-NLS-1$
						Boolean.FALSE);
				loadOptions.put(XMLResource.OPTION_PARSER_FEATURES, parserFeatures);
				return xmiResource;
			}
		});
	}

	@Override
	public boolean isDirty() {
		return dirty;
	}

	@Override
	public void setFocus() {
	}

	@Override
	public void doSave(IProgressMonitor monitor) {
		FileEditorInput i = (FileEditorInput) getEditorInput();
		File file = i.getPath().toFile();
		validateObject(node);
		try (FileWriter fw = new FileWriter(file)) {
			fw.write(serialize(node));
			i.getFile().refreshLocal(IFile.DEPTH_ZERO, monitor);
			dirty = false;
			firePropertyChange(IEditorPart.PROP_DIRTY);
		} catch (IOException | CoreException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void doSaveAs() {
		try {
			System.out.println(serialize(node));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private String serialize(Node rootElement) throws IOException {
		Map<String, Object> saveOptions = new HashMap<String, Object>();
		saveOptions.put(XMLResource.OPTION_EXTENDED_META_DATA, Boolean.TRUE);
		XMLResource resource = new XMLResourceImpl();
		resource.getContents().add(rootElement);
		StringWriter stringWriter = new StringWriter();
		resource.save(new URIConverter.WriteableOutputStream(stringWriter, resource.getEncoding()), saveOptions);
		return stringWriter.getBuffer().toString();
	}

	@Override
	public void init(IEditorSite site, IEditorInput input) throws PartInitException {
		setSite(site);
		setInput(input);

		fSaveAction= ActionFactory.SAVE.create(getSite().getWorkbenchWindow());
		site.getActionBars().setGlobalActionHandler(ActionFactory.SAVE.getId(), fSaveAction);
		site.getActionBars().updateActionBars();
		
		FileEditorInput i = (FileEditorInput) input;
		try {
			node = loadSerialized(i.getPath().toFile());
		} catch (Exception e) {
			// TODO: Notify about error loading
		}
		if (node==null) {
			node = MarketplaceFactory.eINSTANCE.createNode();
		}
		// detect changes
		EContentAdapter adapter = new EContentAdapter() {
			@Override
			public void notifyChanged(org.eclipse.emf.common.notify.Notification notification) {
				super.notifyChanged(notification);				
				dirty = true;
				SolutionEditor.this.firePropertyChange(IEditorPart.PROP_DIRTY);
				SolutionEditor.this.setPartName(node.getName());
			}
		};
		node.eAdapters().add(adapter);
		adapter.setTarget(node);
		// use the plug-in title as the part title
		setPartName(node.getName());
		firePropertyChange(IEditorPart.PROP_DIRTY);
	}

	@Override
	public boolean isSaveAsAllowed() {
		return true;
	}

	public static boolean validateObject(EObject eObject) {
		Diagnostic diagnostic = Diagnostician.INSTANCE.validate(eObject);
		if (diagnostic.getSeverity() == Diagnostic.ERROR || diagnostic.getSeverity() == Diagnostic.WARNING) {
			System.err.println(diagnostic.getMessage());
			for (Iterator<Diagnostic> i = diagnostic.getChildren().iterator();; i.hasNext()) {
				Diagnostic childDiagnostic = (Diagnostic) i.next();
				switch (childDiagnostic.getSeverity()) {
				case Diagnostic.ERROR:
				case Diagnostic.WARNING:
					System.err.println("\t" + childDiagnostic.getMessage());
				}
			}
			//return false;
		}
		return true;
	}

	@Override
	protected void addPages() {
		try {			
			addPage(new OverviewPage(this, "1", "Overview", node));
			addPage(new DescriptionPage(this, "2", "Description", node, getEditorSite()));
		} catch (PartInitException e) {
			e.printStackTrace();
		}		
	}
	@Override
	protected void createPages() {
		super.createPages();
		// remove tab at bottom if only one page was created
		if (getPageCount() == 1 && getContainer() instanceof CTabFolder) {
			((CTabFolder) getContainer()).setTabHeight(0);
		}
	}

}
