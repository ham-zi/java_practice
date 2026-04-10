package com.kh.view;

import java.util.Scanner;

import com.kh.controller.BoardController;
import com.kh.model.vo.User;

public class BoardView {
	BoardController bc = new BoardController();
	
	public void mainMenu() {
		Scanner sc = new Scanner(System.in);
		
		User user = loginMenu(sc);
		if(user != null) {
			boardMenu(sc, user);
		}
	}
	
	public User loginMenu(Scanner sc) {
		User user = null;
		while(true) {
			System.out.println("==================");
			System.out.println("로그인 서비스입니다.");
			System.out.println("1 : 로그인");
			System.out.println("2 : 회원가입");
			System.out.println("3 : 프로그램 종료");
			System.out.println("==================");
			
			System.out.println();
			System.out.print("메뉴 선택 >");
			String menuNum = sc.nextLine();
		
			switch(menuNum) {
			case "1" : 
				user = login();
				return user;
			case "2" :
				createUser();
				break;
			case "3" :
				sc.close();
				return user;
			default  :
				break;
			}
		}
	}
	public void boardMenu(Scanner sc, User user) {
		while(true) {
			System.out.println("===================");
			System.out.println("게시판 서비스입니다.");
			System.out.println("1 : 게시판 전체 목록");
			System.out.println("2 : 게시판 목록 검색");
			System.out.println("3 : 게시판 작성");
			System.out.println("4 : 게시판 삭제");
			System.out.println("5 : 프로그램 종료");
			System.out.println("===================");
			
			System.out.println();
			System.out.print("메뉴 선택 >");
			String menuNum = sc.nextLine();
			
			switch(menuNum) {
			case "1" : 
				selectAll();
				break;
			case "2" :
				findBoard();
				break;
			case "3" :
				createBoard();
				break;
			case "4" :
				updateBoard();
				break;
			case "5" :
				System.out.println("프로그램을 종료합니다.");
				sc.close();
				return;
			default  :
				break;
				
			}
		}
	}
	
	private User login() {
		
	}
	
	private void createUser() {
		
	}
	
	
	private void selectAll() {
		
	}
	
	private void findBoard() {
		
	}
	
	private void createBoard() {
		
	}

	private void updateBoard() {
		
	}
}
