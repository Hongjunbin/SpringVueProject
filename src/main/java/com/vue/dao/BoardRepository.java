package com.vue.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.vue.vo.Board;
import com.vue.vo.Member;
import com.vue.vo.Reply;

@Mapper
public interface BoardRepository {
	
	public List<Board> selectAllBoardList();
	
	public Board selectBoardDetailList(@Param("boardNo") int boardNo);
	
	public int deleteBoard(@Param("boardNo") int boardNo);
	
	public List<Reply> selectBoardDetailReplyList(@Param("boardNo") int boardNo);
	
	public int insertBoardReply(Reply reply);
	
	public int insertBoardPosting(Board board);
	
	public Board selectMyPageInfo(Board board);
	
	public List<Board> selectMyPageBoardInfo(Member member);
	
	public int deleteBoardReply(@Param("replyNo") int replyNo);
	
	public int boardUpdate(Board board);

}
