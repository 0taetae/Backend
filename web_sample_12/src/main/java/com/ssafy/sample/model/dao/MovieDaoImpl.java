package com.ssafy.sample.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.ssafy.sample.dto.MovieDTO;
import com.ssafy.sample.util.DBUtil;

public class MovieDaoImpl implements MovieDao {
	
	private static MovieDaoImpl movieDao;
	
	public static MovieDao getMovieDao() {
		if(movieDao == null) {
			movieDao = new MovieDaoImpl();
		}
		return movieDao;
	}
	
	// select -> resultset, executeQuery
	// insert, update, delete -> executeUpdate

	@Override
	public List<MovieDTO> selectAll() throws SQLException {
		
		List<MovieDTO> list = new ArrayList<>();
		String sql = "select * from movies";
		MovieDTO dto = null;
		
		try(Connection conn = DBUtil.getInstance().getConnection();
				PreparedStatement pstmt = conn.prepareStatement(sql);
				ResultSet rs = pstmt.executeQuery()){
			
			while(rs.next()) {
				dto = new MovieDTO();
				dto.setCode(rs.getString(1));
				dto.setTitle(rs.getString(2));
				dto.setTime(rs.getInt(3));
				dto.setDirector(rs.getString(4));
				dto.setGenre(rs.getString(5));
				
				list.add(dto);
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
		
		return list;
	}

	@Override
	public MovieDTO selectByCode(String code) throws SQLException {
		return null;
	}

	@Override
	public int insert(MovieDTO product) throws SQLException {
		return 0;
	}

	@Override
	public int deleteByCode(String code) throws SQLException {
		return 0;
	}

	@Override
	public int update(MovieDTO product) throws SQLException {
		return 0;
	}

}
