package com.kh.football.view;

import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

import javax.sql.rowset.serial.SQLOutputImpl;

import com.kh.football.controller.FootballController;
import com.kh.football.model.dto.FootballPlayerDto;
import com.kh.football.model.vo.FootballPlayer;

//시각적인 부분, 화면 입/출력
public class FootballView {
	private Scanner sc = new Scanner(System.in);
	private FootballController fc;
	private BoardView bv;

	public FootballView(FootballController fc,BoardView bv) {
		this.fc = fc;
		this.bv = bv;
	}

	// 프로그램 실행 시 보여줄 화면을 출력해주는 기능 담당
	public void mainMenu() {
		// 축구선수 CRUD
		// CREATE : 사용자에게 축구선수의 이름, 포지션, 등번호를 입력받아 저장
		// READ : 만들어진 축구선수들을 조회
		// UPDATE : 기존에 존재하는 축구선수의 정보를 수정
		// DELETE : 기존에 존재하는 축구선수의 정보를 삭제

		// 뷰가 해야할 일
		/*
		 * 1. 사용자의 입력값 받기 2. 모델에서 만든 값 출력하기 3. 성공 실패 여부를 판별해서 출력 4. 추가 성공 시 추가된 데이터
		 * 출력해주기, 실패시엔 실패했다 말해주기
		 */

		while (true) {
			System.out.println("=================");
			System.out.println("축구선수 관리 프로그램");
			System.out.println("1. 축구선수 전체 조회하기");
			System.out.println("2. 축구선수 추가하기");
			System.out.println("3. 축구선수 수정하기");
			System.out.println("4. 축구선수 삭제하기");
			System.out.println("5. 축구선수 검색하기");
			System.out.println("6. 축구선수 파일저장");
			System.out.println("7. 축구 게시판");
			System.out.println("0. 종료하기");
			System.out.println("=================");
			System.out.print("메뉴를 선택(번호 입력) >");
			int menu = 0;
			try {
				menu = sc.nextInt();
				sc.nextLine();
			} catch (InputMismatchException e) {
				System.out.println("");
				System.out.println("**숫자만 입력해주세요**");
				sc.nextLine();
				continue;
			}

			switch (menu) {
			case 0:
				System.out.println("시스템을 종료합니다.");
				sc.close();
				return;
			case 1:
				System.out.println("축구선수 전체 조회하기");
				selectAll();
				break;
			case 2:
				System.out.println("축구선수 추가하기");
				// 사용자가 입력한 값을 객체로 생성하여 저장소에 풋볼플레이어를 저장한다 Create
				addPlayer();
				break;
			case 3:
				System.out.println("축구선수 수정하기");
				updatePlayer();
				break;
			case 4:
				System.out.println("축구선수 삭제하기");
				deletePlayer();
				break;
			case 5:
				System.out.println("축구선수 검색하기");
				selectPlayer();
			case 6:
				System.out.println("선수 파일출력하기");
				fc.outputFootballPlayer();
			case 7:	
				System.out.println("축구 게시판");
				selectAll();
				bv.boardMenu();
				
			default:
				System.out.println("없는 메뉴입니다. 다시 선택해주세요.");
				break;
			}

		}

	}

	// 전체조회하기
	private void selectAll() {
		List<FootballPlayer> list = fc.requestPlayerList();
		if (!list.isEmpty()) {
			for (FootballPlayer f : list) {
				System.out.print("[선수 정보||");
				System.out.print("이름 : " + f.getName());
				System.out.print(", 포지션 : " + f.getPosition());
				System.out.print(", 번호 : " + f.getBackNumber());
				System.out.println(", ID : " + f.getId() + "]");
			}
		} else {
			System.out.println("선수가 없습니다.");
		}
		System.out.println();
	}

	// 추국선수 추가하기
	private void addPlayer() {

		String name;
		String position;
		int num;
		try {
			System.out.print("선수이름 >");
			name = sc.nextLine();
			System.out.print("포지션 >");
			position = sc.nextLine();
			System.out.print("번호 >");
			num = sc.nextInt();
			sc.nextLine();
		} catch (InputMismatchException e) {
			System.out.println("번호를 숫자로 입력해주세요.");
			sc.nextLine();
			return;
		}

		FootballPlayerDto fpd = new FootballPlayerDto(name, position, num);
		FootballPlayer fp = fc.requestAddPlayer(fpd);
		if (fp != null) {
			selectAll();
		} else {
			System.out.println("선수 추가에 실패했습니다.");
		}
		System.out.println();

	}

	// 축구선수 수정하기
	private void updatePlayer() {
		selectAll();
		int id;
		String name;
		String position;
		Integer num;

		// 매개변수는 int를 사용가능하다
		// 1. int가 짧아서,
		// 2.Integer는 정수값이 아닌게 들어올 수 있을니까
		// 3. 서비스단에서 검증이 null인지도 체크해야하고, 음수가 아닌지도 체크를 해야함
		try {
			System.out.print("수정할 축구선수의 id를 입력 >");
			id = sc.nextInt();
			sc.nextLine();
			System.out.print("이름 >");
			name = sc.nextLine();
			System.out.print("포지션 >");
			position = sc.nextLine();
			System.out.print("번호 >");
			num = sc.nextInt();
			sc.nextLine();

			if (name == null || position == null) {
				System.out.println("이름이나 포지션을 입력해주세요.");
				return;
			}

		} catch (InputMismatchException e) {
			System.out.println("id를 숫자로 입력해주세요.");
			sc.nextLine();
			return;
		}
		FootballPlayerDto fpd = new FootballPlayerDto(name, position, num);
		
		try {
			fc.requestUpdatePlayer(id, fpd);
		} catch(IllegalArgumentException e) {
			System.out.println("선수가 존재하지 않습니다.");
		}
		System.out.println();
	}

