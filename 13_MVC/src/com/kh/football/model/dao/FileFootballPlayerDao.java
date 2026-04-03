package com.kh.football.model.dao;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

import com.kh.football.model.vo.FootballPlayer;

//프로그램 외부로 입/출력 하는 메소드들을 담당하는 클래스
public class FileFootballPlayerDao {

	public void outputFootballPlayer(List<FootballPlayer> list) {
		// 파일로 출력 => """출력할 데이터""" / 출력할 파일의 이름, 문자스트림, 보조스트림
		// 
		// 자원반납
		try(BufferedWriter wr = new BufferedWriter(new FileWriter("player.txt"))){
			wr.write("\t\t\t\t\t\t\t 축 구 선 수 목 록");
			wr.newLine();
			wr.newLine();
			wr.newLine();
			String result = list.stream()
						.map(player -> player.getId() + "번 : \t" 
									 + player.getName()
									 + "\t\t\t" + player.getPosition()
									 + "\t\t\t" + player.getBackNumber() + "번")
						.collect(Collectors.joining("\n"));
			wr.write(result);
			
			} catch(IOException e){}
	}
}
