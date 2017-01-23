package jp.ac.oit.igakilab.dwr.ranking;

/**
 * スコアのレコード(名前とスコアのペア)を表すクラスです
 * dwrでクライアントとやり取りするときに利用します
 * @author ryokun
 *
 */
public class RecordForm {
	/**
	 * 順位
	 */
	private int rank;

	/**
	 * 名前
	 */
	private String name;

	/**
	 * スコア(点数)
	 */
	private int score;

	public int getRank() {
		return rank;
	}
	public void setRank(int rank) {
		this.rank = rank;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getScore() {
		return score;
	}
	public void setScore(int score) {
		this.score = score;
	}
}
