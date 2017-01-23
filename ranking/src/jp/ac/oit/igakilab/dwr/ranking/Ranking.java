package jp.ac.oit.igakilab.dwr.ranking;

import java.util.ArrayList;
import java.util.List;

import org.bson.Document;

public class Ranking {
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


	public boolean sendRecord(String gameTitle, RecordForm rec){
		RankingDB db = new RankingDB();

		db.registScore(gameTitle, rec.getName(), rec.getScore());

		return true;
	}
}
