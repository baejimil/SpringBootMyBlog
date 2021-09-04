package com.bjh.blog.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bjh.blog.model.RoleType;
import com.bjh.blog.model.User;
import com.bjh.blog.repository.UserRepository;

@Service	// 스프링이 컴포넌트를 스캔해서 Bean에 등록해줌 , IoC를 해준다 
public class UserService {
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private BCryptPasswordEncoder encoder;
	
	@Transactional(readOnly = true) // 하나의 트랜잭션 안에 여러개의 서비스가 들어갈 수 있다. 
	public User 회원찾기(String username) {
		
		User user = userRepository.findByUsername(username).orElseGet(()->{
			return new User();
		});
		return user;
		
	}
	
	@Transactional // 하나의 트랜잭션 안에 여러개의 서비스가 들어갈 수 있다. 
	public int 회원가입(User user) {
		String rawPassword = user.getPassword();
		String encPassword = encoder.encode(rawPassword);
		user.setPassword(encPassword);
		user.setRole(RoleType.USER);
		try {
			userRepository.save(user);
			return 1;
		} catch (Exception e) {
			return -1;
		}
	}
	
	@Transactional
	public void 회원수정(User user) {
		// 수정시에는 영속성 컨텍스트 User 오브젝트를 영속화시키고, 영속화 된 유저 오브젝트를 수정
		// select를 해서 User 오브젝트를 DB로부터 가져오는 이유는 영속화를 위해서 !!
		// 영속화된 오브젝트를 변경하면 자동으로 DB에 update문을 날려주기 때문에 
		User persistance = userRepository.findById(user.getId()).orElseThrow(()-> {
			return new IllegalArgumentException("회원 찾기 실패");
		});
		// Validate 체크 => oauth 필드에 값이 없으면 수정 가능
				if(persistance.getOauth() == null || persistance.getOauth().equals("")) {
					String rawPassword = user.getPassword();
					String encPassword = encoder.encode(rawPassword);
					persistance.setPassword(encPassword);
					persistance.setEmail(user.getEmail());
				}
		// 회원 수정 함수 종료 시 = 서비스 종료 = 트랜잭션 종료 = commit 자동으로 실행 
		// 영속화된 persistance 객체의 변화가 감지되면 더티체킹이 되서 update 문을 자동으로 날려줌 
	}
}
