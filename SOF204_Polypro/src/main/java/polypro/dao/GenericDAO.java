package polypro.dao;

import java.util.List;

import polypro.mapper.RowMapper;

public interface GenericDAO<T> {
	@SuppressWarnings("hiding")
	<T> List<T> query(String sql, RowMapper<T> rowMapper, Object... parameters);
	void update(String sql, Object... parameters);
	String insert(String sql, Object... parameters);
	void delete(String sql, Object... parameters);
	int countDB(String sql);
}
