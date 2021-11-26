package Menu;

import java.util.Map;

import Cafe.Ingredients;

public class StrawberryJuice extends Menu {

	public static String name = "딸기쥬스";
	public static  int price = 4000;
	@Override
	public void outIngredients() {
		Map<String, Integer>  ingredients = Ingredients.getInstance();
		
		int strawberryQty =  ingredients.get("딸기");
		int iceQty = ingredients.get("얼음");
		
		if (strawberryQty  >= 100 && iceQty>=200) {
			strawberryQty -= 100;
			iceQty -= 200;
			Ingredients.setIceQty(iceQty);
			Ingredients.setStrawberryQty(strawberryQty);	
		} else {
		System.out.println("재료가 소진되었습니다. ");
		}
}
	
	
}
