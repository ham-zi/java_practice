package com.kh.chap01.condition;

import java.util.Scanner;

public class ConditionElse {
	Scanner sc = new Scanner(System.in);

	public void method1() {

		System.out.println("핸드폰 번호 뒷자리를 입력해주세요 >");

		String phoneNum = sc.nextLine();
		String message = "등 당첨 축하드려요~!";

		if (phoneNum.equals("7777")) {
			System.out.println("1" + message);
		} else if (findSeven(phoneNum) == 3) {
			System.out.println("2" + message);
		} else if (findSeven(phoneNum) == 2) {

			System.out.println("3" + message);
		} else {
			System.out.println("다음 기회에...");
		}

	}

	public int findSeven(String phoneNum) {
		int Count = 0;
		if (phoneNum.charAt(0) == '7') {
			++Count;
		}
		if (phoneNum.charAt(1) == '7') {
			++Count;
		}
		if (phoneNum.charAt(2) == '7') {
			++Count;
		}
		if (phoneNum.charAt(3) == '7') {
			++Count;
		}
		return Count;
	}

	public void ageCheck() {
		System.out.println("나이를 입력해주세요.");
		int inputNum = sc.nextInt();
		if(inputNum>0) {
			if(1 <= inputNum && inputNum <= 12) {
				System.out.println("어린이입니다.");
			} else if(13 <= inputNum && inputNum <= 17) {
			System.out.println("청소년입니다.");
			} else if(18 <= inputNum ) {
			System.out.println("성인입니다.");
		}else{
			System.out.println("올바른 나이를 입력해주세요.");
		}
		
		
		}
	}
}