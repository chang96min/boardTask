package com.example.demo.boardController;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.example.demo.boardDto.BoardDto;
import com.example.demo.boardPaging.BoardPaging;
import com.example.demo.boardService.BoardService;
import com.example.demo.boardVo.BoardDetVo;
import com.example.demo.boardVo.BoardEntCountVo;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@RestController
@AllArgsConstructor
//협업 관련 - 다른 ip에서 접속 허용
@CrossOrigin(origins = "*", allowedHeaders ="*")
public class BoardController {
	
	public final BoardService boardService;

	
	//게시판 전체글 리스트 출력
	@GetMapping("/board")
	public BoardEntCountVo boardEntList(BoardPaging boardPaging) {
		
		BoardEntCountVo vo = new BoardEntCountVo();

		vo.setBoardInfo(boardService.boardInfo(boardPaging));
		vo.setTotalNum(boardService.boardCount());
		
		return vo;	
	}
	
	//게시글 상세 페이지 출력
	@GetMapping("/boardDet")
	public List<BoardDetVo> boardDet(BoardDto boardDto) {
		
		int boardId = boardDto.getId();
		
		return boardService.boardDet(boardId);
	}
	
	
	//게시글 수정 페이지
	@GetMapping("/boardModPage")
	public List<BoardDetVo> boardModPage(@RequestBody BoardDto boardDto) {
		
		int boardId = boardDto.getId();
		
		return boardService.boardDet(boardId);
	}
	
	//게시글 수정
	@PostMapping("/boardMod")
	public String boardMod(@RequestBody BoardDto boardDto) {
		
		boardService.boardMod(boardDto);
		
		return "redirect:/board";
	}
	
	//게시글 등록 페이지
	@GetMapping("/boardAddPage")
	public void boarAdd() {
		
	}
	
	//게시글 등록
	@PostMapping("/boardAdd")
	public String boardAdd(@ModelAttribute BoardDto boardDto) throws IllegalStateException, IOException {
		//첨부파일이 있으면
		if(boardDto.getFile() != null) {
			//게시글 등록
			boardService.boardAddFile(boardDto);
			//첨부파일 여러개일 경우 반복하여 각각 저장
			for(MultipartFile file : boardDto.getFile()) {
				UUID uuid = UUID.randomUUID();
			    String originalName = file.getOriginalFilename();
			    String saveName = uuid + originalName;
				File dest = new File("C:\\saveFile\\"+saveName);
				file.transferTo(dest);
				String dir = "C:\\saveFile\\" + saveName;
			
				
			//첨부파일 등록
			boardService.boardFile(originalName,dir);
			    }
		//첨부파일이 없으면
		} else {
			//게시글 등록
			boardService.boardAdd(boardDto);
		}
		return "redirect:/board";	
		
	}
		

}
