package teamplay;

import Cafe.Coffee;
import Cafe.Customer;
import java.util.Scanner;
import java.util.*;
class Cafe {
    private static Scanner scanner = new Scanner(System.in);
    
	private static String customerName;
    private static int customerAccount = 0;

    private static List<String> customerNameList = new ArrayList<>();
    private static List<Integer> customerAccountList = new ArrayList<>();

    private static int menuNum = 0;
	private static String menuName=null;
    private static int menuPrice = 0;
    private static int inventory = 0;
    
    private static List<String> menuNumList = new ArrayList<>();
    private static List<String> menuNameList = new ArrayList<>();
    private static List<Integer> menuPriceList = new ArrayList<>();
    private static List<Integer> inventoryList = new ArrayList<>();
    
    int saleMoney;
    

    	


    //1.회원생성
    private static void accountrCreate() {
		System.out.println("-------------------");
		System.out.println("회원등록");
		System.out.println("-------------------");

		System.out.print("회원님의 이름을 적어주세요: "); 
		customerName = scanner.next();
		customerNameList.add(customerName);
		System.out.print("충전하실 금액을 입력하여주세요: "); 
		customerAccount = scanner.nextInt();
		customerAccountList.add(customerAccount);
		
		for(int i=0;i<customerNameList.size();i++){
			  customerNameList.get(i); 
			  customerAccountList.get(i);
			}
		
	}
    //2.금액충전
    private static void moneyCharge() {

    	System.out.println("-------------------");
		System.out.println("금액충전");
		System.out.println("-------------------");
		System.out.print("이름 : "); 
		customerName = scanner.next();
		
		for(int i=0; i<customerNameList.size(); i++){
			if(customerNameList.get(i).equals(customerName)) {
				//입력받은 이름이 있으면 그 회원에게 충전
				System.out.print("충전 금액: ");
				customerAccount = scanner.nextInt();
				customerAccountList.set(i,customerAccountList.get(i)+customerAccount);
				
			}
			else {
				System.out.println("없는 회원입니다.");
				return;
			}
		}
    }

    //3.금액확인
    private static void accountSee() {
    	System.out.println("--------------");
		System.out.println("금액확인");
		System.out.println("--------------");
		System.out.print("고객성함: "); 
		String customerName = scanner.next();
		for(int i=0; i<customerNameList.size(); i++){
			if(customerNameList.get(i).equals(customerName)) {
				System.out.println(customerNameList.get(i)+" 님의 잔액은"+ customerAccountList.get(i)+" 원 입니다.");
			}
			else {
				System.out.println("없는 회원입니다.");
				return;
			}
		} 
    }
    
    
    //4.메뉴선택
	public void choiceMenu() {
		System.out.println("메뉴선택.");
		System.out.print("고객성함: "); 
		customerName = scanner.next();
		for(int i=0; i<customerNameList.size(); i++){
			if(customerNameList.get(i).equals(customerName)) {
				System.out.println(customerNameList.get(i)+" 님의 잔액은"+ customerAccountList.get(i)+" 원 입니다.");
				System.out.println("메뉴판");
				for(int j=0; j<menuNameList.size(); j++) {
					System.out.println((j+1)+"."+ menuNameList.get(j)+"  가격 :  " + menuPriceList.get(j)+"원");
				}
				System.out.println("--------------------------------------");
				System.out.println("메뉴를 선택해주세요.>>");
				int selectNo=0;
				selectNo = scanner.nextInt();
				for(int j=0; j<menuNameList.size(); j++) {
					if(selectNo==j+1) {
						if(customerAccountList.get(i)< menuPriceList.get(j)) {
						System.out.println(customerNameList.get(i)+"님의 잔액이 부족합니다.");
						return;
						}else if(inventoryList.get(j)<=0) {
							System.out.println("매진되었습니다.");
							return;
						}
						System.out.println(menuNameList.get(j)+"를 주문하셨습니다.");
						System.out.println("가격은 " + menuPriceList.get(j)+"원 입니다.");
						customerAccountList.set(i, customerAccountList.get(i)-menuPriceList.get(j));
						inventoryList.set(j, inventoryList.get(j)-1);
						saleMoney += menuPriceList.get(j);
						System.out.println("남은 잔고는 "+customerAccountList.get(i)+"원 입니다.");
					}
				}				
			}

		}

		
	}
	
	

	
	
	
	
	//1.메뉴추가
	public void addMenu() {
		System.out.println("추가할 메뉴의 이름을 입력해주세요 >>");
		menuName = scanner.next();
		menuNameList.add(menuName);
		
		System.out.println("추가할 메뉴의 가격을 입력해주세요 >>");
		menuPrice = scanner.nextInt();
		menuPriceList.add(menuPrice);
		
		System.out.println("추가할 메뉴의 초기 수량을 입력해주세요 >>");
		inventory = scanner.nextInt();
		inventoryList.add(inventory);
		
		System.out.println(menuName+" 메뉴가 추가되었습니다.");
		//중복 확인
//		for(int i=0; i<menuNameList.size(); i++){
//			if(!menuNameList.get(i).equals(menuName)) {
//				//입력받은 메뉴가 없으면 추가
//				System.out.println("추가할 메뉴의 가격을 입력해주세요 >>");
//				menuPrice = scanner.nextInt();
//				menuPriceList.add(menuPrice);
//		
//				System.out.println("추가할 메뉴의 초기 수량을 입력해주세요 >>");
//				inventory = scanner.nextInt();
//				inventoryList.add(inventory);
//		
//				System.out.println(menuName+" 메뉴가 추가되었습니다.");
//				return;
//			}
//			else {
//				System.out.println(menuName+" 는 이미 있는 메뉴입니다.");
//				return;
//			}
//		}
	}
	
