package com.kh.mybatis.board.model.dao;

import java.util.ArrayList;
import java.util.HashMap;

import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.session.SqlSession;

import com.kh.mybatis.board.model.vo.Board;
import com.kh.mybatis.board.model.vo.Reply;
import com.kh.mybatis.common.model.vo.PageInfo;

public class BoardDao {
	
	public int selectListCount(SqlSession sqlSession) {
		return sqlSession.selectOne("boardMapper.selectListCount"); // 한행일때는 selectOne(), 여러행일때는 selectList()
	}
	
	public ArrayList<Board> selectList(SqlSession sqlSession, PageInfo pi){
		// sqlSession.selectList("boardMapper.selectList");
		// 이렇게만 하면 전체 리스트가 싹다 조회된다..
		
		// 마이바티스에서는 페이징 처리를 위해 RowsBounds 라는 클래스 제공
		
		// * offset : 몇 개의 게시글을 건너 뛰고 조회할건지에 대한 값
		
		/*
		 * ex) boardLimit : 5 (한 페이지에 5개씩 보여질 때)
		 * 									offset(건너뛸 숫자)			limit(조회할 숫자)
		 * currentPage : 1		1~5					0						5
		 * 			   : 2		6~10				5						5
		 * 			   : 3		11~15				10						5
		 * 			...
		 * 
		 */
		
		int offset = (pi.getCurrentPage()-1) * pi.getBoardLimit();
		int limit = pi.getBoardLimit();
		
		RowBounds rowBounds = new RowBounds(offset, limit);
		
		// 버전 업 돼서 제네릭 쓰면 안됨
		return (ArrayList)sqlSession.selectList("boardMapper.selectList", null, rowBounds); // 쿼리 수행후 페이징 처리할 때 사용하는 메소드 // 우측의 두 줄을 한줄로!! ArrayList<Board> list = (ArrayList)sqlSession.selectList("boardMapper.selectList", null, rowBounds); //return list;
				
				
	}
	
	public int increaseCount(SqlSession sqlSession, int boardNo) {
		return sqlSession.update("boardMapper.increaseCount", boardNo);
	}
	
	public Board selectBoard(SqlSession sqlSession, int boardNo) {
		return sqlSession.selectOne("boardMapper.selectBoard", boardNo);
	}
	
	public ArrayList<Reply> selectReplyList(SqlSession sqlSession, int boardNo){
		return (ArrayList)sqlSession.selectList("boardMapper.selectReplyList", boardNo);
	}
	
	public int selectSearchCount(SqlSession sqlSession, HashMap<String, String> map) {
		return sqlSession.selectOne("boardMapper.selectSearchCount", map);
	}
	
	public ArrayList<Board> selectSearchList(SqlSession sqlSession, HashMap<String, String> map, PageInfo pi){
		
		int offset = (pi.getCurrentPage()-1) * pi.getBoardLimit();
		int limit = pi.getBoardLimit();
		
		RowBounds rowBounds = new RowBounds(offset, limit);
		
		return (ArrayList)sqlSession.selectList("boardMapper.selectSearchList", map, rowBounds);
		
		
	}
	

	
	
	
	
	
	
}
