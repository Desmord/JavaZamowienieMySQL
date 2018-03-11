package DAO;

import java.util.List;

import dataClasess.ProductData;
import interfaces.Product;

public class ProductDao implements Product {

	List<Product> products;

	@Override
	public List<ProductData> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<ProductData> findById() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<ProductData> findByName() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean insertProduct(ProductData product) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean updateProduct(ProductData product) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean deleteProduct(ProductData producr) {
		// TODO Auto-generated method stub
		return false;
	}

}
