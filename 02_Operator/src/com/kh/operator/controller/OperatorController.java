package com.kh.operator.controller;

import java.util.Scanner;

public class OperatorController {
	// Scanner scan = new Scanner(System.in);

	public void arithmetic() {

		// 산술연산자
		// +, -, *, /

		int num1 = 10;
		int num2 = 3;

		System.out.println("num1+num2 : " + num1 + num2);
		/*
		 * // -> 연산이 앞에서부터라서 num1+num2 : 103이 나온다. 해결방법 1. 새로운 변수 sum 2. printf 3.
		 * 소괄호(num1 + num2)
		 */
	}

	public void presentToStudent() {
		/*
		 * System.out.println("나눠줄 학생의 수 >"); int studentCount = scan.nextInt();
		 * System.out.println("사탕 개수"); int candyCount = scan.nextInt();
		 * 
		 * System.out.println("1인당 받을 수 있는 사탕의 개수 :" + (candyCount / studentCount) +
		 * "개"); System.out.println("남은 사탕의 개수 :" + (candyCount % studentCount) + "개");
		 */
	}

	public void comparison() {

		/*
		 *
		 * 관계 연산자(비교연산자) 두 개의 값을 가지고 비교하는, 이항 연산자 비교연산을 한 결과 -> true, false 특정 조건을 제시할 수
		 * 있는 조건문에서 조건식으로 사용할 것
		 * 
		 */

		int firstNumber = 10;
		int secondNumber = 25;

		System.out.println(firstNumber < secondNumber);
		System.out.println(firstNumber == secondNumber);
		System.out.println(firstNumber > secondNumber);

		/*
		 * 
		 * 논리 연산자 : 두 개의 논리값을 연산하는 연산자 [ 표현법 ] 논리값 논리연산자 논리값 => 논리값
		 * 
		 * 종료
		 * 
		 * 1. AND 연산 2. OR 연산
		 * 
		 * || &&
		 */

		// 1. 사용자에게 한 개의 정수값을 입력받음
		// 2. 입력한 정수 값이 0보다 크면서 짝수인지 판별
		//
		Scanner scan = new Scanner(System.in);
		System.out.println("숫자 입력:");
		int x = scan.nextInt();
		boolean result = (x > 0) && (x % 2 == 0);
		System.out.println(result);
	}

	public void andOper() {
		// 사용자에게 정수값을 하나 입력받아서
		// 입력받은 정수값을 변수에 대입한 뒤
		// 콘솔창에 출력해보세요.
		Scanner scan = new Scanner(System.in);
		System.out.println("숫자를 입력하세요:");
		int x = scan.nextInt();
		int y = x;
		System.out.println("입력숫자 :" + y);
		System.out.println((1 <= y) && (y <= 10));

	}

	public void orOper() {
		Scanner scan = new Scanner(System.in);
		System.out.println("문자를 입력하세요");
		char letter = scan.nextLine().charAt(0);
		System.out.println(letter);
		boolean result = (letter == 'a') || (letter == 'A');
		System.out.println(result);
	}
	// short서치?

	/*
	 * 
	 * 삼항 연산자 : 피 연산자가 3개 => 3개의 값과 1개의 연산자 (조건문의 형식으로 쓰임)
	 * 
	 * [ 표현식 ] 조건식 ? 조건식이 true일 경우 결과값: 조건식이 false일 경우 결과 값
	 * 
	 */
}
