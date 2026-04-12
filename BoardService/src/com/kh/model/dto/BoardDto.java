package com.kh.model.dto;

import java.text.SimpleDateFormat;
import java.util.Date;

public class BoardDto {
	
	private String boardId;
	private int userNo;
	private String title;
	private String content;
	private String writedDate;
	
	
	public BoardDto(String boardId, int userNo, String title, String content) {
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
	public void setBoardId(String boardId) {
		this.boardId = boardId;
	}
	public int getUserNo() {
		return userNo;
	}

	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getWritedDate() {
		return writedDate;
	}

	

}
