package jp.ac.oit.igakilab.dwr.keijiban;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import org.bson.Document;

import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.model.Sorts;

public class Keijiban {
	static String DB_HOST = "localhost";
	static int DB_PORT = 27017;

	static String DB_NAME = "keijiban";
	static String COL_POSTS = "posts";

	private MongoClient getDBClient(){
		return new MongoClient(DB_HOST, DB_PORT);
	}

	public List<PostForm> getMessages(){
		MongoClient client = getDBClient();
		MongoCollection<Document> col = client.getDatabase(DB_NAME).getCollection(COL_POSTS);

		List<PostForm> messages = new ArrayList<PostForm>();
		for(Document doc : col.find().sort(Sorts.descending("time"))){
			PostForm post = new PostForm();
			post.setName(doc.getString("name"));
			post.setMessage(doc.getString("message"));
			post.setTime(doc.getDate("time"));
			messages.add(post);
		}

		client.close();
		return messages;
	}

	public boolean postMessage(PostForm post){
		MongoClient client = getDBClient();
		MongoCollection<Document> col = client.getDatabase(DB_NAME).getCollection(COL_POSTS);

		Document doc = new Document("name", post.getName())
			.append("message", post.getMessage())
			.append("time", Calendar.getInstance().getTime());

		col.insertOne(doc);

		return true;
	}
}
