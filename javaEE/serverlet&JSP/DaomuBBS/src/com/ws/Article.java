package com.ws;

import java.sql.ResultSet;
import java.sql.SQLException;

public class Article {
	private int id;
	private int pid;
	private int rootID;
	private String cont;
	private String pdate;
	private boolean leaf;

	int grade;
	
	public Article(ResultSet rs) {
		IniFromRs(rs);
	}
	
	public void IniFromRs(ResultSet rs) {
		try {
			if (rs == null) {
				return;
			}

			id = rs.getInt("id");
			pid = rs.getInt("pid");
			rootID = rs.getInt("rootID");
			cont = rs.getString("cont");
			pdate = rs.getString("pdate");
			leaf = rs.getInt("isleaf") == 1 ? true:false;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getPid() {
		return pid;
	}
	public void setPid(int pid) {
		this.pid = pid;
	}
	public int getRootID() {
		return rootID;
	}
	public void setRootID(int rootID) {
		this.rootID = rootID;
	}
	public String getCont() {
		return cont;
	}
	public void setCont(String cont) {
		this.cont = cont;
	}
	public String getPdate() {
		return pdate;
	}
	public void setPdate(String pdate) {
		this.pdate = pdate;
	}
	public int getGrade() {
		return grade;
	}
	public void setGrade(int grade) {
		this.grade = grade;
	}
	public boolean isLeaf() {
		return leaf;
	}
	public void setLeaf(boolean leaf) {
		this.leaf = leaf;
	}
}
