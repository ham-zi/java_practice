package com.kh.model.dto;

import java.util.Date;

public class BoardDto {
	
	private String boardId;
	private String userNo;
	private String title;
	private String content;
	private Date writedDate;
	
	
	public BoardDto(String boardId, String userNo, String title, String content, Date writedDate) {
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
	public void setBoardId(String boardId) {
		this.boardId = boardId;
	}
	public String getUserNo() {
		return userNo;
	}
	public void setUserNo(String userNo) {
		this.userNo = userNo;
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
	public Date getWritedDate() {
		return writedDate;
	}
	public void setWritedDate(Date writedDate) {
		this.writedDate = writedDate;
	}
	

}
