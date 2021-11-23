package Cafe;

public class Customer {
	
	private String customerName;
	private int customerBalance;
	
	public Customer(String customerName, int customerBalance) {
		this.customerName = customerName;
		this.customerBalance = customerBalance;
	}	

	public String getCustomerName() {
		return customerName;
	}
	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}
	public int getCustomerBalance() {
		return customerBalance;
	}
	public void setCustomerBalance(int customerBalance) {
		this.customerBalance = customerBalance;
	}
	
	}
		

	

