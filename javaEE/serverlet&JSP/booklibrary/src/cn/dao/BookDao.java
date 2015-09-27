package cn.dao;

import java.util.List;

import cn.domain.Book;
import cn.domain.Category;
import cn.domain.QueryInfo;
import cn.domain.QueryResult;

public interface BookDao {
	
	int add(Book b);
	void delete(int id);
	void update(Book b);
	void updateCategory(int bid, String[] c);
	Book find(int id);
	List<Book> find(String name);
	@Deprecated
	List<Book> getAll();
	public QueryResult<Book> query(QueryInfo qi);
}
