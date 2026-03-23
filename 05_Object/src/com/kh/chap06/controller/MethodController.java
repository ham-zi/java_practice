package com.kh.chap06.controller;

public class MethodController {

	
	/* 메소드(method)
	 * 멤버함수 / 인스턴스함수
	 * 
	 * 프로그래밍 언어에서의 함수 : 특정 작업을 수행하기 위해서 만들어진 코드 블록
	 * 1. 재사용
	 * 2. 모듈화
	 * 
	 *  
	 *  접근제한자 예약어 반환형 메소드식별자(매개변수의자료형 매개변수식별자)
	 *  생략 가능한 것 : 예약어, 매개변수, return문(void)일 경우
	 *  반환형 : return 시 반환할 값이 있을 경우 반환할 값의 자료형
	 *  메소드 호출 시 전달 인자값 => 매개변수의 자료형 및 개수가 정확하게 일치해야함
	 *  
	 *  
	 *  
	 *  
	 */
	
	
	public void method1() {
		System.out.println("출력용 메서드");
	}
	
	public String method2( ) {
		return "필드값";
	}
	
}
