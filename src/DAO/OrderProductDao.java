package DAO;

import java.util.List;

import dataClasess.OrderProductData;
import interfaces.OrderProduct;

public class OrderProductDao implements OrderProduct{

	List<OrderProduct> orP;
	
	@Override
	public List<OrderProductData> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<OrderProductData> findByOrderId() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<OrderProductData> findByProductId() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean insertProduct(OrderProductData orP) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean updateProduct(OrderProductData orP) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean deleteProduct(OrderProductData orP) {
		// TODO Auto-generated method stub
		return false;
	}

}
