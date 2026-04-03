package com.kh.chap03.model.dao;

import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class FileCharDao {

	// 프로그램 -> 외부매체(파일)
	// 출력

	public void outputToFile() {
		// FileWriter : 파일로 데이터를 2byte단위로 출력하는 스트림

		/*
		 * try ~ with ~ resource 구문
		 * 
		 * try(스트림객체생성){ 예외가 발생할 수 도 있는 구문 } catch (예외클래스 e) { 예외처리 구문; }
		 * 
		 * close() 생략가능 블럭이 종료되는 시점에 close()를 호출해서 자동으로 자원반납 -> 실수를 줄여주는 메서드
		 */

		try (FileWriter fw = new FileWriter("c_char.txt")) {
			fw.write("문자스트림은 이렇게도 나가요~");
			fw.write("문자열이 통째로 나가네?");
			fw.write("易");

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void writeDiary() {
		// 사용자에게 다이어리 내용을 입력받아서
		// 외부파일로 출력
		// 파일명 : 2026년 3월 30일 오늘의 다이어리.txt
		// 날짜클래스 / 포맷변경
		Date now = new Date();
		String title = new SimpleDateFormat("yyyy년MM월dd일").format(now);
		// 날짜데이트 세트
		StringBuilder sb = new StringBuilder();
		sb.append(title);
		sb.append(" 오늘의 다이어리.txt");
		//세미콜론을 쓰면 2개 이상 객체생성 가능
		try(FileWriter fw = new FileWriter(sb.toString());
			Scanner sc = new Scanner(System.in)) {
			System.out.println("다이어리 내용을 입력해주세요 >");
			String content = sc.nextLine();
			fw.write("오늘의 다이어리 내용 : \t" + content);
			
			
		}catch(IOException e) {
			e.printStackTrace();
		}
		
		
	}

}
