package com.ssafy.method;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name="POST",urlPatterns = {"/post.do"})
public class PostServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
       
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//1.한글처리(UTF-8, EUC-KR등)
		response.setContentType("text/html;charset=UTF-8");
		
		//2.데이터 가져오기
		String name = request.getParameter("name");
		int score = Integer.parseInt(request.getParameter("score"));
		String result = null;
		
		if(score>=60) {
			result = "합격";
		}
		else {
			result = "불합격";
		}
		
		//3.출력
		response.getWriter().append("<html><head><title></title></head>");
		response.getWriter().append("<body>");
		
		response.getWriter().append("이름: "+name+"<br>");
		response.getWriter().append("점수: "+score+"<br>");
		response.getWriter().append("결과: "+result+"<br>");
		
		response.getWriter().append("<a href='exam/getTest.html'> 뒤로</a>");	
		response.getWriter().append("</body></html>");	
	}

}
