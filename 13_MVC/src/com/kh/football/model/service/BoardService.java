package com.kh.football.model.service;



import java.util.List;

import com.kh.football.model.dao.BoardDao;
import com.kh.football.model.dto.BoardDto;
import com.kh.football.model.vo.Board;

public class BoardService {
	private BoardDao bd;
	
	public BoardService(BoardDao bd) {
		this.bd = bd;
	}
	
	public List<Board> findAll() {
		return bd.findAll();
	}
	
	public Board findById(int boardNo) {
		return bd.findById(boardNo);
	}
	
	public void saveBoard(BoardDto dto) {
		Board board = new Board(dto.getBoardTitle(),dto.getBoardContent(),dto.getBoardWriter(),dto.getPassword());
		bd.saveBoard(board);
	}
	
	
	
	public Board updateBoard(int boardNo, BoardDto dto) {
		removeBoard(boardNo, dto.getPassword());
	
		Board board = new Board(boardNo,dto.getBoardTitle(), dto.getBoardContent(), dto.getBoardWriter(), dto.getPassword());
		bd.saveBoard(board);
		return board;
	}
	
	public void removeBoard(int boardNo, String password) {
		Board findBoard = findById(boardNo);
		if(findBoard.getPassword().equals(password)) {
		bd.removeBoard(boardNo);
		}else {
			throw new RuntimeException();
		}
	}
	
	public int deleteBoard(int boardNo) {
		List<Board> list = bd.findAll();
		if(boardNo < 0) {
			return 0;
		}
		
		for(int i=0; i<list.size(); i++) {
			if(list.get(i).getBoardNo()==boardNo){
				list.remove(i);
				return 1;
			}
		}
		return 0;
		
	}
	
}
