package com.kh.chap01.run;

import com.kh.chap01.model.vo.Child1;
import com.kh.chap01.model.vo.Child2;
import com.kh.chap01.model.vo.Parent;

public class Run {

	public static void main(String[] args) {
		
		Parent p1 = new Parent();
		p1.printParent();
		
		Child1 c1 = new Child1();
		c1.printChild1();
		c1.printParent();
		
		Child2 c2 = new Child2();
		c2.printChild2();
		c2.printParent();
		
		System.out.println("------------------");
		
		Parent p2 = new Child1();
		// 자동형변환 (Parent) new Child1();
		// 아~! 메모리에서 부모클래스와 자식클래스 영역만큼 공간이 생기고
		// 부모클래스가 생긴 뒤에 자식클래스가 생긴다
		// 거기서 
		p2.printParent();
		// p2로는 Parent타입 객체만 사용가능
		
		Parent[] ps = new Parent[3];
		
		ps[0]=c1;
		ps[1]=c2;
		ps[2]=p2;
	
		c1.printChild1();
		System.out.println("-----------");
		ps[0].print();
		ps[1].print();
		ps[2].print();
		// 동적 바인딩
	}

}
