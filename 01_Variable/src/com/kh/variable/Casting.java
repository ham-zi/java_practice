package com.kh.variable;

public class Casting {
	
	/*
	 * Type Casting(자료형 변환 / 형변환) **매우 중요** 
	 * 
	 * 자료형을 바꾸는 개념
	 * 
	 * ☆자바에서 값을 처리하는 규칙☆
	 * 
	 * 1.=(대입 연산자)기준으로 왼쪽=오른쪽이 같은 자료형이어야 한다.
	 *  => 같은 자료형에 해당하는 리터럴값만 대입할 수 있음.
	 *  => 자료형이 다를 경우? => 값을 바꿔서 대입해야 함.
	 *  
	 * 2. 같은 자료형들끼리만 연산이 가능함
	 *  => 둘 중 하나를 "형변환"해서 맞춰야 한다. 
	 * 
	 * 3. 연산의 결과물도 동일한 자료형
	 *  => 3 + 7 = 10(정수), 1.1 + 3.3 = 4.4(실수)
	 *  
	 *  [ 표현법 ] () 값;
	 *  형변환연산자 / cast연산자
	 *  
	 *  형변환의 종류
	 *  
	 *  1. 자동형변환(Promotion)
	 *  
	 *  작은 크기의 자료형 -> 큰 크기의 자료형
	 *  -> 직접 형변환을 할 필요가 없음
	 *  -> 대입연산자가 실행되기 전에 자동형변환이 된다.
	 *  
	 *  2. 강제형변환,명시적형변환(Type Casting)
	 *  -> 직접 형변환을 해야 할 때 (자료형)식별자
	 *  
	 *  boolean 1byte
	 *  char 2byte
	 *  byte 1byte short 2byte int 4byte long 8byte
	 *  float 4byte double 8byte
	 *  
	 *  
	 *  3. long(정수,8byte) -> float(실수, 4byte) *특이케이스*
	 *  왜 가능할까?
	 *  float(4byte)가 long(8byte)보다 표현할 수 있는 값의 범위가 넓기 때문이다.
	 *  long 100000000000000000L == float 1.0E16
	 *  
	 *  4. char(2byte,문자) -> int(4byte, 정수)
	 *    'a' + 3 => 100 // char문자형은 인트랑 연산이 된다. 
	 *    'a' + '3' => 148 // char문자형과의 연산도 연산이 가능하다.
	 *    
	 */
	
	public void autoCasting() {
		
		/*
		 * String bool = "boolean : 1byte"; String c = "char : 2byte"; String b =
		 * "byte : 1byte"; String s = "short : 2byte"; String i = "int : 4byte"; String
		 * l = "long : 8byte"; String f = "float : 4byte"; String d = "double : 8byte";
		 * 
		 * System.out.println(bool); System.out.println(c); System.out.println(b+s+i+l);
		 * System.out.println(f+d);
		 */
		
		int num = 7;
		long longNum = 10000000000000000L;
		System.out.println(num);
		double doubleNum = num;
		char ch = 'a';
		
		
		int bigNum = 120;
		long smallLong = (long)bigNum;
		float floatNumber = longNum;
		int charNum = ch;
		System.out.println(floatNumber == longNum);
		System.out.println(charNum);
	}
}
