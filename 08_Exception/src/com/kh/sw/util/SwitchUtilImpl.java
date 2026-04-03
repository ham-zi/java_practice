package com.kh.sw.util;

import com.kh.sw.exception.SwitchBoomException;
import com.kh.sw.model.vo.Switch;

public class SwitchUtilImpl implements SwitchUtil {

	@Override
	public boolean toggle(Switch s) {
		boom();
		
		s.setOn(!s.isOn());
		return s.isOn();
	}
	
	/**
	 * 이 메소느는 스위치를 눌렀을 때 10%확률로 폭발 확률을 계산하는 메소드로
	 * 10% 확률로 SwitchBoomException을 발생시킴
	 * 
	 * @author 종로 501호 이다산
	 * @since 2026-03-27
	 */
	private void boom() {
		
		//90%확률로 아무 문제없음
		int randomNum = (int)(Math.random()*100)+1;
		int randomNum2 = (int)(Math.random()*10)+1;
		if((randomNum/10)==randomNum2) { //throw 개발자가 직접 예외를 발생시키는 구문
			throw new SwitchBoomException("BOOM!");
		}
	}
	
	
	
}
