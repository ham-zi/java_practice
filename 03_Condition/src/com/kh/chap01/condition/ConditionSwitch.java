package com.kh.chap01.condition;

public class ConditionSwitch {

	String name;
	
	String address = switch(name) {
	case "고길동", "둘리" -> "서울특별시 도봉구 쌍문동";
	case "짱구"-> "서울특별시 초록구 떡잎마을";
	case "도라에몽" -> "도쿄도 네리마구 츠키미다이";
	default -> "주소지 없음";
	};
}
