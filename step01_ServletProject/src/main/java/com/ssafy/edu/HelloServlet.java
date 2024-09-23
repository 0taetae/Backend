package com.ssafy.edu;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

public class HelloServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//1.한글처리(UTF-8, EUC-KR등)
		response.setContentType("text/html;charset=UTF-8");
		
		//2.출력
		response.getWriter().append("<html><head><title></title></head>");
		response.getWriter().append("<body>");
		response.getWriter().append("헬로우 서블릿<br>");
		response.getWriter().append("<a href='NextServlet'>다음으로</a>");
		response.getWriter().append("</body></html>");
	}

}
