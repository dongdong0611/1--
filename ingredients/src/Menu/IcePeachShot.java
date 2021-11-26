package Menu;

import java.util.Map;

import Cafe.Ingredients;

public class IcePeachShot extends Menu {

	public static String name = "아샷추";
	public static  int price = 3500;

	@Override
	public void outIngredients() {
			Map<String, Integer>  ingredients = Ingredients.getInstance();
			
			int icePeachQty = ingredients.get("복숭아 가루");
			int coffeeQty = ingredients.get("원두");
			
			if (icePeachQty  >= 50 && coffeeQty>=100) {
				icePeachQty -= 50;
				coffeeQty -= 100;
				Ingredients.setCoffeeQty(coffeeQty);
				Ingredients.setIcePeachQty(icePeachQty);
			} else {
			System.out.println("재료가 소진되었습니다. ");
			}
		}

	

}
