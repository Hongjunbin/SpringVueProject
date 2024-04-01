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
public class Member {
	
	private int userNo;
	private String userId;
	private String userPwd;
	private String userName;
	private Date enrollDate;
	private Date modifyDate;

}
