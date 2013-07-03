package uk.co.eelpieconsulting.postcodes.controllers;

import java.io.IOException;
import java.text.ParseException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.ModelAndView;

import uk.co.eelpieconsulting.common.files.FileInformationService;
import uk.co.eelpieconsulting.common.views.ViewFactory;
import uk.co.eelpieconsulting.common.views.json.JsonView;
import uk.co.eelpieconsulting.postcodes.daos.PostcodeDAO;
import uk.co.eelpieconsulting.postcodes.model.UnknownPostcodeException;
import uk.co.eelpieconsulting.postcodes.parsing.FileFinderService;

@Controller
public class SearchController {
	
	private static final int ONE_HOUR = 60 * 60;
	
	private final PostcodeDAO postcodeDAO;
	private final FileFinderService fileFinderService;
	private final ViewFactory viewFactory;
	private final FileInformationService fileInformationService;
	
	@Autowired
	public SearchController(PostcodeDAO postcodeDAO, FileFinderService fileFinderService, ViewFactory viewFactory) {
		this.postcodeDAO = postcodeDAO;
		this.fileFinderService = fileFinderService;
		this.viewFactory = viewFactory;
		fileInformationService = new FileInformationService();
	}
	
	@RequestMapping("/postcode/{id}")
	public ModelAndView postcode(@PathVariable String id ) throws UnknownPostcodeException {
		final JsonView jsonView = (JsonView) viewFactory.getJsonView();
		jsonView.setMaxAge(ONE_HOUR);
		
		final ModelAndView mv = new ModelAndView(jsonView);		
		mv.addObject("data", postcodeDAO.getById(id));
		return mv;
	}
	
	@RequestMapping("/sources")
	public ModelAndView sources() throws IOException, ParseException {
		final JsonView jsonView = (JsonView) viewFactory.getJsonView();
		jsonView.setMaxAge(ONE_HOUR);
		
		final ModelAndView mv = new ModelAndView(jsonView);		
		mv.addObject("data", fileInformationService.makeFileInformationForFiles(fileFinderService.getDataFiles()));
		return mv;
	}

	@ExceptionHandler(UnknownPostcodeException.class)
	@ResponseStatus(value = org.springframework.http.HttpStatus.NOT_FOUND)
	public ModelAndView unknownPostcode(UnknownPostcodeException e) {
		final ModelAndView mv = new ModelAndView(viewFactory.getJsonView());
		mv.addObject("data", "Unknown postcode");
		return mv;
	}

}
