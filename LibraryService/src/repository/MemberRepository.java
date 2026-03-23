package repository;

import domain.Member;

public interface MemberRepository {
	
	void addMember(Member member); //member등록
	void addMapMember(String id, Member member);
	Member getMember(String id, String passwrod); // member찾기
	boolean isAvailableId(String Id); // id생성가능?

}
