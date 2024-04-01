package com.vue.vo;

import java.sql.Date;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class Reply {
	
	private int replyNo;
	private int boardNo;
	private int userNo;
	private String userName;
	private String replyWriting;
	private Date enrollDate;
	private Date modifyDate;
	
}
