package com.animals;

public class Cat extends Animal {

	public Cat(String name, int age) {
		super(name, age);
	}

	@Override
	public String food() {
		return "물고기";
	}

	@Override
	public void sound() {
		System.out.println("야옹");
	}
}