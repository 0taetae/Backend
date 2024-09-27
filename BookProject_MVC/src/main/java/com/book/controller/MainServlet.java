package com.book.controller;

import java.io.IOException;
import java.util.List;

import com.book.dto.BookDTO;
import com.book.dto.LoginDTO;
import com.book.service.BookServiceImpl;
import com.book.service.LoginServiceImpl;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/main")
public class MainServlet extends HttpServlet {
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
		
		/*book*/
		case "insertbook":
			doInsert(request,response);
			break;
		
		case "listbook":
			doList(request, response);
			break;
		case "updatebook":
			doUpdate(request, response);
			break;
		case "deletebook":
			doDel(request,response);
			break;
		/*user*/
		case "login":
			doLogin(request,response);
			break;
		case "logout":
			doLogout(request, response);
			break;
		}
	}
	
	/*book*/
	private void doInsert(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		BookDTO book = new BookDTO();
		book.setIsbn(request.getParameter("isbn"));
		book.setTitle(request.getParameter("title"));
		book.setAuthor(request.getParameter("author"));
		book.setCompany(request.getParameter("company"));
		book.setPrice(Integer.parseInt(request.getParameter("price")));
		
		int n = BookServiceImpl.getBookService().insertBook(book);
		if(n>0) {
			//System.out.println("ok");
			doList(request, response);
		}else {
			System.out.println("error");
		}
	}
	
	private void doList(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<BookDTO> list = BookServiceImpl.getBookService().listBook();
		if(list != null) {
			RequestDispatcher rd = request.getRequestDispatcher("book/bookList.jsp");
			request.setAttribute("booklist", list);  // request에 책 목록 저장
			rd.forward(request, response);  // 목록 페이지로 전달
		}
		
	}
	
	private void doUpdate(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		BookDTO book = new BookDTO();
		book.setIsbn(request.getParameter("isbn"));
		book.setPrice(Integer.parseInt(request.getParameter("price")));
		
		int n = BookServiceImpl.getBookService().updateBook(book);
		if(n >0) {
			doList(request,response);  // 성공 시 목록 페이지로 이동
		}else {
			System.out.println("error");
		}
		
	}
	
	private void doDel(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		BookDTO book = new BookDTO();
		book.setIsbn(request.getParameter("isbn"));
		
		int n = BookServiceImpl.getBookService().deleteBook(book);
		
		if(n>0) {
			doList(request,response);  // 성공 시 목록 페이지로 이동
		}else {
			System.out.println("error");
		}
		
	}
	
	/*user*/
	private void doLogin(HttpServletRequest request, HttpServletResponse response) throws IOException {
		String id = request.getParameter("userid");
		String pwd = request.getParameter("userpwd");
		
		String root = request.getContextPath();  // context root
		LoginDTO dto = LoginServiceImpl.getLoginService().getLoginUser(id, pwd);
		
		if(dto != null) {
			
			// 세션 설정
			HttpSession session = request.getSession();  // 세션 생성
			session.setAttribute("logOK", dto);  // 세션에 로그인 정보 저장
			response.sendRedirect(root + "/login/loginOk.jsp");  // 로그인 성공 페이지로 이동
		}else {
			response.sendRedirect(root + "/login/loginFail.jsp");  // 로그인 실패 페이지로 이동
		}
		
	}
	
	private void doLogout(HttpServletRequest request, HttpServletResponse response) throws IOException {
		HttpSession session = request.getSession();
		LoginDTO dto = (LoginDTO) session.getAttribute("logOK");  // Object 타입 -> LoginDTO 타입
		String root = request.getContextPath();
		
		if(dto != null) {
			session.removeAttribute("logOK");  // 세션에서 로그인 정보 삭제
			
			response.sendRedirect(root + "/index.jsp");  // 로그아웃 후 메인 페이지로 이동
		}
		
	}

	

	

	

	

	

}
