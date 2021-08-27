package com.example.demo.boardDto;

import java.util.Date;
import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class BoardDto {   
	private int id;
	private String tit;
	private String cont;
	private Date regDate;
	private Date modDate;
	private List<MultipartFile> file;
	
	
	

	
}
