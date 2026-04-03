package com.kh.chap04.run;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

import com.kh.chap04.model.vo.Sandwich;

public class PropertiesRun {

	// 파일은 파일인데 확장자가 .Properties가 있음

	// 변경하지 않는 설정 정보
	// 해당 프로그램이 기본적으로 가져야할 정보들을 담는 용도로 많이 사용

	public static void main(String[] args) {
		Properties prop = new Properties();
 
		// 반드시 문자열과 문자열로 이루어져있음

		// 대표적인 상속의 잘못된 예시

		// 옛날에 만들어진 방식

		// 외부에 입력하거나 받는 용도
		//prop.put("asdfasdf", new Sandwich("d", "d"));
		prop.setProperty("List", "LinkedList"); // 전용 메서드가 있는데, 상속으로 인해 put이라는 위험한 메서드에 노출됨
		
		
		try { prop.store(new FileOutputStream("test.properties"), "ddddddd"); } catch
		(IOException e) { e.printStackTrace(); }
		
	}
	
	// 그럼 어떻게 했어야하는가?
	//  객체에 Map<String,String>map을 하면 간단하게 해결이 가능하다.

}
