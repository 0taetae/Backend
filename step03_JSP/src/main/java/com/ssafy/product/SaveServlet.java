package com.ssafy.product;

import java.io.IOException;
import java.util.ArrayList;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet(name="SAVE", urlPatterns = "/save")
public class SaveServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		
		String p=request.getParameter("item");
		HttpSession session=request.getSession();
		
		ArrayList<String> list=(ArrayList<String>)session.getAttribute("shop");  //장바구니: shop
		if(list == null) {
			list=new ArrayList<>();
			list.add(p);
			session.setAttribute("shop", list);
		}else {
			list.add(p);
		}
		
		//-------------------------------------------------------
		response.getWriter().append("<html><head></head><body>");
		response.getWriter().append("Product Added<br>");
		response.getWriter().append("<a href='/lab/basket?type=0'>MyCard</a>");
		response.getWriter().append("</body></html>");
	}
}

















