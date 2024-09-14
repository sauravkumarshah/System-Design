package com.tipsontech.lms.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tipsontech.lms.database.LibraryDatabase;
import com.tipsontech.lms.models.Book;
import com.tipsontech.lms.models.BookLoan;
import com.tipsontech.lms.observer.BookLoanObserver;
import com.tipsontech.lms.service.ILibrarian;
import com.tipsontech.lms.service.ILoanManager;
import com.tipsontech.lms.service.ISearchEngine;

@Service
public class Librarian implements ILibrarian {

	@Autowired
	private ILoanManager loanManager;

	@Autowired
	private ISearchEngine searchEngine;

	@Autowired
	private LibraryDatabase libraryDatabase;

	private BookLoanObserver loanObserver;

	public Librarian() {
		this.loanObserver = new BookLoanObserver();
	}

	@Override
	public BookLoan borrowBook(Long userId, Long bookId) {
		BookLoan loan = loanManager.borrowBook(userId, bookId);
		loanObserver.notifyLoanIssued(loan);
		return loan;
	}

	@Override
	public BookLoan returnBook(Long userId, Long bookId) {
		BookLoan loan = loanManager.returnBook(userId, bookId);
		loanObserver.notifyLoanReturned(loan);
		return loan;
	}

	@Override
	public List<Book> searchBooks(String title) {
		return searchEngine.searchBookByTitle(title);
	}

	@Override
	public void addBook(Book book) {
		libraryDatabase.addBook(book);
	}

}
