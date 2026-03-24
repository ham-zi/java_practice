package com.kh.chap07.view;

import java.util.Scanner;

import com.kh.chap07.controller.TicketController;
import com.kh.chap07.model.vo.Ticket;

public class TicketView {
	// 화면에 메인메뉴를 출력해주는 메소드
	private Scanner sc = new Scanner(System.in);
	private TicketController tc = new TicketController();

	// Scanner도 private로 걸어둔다... 오.....
	public void mainMenu() {
		// 티켓추가하기, 추가된 티켓발급해주기
		while (true) {
			System.out.println("---티켓발급페이지---");
			System.out.println("0. 티켓 전체조회하기.");
			System.out.println("1. 티켓 추가하기");
			System.out.println("2. 티켓 발급받기");
			System.out.println("3. 프로그램 종료");
			System.out.println("번호 입력 >");
			String menuNum = sc.nextLine();
			System.out.println(menuNum);

			switch (menuNum) {
			case "0":
				findAll();
				System.out.println("전체조회");
				break;
			case "1":
				saveView();
				System.out.println("티켓 추가했습니다.");
				break;
			case "2":
				printTicket();
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

	// 티켓을 추가할 수 있는 화면을 출력해주는 기능
	private void saveView() {

		System.out.print("티켓 가격을 입력해주세요>");
		int price = sc.nextInt();
		sc.nextLine();
		System.out.print("기내식을 입력해주세요 >");
		String meal = sc.nextLine();
		System.out.print("좌석번호를 입력해주세요 >");
		String seatNumber = sc.nextLine();
		System.out.print("목적지를 입력해주세요 >");
		String name = sc.nextLine();

		Ticket ticket = new Ticket(name, price, meal, seatNumber);
		System.out.println(ticket.info());

		// 등록된 티켓이 3장이 아니라면 -> 어딘가에 저장

		// 현재 뷰에서 객체를 생성하고, 그 객체들을 사용
		// 객체를 다른 클래스로 옮기는 방법

		// 객체에서 다른 객체로 값을 전달할 때는 메소드를 호출해서 넘겨주자!
		int result = tc.saveTicket(ticket);

		if (result == 1) {
			System.out.println(ticket.getName() + "티켓 등록 성공");
		} else {
			System.out.println("티켓 등록 실패");
		}

	}

	private void printTicket() {
		Ticket ticket = tc.printTicket();
		if (ticket != null) {
			System.out.println(ticket.getName());
		} else if (ticket == null) {
			System.out.println("티켓이 없습니다.");
		}
	}
	
	private void findAll( ) {
		Ticket[] tickets = tc.findAll();
		for(int i=0; i<tickets.length; i++) {
			if(tickets[i]!=null) {
				System.out.println(tickets[i].info());
			}
		}
		System.out.println("----------");
		
	}

}
