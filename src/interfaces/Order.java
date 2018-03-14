package interfaces;

import java.util.List;

import dataClasess.OrderData;

public interface Order {
	
	List<OrderData> findAll();
	List<OrderData> findById(int id);
	List<OrderData> findByCustomerId(int id);
	
	boolean insertProduct(OrderData order);
	boolean updateProduct(int id,OrderData order);
	boolean deleteProduct(int id);

}
