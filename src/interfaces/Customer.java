package interfaces;

import java.util.List;

public interface Customer {
	
	List<Customer> findAll();
	List<Customer> findById();
	List<Customer> findByFirstName();
	List<Customer> findByLastName();
	List<Customer> findByTel();
	
	boolean insertProduct(Customer customer);
	boolean updateProduct(Customer customer);
	boolean deleteProduct(Customer customer);
}
