package com.kh.football.model.dao;

import java.util.List;

import com.kh.football.model.dto.FootballPlayerDto;
import com.kh.football.model.vo.FootballPlayer;

public interface FootballPlayerDao {
	public List<FootballPlayer> getList();
	public FootballPlayer findPlayer(int id);
	public void deletePlayer(int id);
	public FootballPlayer getPlayer(FootballPlayerDto fpd);
	public void addPlayer(FootballPlayer fp);
	public FootballPlayer findById(int id);
	public int getIndex(int id);
	public void setPlayer(int index, FootballPlayer player);
}
