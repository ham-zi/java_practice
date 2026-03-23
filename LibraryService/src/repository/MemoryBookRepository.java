package repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import domain.Book;

public class MemoryBookRepository implements BookRepository {

	private final List<Book> Books = new ArrayList<>();
	private final Map<String, Book> mapBook = new HashMap<>();


	@Override
	public void addBook(Book book) {
		Books.add(book);
	}
	
	@Override
	public void addMapBook(String Id, Book book) {
		mapBook.put(Id, book);
	}

	@Override
	public Book findBook(String title, String author) {
		for(Book book:Books) {
			if( title.equals(book.getTitle()) && author.equals(book.getAuthor())) {
				return book;
			}
		}return null;
	}

	@Override
	public List<Book>findAllBooks() {
		return Books;
	}

	@Override
	public List<Book> findRentableBooks() {
		List<Book>findRentableBooks = new ArrayList<>();
		for(Book book : Books) {
			if(book.getBookCount()>0) {
				findRentableBooks.add(book);
			}
		}
		return findRentableBooks;
	}

}
