package com.student.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.student.entity.Student;
import com.student.service.IStudentService;
import com.student.service.StudentServiceImpl;

public class QueryStudentBySnoServlet extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		int no = Integer.parseInt(request.getParameter("sno"));
		IStudentService studentService = new StudentServiceImpl();
		Student student = null;
		student = studentService.queryStudentBySno(no);
		
		request.setAttribute("student", student);
		request.getRequestDispatcher("student.jsp").forward(request, response);
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
