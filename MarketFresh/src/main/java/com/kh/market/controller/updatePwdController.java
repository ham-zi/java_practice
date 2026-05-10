package com.kh.market.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.kh.market.model.dto.MemberDto;
import com.kh.market.model.dto.PasswordDto;
import com.kh.market.model.service.MemberService;


@WebServlet("/update.pwd")
public class updatePwdController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public updatePwdController() {
        super();
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		MemberDto member = (MemberDto)session.getAttribute("userInfo");
		String currentPwd = request.getParameter("currentPwd");
		String changePwd = request.getParameter("changePwd");
		PasswordDto pwdDto = new PasswordDto(currentPwd, changePwd, member.getMemberNo()) ;
		
		MemberDto updateMember = new MemberService().updatePwd(pwdDto);
		
		if(updateMember != null) {
			session.setAttribute("userInfo", updateMember);
			response.sendRedirect("/market/myInfo_Page.do");
		} else {
			session.setAttribute("message", "비밀번호 변경에 실패했습니다.");
			response.sendRedirect("/market/fail.do");
		}
		
		
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
