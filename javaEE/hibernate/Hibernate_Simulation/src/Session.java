import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import com.model.Customer;


public class Session {
	String tableName = "_customer";
	Map<String, String> cfs = new HashMap<>();
	String[] methodNames;
	public Session() {
		cfs.put("_id", "id");
		cfs.put("_username", "username");
		cfs.put("_password", "password");
		methodNames = new String[cfs.size()];
	}
	
	public void save(Customer customer) {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/hibernate","root","ROOT");
			String sql = createSQL();
			PreparedStatement pstmt = conn.prepareStatement(sql);
			int ii = 1;
			
			for (String s : methodNames) {
				Method m = customer.getClass().getMethod(s);
				Class c = m.getReturnType();
				if (c.getName().equals("int")) {
					pstmt.setInt(ii++, (Integer)m.invoke(customer));
				}
				else if (c.getName().equals("java.lang.String")){
					pstmt.setString(ii++, (String)m.invoke(customer));
				}
				System.out.println(m.getName()+"|"+c.getName());
			}
			pstmt.executeUpdate();
			pstmt.close();
			conn.close();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (NoSuchMethodException e) {
			e.printStackTrace();
		} catch (SecurityException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		}
		
	}

	private String createSQL() {
		int index = 0;
		String str1, str2;
		str1 = "";
		for (String s : cfs.keySet()) {
			str1 += s+",";
			
			String v = cfs.get(s);
			methodNames[index++] = "get" + Character.toUpperCase(v.charAt(0)) + v.substring(1);
		}
		str1 = str1.substring(0, str1.length() - 1);
		
		str2 = "";
		for (int i = 0; i < cfs.size(); i++) {
			str2 += "?,";
		}
		str2 = str2.substring(0, str2.length() - 1);
		String sql = "insert into "+tableName+"("+str1+") values("+str2+")";
		System.out.println(sql);
		return sql;
	}


}
