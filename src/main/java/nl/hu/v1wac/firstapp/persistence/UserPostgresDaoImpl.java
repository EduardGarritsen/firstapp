package nl.hu.v1wac.firstapp.persistence;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import nl.hu.v1wac.firstapp.domain.Account;
import nl.hu.v1wac.firstapp.persistence.PostgresBaseDao;

public class UserPostgresDaoImpl extends PostgresBaseDao implements UserDao {
	
	public String findRoleForUser(String username, String password) throws SQLException {
		System.out.println("Binnen Functie findRoleForUser DaoImpl");
		String rol = null;
		try
			(Connection con = super.getConnection()){
				Statement stmt = con.createStatement();
				ResultSet dbResultSet = stmt.executeQuery("SELECT ROLE FROM USERACCOUNT WHERE USERNAME ='" + username + "' AND PASSWORD ='" + password + "'");
				while (dbResultSet.next()) {
					String dbRol = dbResultSet.getString("ROLE");
					
					rol = dbRol;
				}
			} catch (Exception e) {
				System.out.println(e);
			}
		System.out.println(rol);
		return rol;
	}

	@Override
	public boolean create(Account account) throws SQLException {
		System.out.println("Binnen de functie createAccount");
		boolean resultaat = false;
		
		String query = "INSERT INTO USERACCOUNT VALUES (?, ?, ?)";
		try (Connection con = super.getConnection()) {
			PreparedStatement pstmt = con.prepareStatement(query);
			pstmt.setString(1, account.getUsername());
			pstmt.setString(2, account.getPassword());
			pstmt.setString(3, account.getRole());
			int result = pstmt.executeUpdate();
			pstmt.close();
			
			if (result == 0)
				return false;
			else resultaat = true;
		}
		
		return resultaat;
	}
	
	@Override
	public boolean createP5(Account account) throws SQLException {
		System.out.println("Binnen de functie createAccount");
		boolean resultaat = false;
		
		String query = "INSERT INTO USERACCOUNT VALUES (?, ?, ?, ?, ?, ?)";
		try (Connection con = super.getConnection()) {
			PreparedStatement pstmt = con.prepareStatement(query);
			pstmt.setString(1, account.getUsername());
			pstmt.setString(2, account.getPassword());
			pstmt.setString(3, account.getRole());
			pstmt.setString(4, account.getEmail());
			pstmt.setInt(5, account.getTelefoonnummer());
			pstmt.setString(6, account.getAdres());
			int result = pstmt.executeUpdate();
			pstmt.close();
			
			if (result == 0)
				return false;
			else resultaat = true;
		}
		
		return resultaat;
	}

}
