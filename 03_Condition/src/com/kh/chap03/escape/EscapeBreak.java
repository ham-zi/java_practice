package com.kh.chap03.escape;

import java.util.Scanner;

public class EscapeBreak {
	Scanner sc = new Scanner(System.in);
	
	public void checkId() {
		System.out.println("회원가입 서비스입니다.");
		while(true) {
			System.out.println("아이디를 입력해주세요 (10글자 이하)");
			String userId = sc.nextLine();
			
			if(0<userId.length() && userId.length()<=10) {
				System.out.println("사용 가능한 아이디입니다.");
				break;
			}else{System.out.println("다시 입력해 주세요.");}
		}
	}
	
}
