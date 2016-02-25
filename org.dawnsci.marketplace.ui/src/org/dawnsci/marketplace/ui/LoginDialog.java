package org.dawnsci.marketplace.ui;

import org.eclipse.core.databinding.DataBindingContext;
import org.eclipse.core.databinding.beans.PojoProperties;
import org.eclipse.core.databinding.observable.value.IObservableValue;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.jface.databinding.swt.WidgetProperties;
import org.eclipse.jface.dialogs.IDialogConstants;
import org.eclipse.jface.dialogs.TitleAreaDialog;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;

public class LoginDialog extends TitleAreaDialog {
	@SuppressWarnings("unused")
	private DataBindingContext m_bindingContext;
	private Credentials credentials;
	private IStatus status;
	private Text txtUserName;
	private Text txtPassword;

	/**
	 * Create the dialog.
	 * @param parentShell
	 */
	public LoginDialog(Shell parentShell, Credentials credentials, IStatus status) {
		super(parentShell);
		this.credentials = credentials;
		this.status = status;
	}

	/**
	 * Create contents of the dialog.
	 * @param parent
	 */
	@Override
	protected Control createDialogArea(Composite parent) {
		setTitle("Please specify credentials");
		if (status.isOK()) {
			setMessage(status.getMessage());
		}
		if (status.getSeverity()==IStatus.ERROR) {
			setErrorMessage(status.getMessage());
		}
		Composite area = (Composite) super.createDialogArea(parent);
		Composite container = new Composite(area, SWT.NONE);
		container.setLayout(new GridLayout());
		container.setLayoutData(new GridData(GridData.FILL_BOTH));

		GridLayout gridLayout = (GridLayout) container.getLayout();
		gridLayout.numColumns = 2;
		
		Label lblUserName = new Label(container, SWT.NONE);
		lblUserName.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false, 1, 1));
		lblUserName.setText("User name:");
		
		txtUserName = new Text(container, SWT.BORDER);
		txtUserName.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
		
		Label lblPassword = new Label(container, SWT.NONE);
		lblPassword.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false, 1, 1));
		lblPassword.setText("Password:");
		
		txtPassword = new Text(container, SWT.BORDER | SWT.PASSWORD);
		txtPassword.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));

		return container;
	}

	/**
	 * Create contents of the button bar.
	 * @param parent
	 */
	@Override
	protected void createButtonsForButtonBar(Composite parent) {
		createButton(parent, IDialogConstants.OK_ID, IDialogConstants.OK_LABEL, true);
		createButton(parent, IDialogConstants.CANCEL_ID, IDialogConstants.CANCEL_LABEL, false);
		m_bindingContext = initDataBindings();
	}

	/**
	 * Return the initial size of the dialog.
	 */
	@Override
	protected Point getInitialSize() {
		return new Point(386, 211);
	}
	protected DataBindingContext initDataBindings() {
		DataBindingContext bindingContext = new DataBindingContext();
		//
		IObservableValue observeTextTxtUserNameObserveWidget = WidgetProperties.text(SWT.Modify).observe(txtUserName);
		IObservableValue userNameCredentialsObserveValue = PojoProperties.value("username").observe(credentials);
		bindingContext.bindValue(observeTextTxtUserNameObserveWidget, userNameCredentialsObserveValue, null, null);
		//
		IObservableValue observeTextTxtPasswordObserveWidget = WidgetProperties.text(SWT.Modify).observe(txtPassword);
		IObservableValue passwordCredentialsObserveValue = PojoProperties.value("password").observe(credentials);
		bindingContext.bindValue(observeTextTxtPasswordObserveWidget, passwordCredentialsObserveValue, null, null);
		//
		return bindingContext;
	}
}
