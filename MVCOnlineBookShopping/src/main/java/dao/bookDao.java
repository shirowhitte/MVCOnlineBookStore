package dao;

import java.util.List;

import model.book;

public interface bookDao {
	int addBook(book book);
	int updatePrice(book book);
	int updateStock(book book);
	int delete(int bid);
	book getBookById(int bid);
	List<book>list();
	List<book>viewBookList();
	List<book>viewBookListByName();
	List<book>viewBookListByHighestPrice();
	List<book>viewBookListByLowestPrice();	
	List<book>viewBookListBySearch(String search);	
	List<book>viewBookListByCategory(String category);	
}
