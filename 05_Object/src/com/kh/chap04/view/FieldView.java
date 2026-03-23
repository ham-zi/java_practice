package com.kh.chap04.view;

import com.kh.chap04.controller.FieldController;

public class FieldView {

	public void check() {
		FieldController fc = new FieldController();
		
		fc.global = 1;
		int globalInt = fc.global;
		
		// static변수를 제거하려면, 객체를 Null로 변경해라.
		fc = null;
		
		
		// 생성시점 : static 필드 호출 시점, Metaspace(static)에 올라감
		// class loader 
		
		// 소멸시점 : 프로그램이 종료되면 소멸 => classLoader를 GC가 소멸시키는 시점
		
		// static 키워드는 공유의 목적이 강하다.
		
		// final과 함께 쓴다. 상수
		
		//무조건 선언과 동시에 초기화를 진행 해야함./
		// 기울어지면 static 
		// 파란색 필드
		// 볼드채 final
		
		System.out.println();
		
		
		// AccessModifier (접근제한자 / 접근제어자)
		/*
		 * public => 어디서든 (같은 패키지,  다른패키지,  클래스 내/외부 포함) 접근 가능
		 * 
		 * protected => 같은 패키지라면 무조건 접근 가능
		 * 			 => 다른 패키지라면 특정 조건( 상속 구조인 클래스에서만 접근 가능 )
		 * 
		 * default(package friendly) => 같은 패키지내에서 접근 가능
		 * 
		 * private => 오직 클래스 내부에서만 접근 가능
		 */
	}
	
}
