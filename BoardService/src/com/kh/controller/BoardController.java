package com.kh.controller;

import java.util.List;

import com.kh.model.dto.BoardDto;
import com.kh.model.service.BoardService;
import com.kh.model.vo.Board;
import com.kh.model.vo.User;

public class BoardController {

	BoardService bs = new BoardService();
	
	//create
	public Board createBoard(BoardDto dto) {
		return bs.createBoard(dto);
	}
	
	//read
	public List<Board> selectAll(){
		return bs.selectAll();
	}
	
	public List<Board> findBoardByTitle(String title) {
		return bs.findBoardByTitle(title);
	}
	
	//update
	public List<Board> findMyBoards(User user) {
		return bs.findMyBoards(user);
	}
	
	public boolean isBoard(String boardNo) {
		return bs.isBoard(boardNo);
	}
	
	public Board updateBoard(BoardDto dto) {
		return bs.updateBoard(dto);
	}
	
	//delete
	public void deleteBoard(String boardId) {
		bs.deleteBoard(boardId);
	}
	
	
}
