package com.bjh.blog.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bjh.blog.model.Board;
import com.bjh.blog.model.RoleType;
import com.bjh.blog.model.User;
import com.bjh.blog.repository.BoardRepository;
import com.bjh.blog.repository.UserRepository;

@Service	// 스프링이 컴포넌트를 스캔해서 Bean에 등록해줌 , IoC를 해준다 
public class BoardService {
	
	@Autowired
	private BoardRepository boardRepository;

	@Transactional // 하나의 트랜잭션 안에 여러개의 서비스가 들어갈 수 있다. 
	public void 글쓰기(Board board, User user) {
		board.setCount(0);
		board.setUser(user);
		boardRepository.save(board);
	}

}
