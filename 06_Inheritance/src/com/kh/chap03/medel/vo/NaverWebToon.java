package com.kh.chap03.medel.vo;

public class NaverWebToon extends WebToon {
	//필드부
	private String payment;
	
	//생성자부
	public NaverWebToon() {
		super();
	}
	
	public NaverWebToon(String payment) {
		super();
		this.payment = payment;
	}
	
	public NaverWebToon(String title, String author, String day, String payment) {
		super(title, author, day);
		this.payment = payment;
	}

	//메서드부
	public String getPayment() {
		return payment;
	}	
	
	public void setPayment(String payment) {
		this.payment = payment;
	}


	
	

}
