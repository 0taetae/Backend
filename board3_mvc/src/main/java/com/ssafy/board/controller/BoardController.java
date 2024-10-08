package com.ssafy.board.controller;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

import com.ssafy.board.model.BoardDto;
import com.ssafy.board.model.service.BoardServiceImpl;

@WebServlet("/article")
public class BoardController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String act = request.getParameter("act");
		System.out.println("act =====> " + act);
		
		String path = "";
		if("list".equals(act)) {
			//List<BoardDto> lst = BoardServiceImpl.getBoardService().listArticle();
			path = list(request, response);
			//RequestDispatcher disp = request.getRequestDispatcher(path);
			//disp.forward(request, response);
			forward(request, response, path);
			
		} else if("view".equals(act)) {
			path = view(request, response);
			forward(request, response, path);
			
		} else if("mvwrite".equals(act)) {
			redirect(request, response, "/board/write.jsp");
			
		} else if("write".equals(act)) {
			
		} else if("mvmodify".equals(act)) {
			
		} else if("modify".equals(act)) {
			
		} else if("delete".equals(act)) {
			
		} else {
			
		}
	}

	private String view(HttpServletRequest request, HttpServletResponse response) {
		
		try {
			int articleNo = Integer.parseInt(request.getParameter("articleno"));
			BoardDto boardDto = BoardServiceImpl.getBoardService().viewArticle(articleNo);
			request.setAttribute("article", boardDto);
			return "/board/view.jsp";
		} catch (Exception e) {
			e.printStackTrace();
			return "/index.jsp";
		}
	}

	private String list(HttpServletRequest request, HttpServletResponse response) {
		try {
			List<BoardDto> list = BoardServiceImpl.getBoardService().listArticle();
			request.setAttribute("articles", list);
			return "/board/list.jsp";
		} catch (Exception e) {
			e.printStackTrace();
			return "/index.jsp";
		}
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
	
	private void forward(HttpServletRequest request, HttpServletResponse response, String path)
			throws ServletException, IOException {
		RequestDispatcher dispatcher = request.getRequestDispatcher(path);
		dispatcher.forward(request, response);
	}

	private void redirect(HttpServletRequest request, HttpServletResponse response, String path) throws IOException {
		response.sendRedirect(request.getContextPath() + path);
	}
	
	private String mvModify(HttpServletRequest request, HttpServletResponse response) {
		// TODO : 수정하고자하는 글의 글번호를 얻는다.
		// TODO : 글번호에 해당하는 글정보를 얻고 글정보를 가지고 modify.jsp로 이동.
		return null;
	}

	private String modify(HttpServletRequest request, HttpServletResponse response) {
		// TODO : 수정 할 글정보를 얻고 BoardDto에 set.
		// TODO : boardDto를 파라미터로 service의 modifyArticle() 호출.
		// TODO : 글수정 완료 후 view.jsp로 이동.(이후의 프로세스를 생각해 보세요.)
		return null;
	}

	private String delete(HttpServletRequest request, HttpServletResponse response) {
		// TODO : 삭제할 글 번호를 얻는다.
		// TODO : 글번호를 파라미터로 service의 deleteArticle()을 호출.
		// TODO : 글삭제 완료 후 list.jsp로 이동.(이후의 프로세스를 생각해 보세요.)
		return null;
	}

}
