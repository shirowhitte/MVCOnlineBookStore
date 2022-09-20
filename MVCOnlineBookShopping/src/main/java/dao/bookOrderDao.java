package dao;

import java.util.List;

import model.History;
import model.book;
import model.bookOrder;

public interface bookOrderDao {
	book getBookById(int bid);
	book getQuantityById(int bid);
	List<book>list();
	int addOrder(bookOrder order);
	int updateStock(book book);
	List<History>viewTransactionHistory(int cid);
	List<History>viewCustomerTransaction();
}
