package com.kh.chap07.model.service;

import com.kh.chap07.model.vo.Ticket;

public class TicketService {

	private Ticket[] tickets = new Ticket[3];

	public int saveTicket(Ticket ticket) {

		// 1번 티켓 개수 확인 => 쉬운방법

		// 중복 제거 //
		
		for(int i = 0; i< tickets.length; i++ ) {
			if(tickets[i]== null) {
				tickets[i] = ticket;
				return 1;
			}
		}return 0;
		
		/*  
		 * 
		 * 
		 * 
		 */
		
		// 2번 티켓 개수 2이하라면 티켓 등록
		/*
		 * if (firstTicket == null) { this.firstTicket = ticket; return 1; } else if
		 * (secondTicket == null) { this.secondTicket = ticket; return 1; } else if
		 * (thirdTicket == null) { this.thirdTicket = ticket; return 1; } return 0;
		 */
	
		// boolean을 넣는게 그럴듯 해보이지만
		// 1. 사용하는 기술에 따라 돌려주는 값이 달라짐
		// 정수 값, 주소 값
		// 2.
		
		
		// 뷰로부터 시작된 요청이 컨트롤러를 거쳐서 도달함
				// 1. 티켓이 발급된게 있나 없나 확인 후
				// 2. 발급된게 있으면 티켓의 주소값을 반환해주고
				// 3. 주소값을 담은 필드 비워주기
		
		
		/*배열
		 * 인덱스 개념이 존재, 변수의 나열(메모리 연속된 공간에 저장)
		 * 물리구조와 논리구조가 같다. 같은 자료형의 값을 담을 수 있다.
		 * 
		 */
	
	}

	public Ticket printTicket() {
		Ticket ticket=null;
		
/*		if (firstTicket != null) {
			ticket = firstTicket;
			firstTicket = null;
			return ticket;
			
		} else if (secondTicket != null) {
			ticket = secondTicket;
			secondTicket = null;
			return ticket;
			
		} else if (thirdTicket != null) {
			ticket = thirdTicket;
			thirdTicket = null;
			return ticket;
		}
		return null;

	}*/
	for(int i=0; i < tickets.length; i++) {
		if(tickets[i] != null) {
			ticket = tickets[i];
			tickets[i] = null;
			break;
		}else {return ticket;}
	}
	return ticket;
}
	public Ticket[] findAll() {
		return tickets;
	}
	

}
