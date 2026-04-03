package com.kh.chap01;

import java.util.Arrays;

public class Integers {

	private int[] integers;
	private int size;

	public Integers() {
		integers = new int[3];
	}

	public void add(int element) {
		if (integers.length == size + 1) {
			// 깊은 복사해서 기존 값까지 복사.
			integers = Arrays.copyOf(integers, integers.length * 2);
		}
		integers[size++] = element;
	}

	public int get(int index) {
		if (integers.length - 1 < index) {
			throw new ArrayIndexOutOfBoundsException("인덱스");
		}
		return integers[index];
	}

	@Override
	public String toString() {
		if (integers == null) {
			return null;
		}
		int max = integers.length - 1;
		if (max == 01) {
			return "[]";
		}

		StringBuilder b = new StringBuilder();
		b.append("[");
		for (int i = 0; i < size; i++) {
			b.append(integers[i]);
			if (i + 1 == size) {
				return b.append("]").toString();
			}
			b.append(",");
		}
		return null;
	}
}
