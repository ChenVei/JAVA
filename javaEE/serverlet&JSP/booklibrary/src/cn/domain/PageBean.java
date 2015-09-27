package cn.domain;

import java.util.List;

public class PageBean<T> {

	private final int BAR_SIZE = 10;

	private List<T> list;

	private int pagesize;

	private int totalrecord;
	private int totalpage;

	private int currentpage;
	private int previouspage;
	private int nextpage;

	private int[] pagebar;

	public List<T> getList() {
		return list;
	}

	public void setList(List<T> list) {
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
		previouspage = currentpage - 1;
		if (previouspage < 1) {
			previouspage = 1;
		}
		return previouspage;
	}

	public int getNextpage() {
		nextpage = currentpage + 1;
		if (nextpage > totalpage) {
			nextpage = totalpage;
		}
		return nextpage;
	}

	public int[] getPagebar() {

		if (totalpage < BAR_SIZE) {
			pagebar = new int[totalpage];
			for (int i = 0; i < totalpage; i++) {
				pagebar[i] = i + 1;
			}
		} else {
			pagebar = new int[BAR_SIZE];
			int start = currentpage - BAR_SIZE / 2;
			start = (BAR_SIZE % 2 == 0) ? start + 1 : start;
			int end = currentpage + BAR_SIZE / 2;
			if (start < 1) {
				start = 1;
			} else if (end > totalpage) {
				start = totalpage - BAR_SIZE + 1;
			}
			for (int i = 0; i < BAR_SIZE; i++) {
				pagebar[i] = start + i;
			}
		}
		return pagebar;
	}

}
