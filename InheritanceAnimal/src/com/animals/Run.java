package com.animals;
import java.util.List;

public class Run {
	public static void main(String[] args) {
		List<Animal> animals = List.of(
				new Dog("강아지",3),
				new Cat("고양이",2),
				new Bird("까마귀",10)
				);

		for(Animal x : animals) {
			System.out.println(x.getName());
			x.sound();
			x.eat();
			System.out.println(x.toString());
		}
	}
}
