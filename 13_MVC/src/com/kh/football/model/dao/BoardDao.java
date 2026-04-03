package com.kh.football.model.dao;

import java.util.List;

import com.kh.football.model.dto.BoardDto;
import com.kh.football.model.vo.Board;

public interface BoardDao {
	public List<Board> findAll();
	public Board findById(int boardNo);
	public void saveBoard(Board board);
	public Board removeBoard(int boardNo);
}
