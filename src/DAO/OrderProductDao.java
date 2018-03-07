package DAO;

import java.util.List;

import interfaces.OrderProduct;

public class OrderProductDao implements OrderProduct{

	List<OrderProduct> orP;
	
	@Override
	public List<OrderProduct> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<OrderProduct> findByOrderId() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<OrderProduct> findByProductId() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean insertProduct(OrderProduct orP) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean updateProduct(OrderProduct orP) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean deleteProduct(OrderProduct orP) {
		// TODO Auto-generated method stub
		return false;
	}

}
