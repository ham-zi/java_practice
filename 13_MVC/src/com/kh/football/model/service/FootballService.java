package com.kh.football.model.service;

import java.util.List;

import com.kh.football.custumException.PlayerNotFoundException;
import com.kh.football.model.dao.FileFootballPlayerDao;
import com.kh.football.model.dao.FootballPlayerDao;
import com.kh.football.model.dto.FootballPlayerDto;
import com.kh.football.model.vo.FootballPlayer;
import com.kh.football.model.vo.Position;


public class FootballService {

	public FootballPlayerDao dao;

	public FootballService(FootballPlayerDao dao) {
		this.dao = dao;
	}

	

	public FootballPlayer createFootballPlayer(FootballPlayerDto fpd) {
		FootballPlayer fp = new FootballPlayer(fpd.getName(), Position.from(fpd.getPosition()), fpd.getBackNumber());
		dao.createFootballPlayer(fp);
		return fp;
	}

	public List<FootballPlayer> findFootballPlayers() {
		List<FootballPlayer> players = dao.getList();
		if(players.isEmpty()) {
			throw new PlayerNotFoundException("선수없음"); 
		}
		return players;
	}

	public void updatePlayer(int id, FootballPlayerDto fpd) {
		int index = dao.getIndex(id);
		if(index == -1) {
			throw new PlayerNotFoundException("존재하지 않는 id입니다.");
		}else {
			FootballPlayer newPlayer = new FootballPlayer(id, fpd.getName(), Position.from(fpd.getPosition()), fpd.getBackNumber());
			dao.setPlayer(index, newPlayer);
		}
	}

	public void deletePlayer(int id) {
		dao.deletePlayer(id);

	}

	public FootballPlayer makeFootballPlayerDto(FootballPlayerDto fpd) {
		return dao.getPlayer(fpd);
	}

	public void toFileFootballPlayer() {
		List<FootballPlayer>list = dao.getList();
		new FileFootballPlayerDao().outputFootballPlayer(list);
		
	}
	
}
