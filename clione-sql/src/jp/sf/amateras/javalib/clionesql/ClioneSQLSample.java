package jp.sf.amateras.javalib.clionesql;

import static tetz42.clione.SQLManager.*;
import java.sql.*;
import java.util.List;

/**
 * Clione-SQLのサンプル
 * 
 * @author Naoki Takezoe
 */
public class ClioneSQLSample {
	public static void main(String[] args)  throws SQLException {
		Connection conn = DriverManager.getConnection("jdbc:hsqldb:mem:.", "sa", "");
		prepare(conn);
		
        List<Book> books = sqlManager(conn).useFile("jp/sf/amateras/javalib/clionesql/ClioneSQLSample.sql")
                .findAll(Book.class, params("publisher", "翔泳社").$("price", 3500) );
        
        for(Book book: books){
        	System.out.println("id: " + book.id);
        	System.out.println("title: " + book.title);
        	System.out.println("publisher: " + book.publisher);
        	System.out.println("price: " + book.price);
        	System.out.println("--");
        }
        
        conn.close();
	}
	
	/**
	 * サンプルの実行に必要なテーブルと所期データを作成
	 */
	private static void prepare(Connection conn) throws SQLException {
		Statement stmt = conn.createStatement();
		
		stmt.executeUpdate("CREATE TABLE BOOKS(" +
				"ID INTEGER PRIMARY KEY, " +
				"TITLE VARCHAR(200) NOT NULL, " +
				"PUBLISHER VARCHAR(200) NOT NULL, " +
				"PRICE INTEGER NOT NULL)");
		
		stmt.executeUpdate("INSERT INTO BOOKS VALUES (1, 'Eclipseプラグイン開発徹底攻略', 'マイナビ', 4095)");
		stmt.executeUpdate("INSERT INTO BOOKS VALUES (2, 'Seasar2徹底入門', '翔泳社', 3990)");
		stmt.executeUpdate("INSERT INTO BOOKS VALUES (3, '現場で使えるJavaライブラリ', '翔泳社', 3780)");
		stmt.executeUpdate("INSERT INTO BOOKS VALUES (4, '逆引きScalaレシピ', '翔泳社', 3360)");
		
		stmt.close();
	}
	
	/**
	 * 検索結果をマッピングするクラス
	 */
	public static class Book {
		public int id;
		public String title;
		public String publisher;
		public int price;
	}
}
