package com.kh.chap04.run;

import com.kh.chap04.controller.FieldController;

public class Run {

	public static void main(String[] args) {
		System.out.println(FieldController.stac);
		//호출하면 method area(metaspace)에 올려둠
		//언제 사용하는가? 공유의 목적이 강한
	}
	
}
