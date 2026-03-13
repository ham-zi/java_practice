package com.kh.first; // 패키지 선언부 : 현재 클래스의 위치

/* 	주석의 목적
	> 코드를 작성 한 후 작성한 코드를 쉽게
	주석의 종류
	1. 한 줄 주석 (//) : 작성한 내용이 한 줄 일 때 사용
	  "//" 이후부터 행의 끝까지 모든 내용을 주석으로 간주
	2. 여러 줄 주석(\*~~~~*\) : 작성할 내용이 여러 줄일때 사용
*/	

/*
 * 패키지(package)
 * 
 * 소스코드를 작성할 때, 클래스를 만들어서 작업하는데
 * 모든 클래스들을 동일한 패키지에 생성하여 관리하면 복잡하기 때문에
 * 클래스들을 용도에 맞게 구분해서 패키지에 보관하는 것을 권장!
 * 
 * 패키지는 적어도 세 단계 이상으로 만들어주는 것을 권장함.
 * ex) com.kh.first
 * com.(회사이름).(프로젝트이름/팀이름/카테고리이름/도메인이름)
 * 
 */

/*  { Scope / Block }
 Scope는 복합문을 구성하는 요소, 종속된 문장이 여러 줄 일 때 '{'로 시작하고 '}'로 닫습니다.

* main method : 프로그램의 시작점(Entry Point), 프로그램 당 1개는 있어야함
* 
* method : 하나의 기능 단위
* 
* build(컴파일)가 끝낸 파일, 실행 가능한 파일을 프로그램이라고한다.
* 
*/

public class HelloWorld { //예약어 == keyword
	
	public static void main(String[] args) {
		
		System.out.print("HelloWrold\n");
		printMyName();
		
	}

	public static void printMyName() {
		System.out.println("안녕하세요. 제 이름은입니다. 반갑습니다.");
	}
	
}
