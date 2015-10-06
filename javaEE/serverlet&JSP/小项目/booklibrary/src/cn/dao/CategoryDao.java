package cn.dao;

import java.util.List;

import cn.domain.Category;

public interface CategoryDao {
	void add(Category c);
	void delete(int id);
	void update(Category c);
	List<Category> getAll();
}
