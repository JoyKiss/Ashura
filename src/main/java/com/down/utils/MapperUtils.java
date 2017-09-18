package com.down.utils;

import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class MapperUtils {

	private static SqlSession session;

	private MapperUtils() {
	}

	public static synchronized SqlSession getInstance() {
		if (session == null) {
			session = getSession("mybatis-config4Utils.xml");
		}
		return session;
	}
	public static synchronized SqlSession getInstance(String configFile) {
		if (session == null) {
			session = getSession(configFile);
		}
		return session;
	}
	
	/**
	 * 执行更新和插入操作时需要执行commit事件
	 */
	public static void commit() {
		if(session != null) {
			session.commit();
			session.close();
		}
	}

	/**
	 * 获取Mapper的注入对象
	 * 
	 * @param mapperClass
	 *            mapper的class类
	 * @return
	 */
	public static SqlSession getSession(String configFile) {
		SqlSessionFactory sqlSessionFactory;
		Object result = null;
		try {
			String resource = configFile;
			InputStream inputStream = Resources.getResourceAsStream(resource);
			sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
			session = sqlSessionFactory.openSession();

		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
		}
		return session;
	}

	/**
	 * 获取Mapper的注入对象
	 * 
	 * @param mapperClass
	 *            mapper的class类
	 * @return
	 */
	public static Object getMapper(Class mapperClass) {
		getInstance();
		return session.getMapper(mapperClass);
	}

	/**
	 * 获取Mapper的注入对象
	 * 
	 * @param mapperClass
	 *            mapper的class类
	 * @return
	 */
	public static Object getMapper(Class mapperClass, String configFile) {
		getInstance(configFile);
		return session.getMapper(mapperClass);
	}

}
