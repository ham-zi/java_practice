package com.kh.chap05.run;

import com.kh.chap05.model.service.ExpensiveFilter;
import com.kh.chap05.model.service.SoupFilter;
import com.kh.chap05.model.service.TunaFilter;
import com.kh.chap05.model.vo.Soup;

public class Run {

	public static void main(String[] args) {

		Soup[] soups = { new Soup("김치찌개", "돼지고기", 5000), new Soup("순두부김치찌개", "순두부", 7000),
				new Soup("쭈꾸미김치찌개", "쭈꾸미", 12000), new Soup("참치김치찌개", "참치", 9000), new Soup("꽁치김치찌개", "꽁치", 9000),
				new Soup("종합김치찌개", "돼지,순두부,쭈꾸미,참치,꽁치", 15000) };

		SoupFilter filter = new TunaFilter();

		for (Soup s : soups) {
			if (filter.test(s)) {
				System.out.println(s.getName());
			}
		}

		SoupFilter ef = new ExpensiveFilter();

		for (Soup s : soups) {
			if (ef.test(s)) {
				System.out.println("만원이 넘는찌개 :" + s.getName());
			}
		}

		// 요구사항
		// 김치찌개 이름이 네글자 이하
		// 김치찌개 9000원 이하 찾기

		// 클래스를 따로 구현하지 않고 쓰는자리에서 바로 구현할 수 있는 방법
		// : 익명클래스
		SoupFilter cheapFilter = new SoupFilter() {
			@Override
			public boolean test(Soup s) {
				return s.getPrice() <= 9000;
			}
		};

		SoupFilter shortNameSoupFilter = new SoupFilter() {
			@Override
			public boolean test(Soup soup) {
				for (Soup s : soups) {
					if (s.getName().length() <= 4) {
						System.out.println("이름 짧은 김치찌개 :" + s.getName());
					}
				}
				return false;
			}
		};
		// 클래스 블록

		for (Soup s : soups) {
			if (cheapFilter.test(s)) {
				System.out.println("9000원 보다 저렴한 김치찌개 :" + s.getName());
			}
		}
		
		//1단계 : 익명클래스
		SoupFilter filter1 = new SoupFilter() {
			@Override
			public boolean test(Soup soup) {
				return soup.getMainMenu().contains("치");
			}
		};

		
		//2단계 : 람다 (인터페이스명, 애노테이션, 접근제한자, 반환형, 메소드명 날리고 (매개변수) -> {실행문})
		SoupFilter filter2 = (Soup s) -> {
			return s.getMainMenu().contains("치");
		};
		
		
		//
		
		
		//3단계 : 매개변수 자료형 제거 : 타입추론 + 매개 변수가 한 개라면 괄호 생략 가능
		SoupFilter filter3 = (s) -> {
			return s.getMainMenu().contains("치");
		};
		
		
		//4단계 : 중괄호 안 실행문이 한 줄 이라면 중괄호 + return문 생략
		SoupFilter filter4 = s -> s.getMainMenu().contains("치");
		
		for(Soup s : soups) {
			if(filter2.test(s)) {
				System.out.println("재료에 치 들어간 찌개: " + s.getName());
			}
		}
		
		System.out.println("====================");
		
		SoupFilter priceFilter = s-> s.getPrice()<=9000;
		for(Soup s : soups) {
			
			if(priceFilter.test(s)) {
				System.out.println("9000원 이하인 " + s.getName());
			}
		}
		
		
		
		
	}

}
