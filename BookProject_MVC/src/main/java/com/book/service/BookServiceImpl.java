package com.book.service;

import java.util.List;

import com.book.dao.BookDaoImpl;
import com.book.dto.BookDTO;

public class BookServiceImpl implements BookService{
	
	/*Singleton*/
	public static BookServiceImpl bookService;
	
	public static BookService getBookService() {
		if(bookService==null) {
			bookService = new BookServiceImpl();
		}
		return bookService;
	}
	
	@Override
	public int insertBook(BookDTO book) {
		
		return BookDaoImpl.getBookDao().insertBook(book);  // DAO 호출하여 책 추가
	}

	@Override
	public List<BookDTO> listBook() {
		
		return BookDaoImpl.getBookDao().listbook();  // DAO 호출하여 책 목록 조회
	}

	@Override
	public int updateBook(BookDTO book) {
		
		return BookDaoImpl.getBookDao().updateBook(book);  // DAO 호출하여 책 정보 수정
	}

	@Override
	public int deleteBook(BookDTO book) {
		
		return BookDaoImpl.getBookDao().deleteBook(book);  // DAO 호출하여 책 삭제
	}

}
