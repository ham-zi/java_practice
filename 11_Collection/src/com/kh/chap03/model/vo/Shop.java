package com.kh.chap03.model.vo;

import java.util.Objects;

public class Shop {
	private String name;
	private String menu;
	private int price;

	public Shop(String name, String menu, int price) {
		super();
		this.name = name;
		this.menu = menu;
		this.price = price;
	}

	@Override
	public int hashCode() {
		return Objects.hash(menu, name, price);
	}

	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getMenu() {
		return menu;
	}

	public void setMenu(String menu) {
		this.menu = menu;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Shop other = (Shop) obj;
		return Objects.equals(menu, other.menu) && Objects.equals(name, other.name) && price == other.price;
	}

	
	 @Override public String toString() { return "Shop [name=" + name + ", menu="
	 + menu + ", price=" + price + "]"; }
	 

	// 우리가 해야할 일
	// 필드의 값이 동일하다면
	// equals()와 hashcode()를 오버라이딩해서 동일한 결과값이 출력되도록 구현해야함
	// hashset에서 사용하기 위함인가?
	
	/*
	 * @Override public boolean equals(Object obj) {
	 * 
	 * Shop shop = (Shop)obj;
	 * 
	 * if(this.price == shop.price && this.name.equals(shop.name) &&
	 * this.menu.equals(shop.menu)) { return true; }
	 * 
	 * return false; }
	 * 
	 * @Override public int hashCode() { // ! 필드값이 동일하다면 동일한 해시코드값이 나오게 만들고 싶다 // 모든
	 * 필드값들을 더해서 .hashcode()하면 필드값이 동일했을 때 같은 값이 나온다. // hashCode 오버라이딩 안에서
	 * hashcode()를 사용할 수 있다는것에 놀랐다. return (name + menu + price).hashCode();
	 * 
	 * }
	 */
	// 일반적으로 VO 객체는 반드시 equals()와 hashcode()를 반드시 오버라이딩한다.
}
