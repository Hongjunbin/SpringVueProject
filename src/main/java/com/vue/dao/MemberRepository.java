package com.vue.dao;

import org.apache.ibatis.annotations.Mapper;

import com.vue.vo.Member;

@Mapper
public interface MemberRepository {
	
	public Member loginMember(Member m);
	
	public int joinMember(Member m);
	
	public Member joinIdCheck(Member m);

}
