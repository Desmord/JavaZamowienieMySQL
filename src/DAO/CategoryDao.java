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
	public List<CategoryData> findById() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<CategoryData> findByName() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean insertProduct(CategoryData category) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean updateProduct(CategoryData category) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean deleteProduct(CategoryData category) {
		// TODO Auto-generated method stub
		return false;
	}

}
