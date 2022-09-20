package controller;

import java.io.IOException;
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
 * Servlet implementation class customerSearch
 */
@WebServlet("/customerSearch")
public class customerSearch extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private bookDao bookDao;
  
    public void init(ServletConfig config) throws ServletException {
    	bookDao = new bookDaoImplementation();
	}
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("./customerSearch.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException { 
		
		if(request.getParameter("search")!=null)
		{
			String search = request.getParameter("search");
			List<book>viewBookListBySearch = bookDao.viewBookListBySearch(search);
			request.setAttribute("viewBookListBySearch", viewBookListBySearch);
		}
		request.getRequestDispatcher("./customerSearch.jsp").forward(request, response);


	}

}
