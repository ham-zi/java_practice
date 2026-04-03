package com.kh.football.model.service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import com.kh.football.model.dao.FootballPlayerDao;
import com.kh.football.model.dao.MemoryFootballPlayerDao;
import com.kh.football.model.vo.FootballPlayer;

public class SelectService {
	
	FootballPlayerDao fpd;
	
	public SelectService(FootballPlayerDao fpd) {
		this.fpd = fpd;
	}
	
	
	public List<FootballPlayer> equalsNameSelect(String name) {
		List<FootballPlayer> list = fpd.getList();		
		//boolean result = list.get(0).getName().contains(name);
		// 배열[] 몇 개가 필요할지 몰라서
		// Map for문 돌리기가 힘듬, 정렬의 의미가 없어짐
		// set 정렬의 의미가 없어짐, 중복검사가 필요없어서 쓸데없는 과정X
		// List 
		List<FootballPlayer> searched = new ArrayList<>();
		for(FootballPlayer player : list ) {
			if(player.getName().contains(name)) {
				searched.add(player);
			}
		}
		return searched;
		
	}
	
	
	public List<FootballPlayer>equalsPositionSelect(String position) {
		List<FootballPlayer> players = fpd.getList();
		List<FootballPlayer> eName = players.stream()
											.filter(p -> p.getPosition().equals(position))
											.toList();
		return eName;
	}
	
	
	public List<FootballPlayer> findByNameAndPosition(String name, String position) {
		List<FootballPlayer>players = fpd.getList();
		List<FootballPlayer> findPlayers = players.stream()
												  .filter(player -> player.getName().equals(name))
												  .filter(player -> player.getPosition().equals(position))
												  .collect(Collectors.toList());
		return findPlayers;
		
	}
	
	
	
	
	public List<FootballPlayer> equalsBackNumberSelect(int backNumber) {
		List<FootballPlayer>list = fpd.getList();
		
		List<FootballPlayer>bNums = list.stream()
										.filter(p -> p.getBackNumber() == backNumber)
										.toList();
		return bNums;
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
