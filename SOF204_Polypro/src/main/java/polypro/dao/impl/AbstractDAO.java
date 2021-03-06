package polypro.dao.impl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

import polypro.dao.GenericDAO;
import polypro.mapper.RowMapper;

public class AbstractDAO<T> implements GenericDAO<T> {
	public Connection getConnection() {
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			String url = "jdbc:sqlserver://localhost:1433;" + "databaseName=POLYPRO;" + "integratedSecurity=true";
			String user = "";
			String password = "";
			return DriverManager.getConnection(url, user, password);
		} catch (ClassNotFoundException | SQLException e) {
			return null;
		}
	}

	@SuppressWarnings("hiding")
	@Override
	public <T> List<T> query(String sql, RowMapper<T> rowMapper, Object... parameters) {
		List<T> results = new ArrayList<T>();
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			conn = getConnection();
			ps = conn.prepareStatement(sql);
			setParameter(ps, parameters);
			rs = ps.executeQuery();
			while (rs.next()) {
				results.add(rowMapper.mapRow(rs));
			}
			return results;
		} catch (SQLException e) {
			return null;
		} finally {
			try {
				if (conn != null) {
					conn.close();
				} else if (ps != null) {
					ps.close();
				} else if (rs != null) {
					rs.close();
				}
			} catch (SQLException e) {
				return null;
			}
		}
	}

	private void setParameter(PreparedStatement ps, Object... parameters) {
		try {
			for (int i = 0; i < parameters.length; i++) {
				Object parameter = parameters[i];
				int index = i + 1;
				if (parameter instanceof String) {
					ps.setNString(index, (String) parameter);
				} else if (parameter instanceof Integer) {
					ps.setInt(index, (Integer) parameter);
				} else if (parameter instanceof Double) {
					ps.setDouble(index, (Double) parameter);
				} else if (parameter instanceof Boolean) {
					ps.setBoolean(index, (Boolean) parameter);
				} else if (parameter instanceof Date) {
					ps.setDate(index, new java.sql.Date(((Date) parameter).getTime()));
				}

			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void update(String sql, Object... parameters) {
		Connection conn = null;
		PreparedStatement ps = null;
		try {
			conn = getConnection();
			conn.setAutoCommit(false);
			ps = conn.prepareStatement(sql);
			setParameter(ps, parameters);
			if (ps.executeUpdate() > 0) {
				JOptionPane.showMessageDialog(null, "Thành công", "Thông báo", 0,
						new ImageIcon(this.getClass().getResource("../../../icon/Tick.png")));
				conn.commit();
			}
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "Thất bại", "Thông báo", JOptionPane.ERROR_MESSAGE);
			if (conn != null) {
				try {
					conn.rollback();
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
			}
		} finally {
			try {
				if (conn != null) {
					conn.close();
				}
				if (ps != null) {
					ps.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	@Override
	public String insert(String sql, Object... parameters) {
		String id = null;
		Connection conn = null;
		PreparedStatement ps = null;
		try {
			conn = getConnection();
			conn.setAutoCommit(false);
			ps = conn.prepareStatement(sql);
			setParameter(ps, parameters);
			if (ps.executeUpdate() > 0) {
				JOptionPane.showMessageDialog(null, "Thành công", "Thông báo", 0,
						new ImageIcon(this.getClass().getResource("../../../icon/Tick.png")));
				conn.commit();
			}
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "Thất bại", "Thông báo", JOptionPane.ERROR_MESSAGE);
			if (conn != null) {
				try {
					conn.rollback();
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
			}
			e.printStackTrace();
		} finally {
			try {
				if (conn != null) {
					conn.close();
				}
				if (ps != null) {
					ps.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return id;
	}

	@Override
	public void delete(String sql, Object... parameters) {
		Connection conn = null;
		PreparedStatement ps = null;
		try {
			conn = getConnection();
			conn.setAutoCommit(false);
			ps = conn.prepareStatement(sql);
			setParameter(ps, parameters);
			if (ps.executeUpdate() > 0) {
				JOptionPane.showMessageDialog(null, "Thành công", "Thông báo", 0,
						new ImageIcon(this.getClass().getResource("../../../icon/Tick.png")));
				conn.commit();
			}
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "Thất bại", "Thông báo", JOptionPane.ERROR_MESSAGE);
			if (conn != null) {
				try {
					conn.rollback();
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
			}
			e.printStackTrace();
		} finally {
			try {
				if (conn != null) {
					conn.close();
				}
				if (ps != null) {
					ps.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	@Override
	public int countDB(String sql) {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			conn = getConnection();
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			while (rs.next()) {
				return rs.getInt(1);
			}
		} catch (SQLException e) {
			return 0;
		} finally {
			try {
				if (conn != null) {
					conn.close();
				} else if (ps != null) {
					ps.close();
				} else if (rs != null) {
					rs.close();
				}
			} catch (SQLException e) {
				return 0;
			}
		}
		return 0;
	}
}
