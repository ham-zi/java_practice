package com.kh.chap06.run;

import com.kh.chap06.controller.MethodController;
import com.kh.chap06.controller.OverloadingController;

public class Run {

	
	// 메서드
	// 특정 객체가 수행할 수 있는 기능
	// 소프트웨어로 현실세계의 문제를 해결하기 위함
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		MethodController mc = new MethodController();
		OverloadingController oc = new OverloadingController();
		//mc.method1();
		//mc.method2();
		
		oc.method();
		oc.method(1);
		oc.method("q");
		
	}

}
