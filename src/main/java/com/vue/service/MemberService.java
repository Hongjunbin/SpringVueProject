package com.vue.service;

import com.vue.vo.Member;

public interface MemberService {
	
	public Member loginMember(Member m);
	
	public int joinMember(Member m);
	
	public Member joinIdCheck(Member m);

}
