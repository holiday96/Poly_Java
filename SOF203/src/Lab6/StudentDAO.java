package Lab6;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.swing.JComboBox;

public class StudentDAO {
	private Connection conn;

	public StudentDAO() {
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			conn = DriverManager.getConnection(
					"jdbc:sqlserver://localhost:1433;databasename=SOF203LAB6V2;integratedSecurity=true", "", "");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public ArrayList<Student> getListStudent() {
		ArrayList<Student> list = new ArrayList<Student>();
		String sql = "SELECT*FROM STUDENT";
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Student s = new Student();
				s.setId(rs.getInt("ID"));
				s.setName(rs.getString("SNAME"));
				s.setAddress(rs.getString("SADDRESS"));
				s.setParentName(rs.getString("PARENTNAME"));
				s.setPhone(rs.getString("PHONE"));
				s.setStan(rs.getString("STAN"));

				list.add(s);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return list;
	}

	public void loadComboBoxStandard(JComboBox<String> cboStandard, JComboBox<Integer> cboFees) {
		String sql = "SELECT STAN FROM STANDARDS";
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				cboStandard.addItem(rs.getString("STAN"));
				cboFees.addItem(rs.getInt("FEES"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public boolean addStudent(Student s) {
		String sql = "INSERT INTO STUDENT(SNAME, SADDRESS, PARENTNAME, PHONE, STAN) VALUES(?,?,?,?,?)";
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, s.getName());
			ps.setString(2, s.getAddress());
			ps.setString(3, s.getParentName());
			ps.setString(4, s.getPhone());
			ps.setString(5, s.getStan());

			return ps.executeUpdate() > 0;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}
}
