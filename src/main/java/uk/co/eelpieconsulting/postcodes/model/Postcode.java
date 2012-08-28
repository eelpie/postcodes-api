package uk.co.eelpieconsulting.postcodes.model;

import com.google.code.morphia.annotations.Entity;
import com.google.code.morphia.annotations.Id;

@Entity("postcode")
public class Postcode {

	@SuppressWarnings("unused")
	@Id
	private String id;
	
	private String postcode;

	private int eastings;
	private int northings;

	private double latitude;
	private double longitude;

	
	public Postcode() {
	}
	
	public Postcode(String id, String postcode, int eastings, int northings, double latitude, double longitude) {
		this.id = id;
		this.postcode = postcode;
		this.eastings = eastings;
		this.northings = northings;
		this.latitude = latitude;
		this.longitude = longitude;
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

	public double getLatitude() {
		return latitude;
	}

	public double getLongitude() {
		return longitude;
	}

	@Override
	public String toString() {
		return "Postcode [postcode=" + postcode + ", eastings=" + eastings
				+ ", northings=" + northings + ", latitude=" + latitude
				+ ", longitude=" + longitude + "]";
	}
	
}
