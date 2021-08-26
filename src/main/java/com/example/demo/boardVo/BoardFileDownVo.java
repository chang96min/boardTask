package com.example.demo.boardVo;

import java.util.Date;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class BoardFileDownVo {
	private int id;
	private String originalName;
	private String saveDir;
	private String deleteyn;
	private Date inserttime;
	private int boardid;

}
