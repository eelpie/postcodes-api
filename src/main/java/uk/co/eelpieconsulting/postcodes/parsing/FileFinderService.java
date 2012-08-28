package uk.co.eelpieconsulting.postcodes.parsing;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.springframework.stereotype.Component;

@Component
public class FileFinderService {
	
	private String dataFolder;
	
	public FileFinderService() {
	}

	public void setDataFolder(String dataFolder) {
		this.dataFolder = dataFolder;
	}

	public List<File> getDataFiles() {
		File dataFolderFile = new File(dataFolder);
		return new ArrayList<File>(FileUtils.listFiles(dataFolderFile, new String[] {"csv"}, false));
	}
	
}
