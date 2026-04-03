package com.kh.controller;

import java.util.Arrays;
import java.util.StringTokenizer;

public class StringController {

	
	public void method01() {
		String abc = "abc"; //4byte??? 주소값이 4byte라서 들어가는 메모리는 무한하다?
		//문자열을 담을수있는 클래스를 만들었다 String
		
		new String();
		String str1 = new String("hello");
		String str2 = new String("hello"); //toString();
		// 1. String 클래스의 toString()의 경우
		// 실제 담겨있는 문자열 value값을 반환하게 끔 오버라이딩
		
		
		// equals()
		System.out.println(str1.equals(str2)); 
		// true << 주소 값이 같다??
		// 스트링클래스에서 equlas를 오버라이딩했다
		// 그래서 문자열의 동등비교가 가능해진다.
		
		
		//Object는 모든 클래스의 조상
		//매개변수 자료형에 Object를 해서 무슨 값이든 받을 수 있게한다.
		System.out.println(str1.hashCode());
		System.out.println(str2.hashCode());
		System.out.println("hello".hashCode());
		// 똑같은 값을 해슁해서 같은 값이 나온거다.
		// -> 문자열을 
		// 자바는 해쉬충돌에 취약하다
		// 만들수있는가지수가 4byte밖에 없기 때문.
		
		//String의 hashcode는 주소값을 해싱하는것이 아니라 실제 담긴 문자열값을 기반으로 해싱을 돌리도록 오버라이딩
		// System. identityHashCode(참조형변수)
		System.out.println(System.identityHashCode(str1));
		System.out.println(System.identityHashCode(str2));
		System.out.println(str1 == str2);
		// 다름을 알 수 있다.
		
	}
	
	public void method2() {
		
		String str3= "hello";
		String str4= "hello";
		
		//toString()
		System.out.println(str3);
		System.out.println(str4);
		
		//equals()
		System.out.println(str3.equals(str4));
		
		//hashCode()
		System.out.println(str3.hashCode());
		System.out.println(str4.hashCode());
		
		// identityHashCode()
		System.out.println(System.identityHashCode(str3));
		System.out.println(System.identityHashCode(str4));
		
		// 익명클래스가 사용되어 ??	
	}
	
	public void method3() {
		//어찌하여 다른 가?
		
		String str1 = new String("hello"); //절대 금지
		String str2 = "hello";
		
		//String자료형의 대입연산자를 통해서 StringPool이라는 저장공간에 byte형배열을 집어 넣는다.
		//JVM유일한 공간
		//문자열 리터럴은 대입연산자를 사용해 대입할 때
		// StringPool에서 동일한 문자열이 있는지 없는지 찾고
		// 없으면 올린다.
		// 있으면 주소값만 얕은복사한다
		// StringPool : 동일한 내용의 문자열 value가 존재할 수 없음
		// -> 효율적인 메모리 사용
		System.out.println(System.identityHashCode(str2));
		str2 += "bye";		
		System.out.println(System.identityHashCode(str2));
		System.out.println(str2);
		//새로운 객체를 만들고 그 객체를 반환한듯
		
		String a = "a";
		// 객체를 만드는건 매우 비효율적인 메모리 사용이다
		// String을 어떻게 해야 효율적으로 사용할 수 있을까?
		
		
		//그럼 힙영역에 StringPool의 값들은 언제까지 저장되는가
	
	}

	public void method4() {
		
		StringBuffer sb = new StringBuffer();
		String str = "Hello" + "World";
		sb.append("Hello");
		sb.append("World");
		System.out.println(sb);
		
		// 버퍼는 임시저장공간
		// 문자열은 불변객체라서 내용물 변경이 일어나면 계속 새로운 공간을 할당해서 올릴것
		// 이를 해결하기 위해 임시공간(Buffer)를 준비해서 임시공간에 차곡차곡 담았다가 한번에 처리하는 클래스
		
		StringBuilder sr = new StringBuilder();
		sr.append("Hello");
		sr.append("World");
		System.out.println(sr);
		
		
		//똑같은 기능?
		//차이점은? 
		// 동시 제어 기능 구현(Thread-safe)
		// Thread t;
		// Tomcat, Jetty -> 서버들에서 제공이 많이 되고 있음
		// 충돌날 위험이 없으면 굳이 구현할 필요가 없음
		// StringBuffer에는 동시제어기능을 구현되어 있다.
		// StringBuilder를 쓰면 조금더 빠르기 때문에 동시제어기능이 필요없을 때 많이 사용된다.
		// 코드를 사용할 때 목적이 있어야한다.
		
	}
	
