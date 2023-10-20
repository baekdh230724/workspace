package com.kh.test.board.model.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.kh.test.board.model.dto.Board;

@Mapper
public interface BoardMapper {

	/** 게시글 목록 조회
	 * @return boardList
	 */
	List<Board> selectBoardList();

	/** 게시글 상세 조회
	 * @param no
	 * @return board
	 */
	Board selectOne(int no);
	
	/** 게시글 작성
	 * @param board
	 * @return result
	 */
	int insert(Board board);

	/** 게시글 비밀번호 조회
	 * @param boardNo
	 * @return encPw
	 */
	String selectBoardPw(int boardNo);
	
	/** 게시글 삭제
	 * @param boardNo
	 * @return result
	 */
	int deleteBoard(int boardNo);

	/** 게시글 수정
	 * @param board
	 * @return result
	 */
	int updateBoard(Board board);

	

	
	
}
