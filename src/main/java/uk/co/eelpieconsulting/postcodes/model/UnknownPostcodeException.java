package uk.co.eelpieconsulting.postcodes.model;

public class UnknownPostcodeException extends RuntimeException {
	
	private static final long serialVersionUID = 1L;
	
	private final String id;

	public UnknownPostcodeException(String id) {
		this.id = id;
	}
	
	public String getId() {
		return id;
	}

}
