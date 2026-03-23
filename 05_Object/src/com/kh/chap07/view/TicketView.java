package com.kh.chap07.view;

import java.util.Scanner;

import com.kh.chap07.model.vo.Ticket;

public class TicketView {
	// 화면에 메인메뉴를 출력해주는 메소드
	private Scanner sc = new Scanner(System.in);
	// Scanner도 private로 걸어둔다... 오.....
	public void mainMenu() {
		// 티켓추가하기, 추가된 티켓발급해주기
		while (true) {
			System.out.println("---티켓발급페이지---");
			System.out.println("1. 티켓 추가하기");
			System.out.println("2. 티켓 발급받기");
			System.out.println("3. 프로그램 종료");
			System.out.println("번호 입력 >");
			String menuNum = sc.nextLine();
			System.out.println(menuNum);

			switch (menuNum) {
			case "1": saveView(sc);
				System.out.println("티켓 추가했습니다.");
				break;
			case "2":
				System.out.println("티켓 발급했습니다.");
				break;
			case "3":
				System.out.println("프로그램을 종료합니다.");
				sc.close();
				return;
			default:
				System.out.println("번호를 잘못입력하셨습니다.");
			}
		}
	}
	
	//티켓을 추가할 수 있는 화면을 출력해주는 기능
	private void saveView(Scanner sc) {
		
		System.out.print("티켓 가격을 입력해주세요>");
		int price = sc.nextInt();
		sc.nextLine();
		System.out.print("기내식을 입력해주세요 >");
		String meal = sc.nextLine();
		System.out.print("좌석번호를 입력해주세요 >");
		String seatNumber = sc.nextLine();
		System.out.print("목적지를 입력해주세요 >");
		String name = sc.nextLine();
		
		Ticket ticket = new Ticket(name, price,meal,seatNumber);
		System.out.println(ticket.info());	
	}
	
	
	
}
