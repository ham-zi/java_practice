package domain;

public class Book {

	private final int bookId;
	private final String title;
	private final String author;
	private int bookCount;
	private static int GLOBAL_BOOK_ID;

	private Book(String title, String author) {

		if (title == null || title.isEmpty()) {
			throw new IllegalArgumentException("title입력오류");
		}

		if (author == null || title.isEmpty()) {
			throw new IllegalArgumentException("author입력오류");
		}

		this.bookId = ++GLOBAL_BOOK_ID;
		this.title = title;
		this.author = author;
		this.bookCount++;
	}

	public static Book book(String title, String author) {
		return new Book(title, author);
	}

	public int getBookCount() {
		return bookCount;
	}

	public String getTitle() {
		return title;
	}

	public String getAuthor() {
		return author;
	}
	
	public int getbookId() {
		return bookId;
	}
	
	public void plusCount( ) {
		++bookCount;
	}
	
	public void minusCount() {
		--bookCount;
	}

}
