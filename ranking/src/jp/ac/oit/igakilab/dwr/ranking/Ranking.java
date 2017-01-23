package jp.ac.oit.igakilab.dwr.ranking;

import java.util.ArrayList;
import java.util.List;

import org.bson.Document;

public class Ranking {
	/**
	 * 指定されたゲームの上位10個のランキングを取得します
	 * @param gameTitle ゲームのタイトル
	 * @return ランキングのスコア(RecordFormの配列)
	 */
	public List<RecordForm> getRanking(String gameTitle){
		RankingDB db = new RankingDB();

		List<RecordForm> records = new ArrayList<RecordForm>();

		for(Document doc : db.findScores(gameTitle, 10)){
			RecordForm rec = new RecordForm();
			rec.setName(doc.getString("name"));
			rec.setScore(doc.getInteger("score", 0));
			rec.setRank(records.size() + 1);

			records.add(rec);
		}

		db.closeClient();
		return records;
	}


	/**
	 * 指定されたゲームのスコアとして、新しいスコアを登録します
	 * @param gameTitle ゲームのタイトル
	 * @param rec スコアのデータ(RecordForm, rankは指定しなくてよい)
	 * @return 成功した時true
	 */
	public boolean sendRecord(String gameTitle, RecordForm rec){
		RankingDB db = new RankingDB();

		db.registScore(gameTitle, rec.getName(), rec.getScore());

		return true;
	}
}
