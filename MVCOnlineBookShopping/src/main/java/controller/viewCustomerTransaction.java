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

import model.History;
import model.bookOrder;
import dao.bookOrderDao;
import daoimp.bookOrderDaoImplementation;
/**
 * Servlet implementation class transactionHistory
 */
@WebServlet("/viewCustomerTransaction")
public class viewCustomerTransaction extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private bookOrderDao bookOrderDao;
    public void init(ServletConfig config) throws ServletException {
    	bookOrderDao = new bookOrderDaoImplementation();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<History>viewCustomerTransaction = bookOrderDao.viewCustomerTransaction();
		request.setAttribute("viewCustomerTransaction", viewCustomerTransaction);
		request.getRequestDispatcher("./viewCustomerTransaction.jsp").forward(request, response);
	}

}

