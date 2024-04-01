package com.vue.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.vue.service.BoardService;
import com.vue.vo.Board;
import com.vue.vo.Member;
import com.vue.vo.Reply;

import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequiredArgsConstructor
public class BoardController {
	
	private final BoardService boardService;
	
	@GetMapping("/board")
	public ResponseEntity<?> selectAllBoardList() {
		return ResponseEntity.ok(boardService.selectAllBoardList());
	}
	
	@GetMapping("/boardDetail")
	public ResponseEntity<?> selectBoardDetailList(@RequestParam("boardNo") int boardNo) {
		Map<String, Object> boardData = new HashMap<>();
		boardData.put("board", boardService.selectBoardDetailList(boardNo));
		boardData.put("reply", boardService.selectBoardDetailReplyList(boardNo));
		return ResponseEntity.ok(boardData);
	}
	
	@GetMapping("/boardUpdate")
	public ResponseEntity<?> boardUpdateBeforeSelect(@RequestParam("boardNo") int boardNo, HttpSession session){
		List<Board> list = boardService.selectMyPageBoardInfo((Member)session.getAttribute("loginUser"));
		
		for(int i = 0; i < list.size(); i++) {
			if(boardNo == list.get(i).getBoardNo()) {
				return ResponseEntity.ok(boardService.selectBoardDetailList(boardNo)); 
			}
		}
		return ResponseEntity.ok(false);
	}
	
	@PostMapping("/update")
	public ResponseEntity<?> boardUpdate(@RequestBody Board board){
		return ResponseEntity.ok(boardService.boardUpdate(board));
	}
	
	@PostMapping("/deleteBoard")
	public ResponseEntity<?> deleteBoard(@RequestBody Board board){
		return ResponseEntity.ok(boardService.deleteBoard(board.getBoardNo()));
	}
	
	@PostMapping("/posting")
	public ResponseEntity<?> insertBoardPosting(@RequestBody Board board, HttpSession session) {
		board.setUserNo(((Member)session.getAttribute("loginUser")).getUserNo());
		board.setUserName(((Member)session.getAttribute("loginUser")).getUserName());
		int postingResult = boardService.insertBoardPosting(board);
		if(postingResult > 0) {
			log.info("postingResult == 1 => ok : {}", postingResult);
			return ResponseEntity.ok(postingResult);
		}
		log.info("postingResult == 0 => fail : {}", postingResult);
		return ResponseEntity.ok(postingResult);
	}
	
	@PostMapping("/reply")
	public ResponseEntity<?> insertBoardReply(@RequestBody Reply reply){
		boardService.insertBoardReply(reply);
		return ResponseEntity.ok("OK");
	}
	
	@PostMapping("/replyDelete")
	public ResponseEntity<?> deleteBoardReply(@RequestBody Reply reply){
		log.info("replyNo => {} ", reply.getReplyNo());
		return ResponseEntity.ok(boardService.deleteBoardReply(reply.getReplyNo()));
	}


}
