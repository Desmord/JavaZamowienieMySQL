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
import interfaces.Order;

public class OrderDao implements Order {

	List<Order> orders;

	@Override
	public List<OrderData> findAll() {

		return getDataBaseData("SELECT * FROM zamowienia");

	}

	@Override
	public List<OrderData> findById(int id) {

		return getDataBaseData("SELECT * FROM zamowienia WHERE id = " + id);

	}

	@Override
	public List<OrderData> findByCustomerId(int id) {

		return getDataBaseData("SELECT * FROM `zamowienia` WHERE id_Klienta = " + id);

	}

	@Override
	public boolean insertProduct(OrderData order) {

		return executeQuery("INSERT INTO `zamowienia`(`id`, `id_Klienta`, `rabat_zamowienia`, `koszt_Totalny`) VALUES ("
				+ order.getId() + "," + order.getCustomerId() + "," + order.getDiscount() + "," + order.getTotalCost()
				+ ")");

	}

	@Override
	public boolean updateProduct(int id, OrderData order) {

		return executeQuery("UPDATE `zamowienia` SET `id`=" + order.getId() + ",`id_Klienta`=" + order.getCustomerId()
				+ ",`rabat_zamowienia`=" + order.getDiscount() + ",`koszt_Totalny`=" + order.getTotalCost()
				+ " WHERE id = " + id);

	}

	@Override
	public boolean deleteProduct(int id) {

		return executeQuery("DELETE FROM `zamowienia` WHERE id = "+id);
		
	}

	private boolean executeQuery(String sqlStatement) {

		try {

			Class.forName(ApplicationData.getDriver());
			Connection conn = DriverManager.getConnection(ApplicationData.getDbPath(), "root", null);

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

	private List<OrderData> getDataBaseData(String sqlStatement) {

		List<OrderData> orderList = new ArrayList<OrderData>();

		try {

			Class.forName(ApplicationData.getDriver());
			Connection conn = DriverManager.getConnection(ApplicationData.getDbPath(), "root", null);

			Statement statement = conn.createStatement();
			final String sqlQuery = sqlStatement;
			ResultSet resultSet = statement.executeQuery(sqlQuery);

			while (resultSet.next()) {

				OrderData order = new OrderData(Integer.parseInt(resultSet.getString(1)),
						Integer.parseInt(resultSet.getString(2)), Integer.parseInt(resultSet.getString(3)),
						resultSet.getString(4));

				orderList.add(order);

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

		return orderList;
	}

}
