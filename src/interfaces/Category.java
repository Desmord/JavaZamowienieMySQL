package interfaces;

import java.util.List;

public interface Category {

	List<Category> findAll();
	List<Category> findById();
	List<Category> findByName();
	
	boolean insertProduct(Category category);
	boolean updateProduct(Category category);
	boolean deleteProduct(Category category);
	
}
