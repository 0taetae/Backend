package com.ssafy.method;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/get.do")
public class GetServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//1.한글처리(UTF-8, EUC-KR등)
		response.setContentType("text/html;charset=UTF-8");
		
		//2.데이터 가져오기
		String name = request.getParameter("irum");
		String pass = request.getParameter("amho");
		
		//3.출력
		response.getWriter().append("<html><head><title></title></head>");
		response.getWriter().append("<body>");
		
		response.getWriter().append("이름: "+name+"<br>");
		response.getWriter().append("암호: "+pass+"<br>");
		
		response.getWriter().append("<a href='/edu/exam/getTest.html'> 뒤로</a>");	
		response.getWriter().append("</body></html>");	
	}

}
