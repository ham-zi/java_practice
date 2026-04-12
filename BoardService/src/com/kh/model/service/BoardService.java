package com.kh.model.service;

import java.util.ArrayList;
import java.util.List;

import com.kh.exception.ExistIdException;
import com.kh.model.dto.BoardDto;
import com.kh.model.vo.Board;
import com.kh.model.vo.User;

public class BoardService {

	List<Board>boards = new ArrayList<>();

	//Create
	public Board createBoard(BoardDto dto) {
		Board board = null;
		if(!boards.isEmpty()) {
			for(Board b : boards) {
				if(dto.getBoardId().equals(b.getBoardId())) {
					throw new ExistIdException();
				}
			}
		}


		board = new Board(dto.getBoardId(),dto.getUserNo(),dto.getTitle(),dto.getContent());
		boards.add(board);
		return board;

	}
	
	//Read
	public List<Board> selectAll() {
		return boards;
	}
	
	public List<Board> findBoardByTitle(String title) {
		if(boards.isEmpty()) {
			return null;
		}
		List<Board>list = boards.stream()
								.filter(b -> b.getTitle().contains(title))
								.toList();
		return list;
	}
	
	
	//Update
	public List<Board> findMyBoards(User user) {
		if(!boards.isEmpty()) {
			List<Board>lists = boards.stream()
									 .filter(b -> b.getUserNo() == user.getUserNo())
									 .toList();
			return lists;
		}
		return null;
	}
	
	public boolean isBoard(String boardId) {
		if(!boards.isEmpty()) {
			for(Board board : boards) {
				if(boardId.equals(board.getBoardId())) {
					return true;
				}
			}
		}
		return false;
	}
	
	public Board getBoardByBoardId(String boardId) {
		if(!boards.isEmpty()) {
			for(Board board : boards) {
				if(boardId.equals(board.getBoardId())) {
					return board;
				}
			}
		}
		return null;
	}
	
	public Board updateBoard(BoardDto dto) {
		Board targetBoard = getBoardByBoardId(dto.getBoardId());
		if(targetBoard == null) {
			return null;
		}
		boards.remove(targetBoard);
		return createBoard(dto);
	}
	
	//delete
	public void deleteBoard(String boardId) {
		Board targetBoard = getBoardByBoardId(boardId);
		boards.remove(targetBoard);
	}
	
	
}
