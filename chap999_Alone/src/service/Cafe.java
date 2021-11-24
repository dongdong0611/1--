package service;

import java.util.ArrayList;
import java.util.List;

import sec02.exam01.vo.Inventory;
import sec02.exam01.vo.Menu;
import sec02.exam01.vo.Order;
import sec02.exam01.vo.User;

public class Cafe {
	List<User> userList = new ArrayList<User>();
	List<Order> orderHistory = new ArrayList<Order>();
	List<Inventory> inventoryList = new ArrayList<Inventory>();
	List<Menu> menuList = new ArrayList<Menu>();
	public Cafe() {
		
		this.userList.add(new User("01012345678", "A", 30000));
		this.userList.add(new User("01012341234", "B", 100000));
		this.userList.add(new User("01011112222", "C", 50000));

		this.menuList.add(new Menu(1, "�Ƹ޸�ī��", 3000));
		this.menuList.add(new Menu(2, "���ڶ�", 5000));
		this.menuList.add(new Menu(3, "���⽺��Ŭ��", 4500));
		this.menuList.add(new Menu(4, "���", 4000));

		
		this.orderHistory.add(new Order(this.userList.get(0),this.menuList.get(0),20));
		
		
		
	}
	public void doOrder(String phoneNumber, String menuName, int amount ) {
		
		Order currOrder = new Order(this.getUserByPhoneNumber(phoneNumber),this.getMenuByMenuName(menuName), amount);
		
		System.out.println("--- ���� �ֹ� ---");
		System.out.println(currOrder);
		this.orderHistory.add(currOrder);
		
	
	}
	public void doOrder(String phoneNumber, int menuNumber, int amount ) {
		
		System.out.println(this.getUserByPhoneNumber(phoneNumber).toString());
		
		System.out.println(this.getmenuByMenuNumber(menuNumber));
		
	}
	public Menu getmenuByMenuNumber(int menuNumber) {
		Menu resultMenu = null;
		for(Menu menu : this.menuList) {
			if(menu.getMenuNumber() == menuNumber) {
				resultMenu = menu;
			}
		}
		if(resultMenu == null) resultMenu = new Menu(-1,"none",0);
		return resultMenu;
	}
	
	public Menu getMenuByMenuName(String menuName) {
		Menu resultMenu = null;
		for(Menu menu : this.menuList) {
			if(menu.getMenuName().equals(menuName)) {
				resultMenu = menu;
			}
		}
		if(resultMenu == null) resultMenu = new Menu(-1,"none",0);
		return resultMenu;
	}
	
	public User getUserByPhoneNumber(String phoneNumber) {
		User resultUser = null;
		for(User user : this.userList) {
			if(user.getPhoneNumber().equals(phoneNumber)){
				resultUser = user;
			}
		}
		if(resultUser == null) resultUser = new User("none","none",0);
		return resultUser;
		
	}
	
	public static void main(String[] args) {
		Cafe cafe = new Cafe();
		
		System.out.println("--- ȸ�� ��� ---");
		System.out.println(cafe.userList.toString());
		
		System.out.println("--- �޴� ��� ---");
		System.out.println(cafe.menuList.toString());
		
		System.out.println();
		System.out.println();
		
		
		
		cafe.doOrder("01012345678", "�Ƹ޸�ī��", 1);
		cafe.doOrder("01012341234", "���ڶ�", 2);
		cafe.doOrder("01011112222", "�Ƹ޸�ī��", 3);
		cafe.doOrder("01012345678", "�Ƹ޸�ī��", 4);
		cafe.doOrder("01011112222", "���ڶ�", 5);
		
	
		
		System.out.println("--- �ֹ� ���� ---");
		System.out.println(cafe.orderHistory.toString());	
	}
	
	

}
