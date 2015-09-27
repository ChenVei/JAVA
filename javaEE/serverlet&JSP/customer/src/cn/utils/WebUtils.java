package cn.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.beanutils.ConvertUtils;
import org.apache.commons.beanutils.Converter;

public class WebUtils {
	public static<T> T request2Bean(HttpServletRequest request, Class<T> beanClass) {
		try {
			T bean = beanClass.newInstance();
			Map<String, String[]> map = request.getParameterMap();
			ConvertUtils.register(new Converter() {
				
				@Override
				public Object convert(Class arg0, Object value) {
					if (value == null || value.toString().trim().equals("")) {
						return null;
					}
					SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
					Date d = null;
					try {
						d = sdf.parse((String) value);
					} catch (ParseException e) {
						throw new RuntimeException(e);
					}
					return d;
				}
			}, Date.class);
			
			BeanUtils.populate(bean, map);
			return bean;
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
	
	public static String generateID() {
		return UUID.randomUUID().toString();
	}
}
