package jp.sf.amateras.javalib.clionesql;

import static tetz42.clione.SQLManager.*;
import java.sql.*;
import java.util.List;

/**
 * Clione-SQL�̃T���v��
 * 
 * @author Naoki Takezoe
 */
public class ClioneSQLSample {
	public static void main(String[] args)  throws SQLException {
		Connection conn = DriverManager.getConnection("jdbc:hsqldb:mem:.", "sa", "");
		prepare(conn);
		
        List<Book> books = sqlManager(conn).useFile("jp/sf/amateras/javalib/clionesql/ClioneSQLSample.sql")
                .findAll(Book.class, params("publisher", "�ĉj��").$("price", 3500) );
        
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
	 * �T���v���̎��s�ɕK�v�ȃe�[�u���Ə����f�[�^���쐬
	 */
	private static void prepare(Connection conn) throws SQLException {
		Statement stmt = conn.createStatement();
		
		stmt.executeUpdate("CREATE TABLE BOOKS(" +
				"ID INTEGER PRIMARY KEY, " +
				"TITLE VARCHAR(200) NOT NULL, " +
				"PUBLISHER VARCHAR(200) NOT NULL, " +
				"PRICE INTEGER NOT NULL)");
		
		stmt.executeUpdate("INSERT INTO BOOKS VALUES (1, 'Eclipse�v���O�C���J���O��U��', '�}�C�i�r', 4095)");
		stmt.executeUpdate("INSERT INTO BOOKS VALUES (2, 'Seasar2�O�����', '�ĉj��', 3990)");
		stmt.executeUpdate("INSERT INTO BOOKS VALUES (3, '����Ŏg����Java���C�u����', '�ĉj��', 3780)");
		stmt.executeUpdate("INSERT INTO BOOKS VALUES (4, '�t����Scala���V�s', '�ĉj��', 3360)");
		
		stmt.close();
	}
	
	/**
	 * �������ʂ��}�b�s���O����N���X
	 */
	public static class Book {
		public int id;
		public String title;
		public String publisher;
		public int price;
	}
}
