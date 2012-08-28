package uk.co.eelpieconsulting.postcodes.controllers;

import java.io.IOException;
import java.text.ParseException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import uk.co.eelpieconsulting.common.views.ViewFactory;
import uk.co.eelpieconsulting.postcodes.daos.PostcodeDAO;

@Controller
public class SearchController {
	
	private final PostcodeDAO postcodeDAO;
	private final ViewFactory viewFactory;
	
	@Autowired
	public SearchController(PostcodeDAO postcodeDAO, ViewFactory viewFactory) {
		this.postcodeDAO = postcodeDAO;
		this.viewFactory = viewFactory;
	}
	
	@RequestMapping("/postcode/{id}")
	public ModelAndView postcode(@PathVariable String id ) throws IOException, ParseException  {
		final ModelAndView mv = new ModelAndView(viewFactory.getJsonView());		
		mv.addObject("data", postcodeDAO.getById(id));
		return mv;
	}
	
	
}
