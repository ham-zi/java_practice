package com.kh.chap03.run;

import com.kh.chap03.controller.Cooking;
import com.kh.chap03.controller.CookingController;
import com.kh.chap03.controller.Pasta;
import com.kh.chap03.controller.Rice;
import com.kh.chap03.model.vo.Chef;
import com.kh.chap03.model.vo.MainChef;
import com.kh.chap03.model.vo.SaladChef;

public class Run {
	
	public static void main(String[] args) {
		
		MainChef mc = new MainChef("이다산");
		mc.cooking();
		SaladChef sc = new SaladChef("고길동");
		sc.cooking();
		
		System.out.println("===========");
		
		Chef[] c = {mc, sc};
		for(int i =0; i<c.length; i++) {
			c[i].cooking();
		}
		
		CookingController pc = new CookingController();
		pc.pastaCooking();
		
		Cooking cook = new Rice();
		Cooking cook2 = new Pasta();
		cook.cooking();
		cook2.cooking();
		//Cooking 클래스에 의존
		// 1. 직접적으로 참조하지 않음
		// 2. 정보은닉
		
		//디자인 패턴 : 
		
		
	}
	
}
