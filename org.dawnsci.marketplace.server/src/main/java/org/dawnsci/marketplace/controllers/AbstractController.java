package org.dawnsci.marketplace.controllers;

import java.security.Principal;
import java.util.Date;

import javax.inject.Inject;

import org.dawnsci.marketplace.Platform;
import org.dawnsci.marketplace.social.account.Account;
import org.dawnsci.marketplace.social.account.AccountRepository;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.util.FeatureMapUtil.FeatureEList;
import org.eclipse.emf.ecore.xml.type.XMLTypePackage;
import org.springframework.core.env.Environment;
import org.springframework.social.connect.Connection;
import org.springframework.social.connect.ConnectionRepository;
import org.springframework.social.github.api.GitHub;
import org.springframework.social.google.api.Google;
import org.springframework.social.twitter.api.Twitter;
import org.springframework.ui.ModelMap;

public abstract class AbstractController {

	@Inject
	protected Environment environment;

	@Inject 
	protected ConnectionRepository connectionRepository;
	
	protected static final TypeUtilities DATE_UTILS = new TypeUtilities();
	protected static final EStructuralFeature TEXT = XMLTypePackage.eINSTANCE.getXMLTypeDocumentRoot_Text();

	protected final AccountRepository accountRepository;

	public AbstractController(AccountRepository accountRepository) {
		this.accountRepository = accountRepository;
	}

	public static class TypeUtilities {

		public static Date getDate(long timestamp) {
			return new Date(timestamp);
		}

		@SuppressWarnings("rawtypes")
		public static String getText(Platform p) {
			Object o = p.getMixed().get(TEXT, false);
			if (o instanceof FeatureEList) {
				if (((FeatureEList) o).size() > 0) {
					return ((FeatureEList) o).get(0).toString();
				}
			}
			return null;
		}

	}

	protected void addCommonItems(ModelMap map, Principal principal) {
		map.addAttribute("title", environment.getProperty("marketplace.title"));
		map.addAttribute("footer", environment.getProperty("marketplace.footer"));
		map.addAttribute("typeUtilities", DATE_UTILS);
		addProfile(map, principal);
	}

	/**
	 * Add profile information to the model map.
	 * 
	 * @param map
	 *            the model map
	 * @param principal
	 *            the princial or <code>null</code>
	 */
	private void addProfile(ModelMap map, Principal principal) {
		if (principal != null) {
			Connection<?> connection = null;
			connection = connectionRepository.findPrimaryConnection(Twitter.class);
			if (connection == null)
				connection = connectionRepository.findPrimaryConnection(Google.class);
			if (connection == null)
				connection = connectionRepository.findPrimaryConnection(GitHub.class);
			if (connection != null) {
				map.addAttribute("profileImage", connection.getImageUrl());
				map.addAttribute("profile", connection.getProfileUrl());
			}
			Account findAccountByUsername = accountRepository.findAccountByUsername(principal.getName());
			map.addAttribute(findAccountByUsername);
		}
	}

}
