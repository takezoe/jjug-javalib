package jp.sf.amateras.javalib.jsoup;

import java.io.IOException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

/**
 * jsoupのサンプルです。
 */
public class JsoupSample {
	
	public static void main(String[] args)  throws IOException {
		// Web上のHTMLをパース
		Document doc = Jsoup.connect("http://d.hatena.ne.jp/takezoe/").get();
		
		// CSSセレクタを使用した検索
		Elements headlines = doc.select("div.section h3");
		for(int i=0; i < headlines.size(); i++){
			Element e = headlines.get(i);
			System.out.println(e.html());
		}
	}
	
}
