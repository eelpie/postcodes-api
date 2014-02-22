package uk.co.eelpieconsulting.postcodes.controllers;

import java.io.IOException;
import java.text.ParseException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import uk.co.eelpieconsulting.common.views.EtagGenerator;
import uk.co.eelpieconsulting.common.views.ViewFactory;
import uk.co.eelpieconsulting.postcodes.parsing.ImportService;

@Controller
public class ImportController {
	
	private final ImportService importService;
	private final ViewFactory viewFactory;
	
	@Autowired
	public ImportController(ImportService importService) {
		this.importService = importService;
		this.viewFactory = new ViewFactory(new EtagGenerator());
	}
	
	@RequestMapping("/import")
	public ModelAndView importPricePaidFiles() throws IOException, ParseException  {
		importService.importPostcodes();
		return new ModelAndView(viewFactory.getJsonView()).addObject("data", "ok");
	}

	
}
