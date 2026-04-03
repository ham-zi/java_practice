package com.kh.football.model.vo;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Objects;

public class Board {
	private static int num = 0;
	private final int boardNo;
	private final String boardTitle;
	private final String boardContent;
	private final String boardWriter;
	private final String password;
	private final String createDate;
	public Board(String boardTitle, String boardContent, String boardWriter, String password) 
	{
		if(boardTitle.isBlank()) {
			throw new IllegalArgumentException("타이틀");
		}
		
		this.boardNo = ++num;
		this.boardTitle = boardTitle;
		this.boardContent = boardContent;
		this.boardWriter = boardWriter;
		this.password = password;
		this.createDate = new SimpleDateFormat("yyyy/MM/dd").format(new Date());
	}
	public Board(int boardNo , String boardTitle, String boardContent, String boardWriter, String password) 
	{
		if(boardTitle.isBlank()) {
			throw new IllegalArgumentException("타이틀공백오류");
		}
		if(boardWriter.isBlank()) {
			throw new IllegalArgumentException("글쓴이공백오류");
		}
		if(password.isBlank()) {
			throw new IllegalArgumentException("비밀번호공백오류");
		}
		
		this.boardNo = boardNo;
		this.boardTitle = boardTitle;
		this.boardContent = boardContent;
		this.boardWriter = boardWriter;
		this.password = password;
		this.createDate = new SimpleDateFormat("yyyy/MM/dd").format(new Date());
	}
	public int getBoardNo() {
		return boardNo;
	}

	public String getBoardTitle() {
		return boardTitle;
	}

	public String getBoardContent() {
		return boardContent;
	}

	public String getBoardWriter() {
		return boardWriter;
	}

	public String getPassword() {
		return password;
	}

	public String getCreateDate() {
		return createDate;
	}
	@Override
	public int hashCode() {
		return Objects.hash(boardContent, boardNo, boardTitle, boardWriter, createDate, password);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Board other = (Board) obj;
		return Objects.equals(boardContent, other.boardContent) && boardNo == other.boardNo
				&& Objects.equals(boardTitle, other.boardTitle) && Objects.equals(boardWriter, other.boardWriter)
				&& Objects.equals(createDate, other.createDate) && Objects.equals(password, other.password);
	}
	@Override
	public String toString() {
		return "Board [boardNo=" + boardNo + ", boardTitle=" + boardTitle + ", boardContent=" + boardContent
				+ ", boardWriter=" + boardWriter + ", password=" + password + ", createDate=" + createDate + "]";
	}


}
