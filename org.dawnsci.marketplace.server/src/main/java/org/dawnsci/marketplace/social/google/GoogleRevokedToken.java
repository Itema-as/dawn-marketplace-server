package org.dawnsci.marketplace.social.google;

import org.springframework.social.ExpiredAuthorizationException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class GoogleRevokedToken {

	@RequestMapping("/google/revoked")
	public void simulateExpiredToken() {
		throw new ExpiredAuthorizationException("google");
	}
	
}
