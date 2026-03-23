package repository;

import java.util.ArrayList;
import java.util.List;

import domain.Book;
import domain.Member;

public class MemoryRentRepository implements RentRepository {

	List<Book>rentBooks = new ArrayList<>();
	
	
	
	@Override
	public void addRent(Book book) {
		rentBooks.add(book);
	}

	@Override
	public void removeRent(Book book) {
		rentBooks.remove(book);
	}

	@Override
	public List<Book>findRentBooks() {
		return rentBooks;
	}

	
	
}
