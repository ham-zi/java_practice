package com.kh.model.vo;

import java.util.Date;

public class Board {
	
	private final String boardId;
	private final String userNo;
	private final String title;
	private final String content;
	private final Date writedDate;
	
	public Board(String boardId, String userNo, String title, String content, Date writedDate) {
		super();
		this.boardId = boardId;
		this.userNo = userNo;
		this.title = title;
		this.content = content;
		this.writedDate = writedDate;
	}
	
	public String getBoardId() {
		return boardId;
	}
	public String getUserNo() {
		return userNo;
	}
	public String getTitle() {
		return title;
	}
	public String getContent() {
		return content;
	}
	public Date getWritedDate() {
		return writedDate;
	}
	
	
}
