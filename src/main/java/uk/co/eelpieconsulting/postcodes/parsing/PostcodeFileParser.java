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

import com.google.common.base.Strings;

@Component
public class PostcodeFileParser {

	public List<PostcodeLine> parseFile(File file) throws IOException {		
		final List<PostcodeLine> lines = new ArrayList<PostcodeLine>();
		
		final CSVReader reader = new CSVReader(new InputStreamReader(new FileInputStream(file)));
		reader.readNext();
		
		String [] nextLine;
		while ((nextLine = reader.readNext()) != null) {
			lines.add(new PostcodeLine(nextLine[0], 
					!Strings.isNullOrEmpty(nextLine[9]) ? Integer.parseInt(nextLine[9]) : 0,
					!Strings.isNullOrEmpty(nextLine[10]) ? Integer.parseInt(nextLine[10]) : 0
					));
		}
		return lines;
	}

}
