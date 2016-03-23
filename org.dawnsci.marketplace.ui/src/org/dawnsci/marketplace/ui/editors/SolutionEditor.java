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
import java.io.FileWriter;
import java.io.IOException;

import org.dawnsci.marketplace.MarketplaceFactory;
import org.dawnsci.marketplace.Node;
import org.dawnsci.marketplace.core.MarketplaceSerializer;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IResourceChangeEvent;
import org.eclipse.core.resources.IResourceChangeListener;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.ecore.util.EContentAdapter;
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


	@Override
	public boolean isDirty() {
		// TODO: Do another attempt on getting FormEditor.isDirty() to work properly
		return dirty;
	}

	@Override
	public void setFocus() {
	}

	@Override
	public void doSave(IProgressMonitor monitor) {
		FileEditorInput i = (FileEditorInput) getEditorInput();
		File file = i.getPath().toFile();
		try (FileWriter fw = new FileWriter(file)) {
			fw.write(MarketplaceSerializer.serialize(node));
			i.getFile().refreshLocal(IFile.DEPTH_ZERO, monitor);
			dirty = false;
			firePropertyChange(IEditorPart.PROP_DIRTY);
		} catch (IOException | CoreException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void doSaveAs() {
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
			node = MarketplaceSerializer.loadNode(i.getPath().toFile());
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
				SolutionEditor.this.setPartName(getSolutionTitle());
			}
		};
		node.eAdapters().add(adapter);
		adapter.setTarget(node);
		setPartName(getSolutionTitle());
		firePropertyChange(IEditorPart.PROP_DIRTY);
	}

	private String getSolutionTitle() {
		String name = node.getName();
		if (node.getId()!=null) {
			name = "#"+node.getId()+" - "+node.getName();
		}
		return name;
	}

	@Override
	public boolean isSaveAsAllowed() {
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
