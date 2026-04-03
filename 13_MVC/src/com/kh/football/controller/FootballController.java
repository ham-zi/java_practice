package com.kh.football.controller;

import java.util.List;

import com.kh.football.model.dto.FootballPlayerDto;
import com.kh.football.model.service.FootballService;
import com.kh.football.model.service.SelectService;
import com.kh.football.model.vo.FootballPlayer;

// View와 model사이에서 제어
public class FootballController {
	FootballService fs;
	SelectService ss;
	
	
	public FootballController(FootballService fs, SelectService ss) {
		this.fs = fs;
		this.ss = ss;
	}
	
	public List<FootballPlayer> requestPlayerList() {
		return fs.findPlayerList();
	}
	
	//추가
	public FootballPlayer requestAddPlayer(FootballPlayerDto fpd) {
		return fs.addPlayer(fpd);
	}
	
	//수정
	public void requestUpdatePlayer(int id, FootballPlayerDto fpd) {
		fs.updatePlayer(id,fpd);
	}
	
	public void requestDeletePlayer(int id) {
		fs.deletePlayer(id);
	}
	
	public FootballPlayer requestPlayer(FootballPlayerDto fpd) {
		return fs.requestPlayer(fpd);
	}
	
	public boolean findById(int id) {
		return fs.findById(id);
	}
	
	//검색
	
	public List<FootballPlayer> equalsNameSelect(String name){
		return ss.equalsNameSelect(name);
	}
	
	public List<FootballPlayer> equalsPositionSelect(String position){
		return ss.equalsPositionSelect(position);
	}
	
	public List<FootballPlayer> equalsBackNumberSelect(int backNumber) {
		return ss.equalsBackNumberSelect(backNumber);
	}
	
	public void outputFootballPlayer() {
		fs.outputFootballPlayer();
	}
	
	public List<FootballPlayer> findByNameAndPosition(String name,String position) {
		return ss.findByNameAndPosition(name, position);
	}
	
}