	//2.수량추가
	public void addItem() {
		System.out.println("수량을 추가할 메뉴의 이름을 입력해주세요.>>");
		menuName = scanner.next();
		for(int i=0; i<=menuNameList.size(); i++){
			if(menuNameList.get(i).equals(menuName)) {
				System.out.print("재고 추가 수: ");
				inventory = scanner.nextInt();
				inventoryList.set(i,inventoryList.get(i)+inventory);
			}
			else {
				System.out.println(menuName+" 는 없는 메뉴입니다.");

			}
		}
/*		int i;
		Iterator<String> it = menuNameList.iterator();
		while(it.hasNext()) {
			if(menuNameList.get(i).equals(menuName)) {
				System.out.print("재고 추가 수: ");
				inventory = scanner.nextInt();
				inventoryList.set(i,inventoryList.get(i)+inventory);
			}
			else {
				System.out.println(menuName+" 는 없는 메뉴입니다.");
			}
		}*/


		
	}

	//3.남은 재고 확인
	public void stock() {
		for(int i=0;i<menuNameList.size();i++){
			System.out.println(menuNameList.get(i)+ ", "+ menuPriceList.get(i) +"원, " + inventoryList.get(i)+"개");
			}
	}
	//4.총 매출액 확인
	public void sales() {
		System.out.println("총 매출액은" + saleMoney+"원 입니다.");
	}
	//5.고객명단
	public void customerList() {
		for(int i=0;i<customerNameList.size();i++){
			System.out.println(customerNameList.get(i)+ ", "+ customerAccountList.get(i) +"원");
		}
	}

	
	
	
	
 //	고객용
    public void customers() {
    	java.util.Scanner sc = new java.util.Scanner(System.in);
    	boolean flag = true;
        while (flag) {
        	System.out.println("*********************");
            System.out.println("어떤 업무를 선택하시겠습니까?");
            System.out.println("1.회원등록 2.금액충전하기 3.금액확인하기  4.메뉴선택 5.취소");
        	System.out.println("*********************");
            String stringInput = sc.nextLine();          
            switch (stringInput) {
            case "1":
            	accountrCreate();		//회원생성
                break;
            case "2":
                moneyCharge();		//금액 충전하기
                break;
            case "3":
                accountSee();		//금액 확인하기
                break;
            case "4":
                choiceMenu();	//메뉴선택하기
                break;
            case "5":
                System.out.println("이용해주셔서 감사합니다");
                flag = false;
                break;
            default:
                System.out.println("잘못된 입력입니다");
            }
        }
    }
 //	업체용
    public void cafe() {
    	java.util.Scanner sc = new java.util.Scanner(System.in);
    	boolean flag = true;
        while (flag) {
        	System.out.println("*********************");
            System.out.println("어떤 업무를 선택하시겠습니까?");
            System.out.println("1.메뉴등록");
            System.out.println("2.수량추가");
            System.out.println("3.남은 재고확인");
            System.out.println("4.누적매출");
            System.out.println("5.고객명단");
            System.out.println("6.뒤로가기");
        	System.out.println("*********************");
            String 선택 = sc.nextLine();          
            switch (선택) {
            case "1":
                addMenu();		//메뉴추가
                break;
            case "2":
                addItem();		//수량추가
                break;
            case "3":			
                stock();		//재고확인
                break;
            case "4":			
            	sales();		//매출확인
            	break;
            case "5":
            	customerList();	//고객명단
            	break;
            case "6":			//취소
                System.out.println("이용해주셔서 감사합니다");
                flag = false;
                break;
            default:
                System.out.println("잘못된 입력입니다");
            }
        }
    }
    public void menupan(){
		menuNameList.add("아이스아메리카노");
		menuPriceList.add(3000);
		inventoryList.add(10);
		menuNameList.add("핫초코");
		menuPriceList.add(4000);
		inventoryList.add(15);
		menuNameList.add("바나나라떼");
		menuPriceList.add(5000);
		inventoryList.add(15);
    } 
//	처음시작할때 업체용인지 고객용인지 확인하기 위함
    public void who() {
    	java.util.Scanner sc = new java.util.Scanner(System.in);
    	boolean flag = true;
        while (flag) {
        	System.out.println("*********************");
            System.out.println("1.고객용 2.업체용 3.종료");
        	System.out.println("*********************");
            String stringInput = sc.nextLine();
            switch (stringInput) {
            case "1":
                customers();							//고객용
                break;
            case "2":
                cafe();									//카페용
                break;
            case "3":
                System.out.println("이용해주셔서 감사합니다");
                flag = false;
                break;
            default:
                System.out.println("잘못된 입력입니다");
            }
        }
    }

}
 
public class StarCafe {
    public static void main(String[] args) {
        Cafe ca = new Cafe();
        ca.menupan();
        ca.who();
        
    }
}