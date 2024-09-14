package com.tipsontech.lms.database;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Component;

import com.tipsontech.lms.models.Book;
import com.tipsontech.lms.models.User;

@Component
public class LibraryDatabase {

	private static LibraryDatabase INSTANCE;

	private Map<Long, Book> books = new HashMap<>();
	private Map<Long, User> users = new HashMap<>();

	private LibraryDatabase() {

	}

	public static synchronized LibraryDatabase getInstance() {
		if (INSTANCE == null) {
			INSTANCE = new LibraryDatabase();
		}
		return INSTANCE;
	}

	public Map<Long, Book> getBooks() {
		return books;
	}

	public Map<Long, User> getUsers() {
		return users;
	}

	public void addUser(User user) {
		users.put(user.getUserId(), user);
	}

	public void addBook(Book book) {
		books.put(book.getBookId(), book);
	}
}
