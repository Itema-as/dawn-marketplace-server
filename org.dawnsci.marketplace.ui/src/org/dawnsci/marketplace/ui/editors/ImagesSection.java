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
import org.eclipse.swt.events.PaintEvent;
import org.eclipse.swt.events.PaintListener;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.graphics.ImageData;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Canvas;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.FileDialog;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;
import org.eclipse.ui.forms.IMessage;
import org.eclipse.ui.forms.SectionPart;
import org.eclipse.ui.forms.widgets.FormToolkit;
import org.eclipse.ui.forms.widgets.Section;

public class ImagesSection extends SectionPart {

	private Text txtLogoFilePath;
	private Text txtScreenshotFilePath;
	private Node solution;
	private Canvas canvas;
	private Image screenshot;
	private DataBindingContext bindingContext;
	protected Image logo;

	/**
	 * Create the SectionPart.
	 * 
	 * @param parent
	 * @param toolkit
	 * @param style
	 */
	public ImagesSection(Composite parent, FormToolkit toolkit, int style) {
		super(parent, toolkit, style);
		createClient(getSection(), toolkit);
	}
	
	/**
	 * Fill the section.
	 */
	private void createClient(Section section, FormToolkit toolkit) {

		section.setText("Images");

		Composite container = toolkit.createComposite(section);
		section.setClient(container);

		container.setLayout(new GridLayout(5, false));

		canvas = new Canvas(container, SWT.BORDER | SWT.NO_FOCUS);
		GridData gd_canvas = new GridData(SWT.FILL, SWT.FILL, true, true, 5, 1);
		gd_canvas.widthHint = 400;
		gd_canvas.heightHint = 250;
		canvas.setLayoutData(gd_canvas);
		toolkit.adapt(canvas);
		toolkit.paintBordersFor(canvas);

		// screenshot file

		Label lblScreenshotFile = toolkit.createLabel(container, "Screenshot (16:10):", SWT.NONE);
		lblScreenshotFile.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false, 1, 1));

		txtScreenshotFilePath = toolkit.createText(container, "", SWT.NONE);
		txtScreenshotFilePath.setEditable(false);
		GridData gridData2 = new GridData(SWT.FILL, SWT.CENTER, true, false, 3, 1);
		gridData2.minimumWidth = 150;
		txtScreenshotFilePath.setLayoutData(gridData2);

		Button btnChooseScreenshotFile = toolkit.createButton(container, "...", SWT.NONE);
		btnChooseScreenshotFile.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false, 1, 1));
		btnChooseScreenshotFile.addSelectionListener(new SelectionAdapter() {
			
			@Override
			public void widgetSelected(SelectionEvent e) {
				FileDialog fd = new FileDialog(getSection().getShell(), SWT.OPEN);
				fd.setText("Please select an image file");
				fd.setFilterExtensions(new String[] { "png", "jpg" });
				String open = fd.open();
				if (!(open == null || open.isEmpty())) {
					txtScreenshotFilePath.setText(open);
					screenshot = new Image(canvas.getDisplay(), open);
				}
			}

		});
				
		canvas.addPaintListener(new PaintListener() {
			public void paintControl(PaintEvent e) {
				if (screenshot!=null){
					int y = canvas.getSize().y;
					ImageData imageData = screenshot.getImageData();
					double sx = imageData.width;
					double sy = imageData.height;
					double ratio = sx/sy;
					int x = (int) (y*ratio);
					e.gc.setAntialias(SWT.ON);
					e.gc.setAdvanced(true);
					final Image scaledScr = new Image(canvas.getDisplay(),imageData.scaledTo(x, y));
					canvas.setSize(x, y);
					e.gc.drawImage(scaledScr, 0, 0);
				}
			}
		});

		// logo file

		Label lblLogo = toolkit.createLabel(container, "Logo (110x80):", SWT.NONE);
		lblLogo.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false, 1, 1));

		txtLogoFilePath = toolkit.createText(container, "", SWT.WRAP);
		txtLogoFilePath.setEditable(false);
		txtLogoFilePath.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 3, 1));

		Button btnChooseLogoFile = toolkit.createButton(container, "...", SWT.NONE);
		btnChooseLogoFile.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false, 1, 1));
		btnChooseLogoFile.addSelectionListener(new SelectionAdapter() {
			
			@Override
			public void widgetSelected(SelectionEvent e) {
				FileDialog fd = new FileDialog(getSection().getShell(), SWT.OPEN);
				fd.setText("Please select an image file");
				fd.setFilterExtensions(new String[] { "png", "jpg", "jpeg" });
				String open = fd.open();
				if (!(open == null || open.isEmpty())) {
					txtLogoFilePath.setText(open);
					logo = new Image(canvas.getDisplay(), open);
					if (logo!=null){
						ImageData imageData = logo.getImageData();
						if (imageData.width!=110 || imageData.height!=80){
							getManagedForm()
								.getMessageManager()
									.addMessage("wrong_size","Image must be 110x80 pixels in size.", null, IMessage.ERROR, txtLogoFilePath);
						} else {
							getManagedForm().getMessageManager().removeMessage("wrong_size");
						}
					}
				}
			}
		});		
	}

	@Override
	public boolean setFormInput(Object input) {
		this.solution = (Node) input;
		initDataBindings();
		try {
			screenshot = new Image(canvas.getDisplay(), solution.getScreenshot());
		} catch (Exception e){
			// do nothing
		}		
		return true;
	}

	protected DataBindingContext initDataBindings() {
		bindingContext = new DataBindingContext();
		//
		IObservableValue observeTextTxtLogoFilePathObserveWidget = WidgetProperties.text(SWT.Modify).observe(txtLogoFilePath);
		IObservableValue solutionImageObserveValue = EMFObservables.observeValue(solution, Literals.NODE__IMAGE);
		bindingContext.bindValue(observeTextTxtLogoFilePathObserveWidget, solutionImageObserveValue, null, null);
		//
		IObservableValue observeTextTxtScreenshotFilePathObserveWidget = WidgetProperties.text(SWT.Modify).observe(txtScreenshotFilePath);
		IObservableValue solutionScreenshotObserveValue = EMFObservables.observeValue(solution,Literals.NODE__SCREENSHOT);
		bindingContext.bindValue(observeTextTxtScreenshotFilePathObserveWidget, solutionScreenshotObserveValue, null, null);
		//
		return bindingContext;
	}
	

}
