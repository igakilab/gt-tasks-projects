package jp.ac.oit.igakilab.dwr.ranking;

import org.bson.Document;

import com.mongodb.MongoClient;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.model.Filters;
import com.mongodb.client.model.Sorts;

/**
 * DBにアクセスするためのクラスです
 * clientの初期化や、DBの取得条件指定やデータ登録を行います
 * データ取得系ではDocument型のDBカーソルの返却、
 * データ登録系では複数のパラメータからDocumentを生成しDBに登録するまでを処理します。
 * @author ryokun
 *
 */
public class RankingDB {
	//DBサーバーの設定
	static String DB_HOST = "localhost";
	static int DB_PORT = 27017;

	//DBのコレクション設定
	static String DB_NAME = "ranking";
	static String COL_NAME = "scores";


	private MongoClient client; //DBのクライアントインスタンス

	//コンストラクタ
	public RankingDB(){
		client = new MongoClient(DB_HOST, DB_PORT);
	}

	//コレクションの取得
	private MongoCollection<Document> getCollection(){
		return client.getDatabase(DB_NAME).getCollection(COL_NAME);
	}

	/**
	 * ゲームのランキングを取得します。
	 * スコアの点数が高い順に並び替え、lengthでレコードの個数を指定します
	 * @param gameTitle ゲームのタイトル
	 * @param length レコードの個数
	 * @return DBカーソル
	 */
	public FindIterable<Document> findScores(String gameTitle, int length){
		return getCollection()
			.find(Filters.eq("gameTitle", gameTitle))
			.sort(Sorts.descending("score"))
			.limit(length);
	}

	/**
	 * スコアを新しく登録します
	 * @param gameTitle ゲームのタイトル
	 * @param name 名前
	 * @param score スコア(点数)
	 */
	public void registScore(String gameTitle, String name, int score){
		Document doc = new Document("gameTitle", gameTitle)
			.append("name", name)
			.append("score", score);

		getCollection().insertOne(doc);
	}

	/**
	 * DBクライアントをクローズします
	 */
	public void closeClient(){
		client.close();
	}
}
