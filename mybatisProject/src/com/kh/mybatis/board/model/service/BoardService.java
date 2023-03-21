package com.kh.mybatis.board.model.service;

import java.util.ArrayList;

import com.kh.mybatis.board.model.vo.Board;
import com.kh.mybatis.common.model.vo.PageInfo;

public interface BoardService {

	int selectListCount(); // 게시판 리스트 조회
	ArrayList<Board> selectList(PageInfo pi);
	
	int increaseCount(int boardNo); // 게시판 상세조회
	Board selectBoard(int boardNo);
	
}
