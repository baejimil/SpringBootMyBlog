package com.bjh.blog.repository;


import org.springframework.data.jpa.repository.JpaRepository;

import com.bjh.blog.model.Board;

public interface BoardRepository extends JpaRepository<Board, Integer> {

}

