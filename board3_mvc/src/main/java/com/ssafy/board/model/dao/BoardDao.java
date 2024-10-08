package com.ssafy.board.model.dao;

import java.sql.SQLException;
import java.util.List;

import com.ssafy.board.model.BoardDto;

public interface BoardDao {

	int writeArticle(BoardDto boardDto) throws SQLException;
	List<BoardDto> listArticle() throws SQLException;
	BoardDto viewArticle(int articleNo) throws SQLException;
	void updateHit(int articleNo) throws SQLException;
	
	void modifyArticle(BoardDto boardDto) throws SQLException;
	void deleteArticle(int articleNO) throws SQLException;
	
}
