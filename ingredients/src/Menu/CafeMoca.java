package Menu;

import java.util.Map;

import Cafe.Ingredients;

public class CafeMoca  extends Menu{
	public static String name = "카페모카";
	public static  int price = 4500;


	@Override
	public void outIngredients() {
		Map<String, Integer>  ingredients = Ingredients.getInstance();
		
		int coffeeQty =  ingredients.get("원두");
		int milkQty = ingredients.get("우유");
		int chocoQty = ingredients.get("초콜릿시럽");
	
		
		if (coffeeQty  >= 100 && milkQty>=200 && chocoQty >=10) {
			coffeeQty -= 100;
			milkQty -= 200;
			chocoQty -= 10;
			Ingredients.setCoffeeQty(coffeeQty);
			Ingredients.setMilkQty(milkQty);	
			Ingredients.setChocoQty(chocoQty);
		} else {
		System.out.println("재료가 소진되었습니다. ");
		return;
		}
	}
}
