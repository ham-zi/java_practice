package com.kh.chap04.model.dao;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import com.kh.chap04.model.vo.Message;

public class ObjectDao {

	// 출력
	// 객체 단위로 출력을 할 때 필요한 보조스트림
	public void outputFile() {

		Message m = new Message("이다산", "안녕하세요");

		// 객체를 직렬화 시켜야 데이터가 통과한다.

		try (ObjectOutputStream fos =
				new ObjectOutputStream(new FileOutputStream("e_object.txt"))) {
			fos.writeObject(m);
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	public void intputFile() {
		
		try(ObjectInputStream ois =
				new ObjectInputStream( new FileInputStream("e_object.txt"))) {
			
			Message m = (Message)ois.readObject();
			
			System.out.println(m);
			
		}catch (IOException e) {
			e.printStackTrace();
		}catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	
}
