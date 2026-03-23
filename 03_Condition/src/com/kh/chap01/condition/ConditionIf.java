package com.kh.chap01.condition;

import java.util.Objects;
import java.util.Scanner;

public class ConditionIf {
	Scanner sc = new Scanner(System.in);
	
	
	
	public void IfExample() {

		System.out.println("정답을 입력해주세요 O/X");
		
		char answer = sc.nextLine().charAt(0);
		
		if(answer == 'o' || answer =='O') {
			System.out.println("정답입니다.");
		}
		if(answer == 'x' || answer =='X') {
			System.out.println("오답입니다.");
		}
	}
	
	
	public void isFoxQuestion() {
		System.out.println("문제: 여우는 개과일까요?");
		System.out.println("정답을 입력해주세요 O/X");
		
		char answer = sc.nextLine().charAt(0);
		
		if(answer == 'O' || answer =='o') {
			System.out.println("정답입니다.");
		}
		if(answer == 'X' || answer =='x') {
			System.out.println("오답입니다.");
		}
		
	}
	
	public void ex() {
		/*
		 * String user = "이다산";
		 * 
		 * String name = ( user != null ) ? user : "Guest";
		 * 
		 * 
		 * String title = (post.getTitle() != null) ? post.getTitle : "";
		 * 
		 */
				// Null 방어 코드
		int a = (int) (Math.random()*100)+1;
		int b = (int) (Math.random()*100)+1;
		String c = null;
		String d = "호호";
				 // 값 선택
		int max = (a>b) ? a:b;
		String print = (a>b) ? "a" : "b" ;
		System.out.println(print+","+ max);
		
		
				//기본 값 설정
				/*
				 * int price = product.getPrice() > 0 ? product.getPrice() : 1000;
				 * 
				 * String phone = (user.getPhone( !=null ) ? user.getPhone() : "없음";)
				 */
		
		
		System.out.println(c);
		Objects.equals(c, d);
		
	}
	
}
