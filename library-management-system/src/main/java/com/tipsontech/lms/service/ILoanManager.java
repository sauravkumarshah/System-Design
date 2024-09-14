package com.tipsontech.lms.service;

import com.tipsontech.lms.models.BookLoan;

public interface ILoanManager {

	public BookLoan borrowBook(Long userId, Long bookId);

	public BookLoan returnBook(Long userId, Long bookId);

	public double calculateFine(BookLoan loan);
}
