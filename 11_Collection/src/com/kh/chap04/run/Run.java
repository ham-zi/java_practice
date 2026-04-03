package com.kh.chap04.run;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import com.kh.chap04.model.vo.Sandwich;

public class Run {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		// Map
		// Key + Value 세트로 저장
		
		// HashMap
		
		// key => 식별자 역할
		// 밸류 => 샌드위치 객체
		
		Map <String, Sandwich> sandwich = new HashMap<>();
		// HashMap => put() key와value 함게 요소로 추가해야함
		sandwich.put("참치마요", new Sandwich("담백한맛","참치"));
		sandwich.put("에그마요", new Sandwich("담백한맛","에그"));
		sandwich.put("햄치즈", new Sandwich("짭짤한맛","햄"));
		sandwich.put("K바비큐", new Sandwich("달달한맛","풀드포크바비큐"));
		// 순서 보장 X
		System.out.println(sandwich);
		sandwich.put("참치", new Sandwich("담백한맛","참치"));
		//Value값의 경우 중복 저장 O 가능
		//Key값의 경우 중복 저장 X 불가능
		//Key값이 중복이 발생하면 덮어씌운다.****<< 몰랐었음

		// 2. get(Object Key) : Object
		// 인자로 전달된 key값에 해당하는 value값을 반환해주는 메소드
		// key로 value를 찾아옴.
		
		System.out.println(sandwich.get("햄치즈"));
		System.out.println(sandwich.get("ddd")); // 없는 key값 전달 시 null 반환
		System.out.println(sandwich.size());
		System.out.println(sandwich.isEmpty());

		//replace ( K key, V value) : Key로 요소를 찾아서 Value값을 치환해줌
		sandwich.replace("참치", new Sandwich("참치두배","참치두배"));
		// Put은 없었던 새로운 키값을 추가하면 넣어줌
		// replace는 기존에 존재하지 않는 키값을 인자로 전달하면 추가하지 않음
		
		
		// remove(Object key)
		sandwich.remove("참치");
		
		
		
		// Map에 들어있는 모든 요소들에 순차적으로 접근해야 한다면??
		// for loop문 X, while X
		// 향상된 for문 X, Iterator X
		// .forEach( (key,value) -> {} )
		sandwich.forEach((key, value) -> {
			System.out.println(key + " : " + value);
		});
		System.out.println("===========");
		// 람다를 안쓴다면??
		// Map이 key - Value를 세트로 가지고 있음
		// key값들만 Set으로 바꿔줘야 함
		// Set으로 바꾸면 Iterator를 사용할 수 있음
		// sandwich
		// 1) Map의 key만으로 Set으로 만들기
		Set<String>subSet = sandwich.keySet();
		//System.out.println(subSet);
		// 2) Set을 Iterator로 변경
		Iterator<String> itKey = subSet.iterator();
		// 3) 반복문 사용하기
		while(itKey.hasNext()) {
			String key = itKey.next();
			System.out.println(key + "===" + sandwich.get(key));
		}
		
		// entrySet()
		Set<Entry<String, Sandwich>> entrySet = sandwich.entrySet();
	}

}
