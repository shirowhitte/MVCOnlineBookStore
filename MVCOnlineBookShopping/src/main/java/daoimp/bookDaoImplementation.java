package daoimp;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.book;
import dao.bookDao;
import db.MyDBConnect;

public class bookDaoImplementation implements bookDao {
	public int addBook(book book) {
		Connection conn = MyDBConnect.dbConnect();
		int addBookCount = 0;
		try {
			PreparedStatement s = conn.prepareStatement("insert into book values(book_seq.nextval,?,?,?,?,?,?)");
			s.setString(1, book.getBname());
			s.setString(2, book.getBauthor());
			s.setInt(3, book.getBstock());
			s.setDouble(4, book.getBprice());
			s.setString(5, book.getCname());
			s.setString(6, book.getImg());
			addBookCount = s.executeUpdate();
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return addBookCount;	
	}
	
	@Override
	public int updatePrice(book book) {
		Connection conn = MyDBConnect.dbConnect();
		int updatePrice = 0;
		try {
			PreparedStatement s = conn.prepareStatement("update book set bprice = ? where bid=?");
			s.setDouble(1, book.getBprice());
			s.setInt(2, book.getBid());
			updatePrice = s.executeUpdate();
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return updatePrice;
	}

	@Override
	public int updateStock(book book) {
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
	public int delete(int bid) 
	{
		Connection conn = MyDBConnect.dbConnect();
		int exec = 0;
		try
		{
			PreparedStatement s = conn.prepareStatement("delete from book where bid=?");
			s.setInt(1, bid);
			exec = s.executeUpdate();
			conn.close();
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
		return exec;
	}
	


	@Override
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

	@Override
	public List<book> list() 
	{
		List<book>list = new ArrayList();
		Connection conn = MyDBConnect.dbConnect();
		try
		{
			String query = "select * from book order by bid";
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
	
	public List<book> viewBookList() 
	{
		List<book>list = new ArrayList();
		Connection conn = MyDBConnect.dbConnect();
		try
		{
			String query = "select * from book order by bid";
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

	@Override
	public List<book> viewBookListByName() {
		List<book>list = new ArrayList();
		Connection conn = MyDBConnect.dbConnect();
		try
		{
			String query = "select * from book order by bname";
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

	@Override
	public List<book> viewBookListByHighestPrice() {
		List<book>list = new ArrayList();
		Connection conn = MyDBConnect.dbConnect();
		try
		{
			String query = "select * from book order by bprice desc";
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

	@Override
	public List<book> viewBookListByLowestPrice() {
		List<book>list = new ArrayList();
		Connection conn = MyDBConnect.dbConnect();
		try
		{
			String query = "select * from book order by bprice asc";
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
	@Override
	public List<book> viewBookListBySearch(String search) {
		List<book>list = new ArrayList();
		Connection conn = MyDBConnect.dbConnect();
		try
		{
			String query = "select * from book where bauthor=? or bname=? order by bid";
			PreparedStatement ps = conn.prepareStatement(query);
			ps.setString(1, search);
			ps.setString(2, search);
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

	@Override
	public List<book> viewBookListByCategory(String category) {
		List<book>list = new ArrayList();
		Connection conn = MyDBConnect.dbConnect();
		try
		{
			String query = "select * from book where cname=? order by bid";
			PreparedStatement ps = conn.prepareStatement(query);
			ps.setString(1, category);
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

}
