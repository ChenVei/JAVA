package cn.dao.impl;

import java.util.List;

import cn.dao.BookDao;
import cn.domain.Book;
import cn.domain.Category;
import cn.domain.QueryInfo;
import cn.domain.QueryResult;
import cn.utils.BeanHandler;
import cn.utils.BeanListHandler;
import cn.utils.JdbcUtils;

public class BookDaoImpl implements BookDao {
	
	@Override
	public int add(Book b) {
		String sql = "insert into book(name,description,author,pdate) values(?,?,?,?)";
		Object[] params = { b.getName(), b.getDescription(), b.getAuthor(),
				b.getPdate() };
		int bid = JdbcUtils.update(sql, params);

		for (Category c : b.getCategories()) {
			sql = "insert into category_book(cid,bid) values(?,?)";
			params = new Object[] { c.getId(), bid };
			JdbcUtils.update(sql, params);
		}
		return bid;
	}
	
	public int add(Book b, String[] ids) {
		String sql = "insert into book(name,description,author,pdate) values(?,?,?,?)";
		Object[] params = { b.getName(), b.getDescription(), b.getAuthor(),
				b.getPdate() };
		int bid = JdbcUtils.update(sql, params);
		
		for (String cid: ids) {
			sql = "insert into category_book(cid,bid) values(?,?)";
			params = new Object[] { cid, bid };
			JdbcUtils.update(sql, params);
		}
		return bid;
	}

	@Override
	public void delete(int id) {
		String sql = "delete from category_book where bid = ?";
		Object[] params = { id };
		JdbcUtils.update(sql, params);

		sql = "delete from book where id = ?";
		params = new Object[] { id };
		JdbcUtils.update(sql, params);
	}

	@Override
	public void update(Book b) {
		String sql = "update book set name=?,description=?,author=?,pdate=? where id=?";
		Object[] params = { b.getName(), b.getDescription(), b.getAuthor(),
				b.getPdate(), b.getId() };
		JdbcUtils.update(sql, params);
	}

	@Override
	public void updateCategory(int bid, String[] c) {
		String sql = "delete from category_book where bid = ?";
		JdbcUtils.update(sql, new Object[] { bid });

		for (int i = 0; i < c.length; i++) {
			sql = "insert into category_book(cid,bid) values(?,?)";
			Object[] params = { c[i], bid };
			JdbcUtils.update(sql, params);
		}
	}

	@Override
	public Book find(int id) {
		String sql = "select * from book where id = ?";
		Object[] params = {id};
		Book book = (Book) JdbcUtils.find(sql, params, new BeanHandler<Book>(Book.class));
		
		sql = "select c.* from category_book cb, category c where cb.bid=? and c.id=cb.cid";
		params = new Object[]{book.getId()};
		List<Category> list = (List<Category>) JdbcUtils.find(sql, params, new BeanListHandler<Category>(Category.class));
		book.setCategories(list);
		return book;
	}

	@Override
	public List<Book> getAll() {
		String sql = "select * from book";
		Object[] params = {};
		List<Book> books = (List<Book>) JdbcUtils.find(sql, params, new BeanListHandler<Book>(Book.class));
		for (Book book : books) {
			sql = "select c.* from category_book cb, category c where cb.bid=? and c.id=cb.cid";
			params = new Object[]{book.getId()};
			List<Category> list = (List<Category>) JdbcUtils.find(sql, params, new BeanListHandler<Category>(Category.class));
			book.setCategories(list);
		}
		return books;
	}
	
	@Override
	public List<Book> find(String name) {
		String sql = "select * from book where name like ? or author like ? or description like ?";
		Object[] params = {'%'+name+'%', '%'+name+'%', '%'+name+'%'};
		List<Book> books = (List<Book>) JdbcUtils.find(sql, params, new BeanListHandler<Book>(Book.class));
		for (Book book : books) {
			sql = "select c.* from category_book cb, category c where cb.bid=? and c.id=cb.cid";
			params = new Object[]{book.getId()};
			List<Category> list = (List<Category>) JdbcUtils.find(sql, params, new BeanListHandler<Category>(Category.class));
			book.setCategories(list);
		}
		return books;
	}

	@Override
	public QueryResult<Book> query(QueryInfo qi) {
		
		QueryResult<Book> qr = new QueryResult<Book>();
		String sql = "select * from book limit ?,?";
		Object[] params = {qi.getStartindex(), qi.getPagesize()};
		
		List<Book> books = (List<Book>) JdbcUtils.find(sql, params, new BeanListHandler<Book>(Book.class));
		for (Book book : books) {
			sql = "select c.* from category_book cb, category c where cb.bid=? and c.id=cb.cid";
			params = new Object[]{book.getId()};
			List<Category> list = (List<Category>) JdbcUtils.find(sql, params, new BeanListHandler<Category>(Category.class));
			book.setCategories(list);
		}
		sql = "select count(*) from book";
		int totalrecord = JdbcUtils.getTotalRecords(sql);
		qr.setList(books);
		qr.setTotalrecord(totalrecord);
		
		return qr;
	}
	
	public QueryResult<Book> querySpecific(QueryInfo qi) {
		String name = qi.getQueryString();
		QueryResult<Book> qr = new QueryResult<Book>();
		String sql = "select * from book where name like ? or author like ? or description like ? limit ?,?";
		Object[] params = {'%'+name+'%', '%'+name+'%', '%'+name+'%', qi.getStartindex(), qi.getPagesize()};
		List<Book> books = (List<Book>) JdbcUtils.find(sql, params, new BeanListHandler<Book>(Book.class));
		for (Book book : books) {
			sql = "select c.* from category_book cb, category c where cb.bid=? and c.id=cb.cid";
			params = new Object[]{book.getId()};
			List<Category> list = (List<Category>) JdbcUtils.find(sql, params, new BeanListHandler<Category>(Category.class));
			book.setCategories(list);
		}
		sql = "select count(*) from book where name like ? or author like ? or description like ?";
		params = new Object[]{'%'+name+'%', '%'+name+'%', '%'+name+'%'};
		int totalrecord = JdbcUtils.getTotalRecords(sql, params);
		
		qr.setList(books);
		qr.setTotalrecord(totalrecord);
		return qr;
	}
	
}
