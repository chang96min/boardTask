package com.example.demo.boardPaging;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
public class BoardPaging {
	
	//현재 페이지 번호
	private int currentPageNo;
	//페이지당 표시할 데이터 개수
	private int recordsPerPage;
	//화면 하단에 출력할 페이지 사이즈
	private int pageSize;
	//검색 키워드
	private String searchKeyword;
	//검색 키워드의 타입(ex:제목,작성자 등)
	private String searchType;
	
	//기본생성자
	public BoardPaging() {
		//현재 페이지 번호
		this.currentPageNo = 1;
		//페이지당 표시할 데이터 개수
		this.recordsPerPage = 10;
		//화면 하단에 출력할 페이지 사이즈
		this.pageSize = 10;
		//검색 키워드의 타입
		this.searchType = "tit";
	}
	
	//페이지 번호 클릭시 메서드
	public int getStartPage() {
		return (currentPageNo - 1) * recordsPerPage;
	}

}
