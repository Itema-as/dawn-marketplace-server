package org.dawnsci.marketplace.controllers;

import java.io.File;
import java.io.IOException;
import java.io.StringReader;
import java.io.StringWriter;
import java.nio.file.Files;
import java.nio.file.Path;

import javax.servlet.http.HttpServletRequest;

import org.apache.tika.Tika;
import org.dawnsci.marketplace.services.FileService;
import org.eclipse.mylyn.wikitext.core.parser.MarkupParser;
import org.eclipse.mylyn.wikitext.core.parser.builder.HtmlDocumentBuilder;
import org.eclipse.mylyn.wikitext.markdown.core.MarkdownLanguage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.FileSystemResource;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.HandlerMapping;

@Controller
public class PageController {

	@Autowired
	private FileService fileService;

	private Tika tika;

	public PageController() {
		tika = new Tika();
	}

	@RequestMapping(value = {"/pages/*.md"}, method = RequestMethod.GET)
	public String markdown(HttpServletRequest request, ModelMap map) {

		String resource = ((String) request.getAttribute(HandlerMapping.PATH_WITHIN_HANDLER_MAPPING_ATTRIBUTE)).substring(1);
		Path path = fileService.getPageFile(resource).toPath();			
		map.addAttribute("text", parse(path));
		
		return "page";
	}

	static String parse(Path path) {
		if (!path.toFile().exists()){
			return "";
		}
		StringWriter sw = new StringWriter();
		MarkupParser parser = new MarkupParser();
		parser.setMarkupLanguage(new MarkdownLanguage());
		HtmlDocumentBuilder builder = new HtmlDocumentBuilder(sw);
		builder.setEmitAsDocument(false);
		parser.setBuilder(builder);
		try {
			parser.parse(new StringReader(new String(Files.readAllBytes(path))));
		} catch (IOException e) {
			e.printStackTrace();
		}
		return sw.toString();
	}

	@RequestMapping(value = "/pages/**", method = RequestMethod.GET)
	@ResponseBody
	public ResponseEntity<FileSystemResource> picture(HttpServletRequest request) {

		String resource = ((String) request.getAttribute(HandlerMapping.PATH_WITHIN_HANDLER_MAPPING_ATTRIBUTE)).substring(1);
		Path path = fileService.getPageFile(resource).toPath();			
		
		File file = path.toAbsolutePath().toFile();

		if (file.exists() && file.isFile()) {
			try {
				String detect = tika.detect(file);
				MediaType mediaType = MediaType.parseMediaType(detect);
				return ResponseEntity.ok().contentLength(file.length()).contentType(mediaType)
						.body(new FileSystemResource(file));
			} catch (IOException e) {
				e.printStackTrace();
			}
		} else {
            throw new ResourceNotFoundException(); 
        }		
		return null;
	}

}
