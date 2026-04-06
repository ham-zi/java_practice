package com.kh.football.model.dao;

import java.util.ArrayList;
import java.util.List;

import com.kh.football.custumException.BookNotFoundException;
import com.kh.football.model.dto.FootballPlayerDto;
import com.kh.football.model.vo.FootballPlayer;
import com.kh.football.model.vo.Position;

public class MemoryFootballPlayerDao implements FootballPlayerDao {
	private List<FootballPlayer> players = new ArrayList<>();


	
	{
		players.add(new FootballPlayer("손흥민",Position.STRICKER, 7));
		players.add(new FootballPlayer("호날두",Position.STRICKER, 7));
		players.add(new FootballPlayer("메시", Position.MIDFIELDER, 10));

		//초기화블럭
		
	}


	public List<FootballPlayer> getList() {
		return players;
	}
	
	public void addPlayer(FootballPlayer fp) {
		players.add(fp);
	}
	
	
	
	public FootballPlayer findPlayer(int id) {
		for(FootballPlayer f : players) {
			if(f.getId()==id) {
				return f;
			} 
		}
		return null;
	}

	
	public void deletePlayer(int id) {
		FootballPlayer player = findPlayer(id); //null 가능성
		if(player==null) {
			throw new BookNotFoundException("선수를 찾을 수 없습니다.");
		}
		players.remove(player); // npe 가능 여기다 적어도되나?
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
	
	
	public int getIndex(int id) {
		for(int i =0; i<=players.size(); i++) {
			if(id == players.get(i).getId()) {
				return i;
			}
		}
		return -1;
	}
	
	// update2
	public FootballPlayer findById(int id) {
		for ( FootballPlayer player : players  ) {
			if(player.getId() == id) {
				return player;
			}
		}
		return null;
	
	}
	
}
