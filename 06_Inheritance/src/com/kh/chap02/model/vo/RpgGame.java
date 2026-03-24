package com.kh.chap02.model.vo;

public class RpgGame extends Game {

	
	private int maxLevel;

	public RpgGame() {}
	public RpgGame(String gameName, String publisher, int maxLevel) {
		super(gameName, publisher);
		this.maxLevel = maxLevel;
	}
	
	public int getMaxLevel() {
		return maxLevel;
	}
	public void setMaxLevel(int maxLevel) {
		this.maxLevel = maxLevel;
	}
	
	public String info( ) {
		return super.info() + ", 최대 레벨:" + maxLevel;
	}
	/*
	 * 자식클래스에 메소드를 재정의 했을 경우 자식클래스에 재정의한 메소드가 우선권을 가져서 호출됨!!
	 */
	
}
