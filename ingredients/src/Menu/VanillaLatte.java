package Menu;

import java.util.Map;

import Cafe.Ingredients;

public class VanillaLatte  extends Menu{
	public static String name = "바닐라라떼";
	public static  int price = 4500;



	@Override
	public void outIngredients() {
	Map<String, Integer>  ingredients = Ingredients.getInstance();
		
		int coffeeQty =  ingredients.get("원두");
		int milkQty = ingredients.get("우유");
		int vanillaQty = ingredients.get("바닐라시럽");
		
		if (coffeeQty  >= 100 && milkQty>=200&&vanillaQty>=10) {
			coffeeQty -= 100;
			milkQty -= 200;
			vanillaQty -= 10;
			Ingredients.setCoffeeQty(coffeeQty);
			Ingredients.setMilkQty(milkQty);	
			Ingredients.setVanillaQty(vanillaQty);	
		} else {
		System.out.println("재료가 소진되었습니다. ");
		}
		
		
	}

	

}