	public void method5() {
		
		String str1 = "은총알은 없다"; // 딱 맞는 정답은 존재하지 않는다.
		
		// 1. 문자열.length() : int
		// -> 문자열의 길이를 반환
		System.out.println("str의 길이" + str1.length());
		// 아이디 8~20자 조건걸기
		String userId = "테스트용문자자자";
		if(8 <= userId.length() && userId.length() <= 20) {
		}else {throw new RuntimeException("아이디 글자 수를 확인");}
		
		
		// 2. 문자열.charAt() : char
		char ch = userId.charAt(0);
		System.out.println(ch);
		
		
		// 3. 문자열.substring(int beginIndex) : String
		String phoneNumber = "010-1234-5678";
		String phoneNumber1 = "010-1234";
		System.out.println(phoneNumber.substring(4)); // 4칸 이후 부터
		System.out.println(phoneNumber.substring(4,9)); // 4칸 이후 부터 8칸까지
		//인덱스의 번호를 시작점에 둬라.. 권장사항! 
		
		// 4. 문자열.indexOf(String) : int // substring과 indexof 는 세트다.
		System.out.println(str1.indexOf("없다"));
		//시작되는 인덱스값을 반환해준다.
		
		
		//5. kim@kh.co.kr
		String[] email = {"hong@kh.com", "kim@kh.com", "lee@kh.com", "hahaha@kh.com"};
		for(String s : email) {
			System.out.println(   s.substring(0, s.indexOf("@") ));
		}
		
		// 파일업로드 이미지업로드
		String fileName = "fsfsfsfs.jpg";
		System.out.println(fileName.substring(fileName.indexOf(".")+1));
		// 어떻게 +1이 가능한가? substring(int beginIndex ) <<< int형이라 +1이 가능하다
		
		String fileName2 = "sd.sd.sd.sd.sd.sd.png";
		//.이 중간에 석여있다 이건 어떻게 해결할까?
		System.out.println(fileName2.substring(fileName2.lastIndexOf(".")+1));
		// lastIndexOf()!!
		
		
		// 6. 문자열.toCharArray() : char[]
		String char1 = "배열로만들문자열";
		char[] char2 = char1.toCharArray();
		for(char c: char2) {
			System.out.print(c);
		}
		
		for(int i=0; i< char2.length; i++ ) {
			System.out.print(char2[i]);
		}
		
		
		// 7. char[] -> String
		System.out.println();
		System.out.println(String.valueOf(char2));
		
		
		
		// 8. 문자열.replace(str) : String
		String replaceStr = "KH 아카데미";
		System.out.println(replaceStr.replace("KH", "더조은"));
		System.out.println(replaceStr);
		
		
		// 9. 문자열.toUpperCase() -> 모든 문자열 대문자로 변환
		//		   .toLowerCase() -> 모든  문자열 소문자로 변환
		String lowerStr = "asdf";
		String upperStr = "ASDF";
		System.out.println(lowerStr.toUpperCase());
		System.out.println(upperStr.toLowerCase());
		
		/*
		 * String str1 = "11, 22, 33, 44";
		 * String str2 = "22, 44, 66, 88";
		 * 
		 */
		
		// 문자열 분리시키기
		String split = "갈비,갈비찜,곽만근갈비찜,곽만근얼큰갈비탕";
		
		String[] galubi = split.split(",");
		System.out.println(Arrays.toString(galubi));
		
		
		// (java.util.)StringTokenizer 클래스 이용하는 방법
		StringTokenizer stn = new StringTokenizer(split,",");
		System.out.println(stn.nextToken());		   
		System.out.println(stn.nextToken());		   
		System.out.println(stn.nextToken());		   
		System.out.println(stn.nextToken());		   
 //		System.out.println(stn.nextToken());		   
// -> NoSuchElementException 발생
// 해결 -> 반복문을 써야한다. 반복횟수를 모르니까 while문을 한다
		while(stn.hasMoreTokens()) {
			System.out.println(stn.nextToken());
		}
		
		
	}
	
	
}
