package Lab6;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class BookDAO {
	private Connection conn;
	
	public BookDAO() {
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			conn = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;databasename=SOF203LAB6;integratedSecurity=true","","");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		new BookDAO();
	}
	
	public ArrayList<Book> getListBook(){
		ArrayList<Book> list = new ArrayList<>();
		String sql = "SELECT*FROM BOOK";
		
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				Book b = new Book();
				b.setId(rs.getInt("ID"));
				b.setTitle(rs.getString("TITLE"));
				b.setPrice(rs.getString("PRICE"));
				
				
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return list;
	}
}
