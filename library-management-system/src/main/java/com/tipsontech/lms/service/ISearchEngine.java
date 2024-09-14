package com.tipsontech.lms.service;

import java.util.List;

import com.tipsontech.lms.models.Book;

public interface ISearchEngine {

	List<Book> searchBookByTitle(String title);

	List<Book> searchBookByAuthor(String author);

}
