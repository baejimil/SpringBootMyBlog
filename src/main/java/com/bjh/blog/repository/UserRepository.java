package com.bjh.blog.repository;

//import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bjh.blog.model.User;

public interface UserRepository extends JpaRepository<User, Integer> {
//	Optional<User> findByUsername(String username);
}
