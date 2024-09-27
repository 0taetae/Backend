package com.book.service;

import com.book.dto.LoginDTO;

public interface LoginService {
	public LoginDTO getLoginUser(String id, String pwd);
}
