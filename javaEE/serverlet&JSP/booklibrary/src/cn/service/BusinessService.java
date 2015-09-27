package cn.service;

import java.util.List;

import cn.domain.Book;
import cn.domain.Category;
import cn.domain.PageBean;
import cn.domain.QueryInfo;

public interface BusinessService {
	void addCategory(Category c);
	void deleteCategory(int id);
	void updateCategory(Category c);
	List<Category> getAllCategories();
	void addBook(Book b);
	void deleteBook(int id);
	void updateBook(Book b);
	List<Book> getBooks();
	List<Book> findBook(String name);
	Book findBookById(int id);
	public void updateCategory(int bid, String[] c);
	PageBean<Book> queryBook(QueryInfo qi);
}
