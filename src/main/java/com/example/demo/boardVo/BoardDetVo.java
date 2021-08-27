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
	private BoardEntVo boardDetInfoVo;
	private List<BoardFileDownVo> boardDetFileVo;
}
