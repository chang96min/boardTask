package com.example.demo.boardServiceImp;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.boardDto.BoardDto;
import com.example.demo.boardPaging.BoardPaging;
import com.example.demo.boardRepository.BoardMapper;
import com.example.demo.boardService.BoardService;
import com.example.demo.boardVo.BoardDetVo;
import com.example.demo.boardVo.BoardEntVo;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class BoardServiceImp implements BoardService{
	
	private final BoardMapper boardMapper;
	
	//전체 개수 구하기
	@Override
	public int boardCount(){
		
		return boardMapper.boardCount();
	}
	
	//게시판 전체글 정보(페이징o)
	@Override
	public List<BoardEntVo> boardInfo(BoardPaging boardPaging) {
		
		return boardMapper.boardInfo(boardPaging);
	}
	
	//게시판 전체글 조회
//	@Override
//	public BoardEntCountVo boardEntCountList() {
//		
//		BoardEntCountVo vo = new BoardEntCountVo();
//		
//		vo.setBoardInfo(boardInfo(boardPaging));
//		
//		
//		return 
//	}
	
	//게시글 상세 조회 (id로 조회)
	@Override
	public List<BoardDetVo> boardDet(int boardId) {
		
		return boardMapper.boardDet(boardId);
	}
	
	//게시글 수정
	@Override
	public void boardMod(BoardDto boardDto) {
		
		boardMapper.boardMod(boardDto);
	}
	
	//게시글 추가(첨부x)
	@Override
	public void boardAdd(BoardDto boardDto) {
		
		boardMapper.boardAdd(boardDto);
		
	}
	
	//게시글 추가(첨부x)
		@Override
		public void boardAddFile(BoardDto boardDto) {
			
			boardMapper.boardAddFile(boardDto);
			
		}
	
	//첨부파일 추가
	@Override
	public void boardFile(String originalName, String dir) {
		boardMapper.boardFile(originalName,dir);
	}
	
	
}
