package jp.ac.oit.igakilab.dwr.zaiko;

import java.util.ArrayList;
import java.util.List;

public class Zaiko {
	/**
	 * 在庫DBに登録されている商品とその商品の在庫数のリストを取得します
	 * @return 商品と在庫数のリスト(ItemFormの配列)
	 */
	public List<ItemForm> getItemList(){
		//TODO: 在庫リスト取得メソッドの実装

		//ダミーデータを作成
		List<ItemForm> dummy = new ArrayList<ItemForm>();
		ItemForm i;

		i = new ItemForm();
		i.setName("cola");
		i.setAmount(30);
		dummy.add(i);

		i = new ItemForm();
		i.setName("fritolay");
		i.setAmount(10);
		dummy.add(i);

		return dummy;
	}

	/**
	 * 在庫DBに商品を追加します
	 * @param recv 商品名と追加数量のデータ(ItemForm)
	 * @return 成功したときtrue
	 */
	public boolean receiveItem(ItemForm recv){
		//TODO: 入庫メソッドの実装

		return true;
	}

	/**
	 * 在庫DBからしていた数量の商品を出庫します
	 * @param req 商品名と出庫数量のデータ(ItemForm)
	 * @return 成功した時true, 在庫数が足りないとき、失敗した時false
	 */
	public boolean issueItem(ItemForm req){
		//TODO: 出庫メソッドの実装

		return true;
	}
}
