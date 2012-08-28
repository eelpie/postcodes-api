package uk.co.eelpieconsulting.postcodes.parsing;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import uk.co.eelpieconsulting.postcodes.model.PostcodeLine;
import au.com.bytecode.opencsv.CSVReader;

@Component
public class PostcodeFileParser {

	public List<PostcodeLine> parseFile(File file) throws IOException {		
		final List<PostcodeLine> lines = new ArrayList<PostcodeLine>();
		
		final CSVReader reader = new CSVReader(new InputStreamReader(new FileInputStream(file)));
		String [] nextLine;
		while ((nextLine = reader.readNext()) != null) {
			lines.add(new PostcodeLine(nextLine[0], 
					Integer.parseInt(nextLine[1]),
					Integer.parseInt(nextLine[2]),
					Integer.parseInt(nextLine[3]),
					nextLine[4],
					nextLine[5],
					nextLine[6],
					nextLine[7],
					nextLine[8],
					nextLine[9]					
					));
		}
		return lines;
	}

}
