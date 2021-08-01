package com.bjh.blog.model;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.CreationTimestamp;

@Entity // class가 mysql에 테이블이 생성된다
public class User {
	
	@Id //primary Key
	@GeneratedValue(strategy = GenerationType.IDENTITY) //프로젝트에서 연결된 DB의 넘버링을 따라간다
	private int id ;
	
	@Column(nullable=false, length=20)
	private String username;
	
	@Column(nullable=false, length=100) // 길이를 넉넉하게 하는 이유는 나중에 해쉬로 암호화 하기 때
	private String password;
	
	@Column(nullable=false, length=50)
	private String email;
	
	@ColumnDefault("'user'")
	private String role; // 원래는 Enum을 사용 // admin, user, manager
	
	@CreationTimestamp // 생성될 때 시간 자동 입
	private Timestamp createDate;
}
