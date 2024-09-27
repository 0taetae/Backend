package com.book.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.book.dto.BookDTO;

import common.DBUtil;

public class BookDaoImpl implements BookDao{
	
	/*Singleton*/
	private static BookDaoImpl bookDao;
	
	public static BookDao getBookDao() {
		if(bookDao == null) {
			bookDao = new BookDaoImpl();
		}
		return bookDao;
	}
	
	@Override
	public int insertBook(BookDTO book) {
		
		// 책 정보를 emp 테이블에 삽입하는 SQL 쿼리
		String sql = "insert into bookshop(isbn, title, author, company, price) values(?,?,?,?,?)";
		
		try(Connection conn = DBUtil.getInstance().getConnection(); 
				PreparedStatement pstmt = conn.prepareStatement(sql)){
			
			pstmt.setString(1, book.getIsbn());
			pstmt.setString(2, book.getTitle());
			pstmt.setString(3, book.getAuthor());
			pstmt.setString(4, book.getCompany());
			pstmt.setInt(5, book.getPrice());
			
			return pstmt.executeUpdate();  // 쿼리 실행 및 결과 반환
			
		}catch(SQLException e) {
			e.printStackTrace();
		}
		
		return 0;
	}

	@Override
	public List<BookDTO> listbook() {
		List<BookDTO> list = new ArrayList();  // 책 정보를 저장할 리스트
		String sql = "select * from bookshop order by isbn desc";  // 내림차순으로 책 조회
		BookDTO dto = null;  // 책 정보를 담을 DTO 객체
		
		try(Connection conn = DBUtil.getInstance().getConnection();
				PreparedStatement pstmt = conn.prepareStatement(sql);
				ResultSet rs = pstmt.executeQuery()){
			
			// 책 정보를 리스트에 추가
			while(rs.next()) {
				dto = new BookDTO();  // DTO 객체 생성
				dto.setIsbn(rs.getString(1));
				dto.setTitle(rs.getString(2));
				dto.setAuthor(rs.getString(3));
				dto.setCompany(rs.getString(4));
				dto.setPrice(rs.getInt(5));
				
				list.add(dto);
			}
			
		}catch(SQLException e) {
			e.printStackTrace();
		}
		
		return list;
	}

	@Override
	public int updateBook(BookDTO book) {
		String sql = "update bookshop set price=? where isbn=?";
		
		try(Connection conn = DBUtil.getInstance().getConnection();
				PreparedStatement pstmt = conn.prepareStatement(sql)){
			
			pstmt.setInt(1, book.getPrice());
			pstmt.setString(2, book.getIsbn());
			
			return pstmt.executeUpdate();
			
		}catch(SQLException e) {
			e.printStackTrace();
		}
		
		return 0;
	}

	@Override
	public int deleteBook(BookDTO book) {
		
		String sql = "delete from bookshop where isbn=?";
		
		try(Connection conn = DBUtil.getInstance().getConnection();
				PreparedStatement pstmt = conn.prepareStatement(sql)){
			pstmt.setString(1, book.getIsbn());
			
			
			return pstmt.executeUpdate();
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}

	

}
