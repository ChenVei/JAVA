package cn.domain;

public class QueryInfo {
	private int currentpage = 1;
	private int pagesize = 5;
	private int startindex;
	private String queryString;
	
	public int getCurrentpage() {
		return currentpage;
	}
	public void setCurrentpage(int currentpage) {
		this.currentpage = currentpage;
	}
	public int getPagesize() {
		return pagesize;
	}
	public void setPagesize(int pagesize) {
		this.pagesize = pagesize;
	}
	public int getStartindex() {
		startindex = (currentpage - 1) * pagesize; 
		return startindex;
	}
	
	public String getQueryString() {
		return queryString;
	}
	public void setQueryString(String queryString) {
		this.queryString = queryString;
	}
}
