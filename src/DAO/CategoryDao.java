package DAO;

import java.util.List;

import dataClasess.CategoryData;
import interfaces.Category;

public class CategoryDao implements Category {

	List<Category> categores;
	
	@Override
	public List<CategoryData> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<CategoryData> findById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<CategoryData> findByName(String name) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean insertCategory(CategoryData category) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean updateCategory(int id,CategoryData category) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean deleteCategory(int id) {
		// TODO Auto-generated method stub
		return false;
	}

}
