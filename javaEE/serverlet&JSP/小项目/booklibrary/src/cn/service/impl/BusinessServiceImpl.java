package cn.service.impl;

import java.util.List;

import cn.dao.BookDao;
import cn.dao.CategoryDao;
import cn.dao.impl.BookDaoImpl;
import cn.dao.impl.CategoryDaoImpl;
import cn.domain.Book;
import cn.domain.Category;
import cn.domain.PageBean;
import cn.domain.QueryInfo;
import cn.domain.QueryResult;
import cn.service.BusinessService;

public class BusinessServiceImpl implements BusinessService {
	
	CategoryDao cdao = new CategoryDaoImpl();
	BookDao bdao = new BookDaoImpl();
	
	@Override
	public void addCategory(Category c) {
		cdao.add(c);
	}

	@Override
	public void deleteCategory(int id) {
		cdao.delete(id);
	}

	@Override
	public void updateCategory(Category c) {
		cdao.update(c);
	}

	@Override
	public List<Category> getAllCategories() {
		return cdao.getAll();
	}

	@Override
	public void addBook(Book b) {
		bdao.add(b);
	}

	@Override
	public void deleteBook(int id) {
		bdao.delete(id);
	}

	@Override
	public void updateBook(Book b) {
		bdao.update(b);
	}

	@Override
	public List<Book> findBook(String name) {
		return bdao.find(name);
	}
	
	@Override
	public Book findBookById(int id) {
		return bdao.find(id);
	}

	@Override
	public List<Book> getBooks() {
		return bdao.getAll();
	}

	@Override
	public void updateCategory(int bid, String[] c) {
		bdao.updateCategory(bid, c);
	}
	
	@Override
	public PageBean<Book> queryBook(QueryInfo qi) {
		PageBean<Book> pb = new PageBean<Book>();
		QueryResult<Book> qr = bdao.query(qi);
		pb.setPagesize(qi.getPagesize());
		pb.setCurrentpage(qi.getCurrentpage());
		pb.setList(qr.getList());
		pb.setTotalrecord(qr.getTotalrecord());
		return pb;
	}
	
	public PageBean<Book> querySpecficBook(QueryInfo qi) {
		PageBean<Book> pb = new PageBean<Book>();
		BookDaoImpl bdi = new BookDaoImpl();
		QueryResult<Book> qr = bdi.querySpecific(qi);
		
		pb.setPagesize(qi.getPagesize());
		pb.setCurrentpage(qi.getCurrentpage());
		pb.setList(qr.getList());
		pb.setTotalrecord(qr.getTotalrecord());
		return pb;
	}
	
}
