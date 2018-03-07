package DAO;

import java.util.List;

import interfaces.Order;

public class OrderDao implements Order{

	List<Order> orders;
	
	@Override
	public List<Order> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Order> findById() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Order> findByCustomerId() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean insertProduct(Order order) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean updateProduct(Order order) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean deleteProduct(Order order) {
		// TODO Auto-generated method stub
		return false;
	}

}
