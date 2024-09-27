package com.ssafy.sample.model.dao;

import java.sql.SQLException;
import java.util.List;

import com.ssafy.sample.dto.MovieDTO;

public interface MovieDao {

	/**
	 * 영화 전체 목록 조회
	 */
	public List<MovieDTO> selectAll() throws SQLException;
	
	/**
	 * 영화 상세 조회
	 */
	public MovieDTO selectByCode(String code) throws SQLException;
	
	/**
	 * 영화 정보 추가
	 */
	public int insert(MovieDTO product) throws SQLException;
	
	/**
	 * 영화 정보 삭제
	 */
	public int deleteByCode(String code) throws SQLException;

	/**
	 * 영화 정보 수정
	 */
	public int update(MovieDTO product) throws SQLException;
	
	
	// select -> DTO 타입
	// insert, delete, update -> int 타입
}
