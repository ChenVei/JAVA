package cn.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.beanutils.ConvertUtils;
import org.apache.commons.beanutils.Converter;
import org.apache.commons.beanutils.locale.converters.DateLocaleConverter;

import com.mysql.fabric.xmlrpc.base.Data;

public class WebUtils {
	
	public static <T> T request2Bean(HttpServletRequest request, Class<T> beanClass) {
		try {
			Map<String, String[]> map = request.getParameterMap();
			T bean = beanClass.newInstance();
			ConvertUtils.register(new DateLocaleConverter(), Date.class);
			/*ConvertUtils.register(new Converter() {

				@Override
				public <T> T convert(Class<T> type, Object value) {
					if (value == null || value.toString().trim().equals("")) {
						return null;
					}
					SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
					T date = null;
					try {
						date = (T) sdf.parse((String) value);
					} catch (ParseException e) {
						throw new RuntimeException(e);
					}
					return date;
				}
			}, Data.class);*/

			BeanUtils.populate(bean, map);
			return (T) bean;
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}
}
