package Menu;

import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Objects;
import java.util.Set;

import Cafe.Customer;
import Cafe.Ingredients;

public abstract class Menu {
	public static  String name;
	public static int price; 


	public abstract   void outIngredients ();
	
	public static Customer balance () {
		Customer customer = null; 
		int cw = customer.getCustomerBalance();
		cw -= price;
		customer.setCustomerBalance(cw);
		return customer;
	}
	
	public  static <K, V> String getSingleKeyFromeValue (Map<String, Integer> ingredients, int price) {
		for(Entry<String, Integer> entry: ingredients.entrySet()) {
			if(Objects.equals(price, entry.getValue())) {
				return entry.getKey();
			}
		}
		return null;
	}






	

}