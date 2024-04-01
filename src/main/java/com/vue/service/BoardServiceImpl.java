package com.vue.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.vue.dao.BoardRepository;
import com.vue.vo.Board;
import com.vue.vo.Member;
import com.vue.vo.Reply;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class BoardServiceImpl implements BoardService {
	
	private final BoardRepository boardRepository;
	
	@Override
	public List<Board> selectAllBoardList(){
		return boardRepository.selectAllBoardList();
	}
	@Override
	public Board selectBoardDetailList(int boardNo){
		return boardRepository.selectBoardDetailList(boardNo);
	}
	@Override
	public int deleteBoard(int boardNo) {
		return boardRepository.deleteBoard(boardNo);
	}
	@Override
	public List<Reply> selectBoardDetailReplyList(int boardNo) {
		return boardRepository.selectBoardDetailReplyList(boardNo);
	}
	@Override
	public int insertBoardReply(Reply reply) {
		return boardRepository.insertBoardReply(reply);
	}
	@Override
	public int insertBoardPosting(Board board) {
		return boardRepository.insertBoardPosting(board);
	}
	@Override
	public List<Board> selectMyPageBoardInfo(Member member) {
		return boardRepository.selectMyPageBoardInfo(member);
	}
	@Override
	public int deleteBoardReply(int replyNo) {
		return boardRepository.deleteBoardReply(replyNo);
	}
	
	@Override
	public int boardUpdate(Board board) {
		return boardRepository.boardUpdate(board);
	}

}
