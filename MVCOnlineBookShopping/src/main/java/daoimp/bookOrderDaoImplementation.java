package daoimp;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.History;
import dao.bookOrderDao;
import model.bookOrder;
import model.book;
import db.MyDBConnect;

public class bookOrderDaoImplementation implements bookOrderDao {
	public book getBookById(int bid) {
		// TODO Auto-generated method stub
		Connection conn = MyDBConnect.dbConnect();
		book book = new book();
		try
		{
			PreparedStatement ps = conn.prepareStatement("select * from book where bid=?");
			ps.setInt(1, bid);
			ResultSet rs = ps.executeQuery();
			while(rs.next())
			{
				book.setBid(rs.getInt(1));
				book.setBname(rs.getString(2));
				book.setBauthor(rs.getString(3));
				book.setBstock(rs.getInt(4));
				book.setBprice(rs.getDouble(5));
				book.setCname(rs.getString(6));
				book.setImg(rs.getString(7));
			}
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
		return book;
	}
	
	public book getQuantityById(int bid) {
		Connection conn = MyDBConnect.dbConnect();
		book book = new book();
		try
		{
			PreparedStatement ps = conn.prepareStatement("select bstock from book where bid=?");
			ps.setInt(1, bid);
			ResultSet rs = ps.executeQuery();
			while(rs.next())
			{
				book.setBstock(rs.getInt(1));
			}
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
		return book;
	}

	public List<book> list() 
	{
		List<book>list = new ArrayList();
		Connection conn = MyDBConnect.dbConnect();
		try
		{
			String query = "select * from book";
			PreparedStatement ps = conn.prepareStatement(query);
			ResultSet rs = ps.executeQuery();
			while(rs.next())
			{
				book book = new book();
				book.setBid(rs.getInt(1));
				book.setBname(rs.getString(2));
				book.setBauthor(rs.getString(3));
				book.setBstock(rs.getInt(4));
				book.setBprice(rs.getDouble(5));
				book.setCname(rs.getString(6));
				book.setImg(rs.getString(7));
				list.add(book);
			}
			conn.close();
					
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
		return list;
		
	}
	
	public int addOrder(bookOrder order)
	{
		Connection conn = MyDBConnect.dbConnect();
		int addOrder = 0;
		try {
			PreparedStatement s = conn.prepareStatement("insert into bookOrder values(order_seq.nextval,?,?,?,?,? )");
			s.setInt(1, order.getBid());
			s.setInt(2, order.getCid());
			s.setInt(3, order.getQty());
			s.setString(4, order.getOdate());
			s.setDouble(5, order.getTotalPrice());
			addOrder = s.executeUpdate();
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return addOrder;
	}
	
	public int updateStock(book book)
	{
		Connection conn = MyDBConnect.dbConnect();
		int updateStock = 0;
		try {
			PreparedStatement s = conn.prepareStatement("update book set bstock = ? where bid=?");
			s.setInt(1, book.getBstock());
			s.setInt(2, book.getBid());
			updateStock = s.executeUpdate();
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return updateStock;
	}

	@Override
	public List<History> viewTransactionHistory(int cid) {
		List<History>list = new ArrayList();
		Connection conn = MyDBConnect.dbConnect();
		try
		{
			PreparedStatement p = conn.prepareStatement("SELECT bookOrder.oid, book.bid, book.bname, book.bauthor, bookOrder.qty, bookOrder.odate FROM bookOrder INNER JOIN book ON book.bid=bookOrder.bid where cid=? order by bookOrder.oid");
			p.setInt(1, cid);
			ResultSet rs = p.executeQuery();
			while(rs.next())
			{
				History h = new History();
				h.setOid(rs.getInt(1));
				h.setBid(rs.getInt(2));
				h.setBname(rs.getString(3));
				h.setBauthor(rs.getString(4));
				h.setQty(rs.getInt(5));
				h.setOdate(rs.getString(6));
				list.add(h);
			}
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
		return list;
	}
	
	@Override
	public List<History> viewCustomerTransaction() {
		List<History>list = new ArrayList();
		Connection conn = MyDBConnect.dbConnect();
		try
		{
			PreparedStatement p = conn.prepareStatement("SELECT bookOrder.oid, customer.cfirstname, book.bname, book.cname, bookOrder.qty, bookOrder.totalPrice, bookOrder.odate FROM bookOrder INNER JOIN book ON book.bid=bookOrder.bid INNER JOIN customer on bookOrder.cid = customer.cid order by bookOrder.oid");
			ResultSet rs = p.executeQuery();
			while(rs.next())
			{
				History h = new History();
				h.setOid(rs.getInt(1));
				h.setCname(rs.getString(2));
				h.setBname(rs.getString(3));
				h.setBcategory(rs.getString(4));
				h.setQty(rs.getInt(5));
				h.setTotalPrice(rs.getDouble(6));
				h.setOdate(rs.getString(7));
				list.add(h);
			}
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
		return list;
	}
}
