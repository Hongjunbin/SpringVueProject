package com.vue.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.vue.service.BoardService;
import com.vue.service.MemberService;
import com.vue.vo.Board;
import com.vue.vo.Member;

import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequiredArgsConstructor
public class MemberContoller {
	
	private final MemberService memberService;
	private final BoardService boardService;
	
	@PostMapping("/login")
	public ResponseEntity<Object> loginMember(@RequestBody Member m, HttpSession session) {
		Member loginUser = memberService.loginMember(m);
		
		if(loginUser == null) {
			return ResponseEntity.ok("로그인 실패");
		} else {
			session.setAttribute("loginUser", loginUser);
			return ResponseEntity.ok(loginUser);
		}
	}
	
	/**
	 * joinIdCheck(m) => id 중복체크
	 * joinMember(m) => 체크 후 회원가입
	 * ResponseEntity.ok(2) => 중복 시 정수 2 반환
	 */
	@PostMapping("/join")
	public ResponseEntity<Object> joinMember(@RequestBody Member m){
		
		if(memberService.joinIdCheck(m) == null) {
			int joinMemberResult = memberService.joinMember(m);
			if(joinMemberResult > 0) {
				return ResponseEntity.ok(joinMemberResult);
			}
			return ResponseEntity.ok("회원가입 실패!");
		}
		return ResponseEntity.ok(2);
	}
	
	@GetMapping("/myPageInfo")
	public ResponseEntity<Object> selectMyPageInfo(Member member, HttpSession session) {

		int sessionUserNo = ((Member)session.getAttribute("loginUser")).getUserNo();
		// 로그인 session에 담긴 회원정보를 통해 받아온 스토리지값의 유효성 체크
		if(member.getUserNo() == sessionUserNo) {
			List<Board> boardInfo = boardService.selectMyPageBoardInfo(member);
			Map<String, Object> userInfo = new HashMap<>();
			log.info("boardInfo = {} ", boardInfo);
			userInfo.put("boardInfo", boardInfo);
			userInfo.put("memberInfo", session.getAttribute("loginUser"));
			return ResponseEntity.ok(userInfo);
		} else {
			return ResponseEntity.ok("본인확인이 안됩니다. ( 로그아웃 후 다시 로그인해주세요. ");
		}
	}
}
