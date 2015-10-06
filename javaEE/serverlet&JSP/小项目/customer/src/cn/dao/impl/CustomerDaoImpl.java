package cn.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import cn.dao.CustomerDao;
import cn.domain.Customer;
import cn.domain.QueryResult;
import cn.exception.DaoException;
import cn.utils.JdbcUtils;

public class CustomerDaoImpl implements CustomerDao {

	@Override
	public void add(Customer c) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			conn = JdbcUtils.getConnection();
			String sql = "insert into customer values(?,?,?,?,?,?,?,?,?)";
			pstmt = conn.prepareStatement(sql);

			pstmt.setString(1, c.getId());
			pstmt.setString(2, c.getName());
			pstmt.setString(3, c.getGender());
			if (c.getBirthday() != null) {
				pstmt.setDate(4, new java.sql.Date(c.getBirthday().getTime()));
			}else {
				pstmt.setDate(4, null);
			}
			pstmt.setString(5, c.getCellphone());
			pstmt.setString(6, c.getEmail());
			pstmt.setString(7, c.getPreference());
			pstmt.setString(8, c.getType());
			pstmt.setString(9, c.getDescription());

			pstmt.executeUpdate();
		} catch (SQLException e) {
			throw new DaoException();
		} finally {
			JdbcUtils.release(conn, pstmt, rs);
		}

	}

	@Override
	public void remove(String id) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			conn = JdbcUtils.getConnection();
			String sql = "delete from customer where id = ?";
			pstmt = conn.prepareStatement(sql);

			pstmt.setString(1, id);
			pstmt.executeUpdate();
		} catch (SQLException e) {
			throw new DaoException();
		} finally {
			JdbcUtils.release(conn, pstmt, rs);
		}
	}

	@Override
	public void update(Customer c) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			conn = JdbcUtils.getConnection();
			String sql = "update customer set id=?,name=?,gender=?,birthday=?,cellphone=?,email=?,preference=?,type=?,description=? where id =?";
			pstmt = conn.prepareStatement(sql);

			pstmt.setString(1, c.getId());
			pstmt.setString(2, c.getName());
			pstmt.setString(3, c.getGender());
			pstmt.setDate(4, new java.sql.Date(c.getBirthday().getTime()));
			pstmt.setString(5, c.getCellphone());
			pstmt.setString(6, c.getEmail());
			pstmt.setString(7, c.getPreference());
			pstmt.setString(8, c.getType());
			pstmt.setString(9, c.getDescription());
			pstmt.setString(10, c.getId());

			pstmt.executeUpdate();
		} catch (SQLException e) {
			throw new DaoException(e);
		} finally {
			JdbcUtils.release(conn, pstmt, rs);
		}

	}

	@Override
	public Customer find(String id) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		Customer c = null;
		try {
			conn = JdbcUtils.getConnection();
			String sql = "select * from customer where id = ?";
			pstmt = conn.prepareStatement(sql);

			pstmt.setString(1, id);
			rs = pstmt.executeQuery();

			if (rs.next()) {
				c = new Customer();
				c.setId(rs.getString("id"));
				c.setName(rs.getString("name"));
				c.setGender(rs.getString("gender"));
				c.setBirthday(rs.getDate("birthday"));
				c.setCellphone(rs.getString("cellphone"));
				c.setEmail(rs.getString("email"));
				c.setPreference(rs.getString("preference"));
				c.setType(rs.getString("type"));
				c.setDescription(rs.getString("description"));
			}
		} catch (SQLException e) {
			throw new DaoException();
		} finally {
			JdbcUtils.release(conn, pstmt, rs);
		}
		return c;
	}

	@Override
	public List<Customer> getAll() {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List<Customer> list = new ArrayList<Customer>();

		try {
			conn = JdbcUtils.getConnection();
			String sql = "select * from customer";
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				Customer c = new Customer();
				c.setId(rs.getString("id"));
				c.setName(rs.getString("name"));
				c.setGender(rs.getString("gender"));
				c.setBirthday(rs.getDate("birthday"));
				c.setCellphone(rs.getString("cellphone"));
				c.setEmail(rs.getString("email"));
				c.setPreference(rs.getString("preference"));
				c.setType(rs.getString("type"));
				c.setDescription(rs.getString("description"));

				list.add(c);
			}
		} catch (SQLException e) {
			throw new DaoException();
		} finally {
			JdbcUtils.release(conn, pstmt, rs);
		}
		return list;
	}
	
	public QueryResult pageQuery(int startindex, int pagesize) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		QueryResult qr = new QueryResult();
		List<Customer> list = new ArrayList<Customer>();
		try {
			conn = JdbcUtils.getConnection();
			String sql = "select * from customer limit ?, ?";
			pstmt = conn.prepareStatement(sql);

			pstmt.setInt(1, startindex);
			pstmt.setInt(2, pagesize);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				Customer c = new Customer();
				c = new Customer();
				c.setId(rs.getString("id"));
				c.setName(rs.getString("name"));
				c.setGender(rs.getString("gender"));
				c.setBirthday(rs.getDate("birthday"));
				c.setCellphone(rs.getString("cellphone"));
				c.setEmail(rs.getString("email"));
				c.setPreference(rs.getString("preference"));
				c.setType(rs.getString("type"));
				c.setDescription(rs.getString("description"));
				list.add(c);
			}
			qr.setList(list);
			
			rs.close();
			sql = "select count(*) from customer";
			rs = pstmt.executeQuery(sql);
			if (rs.next()) {
				qr.setTotalrecord(rs.getInt(1));
			}
			
			return qr;
		} catch (SQLException e) {
			throw new DaoException(e);
		} finally {
			JdbcUtils.release(conn, pstmt, rs);
		}
	}
}
