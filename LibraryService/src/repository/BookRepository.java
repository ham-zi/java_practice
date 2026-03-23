package repository;

import java.util.List;

import domain.Book;

public interface BookRepository {
	 
	 void addBook(Book book); //책등록
	 
	 void addMapBook(String id, Book book); //map등록
	 
	 Book findBook(String title, String author); //책찾기
	 
	 List<Book> findAllBooks(); //전체책목록
	 
	 List<Book> findRentableBooks(); // 랜트가능한책목록
	

}
