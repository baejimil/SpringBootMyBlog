package com.bjh.blog.test;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class TempControllerTest {
	
	@GetMapping("/test/home")
	public String tempHome() {
		System.out.println("tempHome()");
		
		// 파일 리턴 기본 경로 : src/main/resources/static
		// 그렇기 때문에 리턴 값에 / 를 붙여서 리턴 !
		// return "/    " ;
		// 풀경로 : src/main/resources/static/home.html
		return "/Home.html";
	}
	
	@GetMapping("/test/img")
	public String tempImg() {
		System.out.println("tempImg()");
		return "/androidLogo.png";
	}
	
	@GetMapping("/test/jsp")
	public String tempJsp() {
		System.out.println("tempJsp()");
		// prefix : /WEB-INF/views/  ( 앞에 붙는 것 )
		// suffix : .jsp ( 뒤에 붙는 것 )
		// 따라서 풀경로 : /WEB-INF/views/test.jsp
		return "test";
	}
}
