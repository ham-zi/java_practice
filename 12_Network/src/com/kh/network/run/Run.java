package com.kh.network.run;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class Run {

	
	/*네트워크
	//통신 가능한 두 대 이상의 장치들을 물리적/논리적으로 연결한 환경
	 * 
	 * 네트워크의 목적: 데이터 교환
	 * 
	 * 
	 * 
	 * 
	 * 
	 * InetAddress : 네트워크 정보를 확인할 수 있는 클래스
	 */ 
	
	public static void main(String[] args) {
		
		// 예외처리 기능이 오류발생시켜서 인지시키는 게아니라
		// 정상적으로 작동하게 지나가는 건가봐
		
		try {
			InetAddress localHost = InetAddress.getLocalHost();
			// localHost 현재 프로그램을 동작시킨 장치를 의미
			System.out.println(localHost);
			System.out.println(localHost.getHostName());
			System.out.println(localHost.getHostAddress());
			
			
			// 도메인 네임을 이용해서 서버컴퓨터와 관련된 정보를 얻어 낼 수 있다.
			// domain name : 사용자가 서비스를 이요할 때 서버의 IP주소를 외우기 어려우니,
			//               외우기 쉬운 구조로 사용자에게 제공하는 이름
			InetAddress googleHost = InetAddress.getByName("www.google.com");
			System.out.println(googleHost);
			//서버는 분산구조로 이루어져 있음
			/*
			 * Client <-> Server Model
			 * 
			 * 현재 구동중인 서버가 존재한다면 클라이언트는 언제든지 서버로 요청을 보낼 수 있음
			 * 단, IP주소와 port번호를 알고 있어야한다.
			 * => 서버는 무조건 응답 결과를 돌려 주어야 한다.
			 * "요청(request)"과 "응답(response)"으로 프로그램이 동작(통신)함  
			 * 웹 통신 방식 : HTTPS(Hyper Text Transfer Protocol Secure)
			 * 
			 * 자바만 가지고 클라이언트와 서버의 간단한 통신하는 프로그램을 구현
			 * 소켓(Socket) : 통신할 수 있게하는 도구
			 * 
			 * Process (프로그램이 메모리에 적재된 상태) 간의 통신을 담당
			 * 프로그램 2개, 서버
			 *
			 */
			
			
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
		}
		
	}
	
}
