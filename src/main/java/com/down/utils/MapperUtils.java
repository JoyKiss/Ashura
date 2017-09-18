package com.down.utils;

import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class MapperUtils {

	/**
	 * 获取Mapper的注入对象
	 * 
	 * @param mapperClass
	 *            mapper的class类
	 * @return
	 */
	public static Object getMapper(Class mapperClass) {
		SqlSessionFactory sqlSessionFactory;
		SqlSession session = null;
		Object result = null;
		try {
			String resource = "mybatis-config4Utils.xml";
			InputStream inputStream = Resources.getResourceAsStream(resource);
			sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
			session = sqlSessionFactory.openSession();
			result = session.getMapper(mapperClass);

		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
		}
		return result;
	}
}
