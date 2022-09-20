package daoimp;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import controller.customerLogin;
import model.Customer;
import dao.customerDao;
import db.MyDBConnect;

public class customerDaoImplementation implements customerDao {
	public Customer login(int username, String password) {
		// Verify login credentials
		Connection conn = MyDBConnect.dbConnect();
		Customer customer = null;
		try {
			PreparedStatement ps = conn.prepareStatement("select * from customer where cid=? and cemail=?");
			ps.setInt(1, username);
			ps.setString(2, password);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				customer = new Customer(rs.getInt(1),rs.getString(2));
			}
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return customer;
	}
	public int registerCustomer(Customer customer) {
		Connection conn = MyDBConnect.dbConnect();
		int registerCount = 0;
		try {
			PreparedStatement ps = conn.prepareStatement("insert into customer values(customer_seq.nextval,?,?,?,?,null)");
			ps.setString(1, customer.getCfirstname());
			ps.setString(2, customer.getClastname());
			ps.setString(3, customer.getCemail());
			ps.setString(4, customer.getCphone());

			registerCount = ps.executeUpdate();
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return registerCount;
	}
	
	public String getCustomerName(int username) {
		Connection conn = MyDBConnect.dbConnect();
		String name = "";
		try {
		
			PreparedStatement r = conn.prepareStatement("select cfirstname from customer where cid=?");
			r.setInt(1,username);
			r.executeUpdate();
			r.getResultSet().next();
			name=r.getResultSet().getString(1);
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return name;
	}
}
