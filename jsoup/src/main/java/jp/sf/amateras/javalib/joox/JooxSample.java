package jp.sf.amateras.javalib.joox;

import static org.joox.JOOX.$;

import java.io.ByteArrayInputStream;

import javax.xml.parsers.DocumentBuilder;

import org.apache.commons.io.IOUtils;
import org.joox.JOOX;
import org.joox.Match;
import org.w3c.dom.Document;

/**
 *  jOOXのサンプルです。
 */
public class JooxSample {
	
	public static void main(String[] args)  throws Exception {
		// XMLをパース
		String xml = IOUtils.toString(JooxSample.class.getResourceAsStream("sample.xml"));
		DocumentBuilder builder = JOOX.builder();
        Document doc = builder.parse(new ByteArrayInputStream(xml.getBytes()));
        
        // CSSセレクタを使用した検索
        Match books = $(doc).find("library[name='Amazon'] book");
        System.out.println(books);
        for(Match book: books.each()){
        	System.out.println(book.attr("id") + ": " + book.find("name").text());
        }
    }
}
