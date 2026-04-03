package com.kh.chap02.medel;

public class Box<T> {
	// 제네릭 < T >
	
	private T item;


	public T getItem() {
		return item;
	}

	public void setItem(T item) {
		this.item = item;
	}

}
