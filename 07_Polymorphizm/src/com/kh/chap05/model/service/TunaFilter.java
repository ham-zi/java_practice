package com.kh.chap05.model.service;

import com.kh.chap05.model.vo.Soup;

public class TunaFilter implements SoupFilter {

	@Override
	public boolean test(Soup soup) {
		// TODO Auto-generated method stub
		return soup.getMainMenu().contains("참치");
		//contains는 포함되어 있는가. 체크
	}

}
