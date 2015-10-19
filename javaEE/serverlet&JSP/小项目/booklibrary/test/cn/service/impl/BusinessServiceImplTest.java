package cn.service.impl;


import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.junit.Test;

import cn.dao.BookDao;
import cn.dao.impl.BookDaoImpl;
import cn.domain.Book;
import cn.domain.Category;
import cn.domain.User;
import cn.service.BusinessService;

public class BusinessServiceImplTest {
	BusinessService bs = new BusinessServiceImpl();
	
	@Test
	public void testGetBooks() {
		BookDao bd = new BookDaoImpl();
		System.out.println(bd.getAll());
	}
	@Test
	public void testFindBook() {
		BookDao bd = new BookDaoImpl();
		System.out.println(bd.find(2));
	}
	@Test
	public void testAddBook() {
		/*for (int i = 0; i < 40; i++) {
			BusinessService bs = new BusinessServiceImpl();
			Book b = new Book("Who"+i, "cool"+i, "WS"+i, new Date());
			List<Category> list = bs.getAllCategories();
			b.setCategories(list);
			bs.addBook(b);
		}*/
		Book b = new Book("zzzz", "cool", "WS", new Date(), "清华大学出版社");
		List<Category> list = bs.getAllCategories();
		b.setCategories(list);
		bs.addBook(b);
	}
	
	@Test
	public void testDelBook() {
		BusinessService bs = new BusinessServiceImpl();
		bs.deleteBook(1);
	}
	
	@Test
	public void testUpdateCategoryBook() {
		BookDao bd = new BookDaoImpl();
		bd.updateCategory(2, new String[]{"1","8","9"});
	}
	
	@Test
	public void testUpdateBook() {
		BusinessService bs = new BusinessServiceImpl();
		Calendar c = Calendar.getInstance();
		c.set(1995, 6, 20);
		Book b = new Book("You", "hot", "HQ", c.getTime());
		b.setId(2);
		bs.updateBook(b);
	}
	
	@Test
	public void testAddCategory() {
		
		Category c = new Category("职场");
		bs.addCategory(c);
	}

	@Test
	public void testDeleteCategory() {
		bs.deleteCategory(2);
	}

	@Test
	public void testUpdateCategory() {
		Category c = new Category("WUha");
		c.setId(1);
		bs.updateCategory(c);
	}

	@Test
	public void testGetAllCategories() {
		List<Category> list = bs.getAllCategories();
	}
	
	@Test
	public void testAddUser() {
		for (int i = 2; i < 8; i++) {
			User u = new User(0, "test"+i, "123123", "aa@ss.com"+i, false);
			bs.addUser(u);
		}
	}
	
}
