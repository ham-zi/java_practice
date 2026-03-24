package com.kh.chap01.model.vo;

public class RpgGame {

	private String gameName;
	private String publisher;
	private int maxLevel;

	public RpgGame() {
		super();
	}

	public RpgGame(String gameName, String publisher, int maxLevel) {
		super();
		this.gameName = gameName;
		this.publisher = publisher;
		this.maxLevel = maxLevel;
	}

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

	public int getMaxLevel() {
		return maxLevel;
	}

	public void setMaxLevel(int maxLevel) {
		this.maxLevel = maxLevel;
	}
	
	public String info() {
		String info = "[게임이름:" + gameName + ", 보급사:" + publisher + ", 최대 레벨:" + maxLevel+"]"; 
		return info;
	}

}
