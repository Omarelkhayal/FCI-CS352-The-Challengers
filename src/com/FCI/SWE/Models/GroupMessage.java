package com.FCI.SWE.Models;

import java.util.List;

import com.google.appengine.api.datastore.DatastoreService;
import com.google.appengine.api.datastore.DatastoreServiceFactory;
import com.google.appengine.api.datastore.Entity;
import com.google.appengine.api.datastore.FetchOptions;
import com.google.appengine.api.datastore.PreparedQuery;
import com.google.appengine.api.datastore.Query;

public class GroupMessage {
	
	private Object name;

	public void SendGroupMessage(String uname, String fname) {
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
