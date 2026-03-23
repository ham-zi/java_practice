package com.kh.chap02.loop;

import java.util.Scanner;

public class LoopFor {

	Scanner scan = new Scanner(System.in);
	
	public void method1() {
		for(int i = 1; i <= 3; i++) {
			System.out.println(i + "번 반복");
		}
	}
	
	public void method2() {
		for(int i = 1; i<=9; i++) {
			for(int j = 1; j<=9; j++) {
				System.out.println(i+"*"+j+"="+i*j);
			}
		}
	}
	public void method3() {
		System.out.println("숫자를 입력해주세요.");
		int num = scan.nextInt();
		System.out.println(num+"단을 출력하겠습니다.");
		for(int j = 1; j<=9; j++) {
			System.out.printf("%1$d * %2$d = %3$d\n", num,j,num*j);
		}
	}
}
