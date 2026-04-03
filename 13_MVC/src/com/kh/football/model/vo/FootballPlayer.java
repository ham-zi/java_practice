package com.kh.football.model.vo;

import java.util.Objects;

public class FootballPlayer {
	// 숫자로 식별자를 만들 때 보편적으로 Long
	private static int num = 0;
	private final String name;
	private final String position;
	private final Integer backNumber;
	private final int id;

	// 등번호가 0일 때 등번호가 0인지 null인지 확인이 가능해서 Integer로 사용
	// Integer형같은 경우 다른 타입의 값이 들어가는 것을 방지하기 위해서 사용한다
	public FootballPlayer(String name, String position, Integer backNumber) {

		if (name == null || name.isBlank()) {
			throw new IllegalArgumentException("선수의 이름을 제대로 입력해주세요.");
		}

		if (backNumber < 0) {
			throw new IllegalArgumentException("등번호는 0보다 커야합니다.");
		}

		if (("공격수".equals(position) || "수비수".equals(position) || "미드필드".equals(position) || "골비퍼".equals(position))) {
			this.id = ++num;
			this.name = name;
			this.position = position;
			this.backNumber = backNumber;
		} else {
			throw new IllegalArgumentException("미드필드/공격수/수비수/골비퍼 중 입력해주세요.");
		}

	}

	public FootballPlayer(int id, String name, String position, Integer backNumber) {
		this.id = id;
		this.name = name;
		this.position = position;
		this.backNumber = backNumber;
	}

	public int getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public String getPosition() {
		return position;
	}

	public Integer getBackNumber() {
		return backNumber;
	}

	@Override
	public String toString() {
		return "FootballPlayer [id=" + id + ", name=" + name + ", position=" + position + ", backNumber=" + backNumber
				+ "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(backNumber, id, name, position);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		FootballPlayer other = (FootballPlayer) obj;
		return Objects.equals(backNumber, other.backNumber) && id == other.id && Objects.equals(name, other.name)
				&& Objects.equals(position, other.position);
	}

}
