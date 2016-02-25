package org.dawnsci.marketplace.ui.editors;

import java.util.ArrayList;
import java.util.Iterator;

import org.dawnsci.marketplace.Iu;
import org.dawnsci.marketplace.Ius;
import org.dawnsci.marketplace.MarketplaceFactory;
import org.dawnsci.marketplace.MarketplacePackage.Literals;
import org.dawnsci.marketplace.Node;
import org.eclipse.core.databinding.DataBindingContext;
import org.eclipse.core.databinding.UpdateValueStrategy;
import org.eclipse.core.databinding.conversion.Converter;
import org.eclipse.core.databinding.observable.value.IObservableValue;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.databinding.EMFObservables;
import org.eclipse.emf.ecore.util.FeatureMapUtil;
import org.eclipse.jface.databinding.swt.WidgetProperties;
import org.eclipse.pde.internal.core.PDECore;
import org.eclipse.pde.internal.core.ifeature.IFeatureModel;
import org.eclipse.pde.internal.ui.dialogs.FeatureSelectionDialog;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;
import org.eclipse.ui.forms.SectionPart;
import org.eclipse.ui.forms.widgets.FormToolkit;
import org.eclipse.ui.forms.widgets.Section;

@SuppressWarnings("restriction")
public class FeatureSection extends SectionPart {

	private Node solution;
	private DataBindingContext bindingContext;
	private Text text;

	public class StringToFeatureConverter extends Converter {
		
		public StringToFeatureConverter() {
			super(String.class, Ius.class);
		}

		@Override
		public Object convert(Object input) {
			Ius iusCollection = MarketplaceFactory.eINSTANCE.createIus();
			String[] ius = ((String)input).split(",");
			for (String string : ius) {
				Iu iu = MarketplaceFactory.eINSTANCE.createIu();
				iu.setRequired(true);
				FeatureMapUtil.addText(iu.getMixed(), string.trim());
				iusCollection.getItems().add(iu);
			}
			return iusCollection;
		}
		
	}
	
	public class FeatureToStringConverter extends Converter {

		public FeatureToStringConverter() {
			super(Ius.class, String.class);
		}

		@Override
		public Object convert(Object input) {
			StringBuilder list = new StringBuilder();
			EList<Iu> ius = ((Ius)input).getItems();
			for (Iterator<Iu> iterator = ius.iterator(); iterator.hasNext();) {
				Iu iu = iterator.next();
				list.append(iu.getMixed().getValue(0).toString());
				if (iterator.hasNext()){
					list.append(", ");
				}
			}
			return list.toString();
		}
		
	}

	public FeatureSection(Composite parent, FormToolkit toolkit, int style) {
		super(parent, toolkit, style);
		createClient(getSection(), toolkit);
	}

	/**
	 * Fill the section.
	 */
	private void createClient(Section section, FormToolkit toolkit) {
		section.setText("Feature");
		Composite container = toolkit.createComposite(section);

		section.setClient(container);
		container.setLayout(new GridLayout(3, false));
		
		Label lblFeature = new Label(container, SWT.NONE);
		lblFeature.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false, 1, 1));
		toolkit.adapt(lblFeature, true, true);
		lblFeature.setText("Feature identifier:");
		
		text = new Text(container, SWT.BORDER | SWT.READ_ONLY);
		text.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
		toolkit.adapt(text, true, true);
		
		Button btnChooseFeature = toolkit.createButton(container, "...", SWT.NONE);
		btnChooseFeature.addSelectionListener(new SelectionAdapter() {

			@Override
			public void widgetSelected(SelectionEvent e) {
				super.widgetSelected(e);
				IFeatureModel[] allModels = PDECore.getDefault().getFeatureModelManager().getModels();
				ArrayList<IFeatureModel> newModels = new ArrayList<IFeatureModel>();
				for (int i = 0; i < allModels.length; i++) {
					if (canAdd(allModels[i]))
						newModels.add(allModels[i]);
				}
				IFeatureModel[] candidateModels = newModels.toArray(new IFeatureModel[newModels.size()]);
				FeatureSelectionDialog fsd = new FeatureSelectionDialog(text.getShell(), candidateModels, false);
				if (fsd.open()==0) {
					IFeatureModel firstResult = (IFeatureModel) fsd.getFirstResult();
					text.setText(firstResult.getFeature().getId());
				}
			}

			private boolean canAdd(IFeatureModel iFeatureModel) {				
				return iFeatureModel.isEditable();
			}
			
		});
	}
	@Override
	public boolean setFormInput(Object input) {
		this.solution = (Node) input;
		initDataBindings();
		return true;
	}
	
	protected DataBindingContext initDataBindings() {
		bindingContext = new DataBindingContext();
		//
		IObservableValue observeTagsObserveWidget = WidgetProperties.text(SWT.Modify).observe(text);
		IObservableValue solutionTagsObserveValue = EMFObservables.observeValue(solution, Literals.NODE__IUS);
		UpdateValueStrategy solutionTagsToModelStrategy = new UpdateValueStrategy();
		solutionTagsToModelStrategy.setConverter(new StringToFeatureConverter());
		UpdateValueStrategy solutionModelToTagsStrategy = new UpdateValueStrategy();
		solutionModelToTagsStrategy.setConverter(new FeatureToStringConverter());
		bindingContext.bindValue(observeTagsObserveWidget, solutionTagsObserveValue, solutionTagsToModelStrategy, solutionModelToTagsStrategy);
		//
		return bindingContext;
	}

}
