package com.kh.chap04.model.vo;

import java.io.Serializable;

public class Message implements Serializable {
	//필드부
	private String to;
	private String content;
	//생성자
	public Message() {
		super();
	}
	public Message(String to, String content) {
		super();
		this.to = to;
		this.content = content;
	}
	//게터
	public String getTo() {
		return to;
	}
	public String getContent() {
		return content;
	}
	
	@Override
	public String toString() {
		return "Message [to=" + to + ", content=" + content + "]";
	}
	
	

	
}
