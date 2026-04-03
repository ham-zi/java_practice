package com.kh.sw.view;

import java.util.InputMismatchException;
import java.util.Scanner;

import com.kh.sw.controller.SwitchController;
import com.kh.sw.exception.SwitchBoomException;

// 오로지 입력 / 출력을 담당
public class SwitchView {
	private SwitchController controller = new SwitchController();
	private Scanner sc = new Scanner(System.in);

	public void menu() {
		
		System.out.println("LED등 스위치 프로그램 시작");
		while (true) { // 코드를 봤을 때 반복문이라는 것을 바로 인지할 수 있기 때문에 while을 사용
			System.out.println("----- 메뉴 선택 -----");
			System.out.println(" 1. 스위치 누르기");
			System.out.println(" 2. 프로그램 종료");
			System.out.println(" > ");
			int menuNo = 0;
			try {
				menuNo = sc.nextInt();
			} catch (InputMismatchException e) {
				System.out.println("메뉴번호(숫자)를 입력 해주세요.");
				continue; // 다시 while문을 처음부터 시작하기 위해서 사용
			} finally {
				sc.nextLine();
			}	
			
			switch(menuNo) {
			case 1 : toggleSwitch();
				break;
			case 2 : System.out.println("프로그램 종료"); sc.close(); return;
			default : System.out.println("정확한 메뉴번호를 입력해주세요.");
			}
			
		}
		
	}
	private void toggleSwitch() {
		boolean result; 
				
				try {result = controller.toggleSwitch();} catch(SwitchBoomException e) {
					System.out.println("도망");
					return;
				}
		if(result) {
			System.out.println("Turn On");
			return;
		} else {
			System.out.println("Turn Off");
			return;
		}
	}

}
