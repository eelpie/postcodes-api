package uk.co.eelpieconsulting.postcodes.parsing;

import static org.junit.Assert.assertEquals;

import java.io.File;
import java.util.List;

import org.junit.Test;

import uk.co.eelpieconsulting.postcodes.model.PostcodeLine;

public class PostcodeFileParserTest {

	@Test
	public void canParseSinglePostcodeFile() throws Exception {
		final File file = new File(this.getClass().getClassLoader().getResource("Data/tw.csv").getFile());
		final PostcodeFileParser parser = new PostcodeFileParser();
		
		final List<PostcodeLine> lines = parser.parseFile(file);
		
		assertEquals(11355, lines.size());
		
		final PostcodeLine firstLine = lines.get(0);
		assertEquals("TW1 1AE", firstLine.getPostcode());
		assertEquals(10, firstLine.getPositionalQualityIndicator());
		assertEquals(515984, firstLine.getEastings());
		assertEquals(173661, firstLine.getNorthings());
	}

}
