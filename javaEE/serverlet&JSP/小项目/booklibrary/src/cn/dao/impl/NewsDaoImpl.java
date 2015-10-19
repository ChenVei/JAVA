package cn.dao.impl;

import java.util.List;

import cn.domain.Book;
import cn.domain.Category;
import cn.domain.News;
import cn.utils.BeanHandler;
import cn.utils.BeanListHandler;
import cn.utils.JdbcUtils;

public class NewsDaoImpl {
	
	public int add(News n) {
		String sql = "insert into news(title,content,pdate) values(?,?,?)";
		Object[] params = {n.getTitle(), n.getContent(), n.getPdate() };
		int nid = JdbcUtils.update(sql, params);
		return nid;
	}
	
	public void delete(int id) {
		String sql = "delete from news where id = ?";
		Object[] params = { id };
		JdbcUtils.update(sql, params);
	}
	
	public void update(News n) {
		String sql = "update news set title=?,content=?,pdate=? where id=?";
		Object[] params = { n.getTitle(), n.getContent(), n.getPdate(), n.getId()};
		JdbcUtils.update(sql, params);
	}
	
	public News find(int id) {
		String sql = "select * from news where id = ?";
		Object[] params = {id};
		return (News) JdbcUtils.find(sql, params, new BeanHandler<News>(News.class));
	}
	
	public List<News> getAll() {
		String sql = "select * from news";
		Object[] params = {};
		return (List<News>) JdbcUtils.find(sql, params, new BeanListHandler<News>(News.class));
	}
}
