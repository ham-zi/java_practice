package com.kh.chap05.model.view;

import com.kh.chap05.model.vo.Member;

public class MemberView {
	
	public void memberMenu() {
		Member member = new Member("user01","1234","홍길동");
		System.out.println(member.info());
		
		new Member("user123");
	}

}
