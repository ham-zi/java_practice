package com.kh.chap02.model.dao;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class FileByteDao {

	// DAO(Data Access Object) >>
	// data가 보관되어 있는 공간에 "직접 접근"해서 "입력,출력"하는 메소들을 구현해줌

	// VO (value Object)

	// 파일에 프로그램에서 만들어진 데이터를 출력(ByteStream 사용)

	public void outputToFile() {
		// 출력 : 프로그램 내의 데이터를 밖으로 내보내겠다 프로그램 -> 외부(파일)
		// => OutputStream

		// FileOutputStream
		// "파일"로 데이터를 출력할 때, 파일과 연결하는 1Byte단위의 스트림

		// 1. FileOutpuStream 객체 생성
		FileOutputStream fos = null;
		try {
			fos = new FileOutputStream("a_byte.txt"); // 이어서 쓰고싶을떄 true??
			// 생성자 호출 시 파일명을 전달, 존재하지 않는 파일명일 경우 해당 파일을 생성하면서 스트림 생성
			// 생성자 호출 시 두 번째 인자값으로 true를 전달하면 이어쓰기 // 안쓰면 덮어쓰기
			// 2. 스트림을 통해 데이터를 출력 : write() 호출
			fos.write(97);
			fos.write(98);
			fos.write(99);
			byte[] arr = { 101, 102, 103 };
			fos.write(arr);
			fos.write('A');
			fos.write('B');
			fos.write('C');

			fos.write('이');
			fos.write('다');
			fos.write('산');
			// -> 한글 출력이 안된다. 글짜가 깨짐 왜냐하면 한글은 2byte다
			// -> 1byte : -128 ~127
			// 바이트스트림으로는 한글/일본어/중국어 해결이 안됨
			// 문자스트림을 사용해야 해결이 가능

			// 3. 스트림의 사용이 끝남
			// 반드시 해줘야 하는 약속 ( 통로 닫기? << 자원반납 )
			// 코드상에서 사용이 전부 종료되었다면 반드시 자원반납을 해주어야 함 <-- 약속

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		try {
			if (fos != null) {
				fos.close();
			}

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	// 이전에는 return없어서 finally가 필수
	// 가독성상 finally가 좋긴함
	// 헷갈렸던 것
	// 예외가 발생하면 프로그램이 터지는게 아니라 알려주고 다음 코드가 실행된다.

	// 프로그램 <= 외부매체(파일)
	// 입력 : 파일로부터 데이터를 가지고 오겠다.
	// FileInputStream : 파일로부터 데이터를 가져와서 입력 받을건데, 1Byte단위로 입력 받겠다.

	public void inputFromFile() {

		FileInputStream fis = null;

		try {
			// 1. 입력 스트림 생성하기
			fis = new FileInputStream("a_byte.txt");
			// 2. 데이터를 입력받기
			// read() 호출 ==> 1byte단위로 읽어옴
			while(!(fis.read() == -1))// 첫번째 글짜가 빠짐
			while(true) { int value = fis.read();
			if(value != -1) { System.out.print((char)value); }else { break; } }
			
			
			System.out.println("------");
			
			int value1 = 0;
			while( (value1=fis.read()) != -1 ) {
				System.out.print( (char)value1 );
			}
			//조건에 지역변수를 선언한 경우
			
			//파일의 마지막 데이터를 입력받고 나서 read를 호출 시 -1이 반환
			System.out.println(fis.read());
			// StringTokenizer와 유사
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}finally {
			try {
			fis.close();
			}catch(IOException e) {
				e.printStackTrace();
			}
		}
		
		
		//  자바7version 자원반납
		/* 자동 자원반납 문법
		 * 
		 * 
		 */
		

	}

	// 필드로 선언안하는 이유
	// 객체가 생성할때 필드로 생성하면 그 만큼 메모리를 사용하게되어 메모리소모가 심하고
	// 반환할때는 어떻게 하나? 고민해야한다.
	// 메서드로 1회성으로 사용하면 메모리 소모도 적고, 터널 닫으면 구조가 깔끔 해 진다.
}
