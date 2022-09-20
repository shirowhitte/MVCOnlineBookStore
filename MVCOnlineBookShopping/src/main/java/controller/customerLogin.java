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

import model.Customer;
import dao.customerDao;
import daoimp.customerDaoImplementation;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/customerLogin")
public class customerLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private customerDao customerDao;
    
    public void init(ServletConfig config) throws ServletException {
		customerDao = new customerDaoImplementation();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int username = Integer.parseInt(request.getParameter("uid"));
		String password = request.getParameter("pwd");
		if (username != 0 && password != null) {
			// Verify login credentials
			Customer customer = customerDao.login(username, password);
			if (customer != null) {
				HttpSession session = request.getSession();
				session.setAttribute("customer", username);
				response.sendRedirect("customerPortal");
			} else {
				response.sendRedirect("customerLogin.jsp?error=Login Failed..!");
			}
		}
	}

}



