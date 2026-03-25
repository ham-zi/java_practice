package com.kh.chap03.medel.vo;

public class KakaoWebToon extends WebToon {
	
	private boolean Free;

	
	
	public KakaoWebToon() {
		super();
	}
	public KakaoWebToon(boolean free) {
		super();
		Free = free;
	}
	public KakaoWebToon(String title, String author, String day, boolean free) {
		super(title, author, day);
		Free = free;
	}	
	
	
	
	public boolean isFree() {
		return Free;
	}

	public void setFree(boolean free) {
		Free = free;
	}




}
