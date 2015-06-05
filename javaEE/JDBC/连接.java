import java.sql.*;

public class TestJDBC {
	public static void main(String[] args) {
		// new oracle.jdbc.driver.OracleDriver();
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver"); // 实例化时自动向DriverManager注册

			conn = DriverManager.getConnection(
					"jdbc:oracle:thin:@localhost:1521:orcl", "scott", "tiger");
			// 阿西吧。终于试成功了555或者是127.0.0.1
		
			stmt = conn.createStatement();
			//默认情况下类型为 TYPE_FORWARD_ONLY，并带有 CONCUR_READ_ONLY 并发级别。

			rs = stmt.executeQuery("select * from dept");  //类似于cursor
			while (rs.next()) {
				System.out.println(rs.getString("deptno"));
				System.out.println(rs.getInt("deptno"));
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (rs != null) {
					rs.close(); // 后打开先关
					rs = null;
				}
				if (stmt != null) {
					stmt.close();
					stmt = null;
				}
				if (conn != null) {
					conn.close();
					conn = null;
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
}