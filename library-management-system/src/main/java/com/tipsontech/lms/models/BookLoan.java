package com.tipsontech.lms.models;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(schema = "lms", name = "book_loan")
@Data
public class BookLoan {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "loan_id")
	private Long loadId;

	@ManyToMany
	private User user;

	@ManyToMany
	private Book book;

	@Column(name = "borrow_date")
	private LocalDate borrowDate;

	@Column(name = "due_date")
	private LocalDate dueDate;

	@Column(name = "returned_date")
	private LocalDate returnedDate;

	@Enumerated(EnumType.STRING)
	@Column(name = "status")
	private LoanStatus status;

}
