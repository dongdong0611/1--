package Cafe;
import java.util.Scanner;
import Cafe.Coffee;
import Cafe.Customer;

public class Test {
	private static Customer[] customerAccount = new Customer[1000];
	private static Coffee[] coffeeMenu = new Coffee[1000];
    private static Scanner scanner = new Scanner(System.in);
    private static int sales = 0;
    

    public static void main(String[] args) {  	
    	
        //고객/매장 선택
    	boolean run = true;
		while(run) {
			System.out.println("----------------------------------------------------------");
			System.out.println("1.고객 | 2.매장 | 3. 종료");
			System.out.println("----------------------------------------------------------");
			System.out.print("선택> ");
			
			int selectNo = scanner.nextInt();
			
			if(selectNo == 1) {
				customerOrder();
			} else if(selectNo == 2) {
				storeManage();
			} else if(selectNo == 3) {
				run = false;
			}
		}
		System.out.println("POS 종료");
	}
    
    //고객
    private static void customerOrder() {
    	boolean run1 = true;
		while(run1) {
			System.out.println("----------------------------------------------------------");
			System.out.println("1.고객등록 | 2.금액충전 | 3. 주문 | 4. 금액확인 | 5. 종료");
			System.out.println("----------------------------------------------------------");
			System.out.print("선택> ");
			
			int selectNo = scanner.nextInt();
			
			if(selectNo == 1) {
				customerRegister();
			} else if(selectNo == 2) {
				customerCharge();
			} else if(selectNo == 3) {
				customerBuy();
			} else if(selectNo == 4) {
				customerBalance();
			} else if(selectNo == 5) {
				run1 = false;
			}
		}
		System.out.println("안녕히가세요.");
    }
    
    //매장
    private static void storeManage() {
    	boolean run2 = true;
		while(run2) {
			System.out.println("----------------------------------------------------------");
			System.out.println("1.메뉴등록 | 2.수량추가 | 3. 남은수량 | 4. 누적매출 | 5. 고객명단 | 6.종료");
			System.out.println("----------------------------------------------------------");
			System.out.print("선택> ");
			
			int selectNo = scanner.nextInt();
			
			if(selectNo == 1) {
				menuRegister();
			} else if(selectNo == 2) {
				menuAddition();
			} else if(selectNo == 3) {
				menuInventory();
			} else if(selectNo == 4) {
				accumulatedSales();
			} else if(selectNo ==5) {
				customerList();
			} else if(selectNo == 6) {
				run2 = false;
			}
		}
		System.out.println("매장관리 프로그램 종료");
    }
    
    //고객등록
    private static void customerRegister() {
		System.out.println("--------------");
		System.out.println("고객등록");
		System.out.println("--------------");

		System.out.print("고객성함: "); 
		String customerName = scanner.next();
		
		System.out.print("초기충전액: ");
		int customerBalance = scanner.nextInt();
		
		Customer newCustomer = new Customer(customerName, customerBalance);
		for(int i=0; i<customerAccount.length; i++) {
			if(customerAccount[i] == null) {
				customerAccount[i] = newCustomer;
				System.out.println("결과: 고객계좌가 생성되었습니다.");
				break;
			} 
		}		
	}
    
    //금액충전
    private static void customerCharge() {
    	System.out.println("--------------");
		System.out.println("금액충전");
		System.out.println("--------------");
		System.out.print("고객성함: "); 
		String customerName = scanner.next();
		System.out.print("충전액: ");
		int money = scanner.nextInt();
		Customer customer = findCustomer(customerName);
		if(customer == null) {
			System.out.println("결과: 계좌가 없습니다.");
			return;
		}
		customer.setCustomerBalance(customer.getCustomerBalance() + money);
		System.out.println("결과: 충전이 성공적으로 완료되었습니다.");
    }
    
    //주문
    private static void customerBuy() {
    	System.out.println("--------------");
		System.out.println("주문");
		System.out.println("--------------");
		System.out.print("고객성함: ");
		String customerName = scanner.next();
		Customer customer = findCustomer(customerName);
		System.out.println("현재 금액은 " + customer.getCustomerBalance()+"원입니다.");
		System.out.println();
		System.out.println("메뉴를 선택해주세요");
		System.out.println("--------------");
		for(int i=0; i<coffeeMenu.length; i++) {
			Coffee order = coffeeMenu[i];
			if(order != null) {
				System.out.print((i+1)+"."+order.getCoffeeName());
				System.out.print("     ");
				System.out.print("가격: "+order.getCoffeePrice());
				System.out.println();
			}
		}
		System.out.println("--------------");
		System.out.print("메뉴 선택> ");
		int selectNo = scanner.nextInt();
		Coffee order = coffeeMenu[selectNo-1];
		if(customer.getCustomerBalance()<order.getCoffeePrice()) {
			System.out.println("금액이 부족합니다.");
			return;
		} else if(order.getCoffeeInventory()<= 0) {
			System.out.println("매진 되었습니다.");
			return;
		}
		System.out.println(order.getCoffeeName()+"를 주문하셨습니다.");
		System.out.println("가격은 " + order.getCoffeePrice()+"원 입니다.");
		customer.setCustomerBalance(customer.getCustomerBalance()-order.getCoffeePrice());
		order.setCoffeeInventory(order.getCoffeeInventory()-1);
		sales += order.getCoffeePrice();
		System.out.println("남은 잔고는 "+customer.getCustomerBalance()+"원 입니다.");
    }
    
