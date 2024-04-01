package com.vue.service;

import org.springframework.stereotype.Service;

import com.vue.dao.MemberRepository;
import com.vue.vo.Member;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class MemberServiceImpl implements MemberService {
	
	private final MemberRepository memberRepository;
	
	public Member loginMember(Member m) {
		return memberRepository.loginMember(m);
	}
	
	public int joinMember(Member m) {
		return memberRepository.joinMember(m);
	}
	
	public Member joinIdCheck(Member m) {
		return memberRepository.joinIdCheck(m);
	}

}
