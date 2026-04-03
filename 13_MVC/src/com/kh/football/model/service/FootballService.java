package com.kh.football.model.service;

import java.util.List;

import com.kh.football.model.dao.FileFootballPlayerDao;
import com.kh.football.model.dao.FootballPlayerDao;
import com.kh.football.model.dto.FootballPlayerDto;
import com.kh.football.model.vo.FootballPlayer;

//축구선수 저장된것으로 서비스
public class FootballService {

	public FootballPlayerDao dao;

	public FootballService(FootballPlayerDao dao) {
		this.dao = dao;
	}

	public List<FootballPlayer> findPlayerList() {
		return dao.getList();
	}

	public FootballPlayer addPlayer(FootballPlayerDto fpd) {

		FootballPlayer fp = new FootballPlayer(fpd.getName(), fpd.getPosition(), fpd.getBackNumber());
		dao.addPlayer(fp);
		return fp;
	}

	public void updatePlayer(int id, FootballPlayerDto fpd) {
		int index = dao.getIndex(id);
		if(index == -1) {
			throw new IllegalArgumentException();
		}
		if (fpd != null) { // null 나올수 있음
			FootballPlayer newPlayer = new FootballPlayer(id, fpd.getName(), fpd.getPosition(), fpd.getBackNumber());
			dao.setPlayer(index, newPlayer);
		} else {
			throw new IllegalArgumentException("수정된 선수 정보 입력 오류");
		}
	}

	public void deletePlayer(int id) {
		dao.deletePlayer(id);

	}

	public FootballPlayer requestPlayer(FootballPlayerDto fpd) {
		return dao.getPlayer(fpd);
	}
	
	public boolean findById(int id) {
		return dao.findById(id) != null;
	}

	public void outputFootballPlayer() {
		List<FootballPlayer>list = dao.getList();
		new FileFootballPlayerDao().outputFootballPlayer(list);
		
	}
	
}
