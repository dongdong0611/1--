package sec02.exam01.vo;

public class Inventory {
	Menu inventoryMenu;
	int inventoryAmount;
	
	public Inventory(Menu inventoryMenu, int inventoryAmount){
		this.inventoryMenu = inventoryMenu;
		this.inventoryAmount = inventoryAmount;
	}

	public Menu getInventoryMenu() {
		return inventoryMenu;
	}

	public void setInventoryMenu(Menu inventoryMenu) {
		this.inventoryMenu = inventoryMenu;
	}

	public int getInventoryAmount() {
		return inventoryAmount;
	}

	public void setInventoryAmount(int inventoryAmount) {
		this.inventoryAmount = inventoryAmount;
	}

	@Override
	public String toString() {
		return "Inventory [inventoryMenu=" + inventoryMenu + ", inventoryAmount=" + inventoryAmount + "]";
	}

}
