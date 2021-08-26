package com.example.demo.boardVo;

import java.util.Date;

import com.example.demo.boardService.BoardService;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class BoardEntVo {

	private int id;
	private String tit;
	private String cont;
	private Date regDate;
	private Date modDate;
	
}

