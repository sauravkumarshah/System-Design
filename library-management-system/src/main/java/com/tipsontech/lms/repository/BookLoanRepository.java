package com.tipsontech.lms.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tipsontech.lms.models.BookLoan;

public interface BookLoanRepository extends JpaRepository<BookLoan, Long> {

	Optional<BookLoan> findLoanByUserAndBook(Long userId, Long bookId);
}
