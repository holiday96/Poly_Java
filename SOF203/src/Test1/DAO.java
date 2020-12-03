package Test1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JComboBox;

public class DAO {
	private Connection conn;

	public DAO() {
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			conn = DriverManager.getConnection(
					"jdbc:sqlserver://localhost:1433;databasename=TEST1;integratedSecurity=true", "", "");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public ArrayList<KhachHang> getListKhachHang() {
		ArrayList<KhachHang> list = new ArrayList<KhachHang>();
		String sql = "SELECT*FROM KHACHHANG";

		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				KhachHang k = new KhachHang();
				k.setMaKH(rs.getString("MAKH"));
				k.setTenKH(rs.getString("TEN"));
				k.setSdt(rs.getString("SDT"));
				k.setEmail(rs.getString("EMAIL"));
				k.setLoaiKH(rs.getString("LOAIKHACHHANG"));

				list.add(k);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}

	public boolean addKhachHang(KhachHang k) {
		String sql = "INSERT INTO KHACHHANG VALUES(?,?,?,?,?)";

		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, k.getMaKH());
			ps.setString(2, k.getTenKH());
			ps.setString(3, k.getSdt());
			ps.setString(4, k.getEmail());
			ps.setString(5, k.getLoaiKH());

			return ps.executeUpdate() > 0;
		} catch (Exception e) {
			e.printStackTrace();
		}

		return false;
	}

	public boolean removeKhachHang(String id) {
		String sql = "DELETE KHACHHANG WHERE MAKH = ?";

		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, id);

			return ps.executeUpdate() > 0;
		} catch (Exception e) {
			e.printStackTrace();
		}

		return false;
	}

	public JComboBox<String> loadCombobox() {
		JComboBox<String> cbo = new JComboBox<String>();
		String sql = "SELECT*FROM LOAIKHACHHANG";

		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				cbo.addItem(rs.getString("LOAIKHACHHANG"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return cbo;
	}

	public ArrayList<String> loadListNameCombobox() {
		ArrayList<String> list = new ArrayList<String>();
		String sql = "SELECT*FROM LOAIKHACHHANG";

		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				list.add(rs.getString(2));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return list;
	}
	
	public ArrayList<KhachHang> getListKhachHangByFilter(String filter) {
		ArrayList<KhachHang> list = new ArrayList<KhachHang>();
		String sql = "SELECT*FROM KHACHHANG WHERE LOAIKHACHHANG = ?";

		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, filter);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				KhachHang k = new KhachHang();
				k.setMaKH(rs.getString("MAKH"));
				k.setTenKH(rs.getString("TEN"));
				k.setSdt(rs.getString("SDT"));
				k.setEmail(rs.getString("EMAIL"));
				k.setLoaiKH(rs.getString("LOAIKHACHHANG"));

				list.add(k);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}
}
