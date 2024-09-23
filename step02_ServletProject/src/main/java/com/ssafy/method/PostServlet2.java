package com.ssafy.method;

import java.io.IOException;
import java.util.Enumeration;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/post2.do")
public class PostServlet2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//1.한글처리(UTF-8, EUC-KR등)
		response.setContentType("text/html;charset=UTF-8");
		
		//2.데이터 가져오기
		String[] hobby = request.getParameterValues("hobby");
		
		if(hobby != null) {
			response.getWriter().append("<h3>** 당신의 취미 **</h3>");
			for(int i=0;i<hobby.length;i++) {
				response.getWriter().append("<li>" + hobby[i]+"</li>");
			}
		}
		Enumeration e = request.getParameterNames();
		while(e.hasMoreElements()) {
			String title = (String) e.nextElement();
			String[] v = request.getParameterValues(title);
			
			if(title.equals("hobby")) {
				continue;
			}
			for(int i=0;i<v.length;i++) {
				response.getWriter().append("<li>"+title+":"+v[i]+"</li>");
			}
		}
		
		response.getWriter().append("<a href='exam/postTest2.html'> 뒤로</a>");	
		
	}

}
