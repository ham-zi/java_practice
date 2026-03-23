package com.kh.chap07.model.vo;

public class Ticket {
	// 티켓을 세개까지 추가할 수 있음
	// 이용자는 추가되어 있는 티켓을 발급받을 수 있음
	// 이코노미 티켓

	private final String name;
	private final int price;
	private final String meal;
	private final String seatNumber;
	private static int count;

	public Ticket(String name, int price, String meal, String seatNumber) {
		this.name = name;
		this.price = price;
		this.meal = meal;
		this.seatNumber = seatNumber;
		plusCount();
	}
	
	public static Ticket of(String name, int price, String meal, String seatNumber) {
		if(count<4) {
			return new Ticket(name,price,meal,seatNumber);
		}
		System.out.println("티켓생성불가능(개수제한)");
		return null;
	}

	public static int getCount() {
		return count;
	}

	public void plusCount() {
		count++;
	}

	public String getName() {
		return name;
	}

	public int getPrice() {
		return price;
	}

	public String getMeal() {
		return meal;
	}

	public String getSeatNumber() {
		return seatNumber;
	}
	
	public String info( ) {
		return "기내식:"+ meal + ", 가격" + price + ", 식사" + meal + ",좌석번호" + seatNumber;
	}
	
	
	

}
