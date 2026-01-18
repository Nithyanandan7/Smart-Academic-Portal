package com.spidy;

import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.FilterConfig;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.io.PrintWriter;

import com.spidy.dao.StudentDao;
import com.spidy.model.Student;


@WebFilter("/StudentLoginServlet")
public class UserPassFilter extends HttpFilter implements Filter {
       

	
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException 
	{
		
		HttpServletRequest req = (HttpServletRequest) request;
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		
		StudentDao filter = new StudentDao();
		Student st = filter.verifyStudent(username, password);
		
		if (st.getVerify()) 
		{
			chain.doFilter(request, response);
		}
		else
		{
			request.setAttribute("username", username);
			request.setAttribute("error", "Invalid username or password");
			RequestDispatcher rd = req.getRequestDispatcher("student-login.jsp");
			rd.forward(req, response);
			return;
		}
	}


}
