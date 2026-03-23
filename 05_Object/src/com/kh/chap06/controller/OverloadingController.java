package com.kh.chap06.controller;

public class OverloadingController {

	
	/*
	 * 메소드 오버로딩(Method Overloading)
	 * 
	 * - "하나의 클래스" 안에 동일한 메소드 식별자로 여러 개의 메소드를 정의하는
	 *  - 매개변수 자료형의 개수, 순서, 종류를 각각 다르게 작성해야함
	 *  - 매개변수 식별자, 접근제한자, 반환타입은 메소드 오버로딩과 연관이 없음
	 * 
	 */
	
	
	//메소드명은 method로 통일
	
	public void method() {
		System.out.println("메소드 오버로딩1");
	}
	
	public void method(int num) {
		System.out.println("메소드 오버로딩2");
	}
	
	public void method(String str) {
		System.out.println("메소드 오버로딩3");
	}

	
	
	// 정적 바인딩 ( Static Binding )
	/* dynamic automatic, static
	 *   동적      자동       정적
	 *  짝을 묶어준다??
	 *  
	 *  
	 */
	
	
}
