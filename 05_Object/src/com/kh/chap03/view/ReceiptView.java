package com.kh.chap03.view;

import java.util.Scanner;

import com.kh.chap03.model.vo.Receipt;

public class ReceiptView {

	
	public void mainMenu( ) {
		Scanner sc = new Scanner(System.in);
		Receipt r = new Receipt();
		System.out.println("----- 영수증 출력 -----");
		//객체 생성과 동시에 입력버퍼와 스캐터에 통로가 생김
		// 통로는 GC가 제거하는가??
		// 특별한 일이 있지 않는 한 사라짐
		// but 통로가 열려있는 상태가 될 수 있음
		// 데이터 누수, 데이터 꼬임 문제 발생 가능성 증가
		// 이 통로는 닫는 메서드가 존재
		// Scanner객체.close()
		
		// Receipt r // new Receipt();
		// 참조자료형   // 객체(Object) ==> 추상적인 개념
		// instance ==> 실제 메모리에 올라간 데이터
		/*1. 참조 자료형
		 * 클래스를 만드는 행위 == 개발자가 자신에게 필요한 사용자 정의 자료형을 만드는 행위
		 * 2. 여러 자료형에 각각 여러개의 값을 보관 가능 + 기능
		 */ 
		
		
		System.out.println(r.info());
		
		
		
		
		sc.close();
	}
}
