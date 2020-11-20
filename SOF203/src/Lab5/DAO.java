package Lab5;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class DAO {
	private Connection conn;

	public DAO() {
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			conn = DriverManager.getConnection(
					"jdbc:sqlserver://localhost:1433;databasename=SOF203LAB5;integratedSecurity=true", "", "");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public boolean addStudent(Student s) {
		String sql = "INSERT INTO tblSTUDENT(MASV, HOTEN, EMAIL, SDT, GIOITINH, DIACHI) VALUES(?,?,?,?,?,?)";
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, s.getMaSV());
			ps.setString(2, s.getHoTen());
			ps.setString(3, s.getEmail());
			ps.setString(4, s.getSdt());
			ps.setBoolean(5, s.isGioiTinh());
			ps.setString(6, s.getDiaChi());

			return ps.executeUpdate() > 0;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	public ArrayList<Student> getListStudent() {
		ArrayList<Student> list = new ArrayList<Student>();
		String sql = "SELECT*FROM tblSTUDENT";

		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Student s = new Student();
				s.setMaSV(rs.getString("MASV"));
				s.setHoTen(rs.getString("HOTEN"));
				s.setEmail(rs.getString("EMAIL"));
				s.setSdt(rs.getString("SDT"));
				s.setGioiTinh(rs.getBoolean("GIOITINH"));
				s.setDiaChi(rs.getString("DIACHI"));

				list.add(s);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}
}
