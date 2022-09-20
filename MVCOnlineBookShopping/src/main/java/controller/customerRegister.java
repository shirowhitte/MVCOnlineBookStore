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
@WebServlet("/customerRegister")
public class customerRegister extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private customerDao customerDao;
    
    public void init(ServletConfig config) throws ServletException {
		customerDao = new customerDaoImplementation();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String firstname = request.getParameter("firstname");
		String lastname = request.getParameter("lastname");
		String contact = request.getParameter("contact");
		String email = request.getParameter("pwd");
		
		if (firstname != null && lastname != null && contact != null && email != null) {
			// Verify login credentials
			int registerCount = customerDao.registerCustomer(new Customer(firstname, lastname,email, contact));
			if (registerCount > 0) {
				request.setAttribute("msg","You have successfully registered a customer account.");
			} else {
				request.setAttribute("msg","Failed to register a customer account...");
			}
			request.getRequestDispatcher("customerRegister.jsp").forward(request, response);
			
		}
	}
}



