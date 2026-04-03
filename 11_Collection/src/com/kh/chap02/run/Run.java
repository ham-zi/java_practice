package com.kh.chap02.run;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import com.kh.chap02.medel.vo.Plant;

public class Run {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
/*
 * 
 * 자바의 컬렉션(Collection Framework)
 * 
 * 추상적 자료형 (Abstract data Type) => Interface
 * + 
 * 구현체 => Class
 * +
 * 알고리즘 => method
 * =============================================
 * 
 * 배열 컬렉션의 차이점
 * 1. 배열을 사용하려고 하면 무조건 크기 할당을 해야함 => 변경 불가능
 * 2. 배열중간위치에 새로운 요소를 추가하거나 삭제할 때 기존 값을 밀거나 땡기는 코드를 써야함

 * 
 * -컬렉션
 * 1. 크기의 제약이 자류로움
 * => 처음 컬렉션을 사용할 때 크기를 지정하지 않아도 사용할 수 있음
 * => 만약 요소가 추가되면서 크기를 넘어서는 상황이 발생하면 알아서 확장됨
 * 
 * 2. 중간에 요소를 추가하거나 삭제하는 경우 기존 값을 밀거나 땡기는 코드가 이미 구현되어 있음
 * => 그때 그때 필요한 메소드를 호출해서 사용하면 됨
 * 
 *
 * -중립
 * -배열의 경우 같은 타입의 자료형만 사용할 수 있음
 * 
 * -컬렉션의 경우 여러 타입의 데이터들을 사용할 수 있음 : 같은 타입의 데이터만 묶어서도 사용 가능

 * 
 * 사용할 데이터의 개수가 명확히 정해져있고, 조회의 목적 => 배열
 * 데이터들의 추가, 수정, 삭제가 빈번하게 일어난다 => 컬렉션

 * 
 * 
 * 종류
 * 
 * - List 계열 : 다루려고하는 값(Value)만 저장 / 저장 시 순서 유지(Index), 중복값 허용
 * 		=> LinkedList, ArrayList, Vector...
 * 
 * - set 계열 : 다루려고하는 값(Value)만 저장 / 저장 시 순서 유지 X, 중복값 허용 X
 * 		=> TreeSet, HashSet...
 * 		=> HashSet
 * 
 * - Map 계열 : 키(key) - 값(Value) 세트로 저장 / 저장 시 순서 유지 X, 키 중복 X ) 값 중복 
 * 
 * 		-=>HashMap, TreeMap, MultiValueMap...
 * => HashMap
 * 
 * 
 * 
 */
		
		//ArrayList 생성 방법
		// ArrayList arr = new ArrayList();
		// ArrayList arr = new ArrayList(정수); // 정수값만큼의 size
		// 조회에 이점이 큼
		ArrayList plants = new ArrayList(3);
		Plant[] plantss = new Plant[3];
		
		// ArrayList는 Object[] 이다.
		// 다형성
		
		
		// 매개변수 (E e) 제네릭
		// -> 매개변수 타입이 Object구나
		
		
		//System.out.println(plantss);
		//System.out.println(plants);
		//plants.add(1); << Integer로 래핍되어서 결국 들어갈 수 있게 됨.
		plants.add(new Plant("서양란", "호접란"));
		plants.add(new Plant("동양란", "황룡관"));
		plants.add(new Plant("관엽", "금전수"));
		plants.add(new Plant("꽃", "개나리"));
		plants.add("식물 끝!");
		plants.add(0,"식물시작");
		System.out.println(plants);
		
		
		// 기존 Object[]의 크기를 넘어서는 요소를 추가하는 경우
		// System.arraycopy 메소드를 호출해서 깊은 복사로 더 큰 배열을 할당함
		// Object타입으로 요소를 관리하기 때문에 여러 자료형의 요소를 하나의 리스트에 요소로 사용할 수 있음.
		
		// 나 지금 깊은 복사 까먹었었구나
	
		
		
		LinkedList list = new LinkedList();
		list.add(new Plant("서양란", "호접란"));
		list.add(new Plant("동양란", "황룡관"));
		list.add(new Plant("관엽", "홍콩야자"));
		list.add(new Plant("꽃", "개나리"));
	
		System.out.println(list);
		// 객체 값과 다음요소의 주소값을 저장함
		// 세퍼레이트체이닝
		// 조회하는데에 약함
		// 대신 교체가 쉬움 (추가삭제)
		
		// add메소드 오버로딩 잘되어 있음
		// add(int index, E e) : List의 index에 전달하는 요소를 추가
		// add(
		//중간 위치에 요소를 추가했을 때 기존 요소를 한 칸 씩 뒤로 밀어주는 코드가 구현되어 있음
		
		
		// 2. 요소를 수정하는 메소드 E:Element 요소
		// set(int index, E e) : List의 index위치에 값을 전달한 요소(e)로 set해주는 메서드

		// list.remove(5); 순서가 당겨져서 5번인덱스까지 밖에 없음
		// -> 지울때 인덱스 위치 조심
		// IndexOutOfBoundsException == index값을 잘 고려해서 인자값을 전달해야함
		
		System.out.println(list);
		
		// 4. 리스트의 크기를 반환받기
		// size() : 리스트에 담겨있는 요소의 개수
		System.out.println(list.size());
		
		// 5. List의 해당 index 위치에 담긴 요소를 반환하는 메소드
		// get(int index) : E
		System.out.println(list.get(0));
		Plant p = (Plant) list.get(0);
		System.out.println(p);

		/*
		 * for(int i = 0; i<list.size(); i++) { System.out.println(
		 * ((Plant)list.get(i)).getType() ); }
		 * 
		 */
		
		for(int i = 0; i<list.size(); i++ ) {
			System.out.println( ((Plant)list.get(i)).getType() );
		}
		
		for(Object plant : list ) {
			System.out.println(plant); // 나 동적바인딩 조건 잘 모르는구나
		}
		
		
		// 6. 리스트 자르기
		// subList(int index1, int index2) : List 타입
		// index1부터 index2까지의 요소를 추출해서 새로운 리스트를 반환
		System.out.println("----------");
		List sub = plants.subList(0, 2);
		System.out.println(sub);
		
		// 7.리스트에다가 요소를 모두 추가하기
		// addAll(Collection c) : 해당 리스트에 다른 컬렉션에 있는 요소들을 모두 추가해주는 메서드
		list.addAll(sub);
		System.out.println(list); //리스트는 데이터 값(Value)이 중복될 수 있음

		// 중복을 해결하기 위해 다른 컬렉션을 사용하는 경우가 있음
		
		// 8.리스트에 현재 요소가 있는지 없는지 판별하는 메소드
		// isEmpty() ; 리스트에 요소가 존재하지 않는다면 true / 하나라도 있으면 false
		
		// 9. 배열 비우기
		list.clear();
		System.out.println(list.isEmpty()); // 자주 씀
		
		
		
	}

}
