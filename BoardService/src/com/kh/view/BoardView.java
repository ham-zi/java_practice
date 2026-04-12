package com.kh.view;

import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;


import com.kh.controller.BoardController;
import com.kh.controller.UserController;
import com.kh.exception.ExistIdException;
import com.kh.exception.ExistNumberException;
import com.kh.model.dto.BoardDto;
import com.kh.model.dto.UserDto;
import com.kh.model.vo.Board;
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
			System.out.println("2 : 게시판 제목 검색");
			System.out.println("3 : 게시판 작성");
			System.out.println("4 : 게시판 수정");
			System.out.println("5 : 게시판 삭제");
			System.out.println("6 : 프로그램 종료");
			System.out.println("===================");
			
			System.out.println();
			System.out.print("메뉴 선택 >");
			String menuNum = sc.nextLine();
			
			switch(menuNum) {
			case "1" : 
				selectAll();
				break;
			case "2" :
				findBoardByTitle();
				break;
			case "3" :
				createBoard(user);
				break;
			case "4" :
				updateBoard(user);
				break;
			case "5" :
				deleteBoard(user);
				break;
			case "6" :
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
			System.out.println("정보를 반드시 입력해주세요.");
			return;
		}
		
		UserDto dto = new UserDto(num, id, pw, name);
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
	
	private void createBoard(User user) {
		System.out.println("게시글 작성");
		System.out.print("게시글 번호 입력 >");
		String boardId = sc.nextLine();
		System.out.print("제목 입력 >");
		String title = sc.nextLine();
		System.out.print("내용 입력 >");
		String content = sc.nextLine();
		if(boardId.isBlank() || title.isBlank() || content.isBlank()) {
			System.out.println("정보를 반드시 입력해주세요.");
			return;
		}
		
		BoardDto dto = new BoardDto(boardId, user.getUserNo(), title, content); 
		try {
			Board board = bc.createBoard(dto);
			if(board == null) {
				System.out.println("게시판 작성에 실패했습니다.");
				System.out.println("관리자에게 문의하세요.");
				return;
			}
		}catch (ExistIdException e) {
			System.out.println("게시판 번호가 중복입니다.");
			return;
		}
		
		selectAll();
		
	}
	
	private void selectAll() {
		List<Board>list = bc.selectAll();
		printBoards(list);
	}
	
	private void findBoardByTitle() {
		System.out.println("게시글 제목 검색");
		System.out.print("게시글 제목 키워드 입력 >");
		String title = sc.nextLine();
		if(title.isBlank()) {
			System.out.println("키워드를 입력해주세요.");
		}
		List<Board>list = bc.findBoardByTitle(title);
		printBoards(list);
	}
	

	private void updateBoard(User user) {
		System.out.println("게시글 수정");
		System.out.println("내 게시글 목록");
		List<Board>list = bc.findMyBoards(user);
		if(list.isEmpty()) {
			System.out.println("존재하는 게시글이 없습니다.");
			return;
		}
		printBoards(list);
		System.out.println("----------------");
		System.out.println("수정 할 게시글 번호를 입력해주세요.");
		System.out.print("게시글 번호 >");
		String boardId = sc.nextLine();
		boolean isBoard = bc.isBoard(boardId);
		if(!isBoard) {
			System.out.println("해당 번호의 게시글이 없습니다.");
			return;
		}
		System.out.print("제목 > ");
		String title = sc.nextLine();
		System.out.print("내용 >");
		String content = sc.nextLine();
		BoardDto dto = new BoardDto(boardId, user.getUserNo(),title, content);
		Board board = bc.updateBoard(dto);
		if(board == null) {
			System.out.println("게시판 수정에 실패했습니다.");
			System.out.println("관리자에게 문의하세요.");
		}
		List<Board>afterList = bc.findMyBoards(user);
		printBoards(afterList);
	}
	
	
	private void printBoards(List<Board>list) {
		if(list.isEmpty()) {
			System.out.println("존재하는 게시글이 없습니다.");
		}
		
		list.stream()
		    .map(b -> "[ 게시판번호:" + b.getBoardId()
		    		 +", 제목:" + b.getTitle()
		    		 +", 유저번호:" + b.getUserNo()
		    		 +", 작성날짜:" + b.getWritedDate() +"]"
		    		 +"\n내용 => " +b.getContent())
		    .forEach(System.out::println);
	}
	
	private void deleteBoard(User user) {
		System.out.println("게시글 삭제");
		System.out.println("내 게시글 목록");
		List<Board>list = bc.findMyBoards(user);
		if(list.isEmpty()) {
			System.out.println("존재하는 게시글이 없습니다.");
			return;
		}
		printBoards(list);
		System.out.println("----------------");
		System.out.println("삭제 할 게시글 번호를 입력해주세요.");
		System.out.print("게시글 번호 >");
		String boardId = sc.nextLine();
		boolean isBoard = bc.isBoard(boardId);
		if(!isBoard) {
			System.out.println("해당 번호의 게시글이 없습니다.");
			return;
		}
		bc.deleteBoard(boardId);
		List<Board>afterList = bc.findMyBoards(user);
		if(afterList.isEmpty()) {
			System.out.println("존재하는 게시글이 없습니다.");
			return;
		}
		printBoards(afterList);
	
	}
}
