package com.demo;

import java.util.Date;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

@Entity
@Table(name="_person")
public class Person {
	private int id;
	private String name;
	private String title;
	private String lover;
	private Date date;
	@Id
	@GeneratedValue
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	@Basic
	public String getName() {
		return name;
	}                                         
	public void setName(String name) {        
		this.name = name;                     
	}                                         
	@Column(name="_title")                    
	public String getTitle() {                
		return title;                         
	}                                         
	public void setTitle(String title) {      
		this.title = title;                   
	}                                         
	
	@Transient
	public String getLover() {
		return lover;
	}
	public void setLover(String lover) {
		this.lover = lover;
	}
	
	@Temporal(TemporalType.DATE)
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
}
