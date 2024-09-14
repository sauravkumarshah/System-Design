package com.tipsontech.lms.observer;

import com.tipsontech.lms.models.BookLoan;

public class BookLoanObserver {

	public void notifyLoanIssued(BookLoan loan) {
		System.out.println("A loan has been issued for book : " + loan.getBook().getTitle());
	}

	public void notifyLoanReturned(BookLoan loan) {
		System.out.println("A loan has been returned for book : " + loan.getBook().getTitle());
	}
}
