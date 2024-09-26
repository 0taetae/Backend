package com.ssafy.exam;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/test1")
public class TestServlet1 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String name="개나리";
		int age = 22;
		
		request.setAttribute("irum", name);
		request.setAttribute("nai", age);
		
		RequestDispatcher rd = request.getRequestDispatcher("view/test1.jsp");
		rd.forward(request, response);
	}

}
