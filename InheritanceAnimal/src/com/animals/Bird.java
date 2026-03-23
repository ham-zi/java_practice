package com.animals;

public class Bird extends Animal {
	
	public Bird(String name, int age) {
		super(name,age);
	}

	@Override
	public String food() {
		return "물고기";
	}
	
	@Override
	public void sound() {
		System.out.println("까악까악");
	}
}
