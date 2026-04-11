package com.kh.view;

import java.util.InputMismatchException;
import java.util.Scanner;


import com.kh.controller.BoardController;
import com.kh.controller.UserController;
import com.kh.exception.ExistIdException;
import com.kh.exception.ExistNumberException;
import com.kh.model.dto.UserDto;
import com.kh.model.vo.User;

public class BoardView {
	BoardController bc = new BoardController();
	UserController uc = new UserController();
	Scanner sc = new Scanner(System.in);
	public void mainMenu() {
		
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
				if(user != null) {
				return user;
				}
				break;
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
			System.out.println(user.getUserName()+"님 어서오세요,");
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
		System.out.println("로그인 서비스");
		System.out.print("아이디 입력 >");
		String id = sc.nextLine();
		System.out.print("비밀번호 입력 >");
		String pw = sc.nextLine();
		User user = uc.login(id, pw);
		if(user!=null) {
			return user;
		}
		System.out.println("ID 혹은 PW 잘못입력하셨습니다.");
		return null;
	}
	
	private void createUser() {
		System.out.println("회원가입 서비스");
		System.out.print("회원번호 입력 >");
		int num=0;
		try {
		num = sc.nextInt();
		sc.nextLine();
		} catch (InputMismatchException e) {
			System.out.println("회원번호는 숫자를 입력하세요.");
			sc.nextLine();
			return;
		}

		System.out.print("회원이름 입력 >");
		String name = sc.nextLine();
		System.out.print("아이디 입력 >");
		String id = sc.nextLine();
		System.out.print("비밀번호 입력 >");
		String pw = sc.nextLine();
		
		if(num<=0) {
			System.out.println("1이상의 숫자를 입력해주세요.");
			return;
		}
		if(name.isBlank() || id.isBlank() || pw.isBlank()) {
			System.out.println("정보를 꼭 입력하세요.");
			return;
		}
		
		UserDto dto = new UserDto(num, id, pw, name);
		//ene, eie 에러처리
		try {
		uc.createUser(dto);
		} catch (ExistIdException e) {
			System.out.println("ID중복입니다.");
			return;
		} catch (ExistNumberException e) {
			System.out.println("회원번호중복입니다.");
			return;
		}
		System.out.println("회원 가입에 성공하셨습니다.");
		
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
