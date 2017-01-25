package jp.ac.oit.igakilab.dwr.keijiban.test;

import java.text.DateFormat;
import java.text.SimpleDateFormat;

import jp.ac.oit.igakilab.dwr.keijiban.Keijiban;
import jp.ac.oit.igakilab.dwr.keijiban.PostForm;

public class TestKeijiban {
	public static void main(String[] args){
		System.out.println("--- TEST getMessages");
		testGetMessages();
		System.out.println();

		System.out.println("--- TEST postMessage");
		testPostMessage();
	}

	public static void testGetMessages(){
		Keijiban k = new Keijiban();
		DateFormat df = new SimpleDateFormat("yy/MM/dd HH:mm");

		for(PostForm p : k.getMessages()){
			System.out.format("%s : %s (%s)\n",
				p.getName(), p.getMessage(), df.format(p.getTime()));
		}
	}

	public static void testPostMessage(){
		String name = "ue";
		String msg = "今日学校行かなあかん？";
		Keijiban k = new Keijiban();

		System.out.format("postMessage(\"%s\", \"%s\")\n", name, msg);
		PostForm p = new PostForm();
		p.setName(name);
		p.setMessage(msg);

		System.out.println("return: " + k.postMessage(p));
	}
}
