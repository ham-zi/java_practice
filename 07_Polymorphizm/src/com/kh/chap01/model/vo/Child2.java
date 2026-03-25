package com.kh.chap01.model.vo;

public class Child2 extends Parent {
	private int z;

	public Child2() {
		super();
	}

	public Child2(int z) {
		super();
		this.z = z;
	}


	public void printChild2() {
		System.out.println("Child2 클래스입니다.");
	}
	
}
