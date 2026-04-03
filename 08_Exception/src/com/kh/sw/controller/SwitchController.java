package com.kh.sw.controller;

import com.kh.sw.model.vo.Switch;
import com.kh.sw.util.SwitchUtil;
import com.kh.sw.util.SwitchUtilImpl;

public class SwitchController {

	private Switch s =new Switch(false);
	
	// 왜 인터페이스인 SwitchUitllmple를 쓰는가?
	
	public boolean toggleSwitch() {
		SwitchUtil su = new SwitchUtilImpl();
		return su.toggle(s);
	}
}
