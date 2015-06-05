import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class TestUpdateRs {

	public static void main(String[] args) {
		try {
			new oracle.jdbc.driver.OracleDriver();
			Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","ws","ws");
			Statement stmt = conn.createStatement(
					ResultSet.TYPE_SCROLL_INSENSITIVE,
					ResultSet.CONCUR_UPDATABLE);
			ResultSet rs = stmt.executeQuery("select * from emp2");
			
			rs.next();
			//更新一行数据
			rs.updateString("ename", "AAAA"); 
			rs.updateRow();  //插入到数据库
			
			//插入新行
			rs.moveToInsertRow();
			rs.updateInt(1, 9999);
			rs.updateString("ename", "AAaa");
			rs.updateInt("mgr", 4567);
			rs.updateDouble("sal", 99.99);
			rs.insertRow();
			
			//移动到新建行
			rs.moveToCurrentRow();
			
			//删除行
			rs.absolute(5);
			rs.deleteRow();
			
			rs.close();
			stmt.close();
			conn.close();	
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
//orcale不支持
//然而并没有什么卵用