package com.kh.vips.model.vo;

public class Hong {
	private String name;

	public Hong(String name) {
		super();
		this.name = name;
	}
	
	public void cooking() {
		System.out.println(name + " s1 요리시작");
	}
	
	public void breakTime() {
		System.out.println(name + " 쉬는시간");
	}

}
