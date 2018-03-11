package interfaces;

import java.util.List;

import dataClasess.OrderProductData;

public interface OrderProduct {
	
	List<OrderProductData> findAll();
	List<OrderProductData> findByOrderId();
	List<OrderProductData> findByProductId();
	
	boolean insertProduct(OrderProductData orP);
	boolean updateProduct(OrderProductData orP);
	boolean deleteProduct(OrderProductData orP);
}
