package sec02.exam01.vo;

public class Menu {
	int menuNumber;
	String menuName;
	int menuCost;
	
	public Menu(int menuNumber, String menuName, int menuCost) {
		this.menuNumber = menuNumber;
		this.menuName = menuName;
		this.menuCost = menuCost;
	}

	public int getMenuNumber() {
		return menuNumber;
	}

	public void setMenuNumber(int menuNumber) {
		this.menuNumber = menuNumber;
	}

	public String getMenuName() {
		return menuName;
	}

	public void setMenuName(String menuName) {
		this.menuName = menuName;
	}

	public int getMenuCost() {
		return menuCost;
	}

	public void setMenuCost(int menuCost) {
		this.menuCost = menuCost;
	}

	@Override
	public String toString() {
		return "Menu [menuNumber=" + menuNumber + ", menuName=" + menuName + ", menuCost=" + menuCost + "]";
	}
	
	

}
