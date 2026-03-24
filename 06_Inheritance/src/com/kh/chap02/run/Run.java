package com.kh.chap02.run;

import com.kh.chap02.model.vo.AosGame;
import com.kh.chap02.model.vo.FpsGame;
import com.kh.chap02.model.vo.RpgGame;

public class Run {

	public static void main(String[] args) {
		AosGame ag = new AosGame();
		ag.setGameName("롤");
		System.out.println(ag.getGameName());
		
		
		FpsGame fg = new FpsGame("배틀그라운드", "크래프톤", 50);
		System.out.println(fg.info());
		RpgGame rg = new RpgGame("와우", "블리자드", 80);
		System.out.println(rg.info());
		
	}
	
}
