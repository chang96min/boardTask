package com.example.demo.boardVo;

import java.util.Date;
import java.util.List;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class BoardDetVo {
	private String tit;
	private String cont;
	private Date regDate;
	private Date modDate;
	private int id;
	private String originalName;
	private String saveDir;
	private String deleteyn;
	private Date inserttime;
	private Date deletetime;
	private int boardid;
}
