package jp.ac.oit.igakilab.dwr.zaiko;

import java.util.ArrayList;
import java.util.List;

import org.bson.Document;

public class Zaiko {
	public List<ItemForm> getItemList(){
		ZaikoDB db = new ZaikoDB();

		List<ItemForm> items = new ArrayList<ItemForm>();

		for(Document doc : db.getItemList()){
			ItemForm tmp = new ItemForm();
			tmp.setName(doc.getString("_id"));
			tmp.setAmount(doc.getInteger("qty", 0));

			items.add(tmp);
		}

		db.closeClient();
		return items;

	}

	public boolean receiveItem(ItemForm recv){
		ZaikoDB db = new ZaikoDB();

		db.receiveItem(recv.getName(), recv.getAmount());

		db.closeClient();
		return true;
	}

	public boolean issueItem(ItemForm req){
		ZaikoDB db = new ZaikoDB();

		boolean res = db.issueItem(req.getName(), req.getAmount());

		db.closeClient();
		return res;
	}
}
