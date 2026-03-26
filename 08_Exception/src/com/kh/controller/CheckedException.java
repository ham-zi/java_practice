package com.kh.controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class CheckedException {
/*
 * 
 * 
 * 
 * 
 * 
 */
	
	public void readString() {
		
		//사용자에게 문자열을 하나만 입력받아서
		//입력받은 문자열의 길이를 출력
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		
		try {String str = br.readLine();
		System.out.println("입력");
		method();
		System.out.println(str.length());
		} catch (IOException e) { //주로 외부매체 입/출력 시
			e.printStackTrace();//버퍼 << 임시저장공간
		}
		
	}
	
	
	private void method() throws IOException {
		System.out.println("위험한 코드");
		throw new RuntimeException("예외발생");
	}
	
	
}
