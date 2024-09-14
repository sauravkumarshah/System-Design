package com.tipsontech.lms.service;

import java.util.List;

import com.tipsontech.lms.models.Book;
import com.tipsontech.lms.models.BookLoan;

public interface ILibrarian {

	public BookLoan borrowBook(Long userId, Long bookId);

	public BookLoan returnBook(Long userId, Long bookId);

	public List<Book> searchBooks(String title);

	public void addBook(Book book);
}
