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

	MongoClient client;

	private MongoCollection<Document> getCollection(){
		return client.getDatabase(DB_NAME).getCollection(COL_NAME);
	}

	public FindIterable<Document> findScores(String gameTitle, int length){
		MongoCollection<Document> col = getCollection();

		return col.find(Filters.eq("gameTitle", gameTitle)).sort(Sorts.descending("score")).limit(length);
	}

	public void registScore(String gameTitle, String name, int score){
		MongoCollection<Document> col = getCollection();
		Document doc = new Document("gameTitle", gameTitle)
			.append("name", name)
			.append("score", score);

		col.insertOne(doc);
	}
}
