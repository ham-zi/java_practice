package com.animals;

public abstract class Animal {

	private final  String name;
	private final  int age;

	protected Animal(String name, int age){
		this.name = name;
		this.age = age;
	}
	
	public void eat() {
		System.out.println( food() + "를 먹는다.");
	}
	
	public abstract void sound();
	
	public abstract String food();
	
	public String getName() {
		return name;
	}
	
	public int getAge() {
		return age;
	}
	
	@Override
	public String toString() {
		return (name+", "+age+"살");
	}
}