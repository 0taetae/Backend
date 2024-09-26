package com.book.dao;

import com.book.dto.LoginDTO;

public interface LoginDao {
	public LoginDTO getLoginUser(String id,String pwd);
}
