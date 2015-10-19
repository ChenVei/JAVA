package cn.service;

import java.util.List;

import cn.domain.Book;
import cn.domain.Category;
import cn.domain.News;
import cn.domain.PageBean;
import cn.domain.QueryInfo;
import cn.domain.User;

public interface BusinessService {

	/**************************************
	 * Category
	 ***************************************/
	void addCategory(Category c);

	void deleteCategory(int id);

	void updateCategory(Category c);

	List<Category> getAllCategories();

	/**************************************
	 * Book
	 ***************************************/
	void addBook(Book b);

	void deleteBook(int id);

	void updateBook(Book b);

	List<Book> findBook(String name);

	Book findBookById(int id);

	List<Book> getBooks();

	void updateCategory(int bid, String[] c);

	PageBean<Book> queryBook(QueryInfo qi);

	PageBean<Book> querySpecficBook(QueryInfo qi);

	/**************************************
	 * User
	 ***************************************/
	void addUser(User u);

	void deleteUser(int id);

	void updateUser(User u);

	User find(int id);

	User find(String username, String password);

	void delete(int id);

	void update(User u);

	List<User> getAllUsers();

	/**************************************
	 * News
	 ***************************************/
	int addNews(News n);

	void deleteNews(int id);

	void updateNews(News n);

	News findNews(int id);

	List<News> getAllNews();

}