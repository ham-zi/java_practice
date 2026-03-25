package com.kh.vips.model.vo;

public class Duli {
	private String name;

	public Duli(String name) {
		super();
		this.name = name;
	}
	
	public void cooking() {
		System.out.println(name + " s1 요리 시작~");
	}
	
	public void breakTime() {
		System.out.println(name + "쉬는시간!");
	}
	
}
