package interfaces;

import java.util.List;

import dataClasess.CategoryData;

public interface Category {

	List<CategoryData> findAll();
	List<CategoryData> findById();
	List<CategoryData> findByName();
	
	boolean insertProduct(CategoryData category);
	boolean updateProduct(CategoryData category);
	boolean deleteProduct(CategoryData category);
	
}
