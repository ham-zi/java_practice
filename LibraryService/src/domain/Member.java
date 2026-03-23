package domain;

public class Member {

	private final String memberId;
	private final String password;

	private Member(String memberId, String password) {
		if (memberId == null || memberId.isEmpty()) {
			throw new IllegalArgumentException("MemberID입력에러");
		}
		if (password == null || password.isEmpty()) {
			throw new IllegalArgumentException("password입력에러");
		}

		this.memberId = memberId;
		this.password = password;
	}

	public static Member member(String memberId, String password) {
		return new Member(memberId,password);
	}

	public String getMemberId() {
		return memberId;
	}

	public String getPassword() {
		return password;
	}
	
	
	
}
