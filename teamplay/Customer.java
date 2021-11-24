package teamplay;

public class Customer {
	
	private String customerName;
	private int customerAccount;
	
	public Customer(String customerName, int customerAccount) {
		this.customerName = customerName;
		this.customerAccount = customerAccount;
	}	

	public String getCustomerName() {
		return customerName;
	}
	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}
	public int getCustomerAccount() {
		return customerAccount;
	}
	public void setCustomerAccount(int customerAccount) {
		this.customerAccount = customerAccount;
	}
	
	}