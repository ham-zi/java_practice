package com.kh.chap02.run;

import java.util.ArrayList;
import java.util.List;

import com.kh.chap02.medel.Box;
import com.kh.chap02.medel.IntegerBox;
import com.kh.chap02.medel.StringBox;
import com.kh.chap02.medel.vo.Plant;

public class GenericRun {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
		//List<String> list = new ArrayList();
		//list.add("adsf");
		
		// 꺼낼 때 불편 함
		
		// Object타입인 리스트를 하나의 타입으로 선언해주기 위해 제네릭 generic이 추가되었다.
		// <제네릭> 타입을 지정해서 컴파일 시점에 체크하는 것
		// 컴파일하는 시점에 타입을 명확하게 지정할 수 있기 때문에 
		// 1. 다룰 요소의 타입을 제한 할 수 있음 => 데이터의 무결성을 지킬 수 있음
		// 2. 매 번 형변환하는 절차를 없앨 수 있음 => 코드 간소화
		
		
		
		//StringBox sb = new StringBox();
		//IntegerBox ib = new IntegerBox();
		Box <String> sb = new Box<>();
		Box <Integer> ib = new Box<>();
		sb.setItem("물컵");
		ib.setItem(123);
		System.out.println(sb.getItem());
		System.out.println(ib.getItem());
		// 개발자들끼리의 암묵적인 약속
		// E -> Element ==> 요소로 사용할 땐 E
		// T -> Type ==> 아무 타입이나 넣을 수 있을 때
		// K -> Key ==> Map의 Key타입은 K
		// V -> Value ==> Map의 Value값은 V
		// N -> Number ==> 숫자타입 N
		// R -> Return ==> 반환타입 R 
		
		List<Plant>plants = new ArrayList<>();
		plants.add(new Plant("관엽", "폴리샤스"));
		plants.add(new Plant("관엽", "뱅갈고무나무"));
		plants.add(new Plant("관엽", "인도고무나무"));
		plants.add(new Plant("관엽", "산세베리아"));
		
		Plant p = plants.get(0);
		
	}
}
