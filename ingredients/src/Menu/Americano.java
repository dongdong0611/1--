package Menu;

import java.util.Map;


import Cafe.Ingredients;

public class Americano extends Menu{

		public static String name = "아메리카노";
		public static  int price = 3000;

	@Override
	public void outIngredients() {
		Map<String, Integer>  ingredients = Ingredients.getInstance();
		
		int coffeeQty =  ingredients.get("원두");
		// String name =Americano.getSingleKeyFromeValue(ingredients, coffeeQty);
		
		if (coffeeQty  >= 100) {
			coffeeQty -= 100;
			Ingredients.setCoffeeQty(coffeeQty);
		} else {
		System.out.println("재료가 소진되었습니다. ");
		return;
		}
		
	}





}
