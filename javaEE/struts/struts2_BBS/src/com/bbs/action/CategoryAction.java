package com.bbs.action;

import java.sql.SQLException;
import java.util.List;

import com.bbs.model.Category;
import com.bbs.service.CategoryService;
import com.opensymphony.xwork2.ActionSupport;

public class CategoryAction extends ActionSupport {
	private List<Category> categories;
	CategoryService cs = new CategoryService();
	private Category category;
	private int id;
	
	public String list() throws SQLException {
		categories = cs.list();
		return SUCCESS;
	}
	public String add() {
		cs.add(category);
		System.out.println(category.getName()+"****"+category.getDescription());
		return SUCCESS;
	}
	public String update() {
		cs.update(category);
		return SUCCESS;
	}
	public String delete() {
		cs.deleteById(id);
		return SUCCESS;
	}
	public String addInput() {
		return INPUT;
	}
	public String updateInput() {
		category = cs.loadById(id);
		return INPUT;
	}
	
	
	public List<Category> getCategories() {
		return categories;
	}
	public void setCategories(List<Category> categories) {
		this.categories = categories;
	}
	public CategoryService getCs() {
		return cs;
	}
	public void setCs(CategoryService cs) {
		this.cs = cs;
	}
	public Category getCategory() {
		return category;
	}
	public void setCategory(Category category) {
		this.category = category;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
}
