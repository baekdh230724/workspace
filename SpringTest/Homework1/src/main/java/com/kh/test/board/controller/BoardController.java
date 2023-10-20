package com.kh.test.board.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.kh.test.board.model.dto.Board;
import com.kh.test.board.model.service.BoardService;

@Controller
@RequestMapping("board")
public class BoardController {

	@Autowired
	private BoardService service;
	
	
	/** 게시글 상세조회(게시글 번호 이용)
	 * @param no : 게시글 번호
	 * @param model
	 * @param ra
	 * @return board/selectOne
	 */
	@GetMapping("selectOne")
	public String selectOne(int no, Model model, RedirectAttributes ra) {
		
		Board board = service.selectOne(no);
		
		if(board != null) {
			model.addAttribute("board", board);
			return "board/selectOne";
		}
		
		ra.addFlashAttribute("message", "존재하지 않는 게시글 입니다");
		return "redirect:/";
	}
	
	@GetMapping("insert")
	public String insert() {
		return "board/insert";
	}
	
	
	/** 게시글 작성(해당 문제에서는 실패하는 경우가 없음)
	 * @param board
	 * @param ra
	 * @return
	 */
	@PostMapping("insert")
	public String insert(Board board, RedirectAttributes ra) {
		
		int result = service.insert(board);
		ra.addFlashAttribute("message", "삽입 성공");
		return "redirect:/";
	}
	
	
	/** 비밀번호 일치 시 삭제
	 * @param boardPw
	 * @param boardNo
	 * @param model
	 * @param ra
	 * @return
	 */
	@PostMapping("deleteBoard")
	public String deleteBoard(String boardPw, int boardNo, RedirectAttributes ra) {
		
		int result = service.deleteBoard(boardPw, boardNo);
		
		if(result > 0) {
			ra.addFlashAttribute("message", "삭제 되었습니다");
			return "redirect:/";
		}
		
		ra.addFlashAttribute("message", "비밀번호가 일치하지 않습니다");
		return "redirect:selectOne?no=" + boardNo;
	}
	
	
	/** 비밀번호 일치 시 수정 화면으로 전환
	 * @param boardPw
	 * @param boardNo
	 * @param model
	 * @param ra
	 * @return
	 */
	@PostMapping("moveUpdate")
	public String moveUpdate(String boardPw, int boardNo, Model model, RedirectAttributes ra) {
		
		Board board = service.moveUpdate(boardPw, boardNo);
		
		if(board != null) {
			model.addAttribute("board", board);
			return "board/update";
		}
		
		ra.addFlashAttribute("message", "비밀번호가 일치하지 않습니다");
		return "redirect:selectOne?no=" + boardNo;
	}
	
	
	/** 게시글 수정
	 * @param board
	 * @param ra
	 * @return
	 */
	@PostMapping("updateBoard")
	public String updateBoard(Board board, RedirectAttributes ra) {
		
		int result = service.updateBoard(board);
		
		String message = null;
		if(result > 0) message = "수정 성공";
		else	 message = "수정 실패";
		
		ra.addFlashAttribute("message", message);
		
		return "redirect:selectOne?no=" + board.getBoardNo();
	}
	
	
	
}
