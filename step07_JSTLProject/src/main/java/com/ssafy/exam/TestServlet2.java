package com.ssafy.exam;

import java.io.IOException;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet(name = "Test2", urlPatterns = { "/test2" })
public class TestServlet2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int score=45;
		
		request.setAttribute("title", "[테스트 화면 2]");
		request.setAttribute("score", score);
		
		RequestDispatcher rd=request.getRequestDispatcher("view/test2.jsp");
		rd.forward(request, response);
	}
}
/* 점수가 60점 이상이면 "합격"  60점 미만이면 "불합격"

[테스트화면 2]
당신의 점수는 75점이고 합격하셨습니다

처음화면
*/



