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

import model.book;
import dao.bookDao;
import daoimp.bookDaoImplementation;
/**
 * Servlet implementation class deleteBook
 */
@WebServlet("/customerViewBook")
public class customerViewBook extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private bookDao bookDao;
    public void init(ServletConfig config) throws ServletException {
    	bookDao = new bookDaoImplementation();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<book>viewBookList = bookDao.viewBookList();
		List<book>viewBookListByName = bookDao.viewBookListByName();
		List<book>viewBookListByLowestPrice = bookDao.viewBookListByLowestPrice();
		List<book>viewBookListByHighestPrice = bookDao.viewBookListByHighestPrice();
		request.setAttribute("viewBookList", viewBookList);
		request.setAttribute("viewBookListByName", viewBookListByName);
		request.setAttribute("viewBookListByLowestPrice", viewBookListByLowestPrice);
		request.setAttribute("viewBookListByHighestPrice", viewBookListByHighestPrice);
		request.getRequestDispatcher("./customerViewBook.jsp").forward(request, response);
	}
}
