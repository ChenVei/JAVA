package cn.domain;

import java.util.List;

public class QueryResult<T> {
	
	private List<T> list;
	private int totalrecord;
	
	public List<T> getList() {
		return list;
	}
	public void setList(List<T> list) {
		this.list = list;
	}
	public int getTotalrecord() {
		return totalrecord;
	}
	public void setTotalrecord(int totalrecord) {
		this.totalrecord = totalrecord;
	}
}
