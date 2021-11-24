package Cafe;

import java.util.ArrayList;
import java.util.List;


public class Cafe {
	private static Cafe instance = new Cafe();
	
	private static String CAFE_NAME = "cosmo";
	private ArrayList<Customer> customerList = new ArrayList<Customer>(); 
	private ArrayList<Stock> stockList = new ArrayList<Stock>();
	
	private Cafe() {}
	
	public static Cafe getInstance() {
		if(instance == null)
			instance= new Cafe();
		return instance;
	}
	
	public ArrayList<Customer> getCustomerList(){
		return customerList;
	}
	
	public void addCustomer(Customer customer) {
		customerList.add(customer);
	}
	
	public ArrayList<Stock> getStockList(){
		return stockList; 
	}
	
	public void addStock(Stock stock) {
		stockList.add(stock);
	}

}
