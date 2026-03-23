package repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import domain.Member;

public class MemoryMemberRepository implements MemberRepository {

	List<Member> members = new ArrayList<>();
	Map<String, Member> MapMember = new HashMap<>();

	@Override
	public void addMember(Member member) {
		members.add(member);
	}
	
	@Override
	public void addMapMember(String id, Member member) {
		MapMember.put(id, member);
	}

	@Override
	public Member getMember(String id, String passwrod) {
		for(Member member : members) {
			if( (member.getMemberId().equals(id)) && member.getPassword().equals(passwrod)){
				return member;
			}
		}
		return null;
	}

	@Override
	public boolean isAvailableId(String Id) {
		for (Member member : members) {
			if (member.getMemberId().equals(Id)) {
				return false;
			}
		}
		return true;
	}

}
