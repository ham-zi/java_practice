package com.kh.football.model.service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import com.kh.football.model.dao.FootballPlayerDao;
import com.kh.football.model.dao.MemoryFootballPlayerDao;
import com.kh.football.model.vo.FootballPlayer;
import com.kh.football.model.vo.Position;

public class SelectService {
	
	FootballPlayerDao fpd;
	
	public SelectService(FootballPlayerDao fpd) {
		this.fpd = fpd;
	}
	
	
	public List<FootballPlayer> findByName(String name) {
		List<FootballPlayer> list = fpd.getList();		
		List<FootballPlayer> players = new ArrayList<>();
		for(FootballPlayer player : list ) {
			if(player.getName().contains(name)) {
				players.add(player);
			}
		}
		return players;
	}
	
	public List<FootballPlayer>findByPosition(String position) {
		List<FootballPlayer> players = fpd.getList();
		List<FootballPlayer> eName = players.stream()
											.filter(p -> p.getPosition() == Position.from(position))
											.toList();
		return eName;
	}
		

	public List<FootballPlayer> findByBackNumber(int backNumber) {
		List<FootballPlayer>list = fpd.getList();
		
		List<FootballPlayer>bNums = list.stream()
				.filter(p -> p.getBackNumber() == backNumber)
				.toList();
		return bNums;
		
	}
		
	
	public List<FootballPlayer> findByNameAndPosition(String name, String position) {
		List<FootballPlayer>players = fpd.getList();
		List<FootballPlayer> findPlayers = players.stream()
				.filter(player -> player.getName().contains(name))
				.filter(player -> player.getPosition() == Position.from(position))
				.collect(Collectors.toList());
		return findPlayers;
		
	}
	

}

