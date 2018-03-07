package interfaces;

import java.util.List;

public interface Product {

	List<Product> findAll();
	List<Product> findById();
	List<Product> findByName();
	
	boolean insertProduct(Product product);
	boolean updateProduct(Product product);
	boolean deleteProduct(Product producr);

}
