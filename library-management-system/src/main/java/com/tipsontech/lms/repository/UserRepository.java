package com.tipsontech.lms.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tipsontech.lms.models.User;

public interface UserRepository extends JpaRepository<User, Long> {

}
