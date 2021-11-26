package Menu;

import java.util.Map;

import Cafe.Ingredients;

public class CafeLatte extends Menu {
	public static String name = "카페라떼";
	public static  int price = 4000;

	@Override
	public void outIngredients() {
		Map<String, Integer>  ingredients = Ingredients.getInstance();
		
		int coffeeQty =  ingredients.get("원두");
		int milkQty = ingredients.get("우유");
		
	
		if (coffeeQty  >= 100 && milkQty>=200) {
			coffeeQty -=100;
			milkQty -= 200;
			Ingredients.setCoffeeQty(coffeeQty);
			Ingredients.setMilkQty(milkQty);	
		} else {
		System.out.println("재료가 소진되었습니다. ");
		return;
		}
		
		
	}

}
