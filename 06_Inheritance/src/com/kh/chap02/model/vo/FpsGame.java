package com.kh.chap02.model.vo;

public class FpsGame extends Game {

	private int stress;

	public FpsGame() {

	}

	public FpsGame(int stress) {
		super();
		this.stress = stress;
	}
	
	public FpsGame(String gameName, String publisher, int stress) {
		super(gameName,publisher);
		this.stress = stress;
	}

	public int getStress() {
		return stress;
	}

	public void setStress(int stress) {
		this.stress = stress;
	}

}
