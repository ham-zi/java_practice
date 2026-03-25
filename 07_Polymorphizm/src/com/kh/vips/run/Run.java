package com.kh.vips.run;

import com.kh.vips.model.vo.Chef;
import com.kh.vips.model.vo.Duli;
import com.kh.vips.model.vo.Hong;
import com.kh.vips.model.vo.Ko;
import com.kh.vips.model.vo.Lee;
import com.kh.vips.model.vo.MainChef;
import com.kh.vips.model.vo.MainPartChef;
import com.kh.vips.model.vo.SaladChef;
import com.kh.vips.model.vo.SaladPartChef;

public class Run {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("빕스 오픈");
		
		Lee lee = new Lee("이승철");
		Hong hong = new Hong("홍길동");
		Ko ko = new Ko("고길동");
		Duli duli = new Duli("둘리");
		
		lee.cooking();
		hong.cooking();
		ko.cooking();
		duli.cooking();
		
		lee.breakTime();
		hong.breakTime();
		ko.breakTime();
		duli.breakTime();
		
		System.out.println("=============");
		/*
		 * MainChef mcHong = new MainChef("홍길동"); MainChef mcDuli = new MainChef("둘리");
		 * SaladChef scLee = new SaladChef("이승철"); SaladChef scKo = new
		 * SaladChef("고길동");
		 */
		MainChef[] mains = {new MainChef("홍길동"),
				new MainChef("둘리")};
		SaladChef[] salads = {				new SaladChef("이승철"),
				new SaladChef("고길동")};
		
		for(int i = 0; i < mains.length; i++) {
			mains[i].beefCooking();
			mains[i].breakTime();
		}
		for(int i = 0; i < salads.length; i++) {
			salads[i].saladCooking();
			salads[i].breakTime();
		}
		
		System.out.println("=================");
		// 다용성 적용
		
		Chef[] chefs = {new MainPartChef("홍길동"), new MainPartChef("고길동"),
				new SaladPartChef("이승철"), new SaladPartChef("둘리")};
		
		for(int i=0; i < chefs.length; i++) {
			chefs[i].cooking();
			chefs[i].breakTime();
		}
		//반복문코드에서 이 객체들이 누군지 전혀모름
		//Chef 객체라면 상관없다
		
		// 정보은닉(information hiding)
		
	}

}
