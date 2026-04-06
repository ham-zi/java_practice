package com.kh.football.view;

import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;
import com.kh.football.controller.FootballController;
import com.kh.football.custumException.PlayerNotFoundException;
import com.kh.football.model.dto.FootballPlayerDto;
import com.kh.football.model.vo.FootballPlayer;


public class FootballView {
	private Scanner sc = new Scanner(System.in);
	private FootballController fc;
	private BoardView bv;

	public FootballView(FootballController fc,BoardView bv) {
		this.fc = fc;
		this.bv = bv;
	}

	public void mainMenu() {


		while (true) {
			System.out.println("=================");
			System.out.println("축구선수 관리 프로그램");
			System.out.println("1. 축구선수 추가");
			System.out.println("2. 축구선수 전체조회");
			System.out.println("3. 축구선수 필터조회");
			System.out.println("4. 축구선수 수정하기");
			System.out.println("5. 축구선수 삭제하기");
			System.out.println("6. 축구선수 파일저장");
			System.out.println("7. 축구 게시판");
			System.out.println("8. 종료하기");
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
			case 1:
				System.out.println("축구선수 추가하기");
				createFootballPlayer();
				break;
			case 2:
				System.out.println("축구선수 전체 조회하기");
				findFootballPlayers();
				break;
			case 3:
				System.out.println("축구선수 검색하기");
				findFootballPlayer();
				break;
			case 4:
				System.out.println("축구선수 수정하기");
				updateFootballPlayer();
				break;
			case 5:
				System.out.println("축구선수 삭제하기");
				deleteFootballPlayer();
				break;
			case 6:
				System.out.println("선수 파일출력하기");
				fc.toFileFootballPlayer();
				break;
			case 7:	
				System.out.println("축구 게시판");
				findFootballPlayers();
				bv.boardMenu();
				break;
			case 8:
				System.out.println("시스템을 종료합니다.");
				sc.close();
				return;
			default:
				System.out.println("없는 메뉴입니다. 다시 선택해주세요.");
				break;
			}

		}
	}
	
	
	private void createFootballPlayer() {
		String name;
		String position;
		int num;
		try {
			System.out.print("선수이름 >");
			name = sc.nextLine();
			System.out.print("포지션 >");
			position = sc.nextLine();
			System.out.print("번호 >");
			System.out.println();
			num = sc.nextInt();
			sc.nextLine();
	
			FootballPlayerDto fpd = new FootballPlayerDto(name, position, num);
			FootballPlayer fp = fc.createFootballPlayer(fpd);
			
			if (fp != null) {
				System.out.println(fp);
				System.out.println("선수 추가에 성공했습니다.");
				findFootballPlayers();
			} else {
				System.out.println("선수 추가에 실패했습니다.");
			}
			System.out.println();
			
			
		} catch (InputMismatchException e) {
			System.out.println("번호를 숫자로 입력해주세요.");
			sc.nextLine();
			return;
		} catch (IllegalArgumentException e) {
			System.out.println("선수 이름을 제대로 입력해주세요.");
		}
	}

	
	private void findFootballPlayers() {
		try {
			List<FootballPlayer> list = fc.findFootballPlayers();
			playerInfo(list);
		} catch(PlayerNotFoundException e) {
			System.out.println("선수가 존재하지 않습니다.");
		}
	}

	
	private void findFootballPlayer() {
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

			} catch (InputMismatchException e) {
				System.out.println("숫자를 입력하세요.");
				continue;
			}
			
			switch(num) {
			case 1 : findByName();break;
			case 2 : findByPosition();break;
			case 3 : findByBackNumber();break;
			case 4 : findByNameAndPosition();break;
			case 5 : System.out.println("검색 종료합니다."); return;
			default : break;
			}
		}
	}
	


	private void updateFootballPlayer() {
		findFootballPlayers();
		int id;
		String name;
		String position;
		Integer num;

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
			FootballPlayerDto fpd = new FootballPlayerDto(name, position, num);
			fc.updateFootballPlayer(id, fpd);

		} catch (InputMismatchException e) {
			System.out.println("id를 숫자로 입력해주세요.");
		} catch(PlayerNotFoundException e) {
			System.out.println("선수가 존재하지 않습니다.");
		}
		System.out.println();
	}

	private void deleteFootballPlayer() {
		System.out.println();
		System.out.println("등록된 축구선수를 삭제하겠습니다.");
		findFootballPlayers();
		System.out.print("삭제할 축구선수의 id를 입력 >");
		int id = 0;

		try {
			id = sc.nextInt();
			sc.nextLine();
			fc.deleteFootballPlayer(id);
			
		} catch (InputMismatchException e) {
			System.out.println("아이디값은 숫자만 입력 가능합니다.");
			sc.nextLine();
			return;
		} catch (PlayerNotFoundException e) {
			System.out.println("선수가 존재하지 않습니다.");
			System.out.println("아이디를 확인 해주세요.");
			return;
		}
		System.out.println("선택하신 선수를 삭제했습니다.");
		findFootballPlayers();
		System.out.println();
	}

	
	//이름검색
		private void findByName() {
			System.out.println("검색할 이름 입력 >");
			String name = sc.nextLine();
			if(name=="") {
				System.out.println("이름을 제대로 입력해주세요.");
			}else {
				try {
					List<FootballPlayer> list = fc.findByName(name);
					if (list.isEmpty()) {
						System.out.println("검색된 선수가 없습니다.");
					} else {
						playerInfo(list);
					}		
				}catch (NullPointerException e) {
					System.out.println("리스트가 존재하지 않습니다.");
				}
			}
			System.out.println();
		}
	
	
	private void findByPosition() {
		
		System.out.println("검색할 포지션 입력 >");
		String position = sc.nextLine();
		if(position=="") {
			System.out.println("포지션을 제대로 입력해주세요.");
		}else {
			List<FootballPlayer> list = fc.findByPosition(position);
			if (list.isEmpty()) {
				System.out.println("검색된 선수가 없습니다.");
			} else {
				playerInfo(list);
			}
		}
		System.out.println();
	}
	
	
	private void findByBackNumber() {
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
			List<FootballPlayer> list = fc.findByBackNumber(backNumber);
			if (list.isEmpty()) {
				System.out.println("검색된 선수가 없습니다.");
			} else {
				playerInfo(list);
			}
		}
	}
	
	private void findByNameAndPosition() {
		
		System.out.println("선수 이름/포지션 검색");
		System.out.print("이름 입력 >");
		String name = sc.nextLine();
		System.out.print("포지션 입력 >");
		String position = sc.nextLine();
		
		List<FootballPlayer>list = fc.findByNameAndPosition(name, position);
		if(list.isEmpty()) {
			System.out.println("검색된 선수가 없습니다.");
		}else {
			playerInfo(list);
		}
		System.out.println();
	}
	
	
	private void playerInfo(List<FootballPlayer>list) {
		list.stream()
				  .map(player -> "[선수 정보]\t 이름 :" + player.getName()
				  		+ ", 포지션 : " + player.getPosition()
				  		+ ", 번호 : " + player.getBackNumber()
				  		+ ", ID : " + player.getId())
				  .forEach(System.out::println);
	}
	
}


