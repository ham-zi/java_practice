package com.kh.chap02.model.vo;

public class AosGame extends Game{
	
	private int characterCount;

	public int getCharacterCount() {
		return characterCount;
	}

	public void setCharacterCount(int characterCount) {
		this.characterCount = characterCount;
	}

	public AosGame() {
		super();
		System.out.println("나는 자식 클래스다.");
	}

	public AosGame(int characterCount) {
		this.characterCount = characterCount;
	}

}
