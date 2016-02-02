package org.dawnsci.marketplace.controllers;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;


@Controller
public class InstallController {
	@ResponseBody
	@RequestMapping(value = "/marketplace-client-intro", method = RequestMethod.GET)
	public String getInstall(HttpServletRequest request,@RequestParam(value = "mpc_install", required = true) String id) throws Exception {
		String userAgent = request.getHeader("User-Agent");
		System.out.println(userAgent);
		return null;
		//return serialize(dataService.getContent(id));
	}

}
