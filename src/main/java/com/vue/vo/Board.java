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
public class Board {
	
	private int boardNo;
	private int userNo;
	private String boardTitle;
	private String boardWriting;
	private String userName;
	private Date enrollDate;
	private Date modifyDate;

}
