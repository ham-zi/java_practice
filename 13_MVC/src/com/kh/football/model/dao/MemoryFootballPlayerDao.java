package com.kh.football.model.dao;

import java.util.ArrayList;

import java.util.List;
import com.kh.football.custumException.PlayerNotFoundException;
import com.kh.football.model.dto.FootballPlayerDto;
import com.kh.football.model.vo.FootballPlayer;
import com.kh.football.model.vo.Position;

public class MemoryFootballPlayerDao implements FootballPlayerDao {
	private List<FootballPlayer> players = new ArrayList<>();


	
	{
		players.add(new FootballPlayer("손흥민",Position.STRICKER, 7));
		players.add(new FootballPlayer("호날두",Position.STRICKER, 7));
		players.add(new FootballPlayer("메시", Position.MIDFIELDER, 10));

		
	}
	public void createFootballPlayer(FootballPlayer fp) {
		players.add(fp);
	}
	

	public List<FootballPlayer> getList() {
		return players;
	}
	

	public FootballPlayer getPlayer(int id) { 
		for(FootballPlayer f : players) {
			if(f.getId()==id) {
				return f;
			} 
		}
		return null;
	}

	public int getIndex(int id) {
		for(int i =0; i< players.size(); i++) {
			if(id == players.get(i).getId()) {
				return i;
			}
		}
		return -1;
	}
	
	public FootballPlayer getPlayer(FootballPlayerDto fpd) {
		for(FootballPlayer f : players) {
			if(f.getName().equals(fpd.getName()) && f.getPosition().equals(fpd.getPosition()) && f.getBackNumber()== fpd.getBackNumber() ) {
				return f;
			}
		}
		return null;
	}
	
	public void setPlayer(int index, FootballPlayer player) {
		players.set(index, player);
	}
	
	public void deletePlayer(int id) {
		FootballPlayer player = getPlayer(id);
		if(player == null) {
			throw new PlayerNotFoundException("선수 없음");
		}
		players.remove(player);
	}
	
	
	
}
