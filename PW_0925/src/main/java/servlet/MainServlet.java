package servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

import dto.Book;

@WebServlet("/main")
public class MainServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		process(request,response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		process(request, response);
	}
	
	private void process(HttpServletRequest request, HttpServletResponse response) throws IOException {
		String action = request.getParameter("action");
		switch(action) {
		case "regist":
			doRegist(request,response);
			break;
		}
	}

	private void doRegist(HttpServletRequest request, HttpServletResponse response) throws IOException {
		String isbn = request.getParameter("isbn");
		String title = request.getParameter("title");
		String author = request.getParameter("author");
		int price = Integer.parseInt(request.getParameter("price"));
		String desc = request.getParameter("desc");
		
		Book book = new Book(isbn,title, author, price, desc);
		
		StringBuilder output = new StringBuilder();
		
		output.append("<html><boby>").append("<h1>입력 내용</h1>").append(book.toString()).append("</body></html>");
		
		response.setContentType("text/html; charset=UTF-8");
		response.getWriter().write(output.toString());
		
		
	}
	
	

}
