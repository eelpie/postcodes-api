package uk.co.eelpieconsulting.postcodes.parsing;

import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class FileFinderService {
	
	private final Logger log = Logger.getLogger(FileFinderService.class);
	
	@Value("${importFolder}")
	private String importFolder;
	
	public List<File> getDataFiles() {
		log.info("Searching for input csv files in folder: " + importFolder);
		File dataFolderFile = new File(importFolder);
		final List<File> fileList = new ArrayList<File>(FileUtils.listFiles(dataFolderFile, new String[] {"csv"}, false));
		Collections.sort(fileList);
		log.info("Found " + fileList.size() + " input files");
		return fileList;
	}
	
}
