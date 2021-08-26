package com.example.demo.boardVo;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class BoardEntCountVo {
	private List<BoardEntVo> boardInfo;
	private int totalNum;
	
}
