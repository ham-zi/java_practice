package com.kh.football.model.vo;

public enum Position {
	STRICKER("공격수"),
	DEFENDER("수비수"),
	MIDFIELDER("미드필더"),
	GOOLKEEPER("골키퍼");
	
	private String desc;

	Position(String desc) {
		this.desc =desc;
	}
		
		
	public static Position from(String input) {
		for (Position p : values()) {
			if(p.desc.equals(input)) {
				return p;
			}
		}
		throw new IllegalArgumentException("존재하지 않는 포지션");
	}
	
	public String getDesc() {
		return desc;
	}
}
