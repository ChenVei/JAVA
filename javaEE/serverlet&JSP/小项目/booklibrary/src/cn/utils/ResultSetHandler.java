package cn.utils;

import java.sql.ResultSet;

public interface ResultSetHandler {
	Object handler(ResultSet rs);
}
