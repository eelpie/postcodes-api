package uk.co.eelpieconsulting.postcodes.parsing;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import uk.co.eelpieconsulting.common.geo.model.LatLong;
import uk.co.eelpieconsulting.postcodes.daos.PostcodeDAO;
import uk.co.eelpieconsulting.postcodes.model.Postcode;
import uk.co.eelpieconsulting.postcodes.model.PostcodeLine;

@Component
public class ImportService {
	
	private final Logger log = Logger.getLogger(ImportService.class);

	private FileFinderService fileFinderService;
	private PostcodeFileParser postcodeFileParser;
	private EastingsNorthingsConvertor eastingsNorthingsConvertor;
	private PostcodeDAO postcodeDAO;
	
	@Autowired
	public ImportService(FileFinderService fileFinderService, PostcodeFileParser postcodeFileParser, EastingsNorthingsConvertor eastingsNorthingsConvertor, PostcodeDAO postcodeDAO) {
		this.fileFinderService = fileFinderService;
		this.postcodeFileParser = postcodeFileParser;
		this.eastingsNorthingsConvertor = eastingsNorthingsConvertor;
		this.postcodeDAO = postcodeDAO;
	}
	
	public void importPostcodes() throws IOException {		
		final List<File> dataFiles = fileFinderService.getDataFiles();
		
		postcodeDAO.removeAll();
		
		for (File file : dataFiles) {
			log.info("Processing input file: " + file.getAbsolutePath());
			final List<PostcodeLine> lines = postcodeFileParser.parseFile(file);
			for (PostcodeLine line : lines) {
				final LatLong latLong = eastingsNorthingsConvertor.convertToLatLong(line.getEastings(), line.getNorthings());
				final String id = new String(line.getPostcode().replace(" ", ""));
				
				final Postcode postcode = new Postcode(id, line.getPostcode(), line.getEastings(), line.getNorthings(), latLong.getLatitude(), latLong.getLongitude());
				log.debug("Adding postcode: " + postcode);
				postcodeDAO.save(postcode);
			}
		}
	}
	
}
