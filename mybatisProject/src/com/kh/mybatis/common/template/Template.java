package com.kh.mybatis.common.template;

import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.io.Resources;	// Resources 임포트 유의!
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class Template {
	
	/*
	 * 기존 JDBC
	 * public static Connection getConnection(){
	 * 		// driver.properties 파일 읽어들여서
	 * 		// 해당 DB와 접속된 Connection 객체 생성해서 반환
	 * }
	 * 
	 * public static void close(JDBC용 객체){
	 * 		// 전달받은 JDBC용 객체를 반납시키는 구문
	 * }
	 * 
	 * public static void commit|rollback(Conn){
	 * 		// 트랜젝션 처리
	 * }
	 * 
	 */
	
	// 마이바티스
	public static SqlSession getSqlSession() {
		
		// mybatis-config.xml 파일 읽어들여서
		// 해당 db와 접속된 SqlSession 객체 생성해서 반환
		SqlSession sqlSession = null;
		
		// SqlSession 생성하기 위해서 => SqlSessionFactory 필요
		// SqlSessionFactory 생성하기 위해서 => SqlSessionFactoryBuilder 필요
		
		String resource = "/mybatis-config.xml"; // '/'하게되면 소스의 최상위 폴더 => src, resources 같은거.. 가리킴
		
		try {
			InputStream stream = Resources.getResourceAsStream(resource);
			sqlSession = new SqlSessionFactoryBuilder().build(stream).openSession(false);
							// openSession() : 기본값 false
							// openSession(boolean autoCommit) : 자동 커밋 여부 (true면 하겠다, false면 안하겠다)
							// => 개발자가 autoCommit을 직접 설정함
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return sqlSession;
		
		
	}
	
	
	
	
	
	

}
