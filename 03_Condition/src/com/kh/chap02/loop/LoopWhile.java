package com.kh.chap02.loop;

public class LoopWhile {

	
	public void printSum() {
		int sum = 0;
		for(int i=0; i<=10 ; i++ ) {
			sum += i;
		}
		System.out.println(sum);
		
		int i=1;
		while(i<=10) {
			sum -= i;
			i++;
		}
		System.out.println(sum);
	}
}
