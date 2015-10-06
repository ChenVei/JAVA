package cn.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import cn.dao.CategoryDao;
import cn.domain.Book;
import cn.domain.Category;
import cn.domain.QueryInfo;
import cn.domain.QueryResult;
import cn.utils.BeanHandler;
import cn.utils.BeanListHandler;
import cn.utils.JdbcUtils;

public class CategoryDaoImpl implements CategoryDao {

	
	@Override
	public void add(Category c) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			conn = JdbcUtils.getConnection();
			String sql = "insert into category(name) values(?)";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, c.getName());
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JdbcUtils.release(conn, pstmt, rs);
		}
	}

	@Override
	public void delete(int id) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			conn = JdbcUtils.getConnection();
			String sql = "delete from category where id=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, id);
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JdbcUtils.release(conn, pstmt, rs);
		}
	}

	@Override
	public List<Category> getAll() {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List<Category> list = new ArrayList<Category>();
		try {
			conn = JdbcUtils.getConnection();
			String sql = "select * from category";
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				Category c = new Category();
				c.setId(rs.getInt("id"));
				c.setName(rs.getString("name"));
				c.setBooks(getBooks(c.getId()));
				list.add(c);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JdbcUtils.release(conn, pstmt, rs);
		}
		return list;
	}

	@Override
	public void update(Category c) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			conn = JdbcUtils.getConnection();
			String sql = "update category set name=? where id=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, c.getName());
			pstmt.setInt(2, c.getId());
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JdbcUtils.release(conn, pstmt, rs);
		}
	}
	
	public List<Book> getBooks(int cid) {
		String sql = "select b.* from category_book cb,book b where cb.bid=b.id and cid=?";
		Object[] params = {cid};
		return (List<Book>) JdbcUtils.find(sql, params, new BeanListHandler<Book>(Book.class));
	}
	
	public Category getCategory(String cid) {
		String sql = "select * from category where id=?";
		Object[] params = {cid};
		Category c = (Category) JdbcUtils.find(sql, params, new BeanHandler<Category>(Category.class));
		sql = "select b.* from category_book cb,book b where cb.bid=b.id and cid=?";
		c.setBooks((List<Book>) JdbcUtils.find(sql, params, new BeanListHandler<Book>(Book.class)));
		return c;
	}
	
	public QueryResult<Book> getBooksByCategory(QueryInfo qi,  String cid) {
		QueryResult<Book> qr = new QueryResult<Book>();
		String sql = "select b.* from category_book cb,book b where cb.bid=b.id and cid=? limit ?,?";
		Object[] params = {cid, qi.getStartindex(), qi.getPagesize()};
		List<Book> books = (List<Book>) JdbcUtils.find(sql, params, new BeanListHandler<Book>(Book.class));
		for (Book book : books) {
			sql = "select c.* from category_book cb, category c where cb.bid=? and c.id=cb.cid";
			params = new Object[]{book.getId()};
			List<Category> list = (List<Category>) JdbcUtils.find(sql, params, new BeanListHandler<Category>(Category.class));
			book.setCategories(list);
		}
		sql = "select count(*) from category_book cb,book b where cb.bid=b.id and cid=?";
		params = new Object[]{cid};
		int totalrecord = JdbcUtils.getTotalRecords(sql, params);
		
		qr.setList(books);
		qr.setTotalrecord(totalrecord);
		return qr;
	}
}
