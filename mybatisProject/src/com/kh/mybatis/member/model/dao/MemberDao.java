package com.kh.mybatis.member.model.dao;

import org.apache.ibatis.session.SqlSession;

import com.kh.mybatis.member.model.vo.Member;

public class MemberDao {
	
	/*
     * int result = 0;
     * PreparedStatement pstmt = null;
     * String sql = prop.getProperty("insertMember");
     * 
     * try{
     *    pstmt = conn.preparedStatement(sql);
     *    pstmt.setString(1, m.getUserId());
     *    pstmt.setString(2, m.getUserPwd());
     *  
     *    result = pstmt.excuteUpdate();
     * }catch(xxx){
     * 
     * }finally{
     *    close(pstmt);
     * }
     * 
     * return result;
     */
	
	
	/*
	 * sqlSessoin에서 제공하는 메소드를 통해서 sql문 찾아서 실행하고 결과 바로 받음
	 * 
	 * 결과 = sqlSession.sql문 종류에 맞는 메소드("매퍼의 별칭.쿼리아이디", [미완성된sql완성시킬객체])
	 * 
	 */
	
	public int insertMember(SqlSession sqlSession, Member m) {
		
		//int result = sqlSession.insert("memberMapper.insertMember", m);
		//return result;
		
		// 위의 두 줄을 한줄로
		return sqlSession.insert("memberMapper.insertMember", m);
		
	}
	
	public Member loginMember(SqlSession sqlSession, Member m) {
		// selectOne 메소드 : 조회결과가 없다면 null 반환
		return sqlSession.selectOne("memberMapper.loginMember", m); // 우측의 두 줄을 한줄로!! Member loginMember = sqlSession.selectOne("memberMapper.loginMember", m);		//return loginMember;
		
	}

}
