package com.kh.controller;

import java.util.InputMismatchException;
import java.util.Scanner;

public class UncheckedException {

	/*
	 * RuntimeException
	 * 
	 * NullpointerExcepiton : 주소 값이 있을거라 예상하고 객체를 참조했더니 null값이 들어있었다
	 * ArrayIndexOutOfBoundsException : 배열의 부적절한 인덱스로 접근했을 때 발생하는 예외
	 * arithmeticException : 나누기 연산을 0으로 나무녀 발생하는 예외 InputTypeMissMatchException :
	 * 입력버퍼의 값이 자료형과 일치하지 않을 때 발생하는 예외 ... ↑ * 개발자가 예측이 가능함
	 * 
	 * 
	 * ClassCastException : 허용할 수 없는 형변환을 진행할 경우 발생하는 예외
	 * 
	 * ArithmeticException
	 * 
	 */

	// 문제의 원인을 원천차단하는 방법
	public void divZero() {
		Scanner sc = new Scanner(System.in);
		System.out.println("나누기 프로그램입니다.");
		System.out.print("첫번째 숫자를 입력해주세요 >");
		int x = sc.nextInt();
		System.out.print("두번째 숫자를 입력해주세요 >");
		int y = sc.nextInt();
		/*
		 * if (y != 0) { System.out.println("연산 결과" + (x / y)); }else {
		 * System.out.println("0은 나누기 연산을 수행할 수 없습니다."); }
		 */
		try {
			System.out.println("연산 결과 : " + (x / y));
		} catch (ArithmeticException e) {
			System.out.println("두 번째 정수에 0을 입력하시면 나눌 수 없습니다.");
		}

		sc.close();
	}

	public void code() {
		Scanner sc = new Scanner(System.in);
		while (true) {
			System.out.println("메뉴를 선택해주세요");
			System.out.println("1. 추가하기");
			System.out.println("2. 삭제하기");
			System.out.println("3. 종료하기");
			System.out.println("숫자를 입력해주세요.");
			int menu = 0;
			try {
				menu = sc.nextInt();
			} catch (InputMismatchException e) {
				System.out.println("잘못 입력하셨습니다.");
			}
			sc.nextLine();
			System.out.println(menu + "번 메뉴를 선택하셨습니다.");

		}
	}

	public int multiCatch() {

		// 정수 입력 받고
		// 100을 리터럴로 나눈 결과를 출력

		Scanner sc = new Scanner(System.in);
		// System.out.print("정수를 입력해주세요 >"); int
		/*
		 * num=0; try { num = sc.nextInt(); //자료형이 int형이 아닌 값이 들어올 시
		 * InpuMismatchException 발생 } catch(InputMismatchException e) {}
		 * 
		 * System.out.println("결과 :"+ (100/num)); // num에 대입된 값이 0일시
		 * ArithmeticException이 발생 sc.close();
		 */
		try {
			int num = sc.nextInt();
			return (100 / num);
		} catch (InputMismatchException e) {
			System.out.println("숫자값을 입력해주세요.");
			return 0;
		} catch (ArithmeticException e) {
			System.out.println("0이 아닌 정수값을 입력해주세요.");
			return 0;
		} finally { // 리턴하기 직전 무조건 finally 블럭을 수행
			sc.close();
		}
	}

	public void orderByCatch() {
		// 배열에서 runtimeException 자주 발생

		// 사용자에게 정수값을 입력받고
		// 입력받은 만큼의 크기를 가진 배열을 생성 및 할당하고
		// 이 배열의 100번째 인덱스에 대입되어 있는 기본값을 출력
		// NegativeArraySizeException : 배열의 크기를 음수로 할당하려고 하면
		// ArrayIndexOutOfBoundsException : 배열의 크기보다 큰 인덱스에 접근
		// NullPointerException
		Scanner sc = new Scanner(System.in);
		System.out.println("배열의 크기를 입력 >");
		try {
			int arrSize = sc.nextInt();
			int[] arr = new int[arrSize];
			System.out.println(arr[100]);
		} catch (NullPointerException e) {
			System.out.println("아무것도 입력하지 않으셨습니다.");
		} catch (InputMismatchException e) { // 1
			System.out.println("숫자를 입력해주세요.");
		} catch (ArrayIndexOutOfBoundsException e) { // 2
			System.out.println("숫자 101 이상을 입력해주세요.");
		} catch (NegativeArraySizeException e) {
			System.out.println("양수를 입력해주세요.");
		} finally {
			sc.close();
		}

		try {
			int arrSize = sc.nextInt();
			int[] arr = new int[arrSize];
			System.out.println(arr[100]);
		} catch (ArrayIndexOutOfBoundsException e) {
			System.out.println("숫자 101 이상을 입력해주세요.");
		} catch (RuntimeException e) {
			// 개발단계에서만 사용!!!!
			e.printStackTrace();
			System.out.println("예외상황 확인");
		} finally {
			sc.close();
		}

	}

}
