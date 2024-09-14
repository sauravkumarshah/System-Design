package com.tipsontech.lms.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tipsontech.lms.models.Book;

public interface BookRepository extends JpaRepository<Book, Long> {

}
