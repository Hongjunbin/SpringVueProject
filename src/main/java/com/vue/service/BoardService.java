package com.vue.service;

import java.util.List;

import com.vue.vo.Board;
import com.vue.vo.Member;
import com.vue.vo.Reply;

public interface BoardService {
	
	public List<Board> selectAllBoardList();
	
	public Board selectBoardDetailList(int boardNo);
	
	public int deleteBoard(int boardNo);
	
	public List<Reply> selectBoardDetailReplyList(int boardNo);
	
	public int insertBoardReply(Reply reply);
	
	public int insertBoardPosting(Board board);
	
	public List<Board> selectMyPageBoardInfo(Member member);
	
	public int deleteBoardReply(int replyNo);
	
	public int boardUpdate(Board board);

}
