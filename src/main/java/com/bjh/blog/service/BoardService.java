package com.bjh.blog.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bjh.blog.config.auth.PrincipalDetail;
import com.bjh.blog.model.Board;
import com.bjh.blog.model.User;
import com.bjh.blog.repository.BoardRepository;

@Service // 스프링이 컴포넌트를 스캔해서 Bean에 등록해줌 , IoC를 해준다
public class BoardService {

	@Autowired
	private BoardRepository boardRepository;

	@Transactional // 하나의 트랜잭션 안에 여러개의 서비스가 들어갈 수 있다.
	public void 글쓰기(Board board, User user) {
		board.setCount(0);
		board.setUser(user);
		boardRepository.save(board);
	}
	
	@Transactional(readOnly = true)
	public Page<Board> 글목록(Pageable pageable) {
		return boardRepository.findAll(pageable);
	}
	
	@Transactional(readOnly = true)
	public Board 글상세보기(int id) {
		return boardRepository.findById(id)
				.orElseThrow(()->{
					return new IllegalArgumentException("글 상세보기 실패 : 아이디를 찾을 수 없습니다");
				});
			
	}
	
	@Transactional
	public void 글삭제하기(int id) {
		boardRepository.deleteById(id);
	}
	
	@Transactional
	public void 글삭제하기(int id, PrincipalDetail principal) {
		Board board = boardRepository.findById(id)
				.orElseThrow(()-> {
					return new IllegalArgumentException("글 찾기 실패 : 해당 글이 존재하지 않습니다");
				});
		
				if(board.getUser().getId() != principal.getUser().getId()) {
					throw new IllegalStateException("글 삭제 실패 : 해당 글을 삭제할 권한이 없습니다");
				}
				boardRepository.delete(board);
	}
	
	@Transactional
	public void 글수정하기(int id, Board requestBoard) {
		Board board = boardRepository.findById(id)
				.orElseThrow(()->{
					return new IllegalStateException("글 찾기 실패 : 아이디를 찾을 수 없습니다 ");
				});
		board.setTitle(requestBoard.getTitle());
		board.setContent(requestBoard.getContent());
		// 해당 함수로 종료시(Service가 종료될 때) 트랜잭션이 종료됩니다. 이때 더티체킹 - 자동 업데이트가 됨. DB flush
	}
	
	
}