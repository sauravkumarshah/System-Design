package com.tipsontech.lms.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tipsontech.lms.models.Book;
import com.tipsontech.lms.repository.BookRepository;
import com.tipsontech.lms.service.ISearchEngine;

@Service
public class SearchEngine implements ISearchEngine {

	@Autowired
	private BookRepository bookRepository;

	@Override
	public List<Book> searchBookByTitle(String title) {
		return bookRepository.findByTitleContaining(title);
	}

	@Override
	public List<Book> searchBookByAuthor(String author) {
		return bookRepository.findByAuthorContaining(author);
	}

}
