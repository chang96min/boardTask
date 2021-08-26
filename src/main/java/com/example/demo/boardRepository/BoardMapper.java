package com.example.demo.boardRepository;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.example.demo.boardDto.BoardDto;
import com.example.demo.boardPaging.BoardPaging;
import com.example.demo.boardVo.BoardDetVo;
import com.example.demo.boardVo.BoardEntVo;
import com.example.demo.boardVo.BoardFileDownVo;

@Mapper
public interface BoardMapper {
	
	//전체 개수 구하기
	int boardCount();
	
	//전체 게시글 조회(페이징o)
	List<BoardEntVo> boardInfo(@Param("pag")BoardPaging boardPaging);

	//게시글 상세 조회(id로 조회)
	List<BoardDetVo> boardDet(@Param("id")int boardId);
	
	//게시글 수정
	void boardMod(@Param("board")BoardDto boardDto);

	//게시글 추가(첨부x)
	void boardAdd(@Param("board") BoardDto boardDto);

	//게시글 추가(첨부o)
	void boardAddFile(@Param("board") BoardDto boardDto);
	
	//첨부파일 추가
	void boardFile(@Param("originalName")String originalName, @Param("dir")String dir);
	
	//첨부파일 다운로드
	BoardFileDownVo boardFileDown(@Param("id") int boardId);

	

}
