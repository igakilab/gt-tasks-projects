package jp.ac.oit.igakilab.dwr.ranking;

import org.bson.Document;

import com.mongodb.MongoClient;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.model.Filters;
import com.mongodb.client.model.Sorts;

public class RankingDB {
	static String DB_HOST = "localhost";
	static int DB_PORT = 27017;

	static String DB_NAME = "ranking";
	static String COL_NAME = "scores";

	private MongoClient client;

	public RankingDB(){
		client = new MongoClient(DB_HOST, DB_PORT);
	}

	private MongoCollection<Document> getCollection(){
		return client.getDatabase(DB_NAME).getCollection(COL_NAME);
	}

	public FindIterable<Document> findScores(String gameTitle, int length){
		return getCollection()
			.find(Filters.eq("gameTitle", gameTitle))
			.sort(Sorts.descending("score"))
			.limit(length);
	}

	public void registScore(String gameTitle, String name, int score){
		Document doc = new Document("gameTitle", gameTitle)
			.append("name", name)
			.append("score", score);

		getCollection().insertOne(doc);
	}

	public void closeClient(){
		client.close();
	}
}
