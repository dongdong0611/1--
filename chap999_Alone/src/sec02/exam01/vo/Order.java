package sec02.exam01.vo;

public class Order {
	User orderUser;
	Menu orderMenu;
	int orderAmount;	
	
	public Order(User orderUser, Menu orderMenu, int orderAmount) {
		this.orderUser = orderUser;
		this.orderMenu = orderMenu;
		this.orderAmount = orderAmount;		
	}

	public User getOrderUser() {
		return orderUser;
	}

	public void setOrderUser(User orderUser) {
		this.orderUser = orderUser;
	}

	public Menu getOrderMenu() {
		return orderMenu;
	}

	public void setOrderMenu(Menu orderMenu) {
		this.orderMenu = orderMenu;
	}

	public int getOrderAmount() {
		return orderAmount;
	}

	public void setOrderAmount(int orderAmount) {
		this.orderAmount = orderAmount;
	}

	@Override
	public String toString() {
		return "Order [orderUser=" + orderUser + ", orderMenu=" + orderMenu + ", orderAmount=" + orderAmount + "]";
	}

}
