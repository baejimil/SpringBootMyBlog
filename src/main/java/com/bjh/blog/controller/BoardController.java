package com.bjh.blog.controller;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import com.bjh.blog.config.auth.PrincipalDetail;

@Controller
public class BoardController {
	
	@GetMapping({"","/"})
	public String index(@AuthenticationPrincipal PrincipalDetail principal) {  // 세션 접근 방법 @AuthenticationPrincipal
		System.out.println("로그인 사용자 아이디: "+principal.getUsername());
		return "index";
	}
	
}
