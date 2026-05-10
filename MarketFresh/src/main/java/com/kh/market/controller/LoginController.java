package com.kh.market.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.kh.market.model.dto.MemberDto;
import com.kh.market.model.service.MemberService;


@WebServlet("/login.do")
public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
 
    public LoginController() {
        super();
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String userId = request.getParameter("userId");
		String userPwd = request.getParameter("userPwd");
		HttpSession session = request.getSession();
		
		
		MemberDto member = new MemberDto();
		member.setMemberId(userId);
		member.setMemberPwd(userPwd);
		
		MemberDto loginMember = new MemberService().login(member);
		if(loginMember != null) {
			session.setAttribute("userInfo", loginMember);
			System.out.println("로그인 유저 정보: " + loginMember); // 여기서 memberId가 null인지 확인!
			response.sendRedirect("/market");
			
		} else {
			session.setAttribute("message", "로그인 실패했습니다.");
			response.sendRedirect("/market/fail.do");
		}
		
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
