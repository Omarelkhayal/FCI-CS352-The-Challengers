package com.FCI.SWE.Models;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import com.google.appengine.api.datastore.DatastoreService;
import com.google.appengine.api.datastore.DatastoreServiceFactory;
import com.google.appengine.api.datastore.Entity;
import com.google.appengine.api.datastore.EntityNotFoundException;
import com.google.appengine.api.datastore.FetchOptions;
import com.google.appengine.api.datastore.PreparedQuery;
import com.google.appengine.api.datastore.Query;

public class GroupID {
	
	private Object name;

	public void CreateGroupID(String uname, String fname) {
		DatastoreService datastore = DatastoreServiceFactory
				.getDatastoreService();
		Query gaeQuery = new Query("friendrequest");
		PreparedQuery pq = datastore.prepare(gaeQuery);
		List<Entity> list = pq.asList(FetchOptions.Builder.withDefaults());

		Entity friendrequest = new Entity("friendrequest", list.size() + 1);
		
		friendrequest.setProperty("sendername", this.name);
		friendrequest.setProperty("friendname", fname);
		friendrequest.setProperty("status", false);
		datastore.put(friendrequest);

		return ;

	}
}
