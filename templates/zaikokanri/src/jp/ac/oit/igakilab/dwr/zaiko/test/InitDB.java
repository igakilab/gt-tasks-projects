package jp.ac.oit.igakilab.dwr.zaiko.test;

import java.util.Arrays;

import org.bson.Document;

import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;

public class InitDB {
	public static void main(String args[]){
		MongoClient client = new MongoClient("localhost", 27017);
		MongoDatabase db = client.getDatabase("zaiko");

		//データベース初期化
		db.drop();
		System.out.println("初期化完了");

		//テストデータ登録
		MongoCollection<Document> col = db.getCollection("receipts");
		col.insertMany(Arrays.asList(
			new Document("name", "コーラ").append("amount", 24),
			new Document("name", "ラムネ").append("amount", 36),
			new Document("name", "ポテトチップス").append("amount", 12),
			new Document("name", "コーラ").append("amount", -6)
		));
		System.out.println("登録完了");

		client.close();
	}
}
