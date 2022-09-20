package controller;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.Customer;
import model.bookOrder;
import model.book;
import dao.bookOrderDao;
import dao.bookDao;
import daoimp.bookOrderDaoImplementation;
import daoimp.bookDaoImplementation;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/category")
public class category extends HttpServlet {
	private static final long serialVersionUID = 1L;
    //private bookDao bookDao;
    private bookOrderDao bookOrderDao;
    private bookDao bookDao;
    
    public void init(ServletConfig config) throws ServletException {
    	bookDao = new bookDaoImplementation();
    	bookOrderDao =  new bookOrderDaoImplementation();
	}
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		request.getAttribute("viewBookListByCategory");
		request.getRequestDispatcher("./category.jsp").forward(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		if(request.getParameter("sort")!=null)
		{
			String category = request.getParameter("sort");
			List<book>viewBookListByCategory = bookDao.viewBookListByCategory(category);
			request.setAttribute("viewBookListByCategory", viewBookListByCategory);
		}
		else
		{
			String hi = "Please enter book name or book author";
			request.setAttribute("hello", hi);
		}
		request.getRequestDispatcher("./category.jsp").forward(request, response);
	}
}
