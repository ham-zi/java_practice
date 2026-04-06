package com.kh.football.model.dao;

import java.util.ArrayList;
import java.util.List;
import com.kh.football.model.vo.Board;

public class MemoryBoardDao implements BoardDao{
	private List<Board> boards = new ArrayList<>();

	{
		boards.add(new Board("첫 글입니다", "재밌다", "괸리자", "1234"));
		boards.add(new Board("두번째 글입니다", "두번째", "괸리자", "1234"));
		
	}
	
	public List<Board> findAll(){
		return boards;
	}
	
	public Board findById(int boardNo) {
		Board board = boards.stream()
							.filter(b -> b.getBoardNo() == boardNo)
							.findFirst()
							.orElse(null);
		return board;
		
	}
	
	public void saveBoard(Board board) {
		//만들 때 미리 정책을 세워놔야 한다.
		//1차 View => 안내메세지를 뿌려주기 위함 
		// 아이디 : 5~20자의 
		// 정책을 미리 알려줘야 다른걸 적기 때문에.
		//2차 
		boards.add(board);
	}
	
	
	public int findIndexById(int boardNo) {
		for(int i=0; i<boards.size(); i++) {
			if(boards.get(i).getBoardNo()==boardNo) {
				return i;
			}
		}
		return 0;
	}
	
	public Board removeBoard(int boardNo) {
		return boards.remove( findIndexById(boardNo) );
	}
	
	
}
