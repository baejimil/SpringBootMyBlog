package com.bjh.blog.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

// 인증이 안된 사용자들이 출입할 수 있는 경로를 /auth/** 허용 -> 인증이 필요 없는 곳
// 그냥 주소가 /이면 index.jsp 허용
// static 이하에 있는 /js/**, /css/**, /image/** 

@Controller
public class UserController {
	
	@GetMapping("/auth/joinForm")
	public String joinForm() {
		
		return "user/joinForm";
	}
	
	@GetMapping("/auth/loginForm")
	public String logForm() {
		
		return "user/loginForm";
	}
}
