package com.ssafy.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

import com.ssafy.dto.LoginDTO;
import com.ssafy.service.LoginServiceImpl;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		process(request,response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		process(request,response);
	}
	protected void process(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action = request.getParameter("action");
		
		switch(action) {
		case "login" : 
			doLogin(request, response);
			break;
		case "logout" : 
			doLogout(request, response);
			break;
		}
	}
	
	private void doLogin(HttpServletRequest request, HttpServletResponse response) throws IOException {
		String id = request.getParameter("id");
		String pwd = request.getParameter("pwd");
		
		String root = request.getContextPath();  // context root
		LoginDTO dto = LoginServiceImpl.getLoginService().getLoginUser(id, pwd);
		
		if(dto != null) {
			
			// 세션 설정
			HttpSession session = request.getSession();
			session.setAttribute("logOK", dto);  // 세션이름: logOK
			
			//System.out.println("OK");
			response.sendRedirect(root + "/logtest/loginOK.jsp");
		}else {
			response.sendRedirect(root + "/logtest/loginFail.jsp");
		}
	}
	
	private void doLogout(HttpServletRequest request, HttpServletResponse response) throws IOException {
		HttpSession session = request.getSession();
		LoginDTO dto = (LoginDTO) session.getAttribute("logOK");
		String root = request.getContextPath();
		
		if(dto !=null) {
			session.removeAttribute("logOK");
			
			response.sendRedirect(root + "/index.jsp");
		}
	}
	

}
