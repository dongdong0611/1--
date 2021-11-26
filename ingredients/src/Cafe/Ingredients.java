package Cafe;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;



public class Ingredients {
	private static Ingredients ingredients = new Ingredients();
	
	private static int coffeeQty =1000; 
	private static int milkQty =3000;
	private static int chocoQty =100;
	private static int vanillaQty = 100;
	private static int iceQty = 1000;
	private static int strawberryQty =500;
	private static int mangoQty = 500; 
	private static int icePeachQty = 1000;
	
	private Ingredients() {} 
	

	public static  Map<String, Integer> getInstance() {
		//Map 컬렉션 생성 
		Map<String, Integer> map = new HashMap<>();
		
		//객체 저장 
		map.put("원두", coffeeQty);
		map.put("우유", milkQty);
		map.put("얼음", iceQty);
		map.put("딸기", strawberryQty);
		map.put("망고", mangoQty);
		map.put("복숭아 가루", icePeachQty);
		map.put("초콜릿시럽", chocoQty);
		map.put("바닐라시럽", vanillaQty);

		
		return map;
	}
	
	public static void lookUpStock() {
	Map<String, Integer> ingredients = Ingredients.getInstance();
	
	Set<Map.Entry <String,Integer>> entrySet = ingredients.entrySet();
	Iterator<Map.Entry<String, Integer>> entryIterator = entrySet.iterator();
	while(entryIterator.hasNext()) {
		Map.Entry<String, Integer> entry=  entryIterator.next();
		String Key = entry.getKey(); 
		Integer Value = entry.getValue();
		
		System.out.println(Key + "  		 "   + Value + "g");
	
	}
}
	
	public static Ingredients getIngredients() {
		return ingredients;
	}

	public static void setIngredients(Ingredients ingredients) {
		Ingredients.ingredients = ingredients;
	}

	public static int getCoffeeQty() {
		return coffeeQty;
	}

	public static void setCoffeeQty(int coffeeQty) {
		Ingredients.coffeeQty = coffeeQty;
	}

	public static int getMilkQty() {
		return milkQty;
	}

	public static void setMilkQty(int milkQty) {
		Ingredients.milkQty = milkQty;
	}

	public static int getChocoQty() {
		return chocoQty;
	}

	public static void setChocoQty(int chocoQty) {
		Ingredients.chocoQty = chocoQty;
	}

	public static int getVanillaQty() {
		return vanillaQty;
	}

	public static void setVanillaQty(int vanillaQty) {
		Ingredients.vanillaQty = vanillaQty;
	}

	public static int getIceQty() {
		return iceQty;
	}

	public static void setIceQty(int iceQty) {
		Ingredients.iceQty = iceQty;
	}

	public static int getStrawberryQty() {
		return strawberryQty;
	}

	public static void setStrawberryQty(int strawberryQty) {
		Ingredients.strawberryQty = strawberryQty;
	}

	public static int getMangoQty() {
		return mangoQty;
	}

	public static void setMangoQty(int mangoQty) {
		Ingredients.mangoQty = mangoQty;
	}

	public static int getIcePeachQty() {
		return icePeachQty;
	}

	public static void setIcePeachQty(int icePeachQty) {
		Ingredients.icePeachQty = icePeachQty;
	}


}
