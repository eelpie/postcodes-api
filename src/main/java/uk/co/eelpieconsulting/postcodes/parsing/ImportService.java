package uk.co.eelpieconsulting.postcodes.parsing;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.springframework.stereotype.Component;

@Component
public class ImportService {

	private FileFinderService fileFinderService;
	private PostcodeFileParser postcodeFileParser;
	
	public ImportService(FileFinderService fileFinderService, PostcodeFileParser postcodeFileParser) {
		this.fileFinderService = fileFinderService;
		this.postcodeFileParser = postcodeFileParser;
	}
	
	public void importPostcodes() throws IOException {
		final List<File> dataFiles = fileFinderService.getDataFiles();
		for (File file : dataFiles) {
			postcodeFileParser.parseFile(file);
		}
	}
	
}
