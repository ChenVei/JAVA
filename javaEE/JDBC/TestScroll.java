import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class TestScroll {

	public static void main(String[] args) {
		try {
			new oracle.jdbc.driver.OracleDriver();
			Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","ws","ws");
			Statement stmt = conn.createStatement(
					ResultSet.TYPE_SCROLL_INSENSITIVE,
					ResultSet.CONCUR_READ_ONLY);
			//resultSetType - 结果集类型，它是 ResultSet.TYPE_FORWARD_ONLY、ResultSet.TYPE_SCROLL_INSENSITIVE 或 ResultSet.TYPE_SCROLL_SENSITIVE 之一
			//resultSetConcurrency - 并发类型；它是 ResultSet.CONCUR_READ_ONLY 或 ResultSet.CONCUR_UPDATABLE 之一	


			ResultSet rs = stmt
					.executeQuery("select * from emp order by sal");
			rs.next(); //第一条记录
			System.out.println(rs.getInt(1));
			rs.last(); //最后一条
			System.out.println(rs.getString(1));
			System.out.println(rs.isLast());
			System.out.println(rs.isAfterLast());
			System.out.println(rs.getRow());
			rs.previous(); //倒数第二条
			System.out.println(rs.getString(1));
			rs.absolute(6); //直接定位第六条，绝对定位
			System.out.println(rs.getString(1));
			
			rs.close();
			stmt.close();
			conn.close();		
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
