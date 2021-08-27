package com.example.demo.boardVo;

import java.util.Date;

import com.example.demo.boardService.BoardService;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class BoardEntVo {

	private String tit;
	private Date regDate;
	private int id;
	private String cont;
	private Date modDate;
	private int accountId;
	private String name;
	
}

