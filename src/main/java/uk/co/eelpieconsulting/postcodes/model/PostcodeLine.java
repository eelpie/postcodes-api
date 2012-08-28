package uk.co.eelpieconsulting.postcodes.model;

public class PostcodeLine {
	
	private final String postcode;
	private final int positionalQualityIndicator;
	private final int eastings;
	private final int northings;
	private final String countryCode;
	private final String NHSRegionalHACode;
	private final String NHSHACode;
	private final String adminCountyCode;
	private final String adminDistrictCode;
	private final String adminWardCode;
	
	public PostcodeLine(String postcode, int positionalQualityIndicator,
			int eastings, int northings, String countryCode,
			String nHSRegionalHACode, String nHSHACode, String adminCountyCode,
			String adminDistrictCode, String adminWardCode) {
		super();
		this.postcode = postcode;
		this.positionalQualityIndicator = positionalQualityIndicator;
		this.eastings = eastings;
		this.northings = northings;
		this.countryCode = countryCode;
		NHSRegionalHACode = nHSRegionalHACode;
		NHSHACode = nHSHACode;
		this.adminCountyCode = adminCountyCode;
		this.adminDistrictCode = adminDistrictCode;
		this.adminWardCode = adminWardCode;
	}
	public String getPostcode() {
		return postcode;
	}
	public int getPositionalQualityIndicator() {
		return positionalQualityIndicator;
	}
	public int getEastings() {
		return eastings;
	}
	public int getNorthings() {
		return northings;
	}
	public String getCountryCode() {
		return countryCode;
	}
	public String getNHSRegionalHACode() {
		return NHSRegionalHACode;
	}
	public String getNHSHACode() {
		return NHSHACode;
	}
	public String getAdminCountyCode() {
		return adminCountyCode;
	}
	public String getAdminDistrictCode() {
		return adminDistrictCode;
	}
	public String getAdminWardCode() {
		return adminWardCode;
	}
	@Override
	public String toString() {
		return "PostcodeLine [postcode=" + postcode
				+ ", positionalQualityIndicator=" + positionalQualityIndicator
				+ ", eastings=" + eastings + ", northings=" + northings
				+ ", countryCode=" + countryCode + ", NHSRegionalHACode="
				+ NHSRegionalHACode + ", NHSHACode=" + NHSHACode
				+ ", adminCountyCode=" + adminCountyCode
				+ ", adminDistrictCode=" + adminDistrictCode
				+ ", adminWardCode=" + adminWardCode + "]";
	}

	
		
	
}
