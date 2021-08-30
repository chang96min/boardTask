package com.example.demo.boardService;

import java.util.List;

import com.example.demo.boardDto.BoardDto;
import com.example.demo.boardPaging.BoardPaging;
import com.example.demo.boardVo.BoardDetVo;
import com.example.demo.boardVo.BoardEntVo;
import com.example.demo.boardVo.BoardFileDownVo;

public interface BoardService{
    //전체 개수 구하기
	public int boardCount(BoardPaging boardPaging);
	
	//게시판 전체글 정보
	public List<BoardEntVo> boardInfo(BoardPaging boardPaging);
	
	//게시글 상세 조회 (id로 조회)
	public BoardEntVo boardDetInfo(int boardId);
	
	//게시글 상세 조회와 맞는 파일 정보
	public List<BoardFileDownVo> boardDetFile(int boardId);
	
	//게시글 수정
	public void boardMod(BoardDto boardDto);

	//게시글 추가(첨부x)
	public void boardAdd(BoardDto boardDto);
	
	//게시글 추가(첨부o)
	public void boardAddFile(BoardDto boardDto);

	//첨부파일 추가
	public void boardFile(String originalName, String dir);
	
	//수정 시 첨부파일 추가
	public void boardFile(String originalName, String dir, BoardDto boardDto);

	//게시글 삭제
	public void boardDel(int id);

	

	

}
