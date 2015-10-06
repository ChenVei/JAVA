package com.bjsxt.shopping.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.bjsxt.shopping.Cart;
import com.bjsxt.shopping.CartItem;
import com.bjsxt.shopping.Category;
import com.bjsxt.shopping.Product;
import com.bjsxt.shopping.SalesItem;
import com.bjsxt.shopping.SalesOrder;
import com.bjsxt.shopping.User;
import com.bjsxt.shopping.util.DB;

public class OrderMYSQLDAO {

	public void saveOrder(SalesOrder so) {
		Connection conn = DB.getConn();
		ResultSet rs = null;
		String sql = "insert into salesorder values (null,?,?,?,?)";
				 
		PreparedStatement pstmt = DB.getPStmt(conn, sql, true);
		try {
			conn.setAutoCommit(false);
			pstmt.setInt(1, so.getUser().getId());
			pstmt.setString(2, so.getAddr());
			pstmt.setTimestamp(3, so.getoDate());
			pstmt.setInt(4, so.getStatus());

			pstmt.executeUpdate();
			rs = pstmt.getGeneratedKeys();
			rs.next();
			int id = rs.getInt(1);
			
			Cart c = so.getCart();
			List<CartItem> items = c.getItems();
			sql = "insert into salesitem values (null, ?, ?, ?, ?)";
			pstmt = DB.getPStmt(conn, sql);
			
			for (Iterator<CartItem> it = items.iterator(); it.hasNext();) {
				CartItem ci = it.next();
				pstmt.setInt(1, ci.getProductId());
				pstmt.setDouble(2, ci.getPrice());
				pstmt.setInt(3, ci.getCount());
				pstmt.setInt(4, id);
				pstmt.addBatch();
			}
			
			pstmt.executeBatch();
			conn.commit();
		} catch (SQLException e) {
			e.printStackTrace();
			try {
				conn.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		} finally {
			DB.closeRs(rs);
			DB.closeStmt(pstmt);
			DB.closeConn(conn);
		}
	}

	public int getOrders(List<SalesOrder> orders, int pageNo, int pageSize) {
		Connection conn = DB.getConn();
		ResultSet rs = null;
		int cnt = 0;
		String sql = "select * from salesorder so "
				+ "left join ruser u on so.userid=u.id order by so.id limit " + (pageNo - 1)
				* pageSize + "," + pageSize;
		try {
			rs = DB.executeQuery(conn, sql);
			while (rs.next()) {
				User u = new User();
				u.setId(rs.getInt("so.userid"));
				u.setUsername(rs.getString("username"));
				u.setPassword(rs.getString("password"));
				u.setPhone(rs.getString("phone"));
				u.setAddr(rs.getString("u.addr"));
				u.setRdate(rs.getTimestamp("rdate"));
				
				SalesOrder so = new SalesOrder();
				so.setId(rs.getInt("so.id"));
				so.setUser(u);
				so.setAddr(rs.getString("so.addr"));
				so.setoDate(rs.getTimestamp("odate"));
				so.setStatus(rs.getInt("status"));
				
				orders.add(so);
			}

			sql = "select * from salesorder so join ruser u on so.userid=u.id";
			rs = DB.executeQuery(conn, sql);
			rs.next();
			cnt = rs.getInt(1);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DB.closeRs(rs);
			DB.closeConn(conn);
		}
		return cnt;
	}

	public SalesOrder loadById(int id) {
		SalesOrder so = null;
		Connection conn = DB.getConn();
		ResultSet rs = null;
		String sql = "select * from salesorder so join ruser u on so.userid=u.id where so.id="+id;
		try {
			rs = DB.executeQuery(conn, sql);
			rs.next();
				User u = new User();
				u.setId(rs.getInt("u.id"));
				u.setUsername(rs.getString("username"));
				u.setPassword(rs.getString("password"));
				u.setPhone(rs.getString("phone"));
				u.setAddr(rs.getString("u.addr"));
				u.setRdate(rs.getTimestamp("rdate"));
				
				so = new SalesOrder();
				so.setId(rs.getInt("so.id"));
				so.setUser(u);
				so.setAddr(rs.getString("so.addr"));
				so.setoDate(rs.getTimestamp("odate"));
				so.setStatus(rs.getInt("status"));

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DB.closeRs(rs);
			DB.closeConn(conn);
		}
		return so;
	}

	public List<SalesItem> getItems(SalesOrder salesOrder) {
		int id = salesOrder.getId();
		List<SalesItem> items = new ArrayList<SalesItem>();
		
		Connection conn = DB.getConn();
		ResultSet rs = null;
		String sql = "select * from salesitem s"
				+ " join product p on s.productid=p.id"
				+ " where orderid="+id;
		
		try {
			rs = DB.executeQuery(conn, sql);
			while (rs.next()) {
				SalesItem si = new SalesItem();
				Product p = new Product();

				p.setId(rs.getInt("p.id"));
				p.setName(rs.getString("p.name"));
				p.setDescr(rs.getString("p.descr"));
				p.setNormalprice(rs.getDouble("p.normalprice"));
				p.setMemberprice(rs.getDouble("p.memberprice"));
				p.setPdate(rs.getTimestamp("p.pdate"));
				p.setCategoryid(rs.getInt("p.categoryid"));
				
				si.setId(rs.getInt("s.id"));
				si.setProduct(p);
				si.setUnitprice(rs.getInt("unitprice"));
				si.setCount(rs.getInt("pcount"));
				si.setOrder(salesOrder);
				
				items.add(si);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DB.closeRs(rs);
			DB.closeConn(conn);
		}
		return items;
	}

	public void updateStatus(SalesOrder salesOrder) {
		Connection conn = DB.getConn();
		ResultSet rs = null;
		String sql = "update salesorder set status="+salesOrder.getStatus()+" where id="+salesOrder.getId();
		DB.executeUpdate(conn, sql);

		DB.closeRs(rs);
		DB.closeConn(conn);
	}

}
