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

import java.io.IOException;

import com.spidy.dao.AdminDao;
import com.spidy.dao.StudentDao;
import com.spidy.model.Student;


@WebFilter("/AdminLoginServlet")
public class AdminPassFilter extends HttpFilter implements Filter 
{
       

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException 
	{

		HttpServletRequest req = (HttpServletRequest) request;
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		
		AdminDao filter = new AdminDao();
		Admin ad = filter.verifyAdmin(username, password);
		
		if (ad.getVerify()) 
		{
			chain.doFilter(request, response);
		}
		else
		{
			request.setAttribute("username", username);
			request.setAttribute("error", "Invalid username or password");
			RequestDispatcher rd = req.getRequestDispatcher("admin-login.jsp");
			rd.forward(req, response);
			return;
		}
		
	}

}
