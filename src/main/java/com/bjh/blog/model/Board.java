package com.bjh.blog.model;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;

import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.CreationTimestamp;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class Board {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id ;
	
	@Column(nullable=false, length=100)
	private String title;
	
	@Lob //	대용량 데이터 시 사용
	private String content;
	
	@ColumnDefault("0")
	private int count;
	
	@ManyToOne //User랑 연관관계 맺어주는 
	@JoinColumn(name="userId") //Foreign Key
	private User user;
	
	@CreationTimestamp
	private Timestamp createDate;
}
