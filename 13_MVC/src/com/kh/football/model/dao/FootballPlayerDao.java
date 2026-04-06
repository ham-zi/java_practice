package com.kh.football.model.dao;

import java.util.List;

import com.kh.football.model.dto.FootballPlayerDto;
import com.kh.football.model.vo.FootballPlayer;

public interface FootballPlayerDao {
	public void createFootballPlayer(FootballPlayer fp);
	public List<FootballPlayer> getList();
	public FootballPlayer getPlayer(int id);
	public FootballPlayer getPlayer(FootballPlayerDto fpd);
	public void deletePlayer(int id);
	public int getIndex(int id);
	public void setPlayer(int index, FootballPlayer player);
}
