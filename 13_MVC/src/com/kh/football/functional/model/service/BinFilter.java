package com.kh.football.functional.model.service;

import com.kh.football.functional.model.dto.Material;

@FunctionalInterface //이 인터페이스는 함수다.
public interface BinFilter {
	
	public boolean test(Material m);
	// 추상메소드가 2개 이상X
}
