package com.kh.chap01.abstraction.model.vo;

public class Puppy {
	
	// [필드]
	/*
	 * 접근제한자 자료형 필드식별자;
	 * 접근제한자 : 이 필드에 접근할 수 있는 접근권한을 제어하는 역할
	 * 
	 *  public > protected > default > private
	 * 클래스 내부에 필드를 선언할 때는 반드시 접근제한자 붙힐 것
	 * 
	 * 
	 * 이름, 종, 성별, 몸무게, 나이
	 * 
	 */
	public String name;
	public String species;
	public String gender;
	public int weight;
	public int age;
	
	// 생성자
	
	// 메서드
	
	public void bark() {
		System.out.println(name+ "이(가) 멍멍합니다.");
		// 클래스 내부의 name
	}
	
	public void sit() {
		System.out.println( name + "이(가) 앉습니다.");
		--weight;
	}
}
