package nl.hu.v1wac.firstapp.persistence;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import nl.hu.v1wac.firstapp.model.Country;

public class CountryPostgresDaoImpl extends PostgresBaseDao implements CountryDao {

	// @Override
	// public boolean save(Country country) {
	// // TODO Auto-generated method stub
	// return false;
	// }

	/***************************** READ methods *****************************/

	private List<Country> selectCountry(String query) {
		List<Country> results = new ArrayList<Country>();

		try (Connection con = super.getConnection()) {
			Statement stmt = con.createStatement();
			ResultSet dbResultSet = stmt.executeQuery(query);

			while (dbResultSet.next()) {
				String code = dbResultSet.getString("code");
				String iso3 = dbResultSet.getString("iso3");
				String name = dbResultSet.getString("name");
				String continent = dbResultSet.getString("continent");
				String region = dbResultSet.getString("region");
				double surfacearea = dbResultSet.getDouble("surfacearea");
				int population = dbResultSet.getInt("population");
				String governmentform = dbResultSet.getString("governmentform");
				double latitude = dbResultSet.getDouble("latitude");
				double longitude = dbResultSet.getDouble("longitude");
				String capital = dbResultSet.getString("capital");

				// int indepyear = dbResultSet.getInt("indepyear");
				// double lifeexpectancy = dbResultSet.getDouble("lifeexpectancy");
				// double gnp = dbResultSet.getDouble("gnp");
				// double gnpoid = dbResultSet.getDouble("gnpoid");
				// String localname = dbResultSet.getString("localname");
				// String headofstate = dbResultSet.getString("headofstate");

				Country newCountry = new Country(code, iso3, name, capital, continent, region, surfacearea, population,
						governmentform, latitude, longitude);
				results.add(newCountry);

			}
		} catch (SQLException sqle) {
			sqle.printStackTrace();
		}

		return results;
	}
	
	

	@Override
	public List<Country> findAll() {
		return selectCountry(
				"SELECT code, iso3, name, continent, region, surfacearea, population, governmentform, latitude, longitude, capital from country");
	}

	@Override
	public Country findByCode(String code) {
		return selectCountry(
				"SELECT code, iso3, name, continent, region, surfacearea, population, governmentform, latitude, longitude, capital from country WHERE code = '"
						+ code+"'").get(0);
	}

	@Override
	public List<Country> find10LargestPopulations() {
		return selectCountry(
				"SELECT code, iso3, name, continent, region, surfacearea, population, governmentform, latitude, longitude, capital from country ORDER BY population DESC limit 10");
	}

	@Override
	public List<Country> find10LargestSurfaces() {
		return selectCountry(
				"SELECT code, iso3, name, continent, region, surfacearea, population, governmentform, latitude, longitude, capital from country ORDER BY SURFACEAREA DESC limit 10");
	}
	
	/***************************** UPDATE methods *****************************/
//	 @Override
//	 public boolean update(Country country) {
//		 boolean result = false;
//		 boolean countryExists = findByCode(country.getCode()) != null;
//		 if (countryExists) {
//			 System.out.println("test1");
//			 String query = "UPDATE country SET indepyear = 2000 WHERE code = '" + country.getCode()+"'";
//			 System.out.println("test2");
//			 try (Connection con = getConnection()){
//				 Statement stmt = con.createStatement();
//				 stmt.executeQuery(query);
//				 if (stmt.executeUpdate(query) == 1) { 
//						result = true;
//					}
//			 } catch (SQLException e) {
//				e.printStackTrace();
//			}
//		 }
//		 
//		 return result;
//	 }
	
	public boolean update(Country country) throws SQLException {
		System.out.println("test1");
		System.out.println(country.getName());
		boolean resultaat  = false;
		
		boolean countryBestaat = findByCode(country.getCode()) != null;
		if (countryBestaat) {
			String query = "UPDATE COUNTRY SET NAME = ?, CAPITAL = ?, REGION = ?, SURFACEAREA = ?, POPULATION = ? WHERE CODE = '" + country.getCode() + "'";
			try (Connection con = super.getConnection()) {
				PreparedStatement pstmt = con.prepareStatement(query);
				System.out.println(country.getName() + " " + country.getCapital());
				
				pstmt.setString(1, country.getName());
				pstmt.setString(2, country.getCapital());
				pstmt.setString(3, country.getRegion());
				pstmt.setDouble(4, country.getSurface());
				pstmt.setInt(5, country.getPopulation());
				
//				pstmt.setString(1, country.getIso3());
//				pstmt.setString(2, country.getName());
//				pstmt.setString(3, country.getCapital());
//				pstmt.setString(4, country.getContinent());
//				pstmt.setString(5, country.getRegion());
//				pstmt.setDouble(6, country.getSurface());
//				pstmt.setInt(7, country.getPopulation());
//				pstmt.setString(8, country.getGovernment());
//				pstmt.setDouble(9, country.getLatitude());
//				pstmt.setDouble(10, country.getLongitude());
				
				int result = pstmt.executeUpdate();
				pstmt.close();
				
				if (result == 0)
					return false;
				else
					resultaat = true;
			}
		}
		
		return resultaat;
	}

	

	/***************************** DELETE methods *****************************/
	@Override
	public boolean delete(Country country) {
		boolean result = false;
		boolean countryExists = findByCode(country.getCode()) != null;

		if (countryExists) {
			String query = "DELETE FROM country WHERE code = '" + country.getCode()+"'";

			try (Connection con = getConnection()) {
				System.out.println("Connectie gemaakt!");

				Statement stmt = con.createStatement();
				//stmt.executeQuery(query);
				if (stmt.executeUpdate(query) == 1) { // 1 row updated!
					result = true;
				}
			} catch (SQLException sqle) {
				sqle.printStackTrace();
			}
		}

		return result;
	}
	
	/********************* CREATE COUNTRY ***********************/
	public boolean create(Country country) throws SQLException {
		boolean resultaat  = false;
		
	
		String query = "INSERT INTO COUNTRY (code, iso3, name, continent, region, surfacearea"
				+ ", indepyear, population, lifeexpectancy, gnp, gnpold, localname"
				+ ", governmentform, headofstate, latitude, longitude, capital) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ? )";
		try (Connection con = super.getConnection()) {
			PreparedStatement pstmt = con.prepareStatement(query);
			pstmt.setString(1, country.getCode());
			pstmt.setString(2, country.getIso3());
			pstmt.setString(3, country.getName());
			pstmt.setString(4, country.getContinent());
			pstmt.setString(5, country.getRegion());
			pstmt.setDouble(6, country.getSurface());
			pstmt.setInt(7, country.getIndepyear());
			pstmt.setInt(8, country.getPopulation());
			pstmt.setInt(9, country.getLifeexpectancy());
			pstmt.setInt(10, country.getGnp());
			pstmt.setInt(11, country.getGnpoid());
			pstmt.setString(12, country.getLocalname());
			pstmt.setString(13, country.getGovernment());
			pstmt.setString(14, country.getHeadofstate());
			pstmt.setDouble(15, country.getLatitude());
			pstmt.setDouble(16, country.getLongitude());
			pstmt.setString(17, country.getCapital());
			int result = pstmt.executeUpdate();
			pstmt.close();
			
			if (result == 0)
				return false;
			else
				resultaat = true;
		}
		
		
		return resultaat;
	}

}