    //금액확인
    private static void customerBalance() {
    	System.out.println("--------------");
		System.out.println("금액확인");
		System.out.println("--------------");
		System.out.print("고객성함: "); 
		String customerName = scanner.next();
		Customer customer = findCustomer(customerName);
		if(customer == null) {
			System.out.println("결과: 계좌가 없습니다.");
			return;
		}
		System.out.println(customer.getCustomerName()+"님의 총 충전금액은 " + customer.getCustomerBalance() + "입니다.");
    }
    
    //메뉴등록
    private static void menuRegister() {
    	System.out.println("--------------");
		System.out.println("메뉴등록");
		System.out.println("--------------");

		System.out.print("메뉴명: "); 
		String coffeeName = scanner.next();
		
		System.out.print("메뉴가격: ");
		int coffeePrice = scanner.nextInt();
		
		System.out.print("초기수량: ");
		int coffeeInventory = scanner.nextInt();
		
		Coffee newMenu = new Coffee(coffeeName, coffeePrice, coffeeInventory);
		for(int i=0; i<coffeeMenu.length; i++) {
			if(coffeeMenu[i] == null) {
				coffeeMenu[i] = newMenu;
				System.out.println("결과: 새 메뉴가 등록되었습니다.");
				break;
			} 
		}		
    }
    
    //수량추가
    private static void menuAddition() {
    	System.out.println("--------------");
		System.out.println("수량추가");
		System.out.println("--------------");
		System.out.print("메뉴이름: "); 
		String coffeeName = scanner.next();
		System.out.print("수량 추가 수:");
		int addition = scanner.nextInt();
		Coffee menuItem = findCoffee(coffeeName);
		if(menuItem == null) {
			System.out.println("결과: 해당 메뉴 아이템이 없습니다.");
			return;
		}
		menuItem.setCoffeeInventory(menuItem.getCoffeeInventory() + addition);
		System.out.println("결과: 수량이 성공적으로 업데이트 되었습니다.");
    }    
    
    //남은수량
    private static void menuInventory() {
    	System.out.println("--------------");
		System.out.println("남은수량");
		System.out.println("--------------");
		for(int i=0; i<coffeeMenu.length; i++) {
			Coffee menuItem = coffeeMenu[i];
			if(menuItem != null) {
				System.out.print(menuItem.getCoffeeName());
				System.out.print("     ");
				System.out.print(menuItem.getCoffeePrice()+"원");
				System.out.print("     ");
				System.out.print(menuItem.getCoffeeInventory()+"잔");
				System.out.println();
			}
		}
    }
    
    //누적매출
    private static void accumulatedSales() {
    	System.out.println("총 매출은 " + sales+"원입니다.");
    }
    
    //고객명단
    private static void customerList() {
    	System.out.println("--------------");
		System.out.println("고객명단");
		System.out.println("--------------");
		for(int i=0; i<customerAccount.length; i++) {
			Customer customer = customerAccount[i];
			if(customer != null) {
				System.out.print(customer.getCustomerName());
				System.out.print("     ");
				System.out.print("총 충전액: " + customer.getCustomerBalance());
				System.out.println();
			}
		}
    }
    
    //findCustomer() 객체 찾기
    private static Customer findCustomer(String customerName) {
		Customer customer = null;
		for(int i=0; i<customerAccount.length; i++) {
			if(customerAccount[i] != null) {
				String dbName = customerAccount[i].getCustomerName();
				if(dbName.equals(customerName)) {
					customer = customerAccount[i];
					break;
				}
			}
		}
		return customer;
	}
    
  //findCoffee() 객체 찾기
    private static Coffee findCoffee(String coffeeName) {
		Coffee menuItem = null;
		for(int i=0; i<coffeeMenu.length; i++) {
			if(coffeeMenu[i] != null) {
				String dbName = coffeeMenu[i].getCoffeeName();
				if(dbName.equals(coffeeName)) {
					menuItem = coffeeMenu[i];
					break;
				}
			}
		}
		return menuItem;
	}
}



