package uk.co.eelpieconsulting.postcodes.parsing;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import uk.co.eelpieconsulting.common.geo.LatLong;
import uk.co.eelpieconsulting.postcodes.daos.PostcodeDAO;
import uk.co.eelpieconsulting.postcodes.model.Postcode;
import uk.co.eelpieconsulting.postcodes.model.PostcodeLine;

@Component
public class ImportService {

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
			final List<PostcodeLine> lines = postcodeFileParser.parseFile(file);
			for (PostcodeLine line : lines) {
				final LatLong latLong = eastingsNorthingsConvertor.convertToLatLong(line.getEastings(), line.getNorthings());
				final String id = new String(line.getPostcode().replace(" ", ""));
				Postcode postcode = new Postcode(id, line.getPostcode(), line.getEastings(), line.getNorthings(), latLong.getLatitude(), latLong.getLongitude());
				postcodeDAO.save(postcode);
			}
		}
	}
	
}
