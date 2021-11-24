package Cafe;
public class Coffee {
	
    private String coffeeName;
	private int coffeePrice;
	private int coffeeInventory;
	
    public Coffee(String coffeeName, int coffeePrice, int coffeeInventory) {
    	this.coffeeName = coffeeName;
    	this.coffeePrice = coffeePrice;
    	this.setCoffeeInventory(coffeeInventory);
    }
	
    public String getCoffeeName() {
		return coffeeName;
	}

	public void setCoffeeName(String coffeeName) {
		this.coffeeName = coffeeName;
	}

	public int getCoffeePrice() {
		return coffeePrice;
	}

	public void setCoffeePrice(int coffeePrice) {
		this.coffeePrice = coffeePrice;
	}

	public int getCoffeeInventory() {
		return coffeeInventory;
	}

	public void setCoffeeInventory(int coffeeInventory) {
		this.coffeeInventory = coffeeInventory;
	}


    

}
