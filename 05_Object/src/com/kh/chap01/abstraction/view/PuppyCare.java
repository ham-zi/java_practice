package com.kh.chap01.abstraction.view;

import java.util.Scanner;

import com.kh.chap01.abstraction.model.vo.Puppy;

public class PuppyCare {
	Puppy puppy = new Puppy();
	//사용자에게 강아지의 정보를 입력받아서
	// 입력받은 강아지의 정보를 출력해주고
	// 강아지와 함께 놀아줄수있는 프로그램

	public void run( ) {
		System.out.println("🐕‍🦺강아지 다마고치‍");
		Scanner sc = new Scanner(System.in);
		System.out.print("강아지 이름이 뭐에요?");
		puppy.name = sc.nextLine();
		System.out.print("강아지 종이 뭐에요?");
		puppy.species = sc.nextLine();
		System.out.print("강아지 몇 살이에요?");
		puppy.age = sc.nextInt();
		System.out.print("강아지 몸무게 몇이에요??");
		puppy.weight = sc.nextInt();
		
		while(true) {
			
			System.out.println("----------------");
			System.out.println(puppy.name+"의 정보");
			System.out.println("종: "+ puppy.species);
			System.out.println("나이: "+ puppy.age);			
			System.out.println("몸무게:"+ puppy.weight);			
			System.out.println("----------------");
			
			System.out.println("메뉴를 선택해주세요");
			
			
		}
		
	}
	
}
