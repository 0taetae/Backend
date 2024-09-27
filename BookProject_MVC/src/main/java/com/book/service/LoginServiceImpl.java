package com.book.service;

import com.book.dao.LoginDaoImpl;
import com.book.dto.LoginDTO;

public class LoginServiceImpl implements LoginService{

	private static LoginServiceImpl loginService;
	
	public static LoginService getLoginService() {
		if(loginService == null) {
			loginService = new LoginServiceImpl();
		}
		return loginService;
	}
	
	@Override
	public LoginDTO getLoginUser(String id, String pwd) {
		return LoginDaoImpl.getLoginDao().getLoginUser(id, pwd);
	}

}
