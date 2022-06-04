package com.bookLibrary.Library.Service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bookLibrary.Library.Model.Book;
import com.bookLibrary.Library.Reposatory.BookRepo;

@Service
public class BookServices {
	@Autowired
	BookRepo bookRepo;

	// Get all books
	public Iterable<Book> getBooks() {
		Iterable<Book> books = new ArrayList<Book>();
		books = bookRepo.findAll();
		return books;
	}

	// Add books
	public void addBook(Book book) {
		bookRepo.save(book);
	}

	// Remove Book
	public void removeBook(long id) {
		bookRepo.deleteById(id);
	}

	// Search by ID
	public Book findById(long id) {
		return bookRepo.findById(id).get();
	}

	// Total books in number
	public long totalBooks() {
		long num;
		num = bookRepo.count();
		return num;
	}
}