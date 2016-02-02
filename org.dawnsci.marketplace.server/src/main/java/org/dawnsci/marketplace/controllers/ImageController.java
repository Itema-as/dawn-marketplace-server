package org.dawnsci.marketplace.controllers;

import java.io.File;
import java.security.Principal;

import org.springframework.core.io.FileSystemResource;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;


/**
 * @author Torkild U. Resheim, Itema AS
 */
@Controller
public class ImageController {

	@RequestMapping(value = "/browser", method = RequestMethod.GET)
	@ResponseBody
	public ResponseEntity<FileSystemResource> picture(@RequestParam(value = "asset", required = true) String asset,
			Principal principal) {
		File file = new File(System.getProperty("user.home"),"keybase.txt");
		if (file.exists() && file.isFile()) {
			return ResponseEntity.ok().contentLength(file.length()).contentType(MediaType.TEXT_PLAIN)
					.body(new FileSystemResource(file));
		}
		return null;
	}

}