package jp.ac.oit.igakilab.dwr.keijiban;

import java.util.Calendar;

import org.bson.Document;

import com.mongodb.MongoClient;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.model.Sorts;

public class KeijibanDB {
	static String DB_HOST = "localhost";
	static int DB_PORT = 27017;

	static String DB_NAME = "keijiban";
	static String COL_NAME = "posts";

	private MongoClient client;

	public KeijibanDB(){
		client = new MongoClient(DB_HOST, DB_PORT);
	}

	private MongoCollection<Document> getCollection(){
		return client.getDatabase(DB_NAME).getCollection(COL_NAME);
	}

	public FindIterable<Document> getMessages(){
		return getCollection().find().sort(Sorts.descending("time"));
	}

	public void postMessage(String name, String message){
		Document doc = new Document("name", name)
			.append("message", message)
			.append("time", Calendar.getInstance().getTime());

		getCollection().insertOne(doc);
	}

	public void closeClient(){
		client.close();
	}
}
