package myproject.studentportal.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import myproject.studentportal.dto.Student;
import myproject.studentportal.factory.StudentServiceFactory;
import myproject.studentportal.service.StudentService;

@WebServlet("*.do")
public class ControllerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String reqPath = request.getRequestURI();
		StudentService studentService = StudentServiceFactory.getStudentService();
		if (reqPath.endsWith("add.do")) {
			String sid = request.getParameter("sid");
			String sname = request.getParameter("sname");
			String saddr = request.getParameter("saddr");
			
			Student student = new Student();
			student.setSid(sid);
			student.setSname(sname);
			student.setSaddr(saddr);
		
			String status = studentService.addStudent(student);
			RequestDispatcher requestDispatcher = null;
			if(status.equals("success")) {
				requestDispatcher = request.getRequestDispatcher("success.html");
				requestDispatcher.forward(request, response);
			}
			if(status.equals("failure")) {
				requestDispatcher = request.getRequestDispatcher("failure.html");
				requestDispatcher.forward(request, response);
			}
			if(status.equals("existed")) {
				requestDispatcher = request.getRequestDispatcher("existed.html");
				requestDispatcher.forward(request, response);
			}
		}
		if (reqPath.endsWith("search.do")) {
			String sid = request.getParameter("sid");
			Student student = studentService.searchStudent(sid);
			RequestDispatcher requestDispatcher = null;
			if(student!=null) {
				request.setAttribute("student", student);
				requestDispatcher = request.getRequestDispatcher("display.jsp");
				requestDispatcher.forward(request, response);
			}else {
				requestDispatcher = request.getRequestDispatcher("notexisted.html");
				requestDispatcher.forward(request, response);
			}
			
		}
		if (reqPath.endsWith("delete.do")) {
			String sid = request.getParameter("sid");
			String status = studentService.deleteStudent(sid);
			RequestDispatcher requestDispatcher = null;
			if(status.equals("success")) {
				requestDispatcher = request.getRequestDispatcher("success.html");
				requestDispatcher.forward(request, response);
			}
			if(status.equals("failure")) {
				requestDispatcher = request.getRequestDispatcher("failure.html");
				requestDispatcher.forward(request, response);
			}
			if(status.equals("notexisted")) {
				requestDispatcher = request.getRequestDispatcher("notexisted.html");
				requestDispatcher.forward(request, response);
			}
		}

	}

}
