package cn.domain;

import java.util.Date;
import java.util.List;

public class Book {
	
	private int id;
	private String name;
	private String description;
	private String author;
	private Date pdate;
	private List<Category> categories;
	private String publisher;
	
	public Book() {}
	public Book(String name, String description, String author,
			Date pdate, String publisher) {
		super();
		this.name = name;
		this.description = description;
		this.author = author;
		this.pdate = pdate;
		this.publisher = publisher;
	}
	public Book(String name, String description, String author,
			Date date) {
		this.name = name;
		this.description = description;
		this.author = author;
		this.pdate = date;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public List<Category> getCategories() {
		return categories;
	}
	public void setCategories(List<Category> categories) {
		this.categories = categories;
	}
	
	@Override
	public String toString() {
		return "Book [id=" + id + ", name=" + name + ", description="
				+ description + ", author=" + author + ", date=" + pdate
				+ ", categories=" + categories + "]";
	}
	public Date getPdate() {
		return pdate;
	}
	public void setPdate(Date pdate) {
		this.pdate = pdate;
	}
	public String getPublisher() {
		return publisher;
	}
	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}
}
