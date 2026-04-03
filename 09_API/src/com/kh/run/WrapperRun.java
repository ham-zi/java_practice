package com.kh.run;

public class WrapperRun {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		// Wrapper Class
		// => 기본 자료형을 참조자료형으로 포장해주는 클래스를 뢔퍼클래스라고 함
		//
		// 기본 자료형 (8개)
		/*
		 * boolean => Boolean
		 * char => Character
		 * byte => Byte
		 * short => Short
		 * Int => Integer
		 * long => Long
		 * float => Float
		 * double => Double
		 * 
		 */
		
		/*
		 * 언제 쓰는가?? 
		 * 1. 참조 자료형으로 바꿔 써야하는 경우
		 * 
		 * 2. 기본 자료형을 객체로 취급해야 하는 경우
		 * 
		 * 3. 다형성을 적용해야하는 경우
		 * 
		 * 4. 매개변수 자료형이 기본자료형은 못받는 경우
		 * 
		 * 5. Null인지 0인지 확인하는 경우 <<< 주요
			// 상품을 담는 클래스
			// int count;
			// 조회하면 0개
			// null인지 0개인지 알수가 없다
			// 상품이 있는지 없는지 알수없다
		 * 
		 *	int a = 1;
		 *	String str = "a";
		 *	str.equals(a);
		 *
		 * 이거로 형변환이 되나?
		 * 
		 */
		
		int num1 = 10;
		int num2 = 15;
		/*
		 * Integer i1 = new Integer(num1); // deprecated System.out.println(i1);
		 */
		Integer i1 = num1;
		Integer i2 = num2;
		System.out.println(i1.equals(i2));
		System.out.println(i1.compareTo(i2)); // 정렬할때 쓰임
		// a.compareTo(b);
		// a가 b보다 크면 1을 반환
		// a가 b보다 작으면 -1을 반환
		// 같으면 0을 반환

		// 문자열로 받은 숫자를 연산할 때
		// 파싱(parsing) == 특정 데이터를 규칙에 따라 분석하고 해석하는 과정
		/* 형변환과는 다르고 해석한다 (수학언어임)
		 */
		String str1 = "11";
		String str2 = "1.1";
		int i = Integer.parseInt(str1);
		
		String intNum = String.valueOf(i);
		
		
		
	}

}
