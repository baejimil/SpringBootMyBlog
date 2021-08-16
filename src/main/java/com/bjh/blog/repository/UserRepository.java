package com.bjh.blog.repository;

import java.util.Optional;

//import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.data.jpa.repository.Query;

import com.bjh.blog.model.User;

public interface UserRepository extends JpaRepository<User, Integer> {
	// SELECT * FROM user WHERE username = 1?;
	Optional<User> findByUsername(String username);
}






//JAP naming 전략
	// SELECT * FROM user WHERE username=?1 AND PASSWORD=?2;
	// User findByUsernameAndPassword(String username, String password);
	
//	또는 아래 방법 	
//	@Query(value = "SELECT * FROM user WHERE username=?1 AND PASSWORD=?2", nativeQuery = true)
//	User login(String username, String password);
//	Optional<User> findByUsername(String username);