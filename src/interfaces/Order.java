package interfaces;

import java.util.List;

import dataClasess.OrderData;

public interface Order {
	
	List<OrderData> findAll();
	List<OrderData> findById();
	List<OrderData> findByCustomerId();
	
	boolean insertProduct(OrderData order);
	boolean updateProduct(OrderData order);
	boolean deleteProduct(OrderData order);

}
