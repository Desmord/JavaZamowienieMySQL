package dataClasess;

public class CustomerData {

	private int id;
	private String firstName;
	private String lastName;
	private int tel;
	private int discount;

	public CustomerData(int id, String firstName, String lastName, int tel, int discount) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.tel = tel;
		this.discount = discount;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public int getTel() {
		return tel;
	}

	public void setTel(int tel) {
		this.tel = tel;
	}

	public int getDiscount() {
		return discount;
	}

	public void setDiscount(int discount) {
		this.discount = discount;
	}

}
