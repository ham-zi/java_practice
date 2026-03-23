package com.kh.variable;

import java.util.Scanner;

/*
Scanner scan = new Scanner(System.in);
} System.in : 표준입력도구에서 입력하는 값들을 받겠음 (바이트 단위)
*/
// . 직접 접근 연산자
// = 대입 연산자
// 변수명 식별자
// buffer : 임시저장공간
// 파싱 : 입력을 읽어 의미 있는 단위로 분해하고, 그 구조를 정리해
//		 컴퓨터가 이해하기 쉬운 형태로 만드는 과정
public class OrderService {
	
	Scanner scan = new Scanner(System.in);
	
	public void printMenu() {
		System.out.println("피자헛에 오신걸 환영합니다.");
		System.out.println("-----피자헛 메뉴판-----");
		System.out.println("1. 치즈/페페로니 피자");
		System.out.println("2. 블랙 BBQ 스테이크 뇨끼 피자");
		System.out.println("3. 이재모 피자");
		System.out.println("-------------------");
	}
	
	public void order() {
		System.out.println("메뉴를 선택해주세요. 번호/메뉴이름 >");
		String selectMenu1 = scan.nextLine();
		System.out.println(selectMenu1+"를 몇 판 주문하시겠습니까? >");
		int selectCount1 = scan.nextInt();
		System.out.println(selectMenu1+"을(를) "+selectCount1+"개 선택하셨습니다.");
	}
	
	
	public void delivery() {
		System.out.println("주소를 입력해주세요 >");
		String inputAddress = scan.nextLine();
		System.out.println(inputAddress+"로 배달합니다.");
	}
	
	
	public static void main(String[] args) {
		/*
		* 자바에서 제공해주는 Scanner라는 클래스 사용
		* Scanner라는 클래스에 존재하는 메소드를 호출해서 입력받을 수 있다.
		*/
		
		
		

	}
}
