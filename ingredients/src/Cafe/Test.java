

package Cafe;
import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

import Cafe.Coffee;
import Cafe.Customer;
import Menu.Americano;
import Menu.CafeLatte;
import Menu.CafeMoca;
import Menu.IcePeachShot;
import Menu.IceTea;
import Menu.MangoJuice;
import Menu.Menu;
import Menu.StrawberryJuice;
import Menu.VanillaLatte;

public class Test {
	private static Customer[] customerAccount = new Customer[1000];
	private static Coffee[] coffeeMenu = new Coffee[1000];
    private static Scanner scanner = new Scanner(System.in);
    private static int sales = 0;
    
    private static Americano americano = new Americano();
    private static CafeLatte cafeLatte = new CafeLatte();
    private static CafeMoca cafeMoca = new CafeMoca();
    private static VanillaLatte vanillaLatte = new VanillaLatte();
    private static IcePeachShot icePeachShot = new IcePeachShot();
    private static IceTea iceTea = new IceTea();
    private static MangoJuice mangoJuice = new MangoJuice();
    private static StrawberryJuice strawberryJuice = new StrawberryJuice();
    

    public static void main(String[] args) {  	
  
    	//초기 고객 명단 
    	customerAccount[0] = new Customer(1234, 10000);

    	// 초기  메뉴
    	
    	coffeeMenu[0] = new Coffee(Americano.name, Americano.price); 
    	coffeeMenu[1] = new Coffee(CafeLatte.name, CafeLatte.price); 
    	coffeeMenu[2] = new Coffee(CafeMoca.name, CafeMoca.price); 
    	coffeeMenu[3] = new Coffee(VanillaLatte.name, VanillaLatte.price); 
    	coffeeMenu[4] = new Coffee(IcePeachShot.name, IcePeachShot.price); 
    	coffeeMenu[5] = new Coffee(IceTea.name, IceTea.price); 
    	coffeeMenu[6] = new Coffee(MangoJuice.name, MangoJuice.price); 
    	coffeeMenu[7] = new Coffee(StrawberryJuice.name, StrawberryJuice.price); 
	
    	
    	//    	coffeeMenu[0] = new Coffee("아메리카노", 3000, 100); 
    	
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
			} else {
				System.out.println("다시 선택하십시오.");
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
			} else {
				System.out.println("다시 선택하십시오.");
			}
		}
		System.out.println("안녕히가세요.");
    }
 
    //매장  
    private static void storeManage() {
    	boolean run2 = true;
		while(run2) {
			System.out.println("----------------------------------------------------------");
			 /*수정 */ 			System.out.println("1.메뉴등록 | 2.수량추가 | 3.남은재료 | 4. 누적매출 | 5. 고객명단 | 6.종료");
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
			} else {
				System.out.println("다시 선택하십시오.");
			}
		}
		System.out.println("매장관리 프로그램 종료");
    }
    
    //고객등록
    private static void customerRegister() {
		System.out.println("--------------");
		System.out.println("고객등록");
		System.out.println("--------------");

		boolean runTemp = true;
		int customerNo = 0;
		while(runTemp) {
			System.out.print("전화번호 뒤 4자리 입력해주십시오: "); 
			int temp = scanner.nextInt();
			if((int)(Math.log10(temp)+1) != 4) {
				System.out.println("입력해주신 번호는 4자리가 아닙니다.");
			} else {
				customerNo += temp;
				runTemp = false;
			}
		}		
		
		System.out.print("초기충전액: ");
		int customerBalance = scanner.nextInt();
				
		Customer newCustomer = new Customer(customerNo, customerBalance);
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
		boolean runTemp = true;
		int customerNo = 0;
		while(runTemp) {
			System.out.print("전화번호 뒤 4자리 입력해주십시오: "); 
			int temp = scanner.nextInt();
			if((int)(Math.log10(temp)+1) != 4) {
				System.out.println("입력해주신 번호는 4자리가 아닙니다.");
			} else {
				customerNo += temp;
				runTemp = false;
			}
		}	
		System.out.print("충전액: ");
		int money = scanner.nextInt();
		Customer customer = findCustomer(customerNo);
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
		boolean runTemp = true;
		int customerNo = 0;
		while(runTemp) {
			System.out.print("전화번호 뒤 4자리 입력해주십시오: "); 
			int temp = scanner.nextInt();
			if((int)(Math.log10(temp)+1) != 4) {
				System.out.println("입력해주신 번호는 4자리가 아닙니다.");
			} else {
				customerNo += temp;
				runTemp = false;
			}
		}	
		Customer customer = findCustomer(customerNo);
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
		 /*수정 */ 
		
		switch(selectNo) {
		case 1:
				americano.outIngredients();
				break;
		case 2: 
				cafeLatte.outIngredients();
				break;
		case 3:
				cafeMoca.outIngredients();
				break;
		case 4: 
				vanillaLatte.outIngredients();
				break;
		case 5: 
				icePeachShot.outIngredients();
				break;
		case 6: 
				iceTea.outIngredients();
				break;
		case 7: 
				mangoJuice.outIngredients();
				break;
		case 8: 
				strawberryJuice.outIngredients();
				break;
				
		}
			
			
		Coffee order = coffeeMenu[selectNo-1];
		runTemp = true;
		StringBuffer coffeeType = new StringBuffer();
		while(runTemp) {
			System.out.println("--------------");
			System.out.println("1. HOT | 2. ICE");
			System.out.println("--------------");
			System.out.print("HOT/ICE 커피를 선택해주세요: ");
			int selectType = scanner.nextInt();
			if(selectType == 1) {
				coffeeType.append("HOT");
				runTemp = false;
			} else if(selectType == 2) {
				coffeeType.append("ICE");
				runTemp = false;
			} else {
				System.out.println("다시 선택해주세요.");
			}
			
		}
		if(customer.getCustomerBalance()<order.getCoffeePrice()) {
			System.out.println("금액이 부족합니다.");
			return;
			 /* 삭제  */ 		
//		} else if(order.getCoffeeInventory()<= 0) {
//			System.out.println("매진 되었습니다.");
//			return;
		}
		System.out.println(coffeeType + " " +order.getCoffeeName()+"를 주문하셨습니다.");
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
		boolean runTemp = true;
		int customerNo = 0;
		while(runTemp) {
			System.out.print("전화번호 뒤 4자리 입력해주십시오: "); 
			int temp = scanner.nextInt();
			if((int)(Math.log10(temp)+1) != 4) {
				System.out.println("입력해주신 번호는 4자리가 아닙니다.");
			} else {
				customerNo += temp;
				runTemp = false;
			}
		}	
		Customer customer = findCustomer(customerNo);
		if(customer == null) {
			System.out.println("결과: 계좌가 없습니다.");
			return;
		}
		System.out.println("남은 충전액은 " + customer.getCustomerBalance() + "입니다.");
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
		 /*삭제 */ 
//		System.out.print("초기수량: ");
//		int coffeeInventory = scanner.nextInt();
		
		//**
		Coffee newMenu = new Coffee(coffeeName, coffeePrice);
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
    
    //잔고수량
    private static void menuInventory() {
    	System.out.println("--------------");
		System.out.println("재고수량");
		System.out.println("--------------");
		System.out.println("메뉴품목 " + "		" + " 재고량 ");
		Ingredients.lookUpStock();
//		for(int i=0; i<coffeeMenu.length; i++) {
//			Coffee menuItem = coffeeMenu[i];
//			if(menuItem != null) {
//				System.out.print(menuItem.getCoffeeName());
//				System.out.print("     ");
//				System.out.print(menuItem.getCoffeePrice()+"원");
//				System.out.print("     ");
//				System.out.print(menuItem.getCoffeeInventory()+"잔");
//				System.out.println();
//			}
//		}
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
		System.out.println("고객변호         충전금액 ");
		for(int i=0; i<customerAccount.length; i++) {
			Customer customer = customerAccount[i];
			if(customer != null) {
				System.out.print(customer.getCustomerNo());
				System.out.print("     ");
				System.out.print(customer.getCustomerBalance()+"원");
				System.out.println();
			}
		}
    }
    
    //findCustomer() 객체 찾기
    private static Customer findCustomer(int customerNo) {
		Customer customer = null;
		for(int i=0; i<customerAccount.length; i++) {
			if(customerAccount[i] != null) {
				int dbName = customerAccount[i].getCustomerNo();
				if(dbName == customerNo) {
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

