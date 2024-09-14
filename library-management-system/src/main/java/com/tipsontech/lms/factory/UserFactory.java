package com.tipsontech.lms.factory;

import com.tipsontech.lms.models.Student;
import com.tipsontech.lms.models.Teacher;
import com.tipsontech.lms.models.User;

public class UserFactory {

	public static User createUser(String type, String name, String email) {
		if ("Student".equalsIgnoreCase(type)) {
			return new Student(name, email);
		} else if ("Teacher".equalsIgnoreCase(type)) {
			return new Teacher(name, email);
		} else {
			throw new IllegalArgumentException("Invalid user type");
		}
	}
}
