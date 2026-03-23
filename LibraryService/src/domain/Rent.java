package domain;

public class Rent {

	private final String rentMemberId;
	private final int rentBookId;
	private int RentCount;

	private Rent(Member member, Book book) {
		this.rentMemberId = member.getMemberId();
		this.rentBookId = book.getbookId();
		RentCount++;
	}

	public static Rent rent(Member member, Book book) {
		return new Rent(member, book);
	}

	public int getRentCount() {
		return RentCount;
	}

	public String getRentMemberId() {
		return rentMemberId;
	}

	public int getRentBookId() {
		return rentBookId;
	}

	public void rentPlusCount() {
		RentCount++;
	}
	
	public void rentMinusCount() {
		RentCount--;
	}
	
}
