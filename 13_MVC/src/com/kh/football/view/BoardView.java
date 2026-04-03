package com.kh.football.view;

import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

import com.kh.football.controller.BoardController;
import com.kh.football.model.dto.BoardDto;
import com.kh.football.model.vo.Board;

public class BoardView {
	private BoardController bc;
	private Scanner sc = new Scanner(System.in);

	public BoardView(BoardController bc) {
		this.bc = bc;
	}

	public void boardMenu() {
		while (true) {
			System.out.println("\n\n");
			System.out.println();
			System.out.println("축구 게시판");
			System.out.println("1. 게시글 상세보기");
			System.out.println("2. 게시글 작성");
			System.out.println("3. 게시글 수정");
			System.out.println("4. 게시글 삭제");
			System.out.println("5. 축구메뉴로 돌아가기");
			System.out.println();
			System.out.print("메뉴 선택 >");
			String menu = sc.nextLine();

			switch (menu) {
			case "1": findById();
				break;
			case "2": saveBoard();
				break;
			case "3":
				updateBoard();
				break;
			case "4":
				deleteBoard();
				break;
			case "5":
				System.out.println("게시글 종료");
				return;
			default:
				System.out.println("메뉴를 다시 선택해주세요.");
			}

		}
	}

	private void findAll() {
		List<Board> boards = bc.findAll();

		if (boards.isEmpty()) {
			System.out.println("존재하는 게시글이 없습니다.");
			System.out.println();
		} else {
			System.out.println("=========================");
			boards.stream().map(b ->"  "+ b.getBoardNo() + " ||	" + b.getBoardTitle() + " || " + b.getBoardWriter()
					+ "	||	" + b.getCreateDate()).forEach(System.out::println);
			System.out.println("=========================");

		}
		// forEach(System.out::println)
		// Consumer<T> -> void 반환타입을 쓴 사례
		// :: << 이거 뭔지 어떻게 Ststem.out.println이 되는지
	}

	private void findById() {
		System.out.println();
		findAll();
		while (true) {
			System.out.print("상세 보기할 게시글 번호 입력 >");
			int boardNo = 0;

			try {
				boardNo = sc.nextInt();
				sc.nextLine();
			} catch (InputMismatchException e) {
				System.out.println("게시글 번호는 숫자만 입력 가능합니다.");
				sc.nextLine();
				return;
			}

			Board board = bc.findById(boardNo);
			// 원천차단
			if (board != null) {
				// 게시글 상세정보
				System.out.println("======================");
				System.out.println("\t" + board.getBoardNo() + "번 게시글");
				System.out.println("제목: " + board.getBoardTitle());
				System.out.print("저자: " + board.getBoardWriter());
				System.out.println(", 날짜: " + board.getCreateDate());
				System.out.println("----------------------");
				System.out.println("본문: " + board.getBoardContent());
				System.out.println("======================");
			} else {
				// board를 아예 참조를 안하기
				System.out.println("존재하지 않는 게시글 번호입니다.");
			}

			System.out.println("메뉴로 돌아가시려면 돌아가기를 입력하세요.");
			String exit = sc.nextLine();

			if ("돌아가기".equals(exit)) {
				break;
			}
		}
		// 사용자가 입력한 게시글 번호

	}
	
	private void saveBoard() {
		System.out.println();
		//사용자에게 글 쓰기를 할 수 있는 양식을 보여주는 메서드
		System.out.println("======게시글 작성======");
		System.out.print("제목을 입력해주세요>");
		String title = sc.nextLine();
		System.out.print("내용을 입력해주세요 >");
		String content = sc.nextLine();
		System.out.print("작성자를 입력해주세요 >");
		String writer = sc.nextLine();
		System.out.print("비밀번호를 입력해주세요 >");
		String password = sc.nextLine();
		BoardDto dto = new BoardDto(title, content, writer, password);
		
		//String[] - 어떤값이 어떤 인덱스에 있는지 알아야됨
		//Map Baor
		//List - 어떤값이 어떤인덱스에 있는지 알아야됨
		try {
			bc.saveBoard(dto);
		}catch(IllegalArgumentException e) {
			System.out.println("제목/작성자/비밀번호 중 공백이 있습니다.");
		}
	}
	
	private void updateBoard() {
		System.out.println();
		findAll();
		System.out.println("======게시글 수정======");
		System.out.print("수정 게시글 번호 입력 >");
		int boardNumber = 0;
		try {
			boardNumber =sc.nextInt();
			sc.nextLine();
		} catch(InputMismatchException e) {
			System.out.println("게시글 번호는 숫자만 가능합니다.");
			sc.nextLine();
			return;
		}
		System.out.print("수정 게시글 비밀번호 입력 >");
		String password = sc.nextLine();
		
		Board board = bc.findById(boardNumber);
		if(board != null) {
			System.out.println("======게시글 수정입력======");
			System.out.print("작성자 입력 > ");
			String writer = sc.nextLine();
			System.out.print("수정 제목 입력 >");
			String title = sc.nextLine();
			System.out.print("수정 내용 입력 >");
			String content = sc.nextLine();
			BoardDto boardDto = new BoardDto(title, content,writer,password );
			Board makeBoard = bc.updateBoard(boardNumber, boardDto);
			
			System.out.println("======================");
			System.out.println("\t" + makeBoard.getBoardNo() + "번 게시글");
			System.out.println("제목: " + makeBoard.getBoardTitle());
			System.out.print("저자: " + makeBoard.getBoardWriter());
			System.out.println(", 날짜: " + makeBoard.getCreateDate());
			System.out.println("----------------------");
			System.out.println("본문: " + makeBoard.getBoardContent());
			System.out.println("======================");
			
		}else {System.out.println("게시글을 잘못 입력하셨습니다.");}
	}
	
	
	private void deleteBoard() {
		System.out.println();
		findAll();
		System.out.println("======게시글 수정======");
		System.out.print("수정 게시글 번호 입력 >");
		int boardNumber = 0;
		try {
			boardNumber =sc.nextInt();
			sc.nextLine();
		} catch(InputMismatchException e) {
			System.out.println("게시글 번호는 숫자만 가능합니다.");
			sc.nextLine();
			return;
		}
		System.out.print("수정 게시글 비밀번호 입력 >");
		String password = sc.nextLine();
		
		Board board = bc.findById(boardNumber);
		
		if(board!=null) {
			try {
				bc.removeBoard(boardNumber, password);
			} catch(RuntimeException e) {
				System.out.println("비밀번호가 틀렸습니다.");
			}
		}
		System.out.println("게시글이 삭제되었습니다.");
		
	}

}
