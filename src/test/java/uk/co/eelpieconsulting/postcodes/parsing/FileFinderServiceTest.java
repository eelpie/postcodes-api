package uk.co.eelpieconsulting.postcodes.parsing;

import static org.junit.Assert.assertEquals;

import java.io.File;
import java.util.List;

import org.junit.Test;

public class FileFinderServiceTest {

	@Test
	public void canLocateAllDataFiles() {
		final String file = this.getClass().getClassLoader().getResource("Data/tw.csv").getFile();
		final String dataImportFolder = new File(file).getParent();		
		final FileFinderService fileFinderService = new FileFinderService();
		
		fileFinderService.setDataFolder(dataImportFolder);
		
		final List<File> dataFiles = fileFinderService.getDataFiles();
		assertEquals(2, dataFiles.size());
		assertEquals("ec.csv", dataFiles.get(0).getName());
		assertEquals("tw.csv", dataFiles.get(1).getName());
	}

}
