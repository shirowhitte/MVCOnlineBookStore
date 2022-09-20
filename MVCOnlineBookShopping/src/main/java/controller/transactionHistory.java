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
@WebServlet("/transactionHistory")
public class transactionHistory extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private bookOrderDao bookOrderDao;
    public void init(ServletConfig config) throws ServletException {
    	bookOrderDao = new bookOrderDaoImplementation();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		int bid = (Integer)session.getAttribute("customer");
		List<History>viewTransactionHistory = bookOrderDao.viewTransactionHistory(bid);
		request.setAttribute("viewTransactionHistory", viewTransactionHistory);
		request.getRequestDispatcher("./transactionHistory.jsp").forward(request, response);
	}

}

