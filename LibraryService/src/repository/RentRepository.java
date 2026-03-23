package repository;

import java.util.List;

import domain.Book;
import domain.Member;

public interface RentRepository {
	
	void addRent(Book book);
	// void findByMemberId
	void removeRent(Book book);
	List<Book>findRentBooks();
	
}
