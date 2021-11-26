package Menu;

import java.util.Map;

import Cafe.Ingredients;

public class IceTea extends Menu {

	public static String name = "아이스티";
	public static  int price = 3000;


		@Override
		public void outIngredients() {
			Map<String, Integer>  ingredients = Ingredients.getInstance();
			
			int icePeachQty = ingredients.get("복숭아 가루");
			if (icePeachQty  >= 100) {
				icePeachQty -= 100;
				Ingredients.setIcePeachQty(icePeachQty);
			} else {
			System.out.println("재료가 소진되었습니다. ");
			}
		}
}
