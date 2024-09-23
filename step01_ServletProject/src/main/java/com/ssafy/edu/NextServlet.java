package com.ssafy.edu;

import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class NextServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//1.한글처리(UTF-8, EUC-KR등)
		response.setContentType("text/html;charset=UTF-8");
		
		//2.출력
		response.getWriter().append("<html><head><title></title></head>");
		response.getWriter().append("<body>");
		response.getWriter().append("넥스트 서블릿<br>");
		response.getWriter().append("<a href='HelloServlet'>이전으로</a>");
		response.getWriter().append("</body></html>");
	}

}
