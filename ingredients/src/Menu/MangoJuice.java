package Menu;

import java.util.Map;

import Cafe.Ingredients;

public class MangoJuice  extends Menu{

	public static String name = "망고쥬스";
	public static  int price = 4000;

	@Override
	public void outIngredients() {
		Map<String, Integer>  ingredients = Ingredients.getInstance();
		
		int mangoQty =  ingredients.get("망고");
		int iceQty = ingredients.get("얼음");
	
		if (mangoQty  >= 100 && iceQty>=200) {
			mangoQty -= 100;
			iceQty -= 200;
			Ingredients.setMangoQty(mangoQty);
			Ingredients.setIceQty(iceQty);	
		} else {
		System.out.println("재료가 소진되었습니다. ");
		}
}

}
