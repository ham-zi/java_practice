package com.kh.chap03.run;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import com.kh.chap03.model.vo.Shop;

public class Run {

	public static void main(String[] args) {
		
		//Set
		
		//집합이라는 개념 adt 추상적개념 -> 인터페이스
		
		
		//HashSet
		//Value값만 저장, index개념 없음 == 순서보장X, 중복을 허용하지 않음
		// 그럼 for문으로 출력이 불가능한가?
		// 가능하다 하지만 순서가 보장되지 않아서 순서가 매 번 다르다.
		
		//문자열만 담을 수 있는 HashSet
		
		Set<String>hs = new HashSet<>();  
		// add()
		
		hs.add("김자반");
		hs.add("김치");
		hs.add("두부");
		hs.add("콩");
		hs.add("콩");
		hs.add("콩");
		
		System.out.println(hs);
		// 인덱스 개념이 없기 때문에, 순서가 매 번 다르다.
		// 중복이 절대 불가능하다
		
		//일기?
		//VO
		
		Set <Shop> shops = new HashSet<>();
		Shop a = new Shop("김밥천국","김치찌개", 9000);
		Shop b = new Shop("김밥천국","김치찌개", 9000);
		shops.add(a);
		shops.add(new Shop("보쌈천국", "보쌈정식", 10000));
		shops.add(new Shop("돈까스집", "왕돈까스", 11000));
		shops.add(new Shop("한식나라", "비빔밥", 8000));
		shops.add(b);
		System.out.println(a.equals(b));
		System.out.println();
	
		// HashSet => set에 새로운 요소를 추가할 때 마다 
		// HashCode()와 Equlas()의 반환값을 기준으로 일치하는 요소가 있는지 없는지 판별함
		// 즉, 오버라이딩된 String
		
		/*
		 * equals()의 호출결과가 true이고 hashCode()의 반환값을 동등비교 연산자를 통해
		 * 비교했을 때 값이 일치한다면 ==> 동일 객체로 판단( 중복저장하지 않음) 
		 * 
		 * VO클래스는 일반적으로 반드시 내부에 equals()와 hashCode()를 오버라이딩한다.
		 * 
		 */
		/*
		 * for(int i=0;i<shops.size();i++) {
		 * 
		 * }
		 */
		
		for(Shop as : shops) {
			System.out.println(as.getMenu());
		}
		
		// Set의 요소를 List로 옮기기
		//List list = new ArrayList<>();
		//list.addAll(shops);
		// Set을 List로 옮길 수 있다.
		
		// 더 편한 방법
		List list = new ArrayList<>(shops);
		
		//다형성
		
		
		////////////////////////////////
		
		// Iterator ( 반복자 )
		// StringTokenizer와 비슷한 포지션?
		
		// HasNext(), next()
		
		// ArrayList / LinkedList / HashSet  /TreeSet 등
		// 개발자가 구체적인 자료구조를 모르더라도 반복 시킬 수 있는 방법
		
		Iterator it = shops.iterator();
		
		while(it.hasNext()) {
			System.out.println(it.next());
		}
		
		// List계열 / Set계열 전부 다 iterator()로 호출해서 반복시킬 수 있음
		// Map => 바로 사용이 불가능
		
		
		
		
	}
	
}
