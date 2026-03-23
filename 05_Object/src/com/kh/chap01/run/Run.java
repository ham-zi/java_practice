package com.kh.chap01.run;

import com.kh.chap01.abstraction.model.vo.Puppy;
import com.kh.chap01.abstraction.view.PuppyCare;

public class Run {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		PuppyCare pc = new PuppyCare();
		Puppy p = new Puppy();
		System.out.println(p.hashCode());
		p.name = "나폴레옹";
		// 객체를 참조한다
		System.out.println(p.name);
		// 선언만 했다면, 기본값이 Null
		
		//필드들을 '멤버' 라고 표현한다.
		//
		Puppy khan = new Puppy();
		khan.name = "징기스칸";
		System.out.println(khan.name);
		// (타입-클래스) => 개발자가 직접 강아지 자료형 제작
		// 클래스란? 객체들의 정보(속성,행위)들을 담아내는 그릇 또는 틀 또는 설계도 또는 명세
		
		
		// 객체지향 프로그래밍:OOP(Object oriented Programming)
		// 현실세계에서의 객체를 속성과 행위를 가진 객체로 생성하며
		// 객체간의 관계를 맺고 상호작용을 통해 프로그래밍을 하는 개발 방법론
		p.bark();
		
		p.weight = 8;
		khan.weight = 88;
		System.out.println(khan.weight);		
		khan.sit();
		khan.sit();
		khan.sit();
		System.out.println(khan.weight);
		
		pc.run();
	
		
		
	}

}
