package com.bjh.blog.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bjh.blog.model.User;
import com.bjh.blog.repository.UserRepository;

@Service	// 스프링이 컴포넌트를 스캔해서 Bean에 등록해줌 , IoC를 해준다 
public class UserService {
	
	@Autowired
	private UserRepository userRepository;
	
	@Transactional // 하나의 트랜잭션 안에 여러개의 서비스가 들어갈 수 있다. 
	public int 회원가입(User user) {
		try {
			userRepository.save(user);
			return 1;
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("UserService: 회원가입(): "+e.getMessage());
		}
		return -1;
	}
}
