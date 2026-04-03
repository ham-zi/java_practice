package com.kh.chap04.model.dao;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class BufferDao {

	// 보조 스트림
	// 기반스트림이 없으면 보조스트림을 사용할수없다.

	// 기반스트림이 input/output 계열일 경우
	// 보조스트림도 input/output 계열을 사용
	// > byteStream

	// 기반스트림이 Reader/Writer 계열일 경우
	// 보조스트림도 Reader/Writer 계열을 사용

	// 기반스트림에 호환되는 보조스트림이 존재

	// BufferedReader / BufferedWriter 를 사용
	// buffer는 임시저장공간

	// 속도향상이 목적인 보조스트림 (이론적)
	// - 임시공간을 제공해서 한 번에 입/출력을 진행
	//

	public void outputFile() {

		FileWriter fw = null;
		BufferedWriter bw = null;

		try {
			fw = new FileWriter("d buffer.txt");
			bw = new BufferedWriter(fw); // 기반스트림을 매개변수에 넣어야 됨

			bw.write("안녕하세요.");
			bw.newLine();
			bw.write("반갑습니다.");

		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			// 자원반납은 항상 생성의 역순으로 진행
			try {
				bw.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
			// 자원반납을 나눠서 예외처리 하는 이유는
			// "같이 뒀을 경우 bw.close()에서 예외가 터지네 fw.close()는 묻히기 때문에 따로 생성
			try {
				fw.close();
			} catch (IOException e) {
				e.printStackTrace();
			}

		}
	}

	public void inputFile() {
		try (BufferedReader brf = new BufferedReader(new FileReader("d buffer.txt"))) {
			// 반납 조건이 있음
			// 꼭 자원반납할 경우 close()를 오버라이딩하는 Closeable를 implements 해야한다.

			String str = "";
			while ((str = brf.readLine()) != null) {
				System.out.println(str);
			}

			//자바 15버전 
			String text = """
						  	ㅁㄴㅇㄻㄴㅇㄻㄴㅇㄹ
						  	ㅁㄴㅇㄻㄴㅇㄹ
					      """;
			System.out.println(text);

		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
