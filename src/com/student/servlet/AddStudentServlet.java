package com.student.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.student.entity.Student;
import com.student.service.IStudentService;
import com.student.service.StudentServiceImpl;

public class AddStudentServlet extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		int no = Integer.parseInt(request.getParameter("sno"));
		String name = request.getParameter("sname");
		int age = Integer.parseInt(request.getParameter("sage"));
		String address = request.getParameter("saddress"); 
		Student student = new Student(no, name, age, address);
		IStudentService studentService = new StudentServiceImpl();
		boolean result = studentService.addStudent(student);
		/**
		 * out request response session  application
		 */
		response.setContentType("text/html; charset=UTF-8");
		response.setCharacterEncoding("utf-8");
		if (!result) {
			request.setAttribute("error", "addError");
		} else{
			request.setAttribute("error", "noAddError");
		}
		request.getRequestDispatcher("QueryStudentServlet").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
