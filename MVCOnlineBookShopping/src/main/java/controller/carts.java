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
@WebServlet("/carts")
public class carts extends HttpServlet {
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
    	request.getRequestDispatcher("./carts.jsp").forward(request, response);
    }
  
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		if(request.getParameter("addCart")!=null)
		{
			int bid = Integer.parseInt(request.getParameter("addCart"));
			book ssbook = bookDao.getBookById(bid);
			request.setAttribute("ssbook", ssbook);
			request.getRequestDispatcher("./carts.jsp").forward(request, response);
		}
		else
		{
			response.sendRedirect("./transactionHistory");
		}
		if(request.getParameter("qty")!=null && request.getParameter("customerID")!=null && request.getParameter("bookID")!=null)
		{
			//bookOrder order = new bookOrder();
			int cid = Integer.parseInt(request.getParameter("customerID"));
			int bid = Integer.parseInt(request.getParameter("bookID"));
			int qty = Integer.parseInt(request.getParameter("qty"));
			double price = Double.parseDouble(request.getParameter("price"));
			Date d = new Date();
			DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");  
			String strDate = dateFormat.format(d);  
			double fPrice = qty*price;
			bookOrderDao.addOrder(new bookOrder(bid,cid,qty,strDate,fPrice));
			//book b1 = new book();
			book bstock = bookOrderDao.getQuantityById(bid);
			int stock = bstock.getBstock();
			int final_stock = stock - qty;
			book book = new book();
			book.setBid(bid);
			book.setBstock(final_stock);
			bookOrderDao.updateStock(book);		
		}
	}
}

