package com.bjsxt.shopping.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.bjsxt.shopping.Category;
import com.bjsxt.shopping.Product;
import com.bjsxt.shopping.util.DB;

public class ProductMYSQLDao implements ProductDao {
	public List<Product> getProducts() {
		List<Product> products = new ArrayList<Product>();
		Connection conn = DB.getConn();
		String sql = "Select * from product";
		ResultSet rs = DB.executeQuery(conn, sql);
		try {
			while (rs.next()) {
				Product p = new Product();

				p.setId(rs.getInt("id"));
				p.setName(rs.getString("name"));
				p.setDescr(rs.getString("descr"));
				p.setNormalprice(rs.getDouble("normalprice"));
				p.setMemberprice(rs.getDouble("memberprice"));
				p.setPdate(rs.getTimestamp("pdate"));
				p.setCategoryid(rs.getInt("categoryid"));

				products.add(p);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DB.closeRs(rs);
			DB.closeConn(conn);
		}
		return products;
	}

	public List<Product> getprProducts(int pageNo, int pageSize) {
		List<Product> products = new ArrayList<Product>();
		Connection conn = DB.getConn();
		ResultSet rs = null;
		String sql = "select * from product limit " + (pageNo - 1) * pageSize
				+ "," + pageSize;
		try {
			rs = DB.executeQuery(conn, sql);
			while (rs.next()) {
				Product p = new Product();

				p.setId(rs.getInt("id"));
				p.setName(rs.getString("name"));
				p.setDescr(rs.getString("descr"));
				p.setNormalprice(rs.getDouble("normalprice"));
				p.setMemberprice(rs.getDouble("memberprice"));
				p.setPdate(rs.getTimestamp("pdate"));
				p.setCategoryid(rs.getInt("categoryid"));

				products.add(p);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return products;
	}

	@Override
	public int getProducts(List<Product> products, int pageNo, int pageSize) {
		Connection conn = DB.getConn();
		ResultSet rs = null;
		int cnt = 0;
		String sql = "select * from product p"
				+ " join category c on p.categoryid=c.id order by p.id limit " + (pageNo - 1)
				* pageSize + "," + pageSize;
		System.out.println(sql);
		// String sql =
		// "select * from product limit "+(pageNo-1)*pageSize+","+pageSize;
		try {
			rs = DB.executeQuery(conn, sql);
			while (rs.next()) {
				Product p = new Product();

				p.setId(rs.getInt("p.id"));
				p.setName(rs.getString("p.name"));
				p.setDescr(rs.getString("p.descr"));
				p.setNormalprice(rs.getDouble("p.normalprice"));
				p.setMemberprice(rs.getDouble("p.memberprice"));
				p.setPdate(rs.getTimestamp("p.pdate"));
				p.setCategoryid(rs.getInt("p.categoryid"));
				
				Category c = new Category();
				c.setId(rs.getInt("c.id"));
				c.setName(rs.getString("c.name"));
				c.setDescr(rs.getString("c.descr"));
				c.setPid(rs.getInt("c.pid"));
				c.setLeaf(rs.getInt("c.isleaf") == 0 ? true : false);
				c.setGrade(rs.getInt("c.grade"));
				p.setCategory(c);
				
				products.add(p);
			}

			sql = "select count(*) from product";
			rs = DB.executeQuery(conn, sql);
			rs.next();
			cnt = rs.getInt(1);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return cnt;
	}

	public int findProducts(List<Product> products, int[] categoryId,
			String keyWord, double lowNormalPrice, double highNormalPrice,
			double lowMemberPrice, double highMemberPrice, Date startDate,
			Date endDate, int pageNo, int pageSize) {
		int cnt = 0;
		Connection conn = DB.getConn();
		ResultSet rs = null;
		String sql = "select * from product where 1=1 ";

		String str = "and categoryid in (";
		for (int i = 0; i < categoryId.length - 1; i++) {
			str += categoryId[i] + ",";
		}
		str += categoryId[categoryId.length - 1] + ") ";
		sql += str;

		if (keyWord != null && keyWord != "") {
			sql += "and (name like '%" + keyWord + "%' or descr like '%"
					+ keyWord + "%')";
		}

		if (lowNormalPrice != -1 && highNormalPrice != -1) {
			sql += " and normalprice between " + lowNormalPrice + " and "
					+ highNormalPrice;
		}

		if (lowMemberPrice != -1 && highMemberPrice != -1) {
			sql += " and memberprice between " + lowMemberPrice + " and "
					+ highMemberPrice;
		}

		/*
		 * if (startDate != null) { sql += " and pdate >= '"+ new
		 * SimpleDateFormat("yyyy-MM-dd").format(startDate) + "'"; } if (endDate
		 * != null) { sql += " and pdate <= '"+ new
		 * SimpleDateFormat("yyyy-MM-dd").format(endDate) + "'"; }
		 */
		try {
			// count pages
			String cntSql = sql.replaceFirst("select \\*", "select count(*)");
			System.out.println(cntSql);
			rs = DB.executeQuery(conn, cntSql);
			rs.next();
			cnt = rs.getInt(1);

			// divide pages
			sql += " limit " + (pageNo - 1) * pageSize + "," + pageSize;
			System.out.println(sql);
			rs = DB.executeQuery(conn, sql);

			while (rs.next()) {
				Product p = new Product();
				p.setId(rs.getInt("id"));
				p.setName(rs.getString("name"));
				p.setDescr(rs.getString("descr"));
				p.setNormalprice(rs.getDouble("normalprice"));
				p.setMemberprice(rs.getDouble("memberprice"));
				p.setPdate(rs.getTimestamp("pdate"));
				p.setCategoryid(rs.getInt("categoryid"));
				products.add(p);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DB.closeRs(rs);
			DB.closeConn(conn);
		}
		return (cnt + pageSize - 1) / pageSize;
	}

	public boolean deleteProductByCategoryId(int categoryId) {
		return false;
	}

	public boolean deleteProductByCategoryId(int[] idArray) {
		return false;
	}

	public boolean updateProduct(Product p) {
		Connection conn = DB.getConn();
		String sql = "update product set name=?, descr=?, normalprice=?, memberprice=?, categoryid=? where id=?";
		PreparedStatement pstmt = DB.getPStmt(conn, sql);
		try {
			pstmt.setString(1, p.getName());
			pstmt.setString(2, p.getDescr());
			pstmt.setDouble(3, p.getNormalprice());
			pstmt.setDouble(4, p.getMemberprice());
			pstmt.setInt(5, p.getCategoryid());
			pstmt.setInt(6, p.getId());

			return pstmt.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DB.closeStmt(pstmt);
			DB.closeConn(conn);
		}
		return false;
	}

	public boolean addProduct(Product p) {
		Connection conn = DB.getConn();

		String sql = "insert into product values (null, ?,?,?,?,?,?)";
		PreparedStatement pstmt = DB.getPStmt(conn, sql);
		try {
			pstmt.setString(1, p.getName());
			pstmt.setString(2, p.getDescr());
			pstmt.setDouble(3, p.getNormalprice());
			pstmt.setDouble(4, p.getMemberprice());
			pstmt.setTimestamp(5, p.getPdate());
			pstmt.setInt(6, p.getCategoryid());

			return pstmt.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DB.closeStmt(pstmt);
			DB.closeConn(conn);
		}
		return false;
	}

	@Override
	public int[] getCategoryIdArray() {
		Connection conn = DB.getConn();
		String sql = "select count(distinct categoryid) from product";
		ResultSet rs = DB.executeQuery(conn, sql);
		int[] idArray = null;
		try {
			rs.next();
			int cnt = rs.getInt(1);
			idArray = new int[cnt];
			sql = "select distinct categoryid from product";
			rs = DB.executeQuery(conn, sql);
			for (int i = 0; i < idArray.length; i++) {
				rs.next();
				idArray[i] = rs.getInt(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return idArray;
	}

	@Override
	public Product loadById(int id) {
		Connection conn = DB.getConn();
		ResultSet rs = null;
		Product p = null;
		try {
			conn = DB.getConn();
			String sql = "select * from product p "
					+ "join category c on p.categoryid=c.id where p.id =" + id +" order by p.id" ;

			rs = DB.executeQuery(conn, sql);
			if (rs.next()) {
				p = new Product();
				p.setId(rs.getInt("p.id"));
				p.setName(rs.getString("p.name"));
				p.setDescr(rs.getString("p.descr"));
				p.setNormalprice(rs.getDouble("normalprice"));
				p.setMemberprice(rs.getDouble("memberprice"));
				p.setPdate(rs.getTimestamp("p.pdate"));
				p.setCategoryid(rs.getInt("categoryid"));
				
				Category c = new Category();
				c.setId(rs.getInt("c.id"));
				c.setName(rs.getString("c.name"));
				c.setDescr(rs.getString("c.descr"));
				c.setPid(rs.getInt("pid"));
				c.setLeaf(rs.getInt("isleaf") == 0 ? true : false);
				c.setGrade(rs.getInt("grade"));
				p.setCategory(c);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DB.closeRs(rs);
			DB.closeConn(conn);
		}
		return p;
	}

	@Override
	public List<Product> getLatestProducts(int count) {
		List<Product> products = new ArrayList<Product>();
		Connection conn = DB.getConn();
		String sql = "Select * from product order by pdate desc limit 0,"+count;
		ResultSet rs = DB.executeQuery(conn, sql);
		try {
			while (rs.next()) {
				Product p = new Product();

				p.setId(rs.getInt("id"));
				p.setName(rs.getString("name"));
				p.setDescr(rs.getString("descr"));
				p.setNormalprice(rs.getDouble("normalprice"));
				p.setMemberprice(rs.getDouble("memberprice"));
				p.setPdate(rs.getTimestamp("pdate"));
				p.setCategoryid(rs.getInt("categoryid"));

				products.add(p);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DB.closeRs(rs);
			DB.closeConn(conn);
		}
		return products;
	}

}
