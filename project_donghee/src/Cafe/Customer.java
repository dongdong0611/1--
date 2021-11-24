package Cafe;

public class Customer {
	private int customerNum; 
	private double point; 
	private int balance;
	
	public Customer(int customerNum, int balance , int point) {
		this.customerNum = customerNum; 
		this.point = point ; 
		this.balance = balance; 
	}

	public int getCustomerNum() {
		return customerNum;
	}

	public void setCustomerNum(int customerNum) {
		this.customerNum = customerNum;
	}

	public double getPoint() {
		return point;
	}

	public void setPoint(double point) {
		this.point = point;
	}

	public int getBalance() {
		return balance;
	}

	public void setBalance(int balance) {
		this.balance = balance;
	}
	
	public String toString() {
		return "고객 번호: " + customerNum + "| 남은 금액 : " + balance + "| 포인트: " + point;
	}
	
}
