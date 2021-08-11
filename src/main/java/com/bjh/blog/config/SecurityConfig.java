package com.bjh.blog.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

//빈 등록 : 스프링 컨테이너에서 객체를 관리할 수 있게 하는 것
@Configuration
@EnableWebSecurity // 	시큐리티 필터가 등록이 된다 
@EnableGlobalMethodSecurity(prePostEnabled = true) //	특정 주소로 접근하면 권한 및 인증을 미리 체크하겠다는 뜻 
//	위에 세개는 세트 
public class SecurityConfig extends WebSecurityConfigurerAdapter{
	
	@Bean // IoC가 됨!! 
	public BCryptPasswordEncoder encodePWD() {
		return new BCryptPasswordEncoder();
	}
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		
		// auth로 들어온 요청은 모두 허용하고 다른 요청은 권한이 필요하다
		http
		.csrf().disable() // csrf 토큰 비활성화 (테스트시 걸어두는게 좋음 
		.authorizeRequests()
			.antMatchers("/", "/auth/**", "/css/**", "/js/**", "/image/**")
			.permitAll()
			.anyRequest()
			.authenticated()
		.and()
			.formLogin()
			.loginPage("/auth/loginForm"); //	다른 권한이 올 때 해당 페이지로 가겠다 
	}
}
