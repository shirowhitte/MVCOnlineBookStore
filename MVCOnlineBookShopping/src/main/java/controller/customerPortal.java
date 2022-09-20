package controller;

import java.io.IOException;
import java.sql.PreparedStatement;
import java.util.List;

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
 * Servlet implementation class deleteBook
 */
@WebServlet("/customerPortal")
public class customerPortal extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private customerDao customerDao;
    public void init(ServletConfig config) throws ServletException {
    	customerDao = new customerDaoImplementation();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		int customerId = (Integer)session.getAttribute("customer");
		if (customerId != 0) {
			String customer = customerDao.getCustomerName(customerId);
			if (customer != null) {
				session.setAttribute("customerName", customer);
				request.getRequestDispatcher("./customerPortal.jsp").forward(request, response);
			} 
		}
	}

}
