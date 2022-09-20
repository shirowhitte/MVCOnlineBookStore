package controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.Admin;
import dao.adminDao;
import daoimp.adminDaoImplementation;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/adminLogin")
public class adminLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private adminDao adminDao;
    
    public void init(ServletConfig config) throws ServletException {
		adminDao = new adminDaoImplementation();
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int username = Integer.parseInt(request.getParameter("username"));
		String password = request.getParameter("password");
		if (username != 0 && password != null) 
		{
			Admin admin = adminDao.login(username, password);
			if (admin != null) 
			{
				HttpSession session = request.getSession();
				session.setAttribute("admin", admin);
				response.sendRedirect("adminPortal.jsp");
			} 
			else 
			{
				response.sendRedirect("login.jsp?error=Login Failed..!");
			}
		}
	}

}



