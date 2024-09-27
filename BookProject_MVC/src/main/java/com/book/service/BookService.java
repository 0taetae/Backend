package com.book.service;

import java.util.List;

import com.book.dto.BookDTO;

public interface BookService {
	public int insertBook(BookDTO book);
	public List<BookDTO> listBook();
	public int updateBook(BookDTO book);
	public int deleteBook(BookDTO book);
}
