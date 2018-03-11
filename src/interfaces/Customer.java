package interfaces;

import java.util.List;

import dataClasess.CustomerData;

public interface Customer {
	
	List<CustomerData> findAll();
	List<CustomerData> findById();
	List<CustomerData> findByFirstName();
	List<CustomerData> findByLastName();
	List<CustomerData> findByTel();
	
	boolean insertProduct(CustomerData customer);
	boolean updateProduct(CustomerData customer);
	boolean deleteProduct(CustomerData customer);
}
