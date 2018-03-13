package DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import application.ApplicationData;
import dataClasess.OrderData;
import interfaces.Order;

public class OrderDao implements Order {

	List<Order> orders;

	@Override
	public List<OrderData> findAll() {

		List<OrderData> orderList = new ArrayList<OrderData>();

		try {

			Class.forName(ApplicationData.getDriver());
			Connection conn = DriverManager.getConnection(ApplicationData.getDbPath(), "root", null);

			Statement statement = conn.createStatement();
			final String sqlQuery = "SELECT * FROM zamowienia";
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

	@Override
	public List<OrderData> findById(int id) {
		
		List<OrderData> orderList = new ArrayList<OrderData>();

		try {

			Class.forName(ApplicationData.getDriver());
			Connection conn = DriverManager.getConnection(ApplicationData.getDbPath(), "root", null);

			Statement statement = conn.createStatement();
			final String sqlQuery = "SELECT * FROM zamowienia WHERE id = "+id;
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

	@Override
	public List<OrderData> findByCustomerId(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean insertProduct(OrderData order) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean updateProduct(OrderData order) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean deleteProduct(OrderData order) {
		// TODO Auto-generated method stub
		return false;
	}

}
