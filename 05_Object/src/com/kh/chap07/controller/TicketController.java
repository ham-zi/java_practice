package com.kh.chap07.controller;

import com.kh.chap07.model.service.TicketService;
import com.kh.chap07.model.vo.Ticket;

public class TicketController {
	// 요청처리기 핸들러
	TicketService ts = new TicketService();
	// 컴포지션 ( 합성 ) -> 얕은복사

	// view -> controller -> service -> repository
	public int saveTicket(Ticket ticket) {
		return ts.saveTicket(ticket);
	}
	
	public Ticket printTicket() {
		return ts.printTicket();
	}
	
	public Ticket[] findAll() {
		return ts.findAll();
	}

}
