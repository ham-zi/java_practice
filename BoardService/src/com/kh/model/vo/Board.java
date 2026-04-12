package com.kh.model.vo;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Board {
	
	private final String boardId;
	private final int userNo;
	private final String title;
	private final String content;
	private final String writedDate;
	
	public Board(String boardId, int userNo, String title, String content) {
		super();
		this.boardId = boardId;
		this.userNo = userNo;
		this.title = title;
		this.content = content;
		this.writedDate = new SimpleDateFormat("yyyy/MM/dd").format(new Date());
	}
	
	public String getBoardId() {
		return boardId;
	}
	public int getUserNo() {
		return userNo;
	}
	public String getTitle() {
		return title;
	}
	public String getContent() {
		return content;
	}
	public String getWritedDate() {
		return writedDate;
	}
	
	
}
