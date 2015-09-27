package cn.domain;

import java.util.List;

public class PageBean {
	
	private List<Customer> list;
	private int pagesize;
	private int totalrecord;
	private int totalpage;
	private int currentpage;
	private int previouspage;
	private int nextpage;
	private int[] pagebar;
	
	public List<Customer> getList() {
		return list;
	}
	public void setList(List<Customer> list) {
		this.list = list;
	}
	public int getPagesize() {
		return pagesize;
	}
	public void setPagesize(int pagesize) {
		this.pagesize = pagesize;
	}
	public int getTotalrecord() {
		return totalrecord;
	}
	public void setTotalrecord(int totalrecord) {
		this.totalrecord = totalrecord;
	}
	public int getTotalpage() {
		totalpage = (totalrecord + pagesize - 1) / pagesize;
		return totalpage;
	}
	public int getCurrentpage() {
		return currentpage;
	}
	public void setCurrentpage(int currentpage) {
		this.currentpage = currentpage;
	}
	public int getPreviouspage() {
		if (currentpage <= 1) {
			previouspage = 1;
		} else {
			previouspage = currentpage - 1;
		}
		return previouspage;
	}
	public int getNextpage() {
		if (currentpage >= totalpage) {
			nextpage = totalpage;
		} else {
			nextpage = currentpage + 1;
		}
		return nextpage;
	}
	public int[] getPagebar() {
		int start;
		int end;
		int[] a;
		if (totalpage < 10) {
			a = new int[totalpage];
			start = 1;
			end = totalpage;
		} else {
			a = new int[10];
			start = currentpage - 4;
			end = currentpage + 5;
			if (start < 1) {
				start = 1;
				end = 10;
			} else if (end > totalpage) {
				start = totalpage - 9;
				end = totalpage;
			}
		}
		for (int i = 0; i < a.length; i++) {
			a[i] = start + i;
		}
		return pagebar = a;
	}
	
}
