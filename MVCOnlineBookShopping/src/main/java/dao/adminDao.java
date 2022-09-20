package dao;

import model.Admin;

public interface adminDao {
	Admin login(int username, String password);
}
