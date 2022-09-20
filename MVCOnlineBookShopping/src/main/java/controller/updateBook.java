package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.Customer;
import model.book;
import dao.bookDao;
import daoimp.bookDaoImplementation;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/updateBook")
public class updateBook extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private bookDao bookDao;
    
    public void init(ServletConfig config) throws ServletException {
    	bookDao = new bookDaoImplementation();
	}
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<book>list = bookDao.list();
		request.setAttribute("list", list);
		request.getRequestDispatcher("./updateBook.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		book book = new book();
		if(request.getParameter("update")!=null)
		{
			String update = request.getParameter("update");
			if(update.equalsIgnoreCase("price"))
			{
				int id = Integer.parseInt(request.getParameter("bn"));
				double bprice = Double.parseDouble(request.getParameter("price"));
				book.setBid(id);
				book.setBprice(bprice);
				bookDao.updatePrice(book);

			}
			else if(update.equalsIgnoreCase("stock"))
			{
				int id = Integer.parseInt(request.getParameter("bn"));
				int bstock = Integer.parseInt(request.getParameter("stock"));
				book.setBid(id);
				book.setBstock(bstock);
				bookDao.updateStock(book);
			}	
		}
		List<book>list = bookDao.list();
		request.setAttribute("list", list);
		request.getRequestDispatcher("./updateBook.jsp").forward(request, response);
	}
}


