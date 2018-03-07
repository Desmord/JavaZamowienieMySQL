package interfaces;

import java.util.List;

public interface Order {
	
	List<Order> findAll();
	List<Order> findById();
	List<Order> findByCustomerId();
	
	boolean insertProduct(Order order);
	boolean updateProduct(Order order);
	boolean deleteProduct(Order order);

}
