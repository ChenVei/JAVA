package cn.utils;

import java.lang.reflect.Field;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.util.ArrayList;
import java.util.List;

public class BeanListHandler<T> implements ResultSetHandler {

	private Class<T> clazz = null;
	private List<T> list = new ArrayList<T>();

	public BeanListHandler(Class<T> clazz) {
		this.clazz = clazz;
	}

	@Override
	public Object handler(ResultSet rs) {
		try {
			T bean = null;
			ResultSetMetaData meta = rs.getMetaData();
			int cnt = meta.getColumnCount();
			while (rs.next()) {
				bean = clazz.newInstance();
				for (int i = 0; i < cnt; i++) {
					String name = meta.getColumnName(i + 1);
					Object value = rs.getObject(name);
					Field f = clazz.getDeclaredField(name);
					f.setAccessible(true);
					f.set(bean, value);
				}
				list.add(bean);
			}

			return list;
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

}
