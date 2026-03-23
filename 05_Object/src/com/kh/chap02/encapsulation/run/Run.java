package com.kh.chap02.encapsulation.run;

import java.util.Scanner;

import com.kh.chap02.encapsulation.model.vo.AutoSellingMachine;

public class Run {

	// 캡슐화 (encapsulation)
	// 속성(데이터)과 해당 데이터를 조작하는 행동(메소드)를 하나의 단위로 묶는 것
	// 정보은닉(information hiding)

	// 객체 생성 new
	// method Area / stack / heap / program count area / native 메소드에 직접적으로 관여하는 area
	// native : java로 구현할수 없는 기능을 실제로 C언어로 구현된 함수를 호출.

	// method area는 클래스에대한 정보(바이트코드)가 적재된다.

	public static void main(String[] args) {
		AutoSellingMachine asm = new AutoSellingMachine();
		// new AutoSellingMachine().hi();
		// 변수 공간에 대입될 수 있는 값은 딱 9가지
		// boolean
		// char
		// byte, short, int , long
		// float, double
		// 주소값
		// 즉, 기본자료형 or 주소값
		/*
		 * asm.name = "삼양라면"; System.out.println(asm.name); asm.price = 1100;
		 * System.out.println(asm.price); asm.stock = 22; System.out.println(asm.stock);
		 * }
		 */
		// Dependency (의존)
		/*
		 * public void 상품판매(){} public void 상품추가(){} public void 재고확인(){} -> (수정)public
		 * void checkStock(){} =>> chap02\encapsulation\run\Run.java에서 에러
		 * 
		 * public void machinequeue(){상품판매, 상품추가, 재고확인} =>(수정)public void
		 * machinequeue(){sellProduct, insertProduct, CheckStock}
		 * =>chap02\encapsulation\run\Run.java에서 정상작동
		 * 
		 * 구현체만 수정하면 Service나 Run에서 수정할 필요가 없다. 즉, 결합도를 낮췄다/ / 의존성을 낮췄다.
		 */

		// 생성자
		/*
		 * private / protected / public / default
		 * 
		 * private 사용 시 getter와 setter 사용 (parameter, argument , 인자, 매개변수) (argument)를
		 * 전달한다.
		 */

		asm.setPrice(1500);
		System.out.println(asm.getPrice());
		asm.setName("삼양라면");
		System.out.println(asm.getName());
		asm.setStock(13);
		System.out.println(asm.getStock());
		
		/* 캡슐화
		 * 1. 값을 숨긴다
		 * 2. 메소드를 통해 필드에 접근할 수 있게 만든다.
		 * 
		 * 데이터를 숨김 => 객체간의 결합도가 낮아짐 => 책임분리
		 *
		 * 
		 * 
		 * 
		 * 
		 * 
		 */

	}
}
