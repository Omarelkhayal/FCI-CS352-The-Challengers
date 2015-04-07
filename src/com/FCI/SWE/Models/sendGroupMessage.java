package com.FCI.SWE.Models;

import org.datanucleus.store.types.sco.backed.List;

import com.google.appengine.api.datastore.DatastoreService;
import com.google.appengine.api.datastore.DatastoreServiceFactory;
import com.google.appengine.api.datastore.Entity;
import com.google.appengine.api.datastore.FetchOptions;
import com.google.appengine.api.datastore.PreparedQuery;
import com.google.appengine.api.datastore.Query;
import com.google.appengine.repackaged.com.google.common.base.Flag.String;

public class sendGroupMessage {

	public void sendgroupdmessage(String uname, ArrayList<String>friends, String content) {
		DatastoreService datastore = DatastoreServiceFactory
				.getDatastoreService();
		Query gaeQuery = new Query("groupmessage");
		PreparedQuery pq = datastore.prepare(gaeQuery);
		List<Entity> list = pq.asList(FetchOptions.Builder.withDefaults());

		Entity groupmessage = new Entity("groupmessage", list.size() + 1);
		
		groupmessage.setProperty("sendername", this.name);
		groupmessage.setProperty("friendname", friends.toString());
		groupmessage.setProperty("content", content);
		datastore.put(groupmessage);

		return ;

	}
}
