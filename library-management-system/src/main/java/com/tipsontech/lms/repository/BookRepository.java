package com.tipsontech.lms.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tipsontech.lms.models.Book;

public interface BookRepository extends JpaRepository<Book, Long> {

	List<Book> findByTitleContaining(String title);

	List<Book> findByAuthorContaining(String author);
}
