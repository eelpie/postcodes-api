package uk.co.eelpieconsulting.postcodes.model;

public class PostcodeLine {
	
	private final String postcode;
	private final int eastings;
	private final int northings;
	
	public PostcodeLine(String postcode, int eastings, int northings) {
		this.postcode = postcode;
		this.eastings = eastings;
		this.northings = northings;
	}
	
	public String getPostcode() {
		return postcode;
	}
	public int getEastings() {
		return eastings;
	}
	public int getNorthings() {
		return northings;
	}
	
	@Override
	public String toString() {
		return "PostcodeLine [eastings=" + eastings + ", northings="
				+ northings + ", postcode=" + postcode + "]";
	}
	
}
