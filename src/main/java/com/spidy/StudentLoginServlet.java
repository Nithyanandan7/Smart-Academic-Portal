package com.spidy;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

import com.spidy.dao.StudentDao;
import com.spidy.model.Student;


@WebServlet("/StudentLoginServlet")
public class StudentLoginServlet extends HttpServlet 
{
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		String username = request.getParameter("username");
		
		HttpSession session = request.getSession();
		session.setAttribute("username", username);
		
		
		StudentDao dao = new StudentDao();
		Student s1 = dao.getStudent(username);
		
		session.setAttribute("student", s1);
		response.sendRedirect("profile.jsp");
	}
}
