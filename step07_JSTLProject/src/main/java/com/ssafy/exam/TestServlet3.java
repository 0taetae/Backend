package com.ssafy.exam;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/test3")
public class TestServlet3 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String[] color = {"red","green","blue"};
		int num = 10;
		
		request.setAttribute("color", color);
		request.setAttribute("num", num);
		
		RequestDispatcher rd = request.getRequestDispatcher("view/test3.jsp");
		rd.forward(request, response);
	}

}

/*
[테스트화면 3]
red
green
blue

1 2 3 4 5 6 7 8 9 10
*/
