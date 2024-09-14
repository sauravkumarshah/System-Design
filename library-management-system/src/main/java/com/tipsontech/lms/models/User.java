package com.tipsontech.lms.models;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(schema = "lms", name = "users")
@Data
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "user_id")
	private Long userId;

	@Column(name = "user_name")
	private String name;

	@Column(name = "email")
	private String email;

	@OneToMany(mappedBy = "user")
	private List<BookLoan> borrowedBooks;

	public User(String name, String email) {
		this.name = name;
		this.email = email;
	}
}
