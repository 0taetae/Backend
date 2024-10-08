package com.ssafy.board.model.service;

import java.util.List;

import com.ssafy.board.model.BoardDto;
import com.ssafy.board.model.dao.BoardDaoImpl;

public class BoardServiceImpl implements BoardService {
	
	private static BoardService boardService = new BoardServiceImpl();
	
	private BoardServiceImpl() {}
	
	public static BoardService getBoardService() {
		return boardService;
	}

	@Override
	public int writeArticle(BoardDto boardDto) throws Exception {
		return 0;
	}

	@Override
	public List<BoardDto> listArticle() throws Exception {
		return BoardDaoImpl.getBoardDao().listArticle();
	}

	@Override
	public BoardDto viewArticle(int articleNo) throws Exception {
		BoardDto boardDto = BoardDaoImpl.getBoardDao().viewArticle(articleNo);
		if(boardDto != null) BoardDaoImpl.getBoardDao().updateHit(articleNo);
		return boardDto;
	}

	@Override
	public void updateHit(int articleNo) throws Exception {

	}

	@Override
	public void modifyArticle(BoardDto boardDto) throws Exception {
		// TODO : BoardDaoImpl의 modifyArticle 호출
		
	}

	@Override
	public void deleteArticle(int articleNo) throws Exception {
		// TODO : BoardDaoImpl의 deleteArticle 호출
		
	}

}
