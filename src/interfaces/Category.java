package interfaces;

import java.util.List;

import dataClasess.CategoryData;

public interface Category {

	List<CategoryData> findAll();
	List<CategoryData> findById(int id);
	List<CategoryData> findByName(String name);
	
	boolean insertCategory(CategoryData category);
	boolean updateCategory(CategoryData category);
	boolean deleteCategory(int id);
	
}
