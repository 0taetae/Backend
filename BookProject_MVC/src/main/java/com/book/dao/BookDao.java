package com.book.dao;

import java.util.List;

import com.book.dto.BookDTO;

public interface BookDao {
	public int insertBook(BookDTO book);
	public List<BookDTO> listbook();
	public int updateBook(BookDTO book);
	public int deleteBook(BookDTO book);
}
