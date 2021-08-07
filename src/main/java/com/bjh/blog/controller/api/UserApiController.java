package com.bjh.blog.controller.api;

import java.io.Console;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.bjh.blog.dto.ResponseDto;
import com.bjh.blog.model.User;

@RestController
public class UserApiController {
	
	@PostMapping("/api/user")
	public ResponseDto<Integer> save(@RequestBody User user) {
		
		System.out.println("UserApiController: save 호출 ");
		return new ResponseDto<Integer>(HttpStatus.OK, 1);
		
	}
}
