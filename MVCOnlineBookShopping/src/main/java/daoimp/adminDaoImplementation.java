package daoimp;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.Admin;
import dao.adminDao;
import db.MyDBConnect;

public class adminDaoImplementation implements adminDao {
	public Admin login(int username, String password) {
		Connection conn = MyDBConnect.dbConnect();
		Admin admin = null;
		try {
			PreparedStatement ps = conn.prepareStatement("select * from admin where aid=? and apwd=?");
			ps.setInt(1, username);
			ps.setString(2, password);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) 
			{
				admin = new Admin(rs.getInt(1),rs.getString(2));
			}
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return admin;
	}
}
