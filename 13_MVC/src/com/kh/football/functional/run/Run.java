package com.kh.football.functional.run;

import java.util.ArrayList;
import java.util.List;
import java.util.function.*;
import java.util.stream.Collectors;

import com.kh.football.functional.model.dto.Material;
import com.kh.football.functional.model.service.BinFilter;
import com.kh.football.functional.model.service.RedFilter;

public class Run {

	public static void main(String[] args) {
		List<Material> bin = new ArrayList<>(List.of(
				new Material("건두부",1000,"흰색"),
				new Material("새우완자",3000,"빨강색"),
				new Material("청경채",1500,"초록색"),
				new Material("분모짜",4000,"흰색"),
				new Material("소고기",10000, "빨강색"),
				new Material("옥수수면",3500, "노랑색")
				));
		//익명클래스 클래스이름생략
		BinFilter yellowFilter = new BinFilter() {
			@Override
			public boolean test(Material m) {
				return m.getColor().equals("노랑색");
			}
		};
		//익명클래스 함수생략
		BinFilter whiteFilter = (Material m) -> {
			return m.getColor().equals("흰색");
		};
		//매개변수의 타입, 괄호 생략
		BinFilter greenFilter = m -> m.getColor().equals("초록색");
		
		//람다식
		
		for(Material m : bin) {
			if(whiteFilter.test(m)) {
				System.out.println(m.getName());
			}
		}
		
		
		//예시
		BinFilter ExpensiveFilter = m -> m.getPrice() > 3000;
		for(Material m : bin) {
			if(ExpensiveFilter.test(m)) {
				System.out.println(m.getName() + " : "+ m.getPrice());
			}
		}
		
		//람다가 되기 위한 조건
		/*
		 * 추상메서드가 2개 이상인 클래스에서는 람다 불가능
		 * 실수를 줄이기 위한 애노테이션있음 -> @FunctionalInterface
		 * Prodicate<T>
		 */
		
		// Prodicate<T> 라는 함수용 인터에피스가 존재함.
		Predicate<Material> isRed = m -> m.getColor().equals("빨강색");
		for(Material m : bin) {
			if(isRed.test(m)) {
				System.out.println(m.getName());
			}
		}
		// Function<T, R>   -> 변환 T를 받아서 R로 변환 -> R(리턴타입)
		// 재료 객체를 받아서 재료객체의 이름을 반환하는 
		Function<Material, String> getName = m -> m.getName();
		Function<Material, String> get = Material :: getName;
		
		System.out.println(getName.apply(new Material("돼지고기",5000,"빨강색")));
		
		
		// Consumer<T> - 소비 T(타입아무거나) -> void
		Consumer<Material> print = m -> System.out.println(m.getName());
		print.accept(new Material("양고기",7000,"빨강색"));
		
		// Supplier<T> - 공급
		Supplier<Material> defaultM = () -> new Material("닭고기",4000, "빨강색");
		Material chicken = defaultM.get();
	
		List<Material> red = bin.stream()
								.filter(m -> m.getColor().equals("빨강색"))
								.collect(Collectors.toList());
		
		List<String> onlyColors = bin.stream()
									.map(Material :: getColor)
									.distinct()
									.collect(Collectors.toList());
		
		String strs = bin.stream()
						 .map(Material::getColor)
						 .distinct()
						 .collect(Collectors.joining(","));
		
		System.out.println("======");
		// 4000원이 넘는 첫번째 재료찾기
		Material found = bin.stream()
							.filter(m -> m.getPrice()>4000)
							.findFirst()
							.orElse(null);
		System.out.println(found);
	
		System.out.println(onlyColors);
		System.out.println(red);
	
		
		
		
		
		
		
		
		
		
		
		Material firstWrite = bin.stream()
								 .filter(b -> b.getColor().equals("흰색"))
								 .filter(b -> b.getPrice() > 3000)
								 .findFirst()
								 .orElse(null);
		
		System.out.println(firstWrite);
		
		
		
		
		
		
		
		
		
		
		
	}
	
	
	
	//마라탕이 재료가 너무 많아서 필터로 걸어내기
	
	

}
