package com.kh.football.controller;

import java.util.List;

import com.kh.football.model.dto.FootballPlayerDto;
import com.kh.football.model.service.FootballService;
import com.kh.football.model.service.SelectService;
import com.kh.football.model.vo.FootballPlayer;

public class FootballController {
	FootballService fs;
	SelectService ss;
	
	public FootballController(FootballService fs, SelectService ss) {
		this.fs = fs;
		this.ss = ss;
	}
	
	public FootballPlayer createFootballPlayer(FootballPlayerDto fpd) {
		return fs.createFootballPlayer(fpd);
	}

	public List<FootballPlayer> findFootballPlayers() {
		return fs.findFootballPlayers();
	}
	
	public List<FootballPlayer> findByName(String name){
		return ss.findByName(name);
	}
	
	public List<FootballPlayer> findByPosition(String position){
		return ss.findByPosition(position);
	}
	
	public List<FootballPlayer> findByBackNumber(int backNumber) {
		return ss.findByBackNumber(backNumber);
	}
	
	public List<FootballPlayer> findByNameAndPosition(String name,String position) {
		return ss.findByNameAndPosition(name, position);
	}
	
	
	public void updateFootballPlayer(int id, FootballPlayerDto fpd) {
		fs.updatePlayer(id,fpd);
	}
	
	public void deleteFootballPlayer(int id) {
		fs.deletePlayer(id);
	}

	public FootballPlayer makeFootballPlayerDto(FootballPlayerDto fpd) {
		return fs.makeFootballPlayerDto(fpd);
	}
	

	public void toFileFootballPlayer() {
		fs.toFileFootballPlayer();
	}
}
