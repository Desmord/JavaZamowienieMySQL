package interfaces;

import java.util.List;

public interface OrderProduct {
	
	List<OrderProduct> findAll();
	List<OrderProduct> findByOrderId();
	List<OrderProduct> findByProductId();
	
	boolean insertProduct(OrderProduct orP);
	boolean updateProduct(OrderProduct orP);
	boolean deleteProduct(OrderProduct orP);
}
