package interfaces;

import java.util.List;

import dataClasess.ProductData;

public interface Product {

	List<ProductData> findAll();
	List<ProductData> findById(int id);
	List<ProductData> findByName(String name);
	
	boolean insertProduct(ProductData product);
	boolean updateProduct(ProductData product);
	boolean deleteProduct(ProductData producr);

}
