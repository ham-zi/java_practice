package com.kh.array;

import java.util.Arrays;
import java.util.List;

public class Array {

	public void method1() {

		/*
		 * 1. 배열 선언
		 * 
		 * 변수 선언 방법
		 * 
		 * 자료형 변수명;
		 * 
		 * 변수 선언 방법
		 * 
		 * 1) 자료형 배열명[]; 2) 자료형[] 배열명; -> 두번째 방법 채택율↑
		 * 
		 * 왼쪽과 오른족의 자료형이 같아야한다. 그래서 String[] names = []; 되는거구나?
		 * 
		 * 
		 * [ 표현법 ] int[] nums; nums = new int[5];
		 * 
		 * int[]arr = new int[5];
		 * 
		 * 배열은 참조 자료형이다.
		 * 
		 */

		int[] nums = new int[5];

		for (int i = 0; i <= 4; i++) {
			nums[i] = i + 1;
		}

		for (int i : nums) {
			System.out.println(i);
		}

		/*
		 * 기본자료형 :boolean, char
		 * 
		 * 
		 * 해시코드 : 주소값을 10진수(int형)형태로 나타낸 것
		 * 
		 * 
		 * Arrays.ToString(배열식별자) => 배열의 요소들을 예쁘게 출력해줌
		 * 
		 */

	}

	public void createLottoNumber() {

		int[] lottoNumber = new int[6];
		for (int i = 0; i <= 5; i++) {
			lottoNumber[i] = (int) (Math.random() * 45) + 1;
			System.out.println((i + 1) + "번째 숫자 :" + lottoNumber[i]);

		}

	}

	public void method4() {
		int[] lottoNumber = new int[6];
		for (int i = 0; i <= 5; i++) {
			lottoNumber[i] = (int) (Math.random() * 45) + 1;
			System.out.println((i + 1) + "번째 숫자 :" + lottoNumber[i]);

		}

		char[] love = new char[4];
		love[0] = 'l';
		love[1] = 'o';
		love[2] = 'v';
		love[3] = 'e';
		System.out.println(Arrays.toString(lottoNumber));

		System.out.println(love.hashCode());
		// char형의 기본값 '', 정수형의 기본값은 0 , 실수형의 기본값은 0.0
		// 주소가 같은지 확인해보려면? ****hashCode()****
		love = new char[5];
		System.out.println(love.hashCode());

		int[] arr = { 100, 200, 300 };

		// 자바의 자동 메모리 관리
		// 가리킴 -> 포인터
		// GC가 언제 지우는지 모름
		// love = null;
		// System.out.println(love.hashCode());
		// java.lang.NullPointerException
		// 배열 복사
		// ★★★☆☆☆얕은복사☆☆☆★★★
		//
		// 깊은복사
	}

	public void method6() {
		int[] origin = { 1, 3, 5 };
		System.out.println(Arrays.toString(origin));
		// ★★★☆☆☆얕은복사☆☆☆★★★
		// 같은 주소 값을 복사하기 때문에 가리키고 있는 대상이 같다.
		//int[] copy = origin; // 주소 복사
		//System.out.println(origin.hashCode());
		//System.out.println(copy.hashCode());
		//origin = null;
		//System.out.println(copy.hashCode());
		
		// 깊은 복사
		//언제 사용하는가?
		//더 큰 데이터를 포함하는 새 배열이 필요해서
		//큰 배열로 복사하는 경우가 많다.
		int[] copy2 = new int[10];
		// 네이밍컨벤션 == 클래스 / 인터페이스 == 첫글자가 대문자
		// System Arrays Object 클래스
		System.arraycopy(origin, 0, copy2, 0, 3);
		//arraycopy(원본배열명, 원본에서복사시작할인덱스, 카피배열명, 카피배열에서복사될인덱스,복사요소개수)
		System.out.println(Arrays.toString(copy2));
		int[] copy3 = Arrays.copyOf(origin, 15);
		// ArrayList<>()가 만들어지는 코드인가보다.
		
	}

}
