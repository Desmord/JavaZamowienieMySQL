package DAO;

import java.util.List;

import dataClasess.CustomerData;
import interfaces.Customer;

public class CustomerDao implements Customer {

	List<Customer> customers;
	
	@Override
	public List<CustomerData> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<CustomerData> findById() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<CustomerData> findByFirstName() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<CustomerData> findByLastName() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<CustomerData> findByTel() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean insertProduct(CustomerData customer) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean updateProduct(CustomerData customer) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean deleteProduct(CustomerData customer) {
		// TODO Auto-generated method stub
		return false;
	}

}
