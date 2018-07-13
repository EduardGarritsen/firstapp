package nl.hu.v1wac.firstapp.persistence;

import java.sql.SQLException;

import nl.hu.v1wac.firstapp.domain.Account;


public interface UserDao {
	public String findRoleForUser(String username, String password) throws SQLException;
	public boolean create(Account account) throws SQLException;
	public boolean createP5(Account account) throws SQLException;
}
