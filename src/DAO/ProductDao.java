package DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.mysql.jdbc.exceptions.jdbc4.MySQLIntegrityConstraintViolationException;

import application.ApplicationData;
import dataClasess.OrderData;
import dataClasess.ProductData;
import interfaces.Product;

public class ProductDao implements Product {

	List<Product> products;

	@Override
	public List<ProductData> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<ProductData> findById() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<ProductData> findByName() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean insertProduct(ProductData product) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean updateProduct(ProductData product) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean deleteProduct(ProductData producr) {
		// TODO Auto-generated method stub
		return false;
	}
	
	private boolean executeQuery(String sqlStatement) {

		try {

			Class.forName(ApplicationData.getDriver());
			Connection conn = DriverManager.getConnection(ApplicationData.getDbPath(),ApplicationData.getUser(), ApplicationData.getPassword());

			Statement statement = conn.createStatement();
			final String sqlQuery = sqlStatement;
			statement.execute(sqlQuery);

			if (statement != null) {
				statement.close();
			}
			if (conn != null) {
				conn.close();
			}

		} catch (MySQLIntegrityConstraintViolationException e) {

			System.out.println("Index istnieje");
			return false;

		} catch (SQLException e) {

			System.out.println("Blad sql");
			System.out.println(e);
			return false;

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			return false;
		}

		return true;
	}

	private List<ProductData> getDataBaseData(String sqlStatement) {

		List<ProductData> productList = new ArrayList<ProductData>();

		try {

			Class.forName(ApplicationData.getDriver());
			Connection conn = DriverManager.getConnection(ApplicationData.getDbPath(), ApplicationData.getUser(),
					ApplicationData.getPassword());

			Statement statement = conn.createStatement();
			final String sqlQuery = sqlStatement;
			ResultSet resultSet = statement.executeQuery(sqlQuery);

			while (resultSet.next()) {
				ProductData product = new ProductData(Integer.parseInt(resultSet.getString(1)), resultSet.getString(2),
						resultSet.getString(3), Integer.parseInt(resultSet.getString(4)), resultSet.getString(5),
						Integer.parseInt(resultSet.getString(6)));

				productList.add(product);
			}

			if (statement != null) {
				statement.close();
			}
			if (resultSet != null) {
				resultSet.close();
			}
			if (conn != null) {
				conn.close();
			}

		} catch (SQLException e) {

			System.out.println("Blad sql");
			System.out.println(e);

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

		return productList;
	}
	
	public List<Integer> getAllId() {

		List<Integer> idList = new ArrayList<Integer>();

		try {

			Class.forName(ApplicationData.getDriver());
			Connection conn = DriverManager.getConnection(ApplicationData.getDbPath(), ApplicationData.getUser(), ApplicationData.getPassword());

			Statement statement = conn.createStatement();
			final String sqlQuery = "SELECT `id` FROM `produkt`";
			ResultSet resultSet = statement.executeQuery(sqlQuery);
			
			while(resultSet.next()) {
				
				idList.add(Integer.parseInt(resultSet.getString(1)));
			
			}

			if (statement != null) {
				statement.close();
			}
			if (resultSet != null) {
				resultSet.close();
			}
			if (conn != null) {
				conn.close();
			}

		} catch (SQLException e) {

			System.out.println("Blad sql");
			System.out.println(e);

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

		return idList;
	}

}
