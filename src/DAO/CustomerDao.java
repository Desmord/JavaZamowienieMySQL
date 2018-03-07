package DAO;

import java.util.List;

import interfaces.Customer;

public class CustomerDao implements Customer {

	List<Customer> customers;
	
	@Override
	public List<Customer> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Customer> findById() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Customer> findByFirstName() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Customer> findByLastName() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Customer> findByTel() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean insertProduct(Customer customer) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean updateProduct(Customer customer) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean deleteProduct(Customer customer) {
		// TODO Auto-generated method stub
		return false;
	}

}
