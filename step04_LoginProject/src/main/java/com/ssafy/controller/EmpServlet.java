package com.ssafy.controller;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

import com.ssafy.dto.EmpDTO;
import com.ssafy.service.EmpServiceImpl;

@WebServlet("/emp")
public class EmpServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		process(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		process(request, response);
	}
	
	protected void process(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action = request.getParameter("action");
		
		switch(action) {
		case "insertemp":
			doInsert(request, response);
			break;
		case "listemp":
			doList(request, response);
			break;
		case "updateemp":
			doUpdate(request,response);
			break;
		case "deleteemp":
			doDel(request,response);
			break;
		}
	}
	
	private void doInsert(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		EmpDTO emp = new EmpDTO();
		emp.setEname(request.getParameter("ename"));
		emp.setPhone(request.getParameter("phone"));
		emp.setDept(request.getParameter("dept"));
		
		int n = EmpServiceImpl.getEmpService().insertEmp(emp);
		if(n>0) {
			//System.out.println("ok");
			doList(request, response);
		}else {
			System.out.println("error");
		}
	}

	private void doDel(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		EmpDTO emp = new EmpDTO();
		emp.setEno(Integer.parseInt(request.getParameter("eno")));
		
		int n = EmpServiceImpl.getEmpService().deleteEmp(emp);
		if(n>0) {
			doList(request,response);
		}else {
			System.out.println("error");
		}
	}

	private void doUpdate(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		EmpDTO emp = new EmpDTO();
		emp.setEno(Integer.parseInt(request.getParameter("eno")));
		emp.setPhone(request.getParameter("phone"));
		emp.setDept(request.getParameter("dept"));
		
		int n = EmpServiceImpl.getEmpService().updateEmp(emp);
		if(n>0) {
			doList(request, response);
		}else {
			System.out.println("error");
		}
	}

	private void doList(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<EmpDTO> list = EmpServiceImpl.getEmpService().listEmp();
		if(list != null) {
			// request 객체
			RequestDispatcher rd = request.getRequestDispatcher("emptest/empList.jsp");
			request.setAttribute("emplist", list); // request 명 : emplist
			rd.forward(request, response);
		}
	}

	

}
