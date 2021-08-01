package com.bjh.blog.test;

import org.springframework.web.bind.annotation.GetMapping;

public class BlogControllerTest {
	
	@GetMapping("/test/hello")
	public String hello() {
		return "Hello";
	}

}
