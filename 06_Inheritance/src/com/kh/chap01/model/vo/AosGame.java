package com.kh.chap01.model.vo;

public class AosGame {
	private String gameName;
	private String publisher;
	private int characterCount;
	
	
	public String getGameName() {
		return gameName;
	}
	public void setGameName(String gameName) {
		this.gameName = gameName;
	}
	public String getPublisher() {
		return publisher;
	}
	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}
	public int getCharacterCount() {
		return characterCount;
	}
	public void setCharacterCount(int characterCount) {
		this.characterCount = characterCount;
	}
	
	
	
	public AosGame(String gameName, String publisher, int characterCount) {
		super();
		this.gameName = gameName;
		this.publisher = publisher;
		this.characterCount = characterCount;
	}
	public AosGame() {
		super();
	}
	
	public String info() {
		String info = "[게임이름:" + gameName + ", 보급사:" + publisher + ", 케릭터 수:" + characterCount +"]"; 
		return info;
	}
	
	// 기본생성자, 매개변수 생성자
	// 게터,세터

}
