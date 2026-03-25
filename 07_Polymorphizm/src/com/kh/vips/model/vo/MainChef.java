package com.kh.vips.model.vo;

public class MainChef {
	
	private String name;
	public MainChef(String name) {
		this.name = name;
	}
	
	public void beefCooking() {
		System.out.println(name + " 고기 굽기");
	}
	public void breakTime() {
		System.out.println(name + " 쉬는 시간");
	}

}
