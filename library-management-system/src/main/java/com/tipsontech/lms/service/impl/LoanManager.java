package com.tipsontech.lms.service.impl;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tipsontech.lms.models.Book;
import com.tipsontech.lms.models.BookLoan;
import com.tipsontech.lms.models.LoanStatus;
import com.tipsontech.lms.models.User;
import com.tipsontech.lms.repository.BookLoanRepository;
import com.tipsontech.lms.repository.BookRepository;
import com.tipsontech.lms.repository.UserRepository;
import com.tipsontech.lms.service.ILoanManager;

@Service
public class LoanManager implements ILoanManager {

	@Autowired
	private BookRepository bookRepository;

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private BookLoanRepository bookLoanRepository;

	private final static int DUE_DAYS = 15;

	private final static double DAILY_FINE_RATE = 10.0;

	@Override
	public BookLoan borrowBook(Long userId, Long bookId) {
		User user = userRepository.findById(userId).orElseThrow();
		Book book = bookRepository.findById(bookId).orElseThrow();

		if (book.getCopiesAvailable() > 0) {
			BookLoan loan = new BookLoan();

			loan.setUser(user);
			loan.setBook(book);
			loan.setBorrowDate(LocalDate.now());
			loan.setDueDate(LocalDate.now().plusDays(DUE_DAYS));
			loan.setStatus(LoanStatus.BORROWED);

			book.setCopiesAvailable(book.getCopiesAvailable() - 1);
			bookRepository.save(book);
			bookLoanRepository.save(loan);

			return loan;
		} else {
			throw new RuntimeException("Book is not available");
		}

	}

	@Override
	public BookLoan returnBook(Long userId, Long bookId) {
		Optional<BookLoan> loanByUserAndBook = bookLoanRepository.findLoanByUserAndBook(userId, bookId);
		if (loanByUserAndBook.isPresent()) {
			BookLoan loan = loanByUserAndBook.get();

			loan.setReturnedDate(LocalDate.now());
			loan.setStatus(LoanStatus.RETURNED);

			Book book = loan.getBook();
			book.setCopiesAvailable(book.getCopiesAvailable() + 1);

			bookRepository.save(book);

			bookLoanRepository.save(loan);
			return loan;
		} else {
			throw new RuntimeException("No active loan found");
		}
	}

	@Override
	public double calculateFine(BookLoan loan) {

		LocalDate currentDate = LocalDate.now();

		// If the loan has already been returned, use the returned date for fine
		// calculation
		LocalDate effectiveReturnDate = loan.getReturnedDate() != null ? loan.getReturnedDate() : currentDate;

		// Calculate the number of overdue days
		long overdueDays = ChronoUnit.DAYS.between(loan.getDueDate(), effectiveReturnDate);

		// If the book is returned on time or early, no fine
		if (overdueDays <= 0) {
			return 0.0;
		}

		// Calculate fine based on overdue days
		return overdueDays * DAILY_FINE_RATE;
	}

}
