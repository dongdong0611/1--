package Cafe;

import Menu.Americano;
import Menu.CafeLatte;
import Menu.CafeMoca;
import Menu.IcePeachShot;
import Menu.IceTea;
import Menu.StrawberryJuice;
import Menu.VanillaLatte;

public class test2 {
	public static void main(String[] args) {
		VanillaLatte americano = new VanillaLatte();
		americano.outIngredients();
		Ingredients.lookUpStock();
		
	}

}
