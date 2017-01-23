package jp.ac.oit.igakilab.dwr.zaiko;

import java.util.Arrays;
import java.util.List;

import org.bson.Document;
import org.bson.conversions.Bson;

import com.mongodb.MongoClient;
import com.mongodb.client.AggregateIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.model.Accumulators;
import com.mongodb.client.model.Aggregates;
import com.mongodb.client.model.Filters;

public class ZaikoDB {
	static String DB_HOST = "localhost";
	static int DB_PORT = 27017;

	static String DB_NAME = "zaiko";
	static String COL_NAME = "receipts";

	private MongoClient client;

	public ZaikoDB(){
		client = new MongoClient(DB_HOST, DB_PORT);
	}

	private MongoCollection<Document> getCollection(){
		return client.getDatabase(DB_NAME).getCollection(COL_NAME);
	}

	private int getItemQuantity(String itemName){
		List<Bson> query = Arrays.asList(
			Aggregates.match(Filters.eq("name", itemName)),
			Aggregates.group(null, Accumulators.sum("qty", "$amount")));

		Document doc = getCollection().aggregate(query).first();

		return doc != null ? doc.getInteger("qty", 0) : 0;
	}

	public AggregateIterable<Document> getItemList(){
		return getCollection().aggregate(Arrays.asList(
			Aggregates.group("$name", Accumulators.sum("qty", "$amount"))));
	}

	public void receiveItem(String itemName, int amount){
		Document doc = new Document("name", itemName)
			.append("amount", amount);

		getCollection().insertOne(doc);
	}

	public boolean issueItem(String itemName, int amount){
		int nowQty = getItemQuantity(itemName);

		if( nowQty >= amount ){
			Document doc = new Document("name", itemName)
				.append("amount", -amount);
			getCollection().insertOne(doc);
			return true;
		}else{
			return false;
		}
	}

	public void closeClient(){
		client.close();
	}
}
