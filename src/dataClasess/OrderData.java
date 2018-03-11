package dataClasess;

public class OrderData {

	private int id;
	private int customerId;
	private int discount;
	private String totalCost;

	public OrderData(int id, int customerId, int discount, String totalCost) {
		this.id = id;
		this.customerId = customerId;
		this.discount = discount;
		this.totalCost = totalCost;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getCustomerId() {
		return customerId;
	}

	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}

	public int getDiscount() {
		return discount;
	}

	public void setDiscount(int discount) {
		this.discount = discount;
	}

	public String getTotalCost() {
		return totalCost;
	}

	public void setTotalCost(String totalCost) {
		this.totalCost = totalCost;
	}

}
