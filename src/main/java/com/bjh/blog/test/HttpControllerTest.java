package com.bjh.blog.test;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


// 사용자가 요청 -> 응답(HTML) @Controller
// 사용자가 요청 -> 응답(DATA) @RestController
@RestController
public class HttpControllerTest {
	
	// 인터넷 브라우저 요청은 무조건 GET 요청밖에 할 수 없다!!!
	// https://localhost:8080/http/get
	@GetMapping("/http/get")
	public String getTest(Member m) {
		return "GET 요청:"+m.getId()+","+m.getUsername()+","+m.getPassword()+","+m.getEmail();
	}
	
	@PostMapping("/http/post")
	public String postTest(@RequestBody Member m) { //MessageConverter 라는 SPRING 기능이 json을 변환해서 출력
		return "POST 요청: "+m.getId()+","+m.getUsername()+","+m.getPassword()+","+m.getEmail();
		}
	
	@PutMapping("/http/put")
	public String putTest() {
		return "PUT 요청: ";
	}
	
	@DeleteMapping("/http/delete")
	public String deleteTest() {
		return "DELETE 요청: ";
}

}
