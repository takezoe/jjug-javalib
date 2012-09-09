package jp.sf.amateras.javalib.thymeleaf;

import java.util.ArrayList;
import java.util.List;

import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;
import org.thymeleaf.templateresolver.ClassLoaderTemplateResolver;

/**
 * Thymeleafのサンプル
 * 
 * @author Naoki Takezoe
 */
public class ThymeleafSample {
	public static void main(String[] args) {
		TemplateEngine engine = new TemplateEngine();
		engine.setTemplateResolver(new ClassLoaderTemplateResolver());
				
		List<Book> books = new ArrayList<Book>();
		books.add(new Book("Seasar2徹底入門", "http://www.amazon.co.jp/exec/obidos/ASIN/4798121509"));
		books.add(new Book("現場で使えるJavaライブラリ", "http://www.amazon.co.jp/exec/obidos/ASIN/4798123366"));
		books.add(new Book("Scala逆引きレシピ", "http://www.amazon.co.jp/exec/obidos/ASIN/4798125415"));
		
		Context context = new Context();
		context.setVariable("books", books);
		
		String result = engine.process("jp/sf/amateras/javalib/thymeleaf/ThymeleafSample.xhtml", context);
		
		System.out.println(result);
	}
	
	public static class Book {
		public String title;
		public String url;
		
		public Book(String title, String url){
			this.title = title;
			this.url = url;
		}
	}
}
