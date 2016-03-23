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
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.attribute.FileAttribute;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpHead;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.ByteArrayEntity;
import org.apache.http.entity.mime.MultipartEntityBuilder;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
import org.dawnsci.marketplace.Iu;
import org.dawnsci.marketplace.Node;
import org.dawnsci.marketplace.core.MarketplaceSerializer;
import org.dawnsci.marketplace.ui.Activator;
import org.dawnsci.marketplace.ui.Credentials;
import org.dawnsci.marketplace.ui.LoginDialog;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.core.runtime.jobs.IJobChangeEvent;
import org.eclipse.core.runtime.jobs.JobChangeAdapter;
import org.eclipse.emf.common.util.EList;
import org.eclipse.equinox.security.storage.ISecurePreferences;
import org.eclipse.equinox.security.storage.SecurePreferencesFactory;
import org.eclipse.equinox.security.storage.StorageException;
import org.eclipse.jface.action.Action;
import org.eclipse.jface.action.IToolBarManager;
import org.eclipse.jface.dialogs.IDialogConstants;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.osgi.util.NLS;
import org.eclipse.pde.internal.build.site.QualifierReplacer;
import org.eclipse.pde.internal.core.PDECore;
import org.eclipse.pde.internal.core.PDECoreMessages;
import org.eclipse.pde.internal.core.exports.FeatureExportInfo;
import org.eclipse.pde.internal.core.exports.FeatureExportOperation;
import org.eclipse.pde.internal.core.ifeature.IFeatureModel;
import org.eclipse.pde.internal.ui.PDEPluginImages;
import org.eclipse.pde.internal.ui.PDEUIMessages;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.program.Program;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Link;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.forms.IManagedForm;
import org.eclipse.ui.forms.IMessage;
import org.eclipse.ui.forms.editor.FormEditor;
import org.eclipse.ui.forms.editor.FormPage;
import org.eclipse.ui.forms.widgets.FormToolkit;
import org.eclipse.ui.forms.widgets.ScrolledForm;
import org.eclipse.ui.forms.widgets.Section;
import org.eclipse.ui.progress.IProgressConstants;

@SuppressWarnings("restriction")
public class OverviewPage extends FormPage {

	private static final String MPC = "MPC";

	private static final String X_CSRF_TOKEN = "X-CSRF-TOKEN";
	
	private Node solution;

	protected class AntErrorDialog extends MessageDialog {
		private File fLogLocation;

		public AntErrorDialog(File logLocation) {
			super(PlatformUI.getWorkbench().getDisplay().getActiveShell(), PDECoreMessages.FeatureBasedExportOperation_ProblemDuringExport, null, null, MessageDialog.ERROR, new String[] {IDialogConstants.OK_LABEL}, 0);
			fLogLocation = logLocation;
		}

		protected Control createMessageArea(Composite composite) {
			Link link = new Link(composite, SWT.WRAP);
			try {
				link.setText(NLS.bind(PDEUIMessages.PluginExportWizard_Ant_errors_during_export_logs_generated, "<a>" + fLogLocation.getCanonicalPath() + "</a>")); //$NON-NLS-1$ //$NON-NLS-2$
			} catch (IOException e) {
				Activator.log(e);
			}
			GridData data = new GridData();
			data.widthHint = convertHorizontalDLUsToPixels(IDialogConstants.MINIMUM_MESSAGE_AREA_WIDTH);
			link.setLayoutData(data);
			link.addSelectionListener(new SelectionAdapter() {
				public void widgetSelected(SelectionEvent e) {
					try {
						Program.launch(fLogLocation.getCanonicalPath());
					} catch (IOException ex) {
						Activator.log(ex);
					}
				}
			});
			return link;
		}
	}

	public OverviewPage(FormEditor editor, String id, String title, Node solution) {
		super(editor, id, title);
		this.solution = solution;
	};

	public OverviewPage(String id, String title) {
		super(id, title);
	}

	private void createActions(IToolBarManager manager) {
		Action publishAction = new Action("Publish to DAWN marketplace", Action.AS_PUSH_BUTTON) {

			@Override
			public ImageDescriptor getImageDescriptor() {
				return Activator.getImageDescriptor("icons/publish.png");
			}

			@Override
			public void run() {
				OverviewPage.this.getManagedForm().getMessageManager().removeAllMessages();
				try {
					scheduleExportJob();
				} catch (IOException e) {
					OverviewPage.this.getManagedForm().getMessageManager().addMessage(MPC, e.getMessage(), null,
							IMessage.ERROR);
				}
			}

		};
		manager.add(publishAction);
		manager.update(true);
	}

