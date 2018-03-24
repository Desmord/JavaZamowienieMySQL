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
import dataClasess.ProductData;
import interfaces.Product;

public class ProductDao implements Product {

	List<Product> products;

	public List<ProductData> findByCategory(int categoryID) {
		return getDataBaseData("SELECT * FROM produkt WHERE id_Kategori = " + categoryID);
	}

	@Override
	public List<ProductData> findAll() {
		return getDataBaseData("SELECT * FROM produkt");
	}

	@Override
	public List<ProductData> findById(int id) {
		return getDataBaseData("SELECT * FROM produkt WHERE id = " + id);
	}

	@Override
	public List<ProductData> findByName(String name) {
		return getDataBaseData("SELECT * FROM produkt WHERE nazwa = '" + name + "'");
	}

	@Override
	public boolean insertProduct(ProductData product) {
		return executeQuery(
				"INSERT INTO `produkt`(`id`, `nazwa`, `cena`, `stan_Ilosci`, `rabat`, `id_Kategori`) VALUES ("
						+ product.getId() + ",'" + product.getName() + "','" + product.getPrice() + "',"
						+ product.getQuantity() + ",'" + product.getDiscount() + "'," + product.getCategoryId() + ")");
	}

	@Override
	public boolean updateProduct(ProductData product) {
		return executeQuery("UPDATE `produkt` SET `id`=" + product.getId() + ",`nazwa`='" + product.getName()
				+ "',`cena`='" + product.getPrice() + "',`stan_Ilosci`=" + product.getQuantity() + ",`rabat`='"
				+ product.getDiscount() + "',`id_Kategori`=" + product.getCategoryId() + " WHERE id = "
				+ product.getId());
	}

	@Override
	public boolean deleteProduct(int id) {
		return executeQuery("DELETE FROM `produkt` WHERE id = " + id);
	}

	private boolean executeQuery(String sqlStatement) {

		try {

			Class.forName(ApplicationData.getDriver());
			Connection conn = DriverManager.getConnection(ApplicationData.getDbPath(), ApplicationData.getUser(),
					ApplicationData.getPassword());

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
			Connection conn = DriverManager.getConnection(ApplicationData.getDbPath(), ApplicationData.getUser(),
					ApplicationData.getPassword());

			Statement statement = conn.createStatement();
			final String sqlQuery = "SELECT `id` FROM `produkt`";
			ResultSet resultSet = statement.executeQuery(sqlQuery);

			while (resultSet.next()) {

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
