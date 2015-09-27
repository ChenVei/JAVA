package cn.utils;

import java.lang.reflect.Field;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;

public class BeanHandler<T> implements ResultSetHandler {
	Class<T> clazz = null;
	
	public BeanHandler(Class<T> clazz) {
		this.clazz = clazz;
	}

	@Override
	public T handler(ResultSet rs) {
		try {
			if (!rs.next()) {
				return null;
			}
			T bean = clazz.newInstance();
			ResultSetMetaData meta = rs.getMetaData();
			int cnt = meta.getColumnCount();
			for (int i = 0; i < cnt; i++) {
				String name = meta.getColumnName(i+1);
				Object value = rs.getObject(name);
				Field f = clazz.getDeclaredField(name);
				f.setAccessible(true);
				f.set(bean, value);
			}
			return bean;
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}


}
