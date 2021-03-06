package uk.co.eelpieconsulting.postcodes.parsing;

import org.springframework.stereotype.Component;

import uk.co.eelpieconsulting.common.geo.OSRefConvertor;
import uk.co.eelpieconsulting.common.geo.model.LatLong;

@Component
public class EastingsNorthingsConvertor {

	private OSRefConvertor osRefConvertor;
	
	public EastingsNorthingsConvertor() {
		osRefConvertor = new OSRefConvertor();
	}

	public LatLong convertToLatLong(int eastings, int northings) {
		return osRefConvertor.toLatLong(eastings, northings);
	}

}
