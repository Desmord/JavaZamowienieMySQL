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
import dataClasess.CategoryData;
import dataClasess.OrderData;
import interfaces.Category;

public class CategoryDao implements Category {

	List<Category> categores;

	@Override
	public List<CategoryData> findAll() {
		return getDataBaseData("SELECT * FROM kategoria_produktu");
	}

	@Override
	public List<CategoryData> findById(int id) {
		return getDataBaseData("Select * FROM kategoria_produktu where id = " + id);
	}

	@Override
	public List<CategoryData> findByName(String name) {
		return getDataBaseData("Select * FROM kategoria_produktu where nazwa = '" + name + "'");
	}
	
	public String getCategoryName(int id) {		
		List<CategoryData> list = getDataBaseData("Select * FROM kategoria_produktu where id = " + id);	
		return list.get(0).getName();
	}

	@Override
	public boolean insertCategory(CategoryData category) {
		return executeQuery("INSERT INTO `kategoria_produktu`(`id`, `nazwa`) VALUES (" + category.getId() + ",'"
				+ category.getName() + "')");
	}

	@Override
	public boolean updateCategory(CategoryData category) {
		return executeQuery("UPDATE `kategoria_produktu` SET `id`=" + category.getId() + ",`nazwa`='"
				+ category.getName() + "' WHERE id = " + category.getId());
	}

	@Override
	public boolean deleteCategory(int id) {
		return executeQuery("DELETE FROM `kategoria_produktu` WHERE id =" + id);
	}

	private List<CategoryData> getDataBaseData(String sqlStatement) {

		List<CategoryData> categoryList = new ArrayList<CategoryData>();

		try {

			Class.forName(ApplicationData.getDriver());
			Connection conn = DriverManager.getConnection(ApplicationData.getDbPath(), ApplicationData.getUser(),
					ApplicationData.getPassword());

			Statement statement = conn.createStatement();
			final String sqlQuery = sqlStatement;
			ResultSet resultSet = statement.executeQuery(sqlQuery);

			while (resultSet.next()) {

				CategoryData category = new CategoryData(Integer.parseInt(resultSet.getString(1)),
						resultSet.getString(2));
				categoryList.add(category);

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

		return categoryList;
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
	
	public List<Integer> getAllId() {

		List<Integer> idList = new ArrayList<Integer>();

		try {

			Class.forName(ApplicationData.getDriver());
			Connection conn = DriverManager.getConnection(ApplicationData.getDbPath(), ApplicationData.getUser(), ApplicationData.getPassword());

			Statement statement = conn.createStatement();
			final String sqlQuery = "SELECT `id` FROM `kategoria_produktu`";
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
