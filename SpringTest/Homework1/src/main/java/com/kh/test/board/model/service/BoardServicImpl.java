package com.kh.test.board.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.kh.test.board.model.dto.Board;
import com.kh.test.board.model.mapper.BoardMapper;

@Transactional
@Service
public class BoardServicImpl implements BoardService {
	
	@Autowired
	private BoardMapper mapper;

	@Autowired
	private BCryptPasswordEncoder bcrypt;
	
	
	@Override
	public List<Board> selectBoardList() {
		return mapper.selectBoardList();
	}
	
	@Override
	public Board selectOne(int no) {
		return mapper.selectOne(no);
	}
	
	@Override
	public int insert(Board board) {
		// 비밀번호 암호화 후 board에 세팅
		board.setBoardPw(bcrypt.encode(board.getBoardPw()));
		return mapper.insert(board);
	}
	
	@Override
	public int deleteBoard(String boardPw, int boardNo) {
		// 게시글 번호를 이용해 암호화된 비밀번호 조회
		String encPw = mapper.selectBoardPw(boardNo);
		
		// 게시글의 비밀번호와 입력 받은 비밀번호가 일치하지 않으면 0 반환
		if( !bcrypt.matches(boardPw, encPw) ) return 0;
		
		// 일치하면 update 결과 반환
		return mapper.deleteBoard(boardNo);
	}
	
	@Override
	public Board moveUpdate(String boardPw, int boardNo) {
		
		// 게시글 번호를 이용해 암호화된 비밀번호 조회
		String encPw = mapper.selectBoardPw(boardNo);
		
		// 게시글의 비밀번호와 입력 받은 비밀번호가 일치하지 않으면 null 반환
		if( !bcrypt.matches(boardPw, encPw) ) return null;
		
		// 일치하면 게시글 상세 조회 결과 반환
		return mapper.selectOne(boardNo);
	}
	
	
	@Override
	public int updateBoard(Board board) {
		
		// 비밀번호 암호화 후 board에 세팅
		board.setBoardPw(bcrypt.encode(board.getBoardPw()));
		return mapper.updateBoard(board);
	}
}
