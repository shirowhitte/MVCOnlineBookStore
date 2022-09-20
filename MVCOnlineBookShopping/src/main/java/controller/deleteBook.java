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
@WebServlet("/deleteBook")
public class deleteBook extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private bookDao bookDao;
    public void init(ServletConfig config) throws ServletException {
    	bookDao = new bookDaoImplementation();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<book>list = bookDao.list();
		request.setAttribute("list", list);
		request.getRequestDispatcher("./deleteBook.jsp").forward(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		if(request.getParameter("bnamedel")!=null)
		{
			int bname = Integer.parseInt(request.getParameter("bnamedel"));
			bookDao.delete(bname);
			List<book>list = bookDao.list();
			request.setAttribute("list", list);
			request.getRequestDispatcher("./deleteBook.jsp").forward(request, response);
		}
	}

}
