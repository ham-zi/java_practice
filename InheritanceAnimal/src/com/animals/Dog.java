package com.animals;

public class Dog extends Animal{

	public Dog(String name, int age) {
		super(name, age);
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public String food() {
		return "강아지 사료";
	}
	
	@Override
	public void sound() {
		System.out.println("멍멍");
	}
	
}


