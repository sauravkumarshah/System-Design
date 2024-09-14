package com.tipsontech.lms.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tipsontech.lms.models.Book;
import com.tipsontech.lms.models.BookLoan;

public interface BookLoanRepository extends JpaRepository<BookLoan, Long> {

}
