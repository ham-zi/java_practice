package com.kh.football.controller;

import java.util.List;

import com.kh.football.model.dto.BoardDto;
import com.kh.football.model.service.BoardService;
import com.kh.football.model.vo.Board;

public class BoardController {
	private BoardService bs;
	
	public BoardController(BoardService bs) {
		this.bs = bs;
	}
	
	public List<Board> findAll() {
		return bs.findAll();
	}
	
	public Board findById(int boardNo) {
		return bs.findById(boardNo);
	}
	
	public void saveBoard(BoardDto dto) {
		bs.saveBoard(dto);
	}
	
	public Board updateBoard(int boardNumber, BoardDto dto) {
		return bs.updateBoard(boardNumber, dto);
	}

	public void removeBoard(int boardNo, String password) {
		bs.removeBoard(boardNo, password);
	}
	
}
