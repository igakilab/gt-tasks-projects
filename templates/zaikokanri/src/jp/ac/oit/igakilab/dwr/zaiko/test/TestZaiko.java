package jp.ac.oit.igakilab.dwr.zaiko.test;

import jp.ac.oit.igakilab.dwr.zaiko.ItemForm;
import jp.ac.oit.igakilab.dwr.zaiko.Zaiko;

public class TestZaiko {
	public static void main(String[] args){
		System.out.println("--- TEST getItemList");
		testGetItemList();
		System.out.println();

		System.out.println("--- TEST receiveItem");
		testReceiveItem();
		System.out.println();

		System.out.println("--- TEST issueItem");
		testIssueItem();
		System.out.println();
	}

	public static void testGetItemList(){
		Zaiko z = new Zaiko();

		for(ItemForm i : z.getItemList()){
			System.out.format("%s: %d個\n", i.getName(), i.getAmount());
		}
	}

	public static void testReceiveItem(){
		String name = "oreo";
		int amount = 5;
		Zaiko z = new Zaiko();

		System.out.format("receiveItem(\"%s\", %d)\n", name, amount);
		ItemForm i = new ItemForm();
		i.setName(name);
		i.setAmount(amount);

		System.out.println("return: " + z.receiveItem(i));
	}

	public static void testIssueItem(){
		String name = "oreo";
		int amount = 3;
		Zaiko z = new Zaiko();

		System.out.format("issueItem(\"%s\", %d)\n", name, amount);
		ItemForm i = new ItemForm();
		i.setName(name);
		i.setAmount(amount);

		System.out.println("return: " + z.issueItem(i));
	}
}
