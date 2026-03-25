package com.kh.chap03.run;

import com.kh.chap03.medel.vo.KakaoWebToon;
import com.kh.chap03.medel.vo.NateWebToon;
import com.kh.chap03.medel.vo.NaverWebToon;
import com.kh.chap03.medel.vo.WebToon;

public class Run {

	public static void main(String[] args) {
		WebToon webToon = new WebToon("화산귀환", "LICO", "수요일");
		NaverWebToon nw = new NaverWebToon("전지적독자시점", "UMI", "수요일", "쿠키");
		KakaoWebToon kw = new KakaoWebToon("수린당성군전", "일링스", "수요일", true);

		System.out.println(webToon);
		System.out.println(nw);
		System.out.println(kw);

		NateWebToon nwt = new NateWebToon("재미", "작가");
		System.out.println(nwt);
		System.out.println(nwt.hashCode());

	}

}
