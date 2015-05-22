import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;


public class TestTraction {

	public static void main(String[] args) {
		Connection conn = null;
		Statement stmt = null;
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","ws","ws");
			
			conn.setAutoCommit(false);
			stmt = conn.createStatement();
			  stmt.addBatch("insert into dept2 values(51,'xxx','haha')");
			  stmt.addBatch("insert into dept2 values(52,'xxx','haha')");
			  stmt.addBatch("insert into dept2 values(53,'xxx','haha')");
			stmt.executeBatch();
			conn.commit();
			conn.setAutoCommit(true);
		} catch (Exception e) {
			
			e.printStackTrace();
			
			try {
				if (conn != null) {
					conn.rollback();
				conn.setAutoCommit(true);
				}
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		} finally {
			try {
				stmt.close();
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
}





