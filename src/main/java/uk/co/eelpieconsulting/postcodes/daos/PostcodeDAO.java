package uk.co.eelpieconsulting.postcodes.daos;

import java.net.UnknownHostException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import uk.co.eelpieconsulting.postcodes.model.Postcode;
import uk.co.eelpieconsulting.postcodes.model.UnknownPostcodeException;

import com.google.code.morphia.Datastore;
import com.google.code.morphia.query.Query;
import com.mongodb.MongoException;

@Component
public class PostcodeDAO {
			
	private final Datastore datastore;

	@Autowired
	public PostcodeDAO(DataSourceFactory dataSourceFactory) throws UnknownHostException, MongoException {
		this.datastore = dataSourceFactory.getDatastore();
	}
	
	public void save(Postcode postcode) {
		datastore.save(postcode);		
	}

	public void removeAll() {
		final Query<Postcode> allStops = datastore.createQuery(Postcode.class);
		datastore.delete(allStops);
	}

	public List<Postcode> getAll() {
		final Query<Postcode> all = datastore.createQuery(Postcode.class);
		return all.asList();
	}

	public Postcode getById(String id) throws UnknownPostcodeException {
		final Query<Postcode> query = datastore.createQuery(Postcode.class).field("id").equal(id);
		final Postcode postcode = query.get();
		if (postcode != null) {
			return postcode;
		}
		throw new UnknownPostcodeException(id);
	}
	
}