	private void deletePlayer() {
		System.out.println();
		System.out.println("등록된 축구선수를 삭제하겠습니다.");
		selectAll();
		System.out.print("삭제할 축구선수의 id를 입력 >");
		int id = 0;

		try {
			id = sc.nextInt();
			sc.nextLine();
		} catch (InputMismatchException e) {
			System.out.println("아이디값은 숫자만 입력 가능합니다.");
			sc.nextLine();
			return;
		}
		fc.requestDeletePlayer(id);
		System.out.println("선택하신 선수를 삭제했습니다.");
		selectAll();
		System.out.println();
	}

	private void selectPlayer() {
		System.out.println("선수 검색");
		while (true) {
			System.out.println("1. 이름 검색");
			System.out.println("2. 포지션 검색");
			System.out.println("3. 번호 검색");
			System.out.println("4. 이름이랑 포지션");
			System.out.println("5. 검색 종료");
			System.out.println("숫자를 입력하여 선택하세요.");
			int num;
			try {
				num = sc.nextInt();
				sc.nextLine();

			} catch (RuntimeException e) {
				System.out.println("숫자를 입력하세요.");
				continue;
			}
			
			switch(num) {
			case 1 : equalsNameSelect();break;
			case 2 : equalsPositionSelect();break;
			case 3 : equalsBackNumberSelect();break;
			case 4 : selectNameAndPosition();break;
			case 5 : System.out.println("검색 종료합니다."); return;
			default : break;
			}
			

		}

	}
	//이름과 포지션으로 검색
	private void selectNameAndPosition() {
		System.out.println("선수 이름/포지션 검색");
		System.out.print("이름 입력 >");
		String name = sc.nextLine();
		System.out.print("포지션 입력 >");
		String position = sc.nextLine();
		
		List<FootballPlayer>list = fc.findByNameAndPosition(name, position);
		if(list.isEmpty()) {
			System.out.println("검색된 선수가 없습니다.");
		}else {
			String info = list.stream()
							  .map(player -> "[선수 정보]\t 이름 :" + player.getName()
							  		+ ", 포지션 : " + player.getPosition()
							  		+ ", 번호 : " + player.getBackNumber()
							  		+ ", ID : " + player.getId())
							  .collect(Collectors.joining());
			System.out.println(info);
			
		}
		System.out.println();
	}
	
	//포지션 검색
	private void equalsPositionSelect() {
		
		System.out.println("검색할 포지션 입력 >");
		String position = sc.nextLine();
		if(position=="") {
			System.out.println("포지션을 제대로 입력해주세요.");
		}else {
			List<FootballPlayer> list = fc.equalsPositionSelect(position);
			if (!list.isEmpty()) {
				for (FootballPlayer f : list) {
					System.out.print("[선수 정보||");
					System.out.print("이름 : " + f.getName());
					System.out.print(", 포지션 : " + f.getPosition());
					System.out.print(", 번호 : " + f.getBackNumber());
					System.out.println(", ID : " + f.getId() + "]");
				}
			} else {
				System.out.println("선수가 없습니다.");
			}
			
			
		}
		System.out.println();
	}
	
	
	//등번호검색
	private void equalsBackNumberSelect() {
		System.out.println("검색할 등번호 입력 >");
		int backNumber ;
		try {
		backNumber = sc.nextInt();
		sc.nextLine();
		}catch(InputMismatchException e) {
			System.out.println("번호를 입력해주세요.");
			return;
		}
		if(backNumber<0) {
			System.out.println("번호을 제대로 입력해주세요.");
		}else {
			List<FootballPlayer> list = fc.equalsBackNumberSelect(backNumber);
			if (!list.isEmpty()) {
				for (FootballPlayer f : list) {
					System.out.print("[선수 정보||");
					System.out.print("이름 : " + f.getName());
					System.out.print(", 포지션 : " + f.getPosition());
					System.out.print(", 번호 : " + f.getBackNumber());
					System.out.println(", ID : " + f.getId() + "]");
				}
			} else {
				System.out.println("선수가 없습니다.");
			}
			
			
		}
	}
	
	
	//이름검색
	private void equalsNameSelect() {
		System.out.println("검색할 이름 입력 >");
		String name = sc.nextLine();
		if(name=="") {
			System.out.println("이름을 제대로 입력해주세요.");
		}else {
			List<FootballPlayer> list = fc.equalsNameSelect(name);
			if (!list.isEmpty()) {
				for (FootballPlayer f : list) {
					System.out.print("[선수 정보||");
					System.out.print("이름 : " + f.getName());
					System.out.print(", 포지션 : " + f.getPosition());
					System.out.print(", 번호 : " + f.getBackNumber());
					System.out.println(", ID : " + f.getId() + "]");
				}
			} else {
				System.out.println("선수가 없습니다.");
			}		
		}
		System.out.println();
	}
}

/// 3개의 값을 넘기는데 너무 번거롭다
/*
 * 1. FootballPlayer Vo 탈락 => 생성자 인자값 부족 2. ArrayList 0 => 인덱스를 알아야함 3. HashMap
 * => 벨류가 String String int or String Object << Object가 안좋다 4. Class를 만든다.
 * 
 */
