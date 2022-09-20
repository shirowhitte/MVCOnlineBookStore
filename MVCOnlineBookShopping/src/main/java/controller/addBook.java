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
import model.book;
import dao.bookDao;
import daoimp.bookDaoImplementation;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/addBook")
public class addBook extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private bookDao bookDao;
    
    public void init(ServletConfig config) throws ServletException {
    	bookDao = new bookDaoImplementation();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String img =  request.getParameter("file");
		String category =  request.getParameter("sort");
		String bname = request.getParameter("bname");
		String bauthor = request.getParameter("bauthor");
		int bstock = Integer.parseInt(request.getParameter("bstock"));
		double bprice = Double.parseDouble(request.getParameter("bprice"));
		
		if (img != null && category != null && bname != null && bauthor != null && bstock!=0 && bprice !=0.0) {
			book book = new book(bname,bauthor,bstock,bprice,category,img);
			bookDao.addBook(book);
			request.getRequestDispatcher("./addBook.jsp").forward(request, response);
			
		}
	}
}


