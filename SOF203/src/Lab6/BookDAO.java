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
			conn = DriverManager.getConnection(
					"jdbc:sqlserver://localhost:1433;databasename=SOF203LAB6;integratedSecurity=true", "", "");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public ArrayList<Book> getListBook() {
		ArrayList<Book> list = new ArrayList<>();
		String sql = "SELECT*FROM BOOK";
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Book b = new Book();
				b.setId(rs.getInt("ID"));
				b.setTitle(rs.getString("TITLE"));
				b.setPrice(rs.getString("PRICE"));

				list.add(b);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return list;
	}

	public boolean addBook(Book b) {
		String sql = "INSERT INTO BOOK VALUES(?,?,?)";
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, b.getId());
			ps.setString(2, b.getTitle());
			ps.setString(3, b.getPrice());

			return ps.executeUpdate() > 0;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	public boolean deleteBook(Book b) {
		String sql = "DELETE FROM BOOK WHERE ID = ? AND TITLE = ? AND PRICE = ?";
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, b.getId());
			ps.setString(2, b.getTitle());
			ps.setString(3, b.getPrice());

			return ps.executeUpdate() > 0;
		} catch (Exception e) {
			e.printStackTrace();
		}

		return false;
	}

	public ArrayList<Book> searchBook(String title) {
		ArrayList<Book> list = new ArrayList<Book>();
		String sql = "SELECT*FROM BOOK WHERE TITLE LIKE ?";
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, "%" + title + "%");
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Book b = new Book();
				b.setId(rs.getInt("ID"));
				b.setTitle(rs.getString("TITLE"));
				b.setPrice(rs.getString("PRICE"));

				list.add(b);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return list;
	}
}
