package com.kh.football.run;

import com.kh.football.controller.BoardController;
import com.kh.football.controller.FootballController;
import com.kh.football.model.dao.FootballPlayerDao;
import com.kh.football.model.dao.MemoryFootballPlayerDao;
import com.kh.football.model.service.BoardService;
import com.kh.football.model.service.FootballService;
import com.kh.football.model.service.SelectService;
import com.kh.football.view.BoardView;
import com.kh.football.view.FootballView;
import com.kh.football.model.dao.BoardDao;
import com.kh.football.model.dao.MemoryBoardDao;
public class Run {

	public static void main(String[] args) {
		FootballPlayerDao fpd = new MemoryFootballPlayerDao();
		SelectService ss = new SelectService(fpd);
		FootballService fps = new FootballService(fpd);
		FootballController fc = new FootballController(fps,ss);
		
		BoardDao bd = new MemoryBoardDao();
		BoardService bs = new BoardService(bd);
		BoardController bc = new BoardController(bs);
		BoardView bv = new BoardView(bc);
		
		
		
		new FootballView(fc, bv).mainMenu();
		
		//MVC패턴 ( Model - View - Controller )
		//"애플리케이션의 구조를 세 가지 요소로 분리"
		//라는 소프트웨어 아키텐쳐 디자인 패턴
		/* 1. Model (Data 담당)
		 * VO : 값을 담당
		 * DAO : (data access Object) 외부매체와의 상호작용
		 * Service : 비즈니스로직
		 * DTD : 데이터 전송용도
		 * Entity : 테이블과의 매핑
		 * 
		 * 2. View (사용자 인터페이스 담당)
		 * 사용자에게 정보 표시 / 사용자의 입력값을 받음
		 * 모델에서 만들어진 데이터를 시각적으로 표현 
		 * 모델과 직접 상호작용하지 않음
		 * 
		 * 3. Controller
		 * Model하고 View의 중간다리 역할
		 * 사용자가 View에서 입력한 값을 Model에 전달
		 * Model에서 일어난 처리작업 결과를 View로 반환 
		 * 
		 * 
		 */
		
		//축구선수 CRUD 구현
		/* Create(생성) : View에서 만들어진 데이터를 축구선수모양으로 만들고 저장
		 * Read(조회) : 저장되어 있는 축구선수들을 조회해서 출력
		 * Update(수정) : 저장되어 있는 축구선수들의 값을 갱신
		 * Delete(삭제) : 저장되어 있는 축구선수들의 데이터를 삭제
		 * 
		 * 악세사리 ( C:상품게시 R:상품정보조회 U:상품정보수정 D:상품삭제 )
		 * 이벤트 ( C: R: U: D: )
		 * 공지사항 :( C: 게시글작성 R:게시판 U:게시글수정 D:게시글삭제 )
		 * 회원 : ( C:회원가입 R:마이페이지 U:내정보수정 D:회원탈퇴 )
		 * 
		 * 회원의 C를 구현하겠다.
		 * 아이디,비밀번호,전화번호,이메일
		 * public class MemberVO { 필드~ }
		 * 
		 * 공지사항C를 구현하겠다.
		 * public class NoticeVO
		 * 게시글제목, 게시글내용,게시글작성자, 카테고리 { 필드~ }
		 * 
		 * 모든 문제를 CRUD로 구성되어 있구나
		 * 내가 화면에 어떻게 출력을 할까??를 먼저 고민
		 * 
		 * 
		 */
		
		
		
	}

	
	
}
