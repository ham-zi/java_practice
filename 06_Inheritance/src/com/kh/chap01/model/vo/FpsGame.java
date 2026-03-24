package com.kh.chap01.model.vo;

public class FpsGame {

	private String gameName;
	private String publisher;
	private double stress;

	public FpsGame() {
		super();
	}

	public FpsGame(String gameName, String publisher, double stress) {
		super();
		this.gameName = gameName;
		this.publisher = publisher;
		this.stress = stress;
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

	public double getStress() {
		return stress;
	}

	public void setStress(double stress) {
		this.stress = stress;
	}

	public String info() {
		String info = "[게임이름:" + gameName + ", 보급사:" + publisher + ", 스트레스:" + stress+"]"; 
		return info;
	}
}