	@Override
	protected void createFormContent(IManagedForm managedForm) {
		FormToolkit toolkit = managedForm.getToolkit();
		ScrolledForm form = managedForm.getForm();
		createActions(form.getToolBarManager());
		form.setText("Overview");
		Composite body = form.getBody();
		toolkit.decorateFormHeading(form.getForm());
		toolkit.paintBordersFor(body);

		body.setLayout(new GridLayout(2, false));

		DetailsSection detailsSection = new DetailsSection(managedForm.getForm().getBody(), toolkit, Section.TITLE_BAR);
		detailsSection.initialize(managedForm);
		GridData gdDetails = new GridData(GridData.FILL, GridData.FILL, true, true);
		gdDetails.verticalSpan = 2;
		gdDetails.verticalAlignment = SWT.BEGINNING;
		gdDetails.widthHint = 300;
		detailsSection.getSection().setLayoutData(gdDetails);
		detailsSection.setFormInput(solution);

		FeatureSection featureSection = new FeatureSection(managedForm.getForm().getBody(),
				toolkit, Section.TITLE_BAR);
		featureSection.initialize(managedForm);
		GridData gdFeature = new GridData(GridData.FILL, GridData.FILL, true, false);
		featureSection.getSection().setLayoutData(gdFeature);
		featureSection.setFormInput(solution);

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

	private String getCsrfToken(CloseableHttpClient client) throws ClientProtocolException, IOException {
		String url = getMarketplaceUrl();

		HttpHead head = new HttpHead(url + "token");
		head.addHeader(X_CSRF_TOKEN, "fetch");
		CloseableHttpResponse response = client.execute(head);

		EntityUtils.consume(response.getEntity());
		String token = null;
		Header[] headers = response.getHeaders(X_CSRF_TOKEN);
		for (Header header : headers) {
			token = header.getValue();
		}
		return token;
	}

	private String getMarketplaceUrl() {
		String url = System.getProperty("org.eclipse.epp.internal.mpc.core.service.DefaultMarketplaceService.url");
		// XXX: Switch to using Spring REST instead of Jersey to avoid this kludge?
		if (url.endsWith("mpc")) {
			url = url.substring(0, url.length() - 3);
		}
		return url;
	}
	
	private void addMessage(int type, String text) {
		Display.getDefault().asyncExec(new Runnable() {
			
			@Override
			public void run() {
				OverviewPage.this.getManagedForm().getMessageManager().addMessage(MPC,
						text, null, type);
			}
		});

	}

	/**
	 * Signs in to the marketplace server using its authentication form.
	 * 
	 * @throws ClientProtocolException
	 * @throws IOException
	 * @throws UnsupportedEncodingException
	 * @throws StorageException 
	 */
	private boolean signIn(CloseableHttpClient client) throws ClientProtocolException, IOException, UnsupportedEncodingException, StorageException {
				
		OverviewPage.this.getManagedForm().getMessageManager().removeMessage(MPC);
		
		String token = getCsrfToken(client);
		String url = getMarketplaceUrl();

		ISecurePreferences root = SecurePreferencesFactory.getDefault().node("org.dawnsci.marketplace");
		ISecurePreferences node = root.node(URLEncoder.encode(url, "utf-8"));
				
		String user = node.get("username","");
		String password = node.get("password","");
		
		HttpPost httpPost = new HttpPost(url + "signin/authenticate");
		httpPost.addHeader(X_CSRF_TOKEN, token);

		List<NameValuePair> params = new ArrayList<NameValuePair>(3);
		params.add(new BasicNameValuePair("_csrf", token));
		params.add(new BasicNameValuePair("username", user));
		params.add(new BasicNameValuePair("password", password));

		httpPost.setEntity(new UrlEncodedFormEntity(params));
		
		HttpResponse response = client.execute(httpPost);
		int statusCode = response.getStatusLine().getStatusCode();
		String location = response.getFirstHeader("Location").getValue();

		if (statusCode == 302 && !location.contains("bad_credentials")) {
			addMessage(IMessage.INFORMATION, "Signed into the marketplace service");
			return true;
		} else {
			addMessage(IMessage.ERROR, "Could not sign in to the marketplace service. Please verify credentials.");
			requestCredentials(node, user, password);
			return false;
		}
	}

	private void requestCredentials(final ISecurePreferences node, String user, String password) {
		Credentials credentials = new Credentials(user,password);
		IStatus status = new Status(IStatus.ERROR,"org.dawnsci.marketplace.ui","Could not sign in to the marketplace service. Please verify credentials and try again.");
		LoginDialog ld = new LoginDialog(this.getSite().getShell(), credentials, status);
		this.getSite().getShell().getDisplay().asyncExec(new Runnable() {
			
			@Override
			public void run() {
				if (ld.open()==0) {
					try {
						node.put("username", credentials.getUsername(), false);
						node.put("password", credentials.getPassword(), true);
					} catch (StorageException e) {						
						e.printStackTrace();
					}
				}
			}
		});
	}
	
	protected Object[] getFeatures() {
		List<String> identifiers = new ArrayList<>();
		EList<Iu> ius = solution.getIus().getItems();
		for (Iterator<Iu> iterator = ius.iterator(); iterator.hasNext();) {
			Iu tag = iterator.next();
			String id = tag.getMixed().getValue(0).toString();
			identifiers.add(id);
		}
		IFeatureModel[] allModels = PDECore.getDefault().getFeatureModelManager().getModels();
		ArrayList<IFeatureModel> newModels = new ArrayList<IFeatureModel>();
		for (int i = 0; i < allModels.length; i++) {
			if (identifiers.contains(allModels[i].getFeature().getId())) {
				newModels.add(allModels[i]);
			}
		}
		return newModels.toArray(new IFeatureModel[0]);		
	}
	
	protected void scheduleExportJob() throws IOException {
		
		Path folder = Files.createTempDirectory("eclipse-export", new FileAttribute<?>[0]);
		final FeatureExportInfo info = new FeatureExportInfo();
		info.toDirectory = false; // in order to install from the repository
		info.useJarFormat = true;
		info.exportSource = false;
		info.exportSourceBundle = false;
		info.allowBinaryCycles = true;
		info.useWorkspaceCompiledClasses = false;
		info.destinationDirectory = folder.toString();
		info.zipFileName = "p2-repo.zip";
		info.items = getFeatures();
		info.signingInfo = null; //
		info.exportMetadata = true;
		info.qualifier = QualifierReplacer.getDateQualifier();

		final FeatureExportOperation job = new FeatureExportOperation(info, PDEUIMessages.FeatureExportJob_name);
		job.setUser(true);
		job.setRule(ResourcesPlugin.getWorkspace().getRoot());
		job.setProperty(IProgressConstants.ICON_PROPERTY, PDEPluginImages.DESC_PLUGIN_OBJ);
		
		// listen to job changes, we'll upload stuff when the building has been done 
		job.addJobChangeListener(new JobChangeAdapter() {
			public void done(IJobChangeEvent event) {
				if (job.hasAntErrors()) {
					// if there were errors when running the ant scripts, inform
					// the user where the logs can be found.
					final File logLocation = new File(info.destinationDirectory, "logs.zip"); //$NON-NLS-1$
					if (logLocation.exists()) {
						PlatformUI.getWorkbench().getDisplay().syncExec(new Runnable() {
							public void run() {
								AntErrorDialog dialog = new AntErrorDialog(logLocation);
								dialog.open();
							}
						});
					}
				} else if (event.getResult().isOK()) {
					// can publish
					try (CloseableHttpClient client = HttpClientBuilder.create().build()) {
						// sign in and upload items
						if (signIn(client)) {
							uploadForm(client);							
							// upload the images
							if (solution.getScreenshot() != null) {
								uploadFile(client, Paths.get(solution.getScreenshot()), "upload-screenshot");
							}
							if (solution.getImage() != null) {
								uploadFile(client, Paths.get(solution.getImage()), "upload-image");
							}
							// upload the repository
							uploadFile(client, folder.resolve("p2-repo.zip"),"upload-p2repo");
						}
					} catch (Exception e) {
						e.printStackTrace();
						addMessage(IMessage.ERROR, e.getMessage());
					}

				}
			}

		});
		job.schedule();
	}
	
	protected void uploadFile(CloseableHttpClient client, Path path, String segment) throws ClientProtocolException, IOException {
		String token = getCsrfToken(client);
		String url = getMarketplaceUrl();

		// upload the p2-repository file
		HttpPost httpPost = new HttpPost(url + "/"+segment);
		httpPost.addHeader(X_CSRF_TOKEN, token);
		HttpEntity file = MultipartEntityBuilder
				.create()
				.addBinaryBody("file", path.toFile())
				.addTextBody("id", solution.getId().toString())
				.build();		 
		httpPost.setEntity(file);
		HttpResponse response = client.execute(httpPost);
		int statusCode = response.getStatusLine().getStatusCode();
		if (statusCode == 200) {
			String result = EntityUtils.toString(response.getEntity());
			// obtain some key values from the server version
			// and update the local instance
			Node node = MarketplaceSerializer.deSerializeSolution(result);
			solution.setChanged(node.getChanged());
			addMessage(IMessage.INFORMATION, "File "+path.getFileName()+" uploaded");
		} else {
			String reasonPhrase = response.getStatusLine().getReasonPhrase();
			addMessage(IMessage.ERROR, reasonPhrase);
		}
	}

	private void uploadForm(CloseableHttpClient client)
			throws ClientProtocolException, IOException, UnsupportedEncodingException {
		OverviewPage.this.getManagedForm().getMessageManager().removeMessage(MPC);

		String token = getCsrfToken(client);
		String url = getMarketplaceUrl();

		// upload the form
		HttpPost httpPost = new HttpPost(url + "/upload");
		httpPost.addHeader(X_CSRF_TOKEN, token);
		HttpEntity entity = new ByteArrayEntity(
				MarketplaceSerializer.serialize(solution).getBytes("UTF-8"));
		httpPost.setEntity(entity);
		HttpResponse response = client.execute(httpPost);
		int statusCode = response.getStatusLine().getStatusCode();
		if (statusCode == 200) {
			String result = EntityUtils.toString(response.getEntity());
			// obtain some key values from the server version
			// and update the local instance
			Node node = MarketplaceSerializer.deSerializeSolution(result);
			solution.setId(node.getId());
			solution.setChanged(node.getChanged());
			solution.setCreated(node.getCreated());
			addMessage(IMessage.INFORMATION, "Solution uploaded");
		} else {
			String reasonPhrase = response.getStatusLine().getReasonPhrase();
			addMessage(IMessage.ERROR, reasonPhrase);
		}
	}
}
