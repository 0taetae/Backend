package com.book.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.book.dto.LoginDTO;

import common.DBUtil;

public class LoginDaoImpl implements LoginDao{
	
	/*Singleton 패턴*/
	private static LoginDaoImpl loginDao;
	public static LoginDao getLoginDao() {
		if(loginDao==null) {
			loginDao = new LoginDaoImpl();
		}
		return loginDao;
		
	}

	@Override
	public LoginDTO getLoginUser(String id, String pwd) {
		LoginDTO dto = null;  // 조회된 사용자 정보 저장
		Connection conn = null;  // DB 연결
		PreparedStatement pstmt = null;  // SQL 실행
		ResultSet rs = null;  // SQL 조회 결과 저장
		
		try {
			String sql = "select * from users where id=? and pwd=?";
			conn = DBUtil.getInstance().getConnection();  // DB 연결
			pstmt = conn.prepareStatement(sql);  // SQL 쿼리 준비
			pstmt.setString(1, id);
			pstmt.setString(2, pwd);
			rs = pstmt.executeQuery();  // 쿼리 실행 및 결과 저장
			
			// 결과 존재할 경우 DTO에 값 설정
			if(rs.next()) {
				dto = new LoginDTO();  // DTO 객체 생성
				dto.setId(rs.getString("id"));  // 조회된 사용자 ID 설정
				dto.setPwd(rs.getString("pwd"));
				dto.setName(rs.getString("name"));
				dto.setPoint(rs.getDouble("point"));
			}
			
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			DBUtil.getInstance().close(rs,pstmt,conn);
		}
		
		return dto;  // 조회된 사용자 정보를 담은 DTO 반환
	}
	
	

}
