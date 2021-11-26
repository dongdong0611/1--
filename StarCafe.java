package teamplay;

import java.util.Scanner;
import java.util.*;

class Cafe{
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
    
    private static int orderCustomerIndex = -1;
    private static int orderCustomerAccount = 0;
    private static List<String> orderMenuName = new ArrayList<>();
    private static List<Integer> orderMenuPrice = new ArrayList<>();
    
    
    int saleMoney;
    

    	


    //1.회원생성
    private static void accountrCreate() {
    	System.out.println("--------------------");
		System.out.println("회원등록");
    	System.out.println("--------------------");

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
    	System.out.println("--------------------");
		System.out.println("금액충전");
    	System.out.println("--------------------");
		System.out.print("이름 : "); 
		customerName = scanner.next();
		int x=0;
		for(int i=0; i<customerNameList.size(); i++){
			if(customerNameList.get(i).equals(customerName)) {
				//입력받은 이름이 있으면 그 회원에게 충전
				System.out.print("충전 금액: ");
				customerAccount = scanner.nextInt();
				customerAccountList.set(i,customerAccountList.get(i)+customerAccount);
				System.out.println(customerNameList.get(i)+"님의 충전 후 잔액은"+ customerAccountList.get(i) +"원 입니다");
				break;
			}
			else {
				x++;
				continue;
			}
		}
		if(x==customerNameList.size()){
			System.out.println(customerName+" 는 없는 사람입니다.");
		}
    }
    


    

    //3.금액확인
    public void accountSee() {
		System.out.println("고객성함>>>"); 
		customerName = scanner.next();
    	int x=0;
		for(int i=0; i<customerNameList.size(); i++){
			if(customerNameList.get(i).equals(customerName)){
				System.out.println(customerNameList.get(i)+" 님의 잔액은"+ customerAccountList.get(i)+" 원 입니다.");
				break;
			}
				else {
					x++;
					continue;
			}
		}
		if(x==customerNameList.size()){
			System.out.println("없는 회원입니다.");
		}
	}
    
    

    
	
    //4.메뉴선택
    public void checkCustomer() {
    	java.util.Scanner sc = new java.util.Scanner(System.in);
    	boolean flag = true;
        while (flag) {
        	System.out.print("고객성함: "); 
    		customerName = scanner.next();
    		for(int i=0; i<customerNameList.size(); i++){
    			if(customerNameList.get(i).equals(customerName)) {
    				System.out.println(customerNameList.get(i)+" 님의 잔액은 "+ customerAccountList.get(i)+"원 입니다.");
    				orderCustomerIndex = i;
    				orderCustomerAccount += customerAccountList.get(i);
    				choiceMenu();
    				flag = false;
    				break;
    			} 	
    			System.out.println("없는 고객입니다. 다시 입력해주세요.");
    		}

        }
    }
    //4.메뉴 선택 후 고객이 맞으면 장바구니 선택사항 열어줌.
	public void choiceMenu() {
		java.util.Scanner sc = new java.util.Scanner(System.in);
    	boolean flag = true;
        while (flag) {
        	System.out.println("--------------------");
        	System.out.println("메뉴주문");
            System.out.println("1.장바구니에 메뉴추가" );
            System.out.println("2.장바구니에서 메뉴빼기" );
            System.out.println("3.장바구니 확인" );
            System.out.println("4.계산" );
            System.out.println("5.취소" );
        	System.out.println("--------------------");
            String stringInput = sc.nextLine();
            switch (stringInput) {
            case "1":
                addOrder();					//장바구니 담기
                break;
            case "2":
                deleteOrder();				//장바구니 담기 취소
                break;
            case "3":
            	checkOrder();				//장바구니 확인
            	break;
           case "4":
              checkOrder();					//장바구니 계산
              System.out.println("이대로 결제하시겠습니까?");
              System.out.println("1.네 2.아니오");
              String finalInput = sc.nextLine();
              switch (finalInput) {
              case "1":
            	  customerAccountList.set(orderCustomerIndex, 
            			  customerAccountList.get(orderCustomerIndex)-orderMenuPrice.stream().mapToInt(Integer::intValue).sum());
            	  saleMoney +=  orderMenuPrice.stream().mapToInt(Integer::intValue).sum();
            	  System.out.println("결제가 완료되었습니다.");
            	  System.out.println("현재 남은 잔액은 " + customerAccountList.get(orderCustomerIndex)+"원 입니다." );
            	  System.out.println("감사합니다.");
            	  orderCustomerIndex = -1;
            	  orderCustomerAccount = 0;
            	  orderMenuName.removeAll(orderMenuName);
            	  orderMenuPrice.removeAll(orderMenuPrice);
            	  flag = false;
            	  break;
              case "2":
            	  System.out.println("결제 취소하셨습니다.");
            	  continue;
              } 
              break;
           case "5":
        	    flag = false;
           default:
                System.out.println("잘못된 입력입니다");
            }
        }
		}	
	//4-1 장바구니에 담기
	public void addOrder() {
		java.util.Scanner sc = new java.util.Scanner(System.in);
    	boolean flag = true;
        while (flag) {
			System.out.println("메뉴판");
			for(int j=0; j<menuNameList.size(); j++) {
				System.out.println((j+1)+"."+ menuNameList.get(j)+"  가격 :  " + menuPriceList.get(j)+"원");
			}
			System.out.println("----------------");
			System.out.println("메뉴를 선택해주세요.>>");
			int selectNo=0;
			selectNo = sc.nextInt();
			
				if(inventoryList.get(selectNo-1)>0 && orderMenuPrice.stream().mapToInt(Integer::intValue).sum()+menuPriceList.get(selectNo-1) <= orderCustomerAccount) {
							orderMenuName.add(menuNameList.get(selectNo-1));
							orderMenuPrice.add(menuPriceList.get(selectNo-1));
							inventoryList.set(selectNo-1, inventoryList.get(selectNo-1)-1);
							System.out.println(menuNameList.get(selectNo-1)+"를 장바구니에 넣으셨습니다.");
							System.out.println("현재 장바구니 결제금액은 총 " + orderMenuPrice.stream().mapToInt(Integer::intValue).sum()+"원 입니다.");
							System.out.println();
							flag = false;
							break;
						} else if(inventoryList.get(selectNo-1)<=0){
							System.out.println("매진 되었습니다.");
							flag = false;
							break;
						} else if (orderMenuPrice.stream().mapToInt(Integer::intValue).sum()+menuPriceList.get(selectNo-1) > orderCustomerAccount){
							System.out.println("잔액이 부족합니다.");
							flag = false;
							break;
						}
				}
				
				
			}
			
   			
  
	//4-2 장바구니 담기취소
    public void deleteOrder() {
 		java.util.Scanner sc = new java.util.Scanner(System.in);
     	boolean flag = true;
     	if(orderMenuName.size() != 0 ) {
         while (flag) {
 			System.out.println("현재 장바구니");
 			for(int j=0; j<orderMenuName.size(); j++) {
 				System.out.println((j+1)+"."+ orderMenuName.get(j)+"  가격 :  " + orderMenuPrice.get(j)+"원");
 			}
 			System.out.println("현재 장바구니 결제금액은 총 " + orderMenuPrice.stream().mapToInt(Integer::intValue).sum()+"원 입니다.");
 			System.out.println("-------------------");
 			System.out.println("빼실 메뉴를 선택해주세요.>>");
 			int selectNo=0;
 			selectNo = sc.nextInt();
 				System.out.println(orderMenuName.get(selectNo-1)+"를 장바구니에서 뺐습니다.");
 				inventoryList.set(menuNameList.indexOf(orderMenuName.get(selectNo-1)), inventoryList.get(selectNo-1)+1); 
 				orderMenuName.remove(orderMenuName.get(selectNo-1));
 				orderMenuPrice.remove(orderMenuPrice.get(selectNo-1)); 								
 				System.out.println("현재 장바구니 결제금액은 총 " + orderMenuPrice.stream().mapToInt(Integer::intValue).sum()+"원 입니다.");
 				System.out.println();
 				flag = false;
 				break;
         } 
 		} else {
 			System.out.println("현재 장바구니에 아무것도 없습니다.");
 			return;
 		}
 			}
 			
    //4-3 장바구니 확인
    public void checkOrder() {
    	java.util.Scanner sc = new java.util.Scanner(System.in);
     	boolean flag = true;
     	if(orderMenuName.size() != 0 ) {
         	System.out.println("현재 장바구니");
 			for(int j=0; j<orderMenuName.size(); j++) {
 				System.out.println((j+1)+"."+ orderMenuName.get(j)+"  가격 :  " + orderMenuPrice.get(j)+"원");
 			}
 			System.out.println("현재 장바구니 결제금액은 총 " + orderMenuPrice.stream().mapToInt(Integer::intValue).sum()+"원 입니다.");
 			System.out.println("----------------------");
 			return;
 			} else {
  			System.out.println("현재 장바구니에 아무것도 없습니다.");
  			return;
  		}
 		}
 			
    
	
	
	//1.메뉴추가
	public void addMenu() {
		int x=0;
		System.out.println("추가할 메뉴의 이름을 입력해주세요 >>");
		menuName = scanner.next();
		for(int i=0; i<menuNameList.size(); i++){
			if(menuNameList.get(i).equals(menuName)){
				System.out.println(menuName+"는 이미 있는 메뉴입니다.");
				break;
			}
				else {
					x++;
				continue;
			}
		}
		if(x==menuNameList.size()){
			menuNameList.add(menuName);
			
			System.out.println("추가할 메뉴의 가격을 입력해주세요 >>");
			menuPrice = scanner.nextInt();
			menuPriceList.add(menuPrice);
	
			System.out.println("추가할 메뉴의 초기 수량을 입력해주세요 >>");
			inventory = scanner.nextInt();
			inventoryList.add(inventory);
			
			System.out.println(menuName+" 메뉴가 추가되었습니다.");
		}
	}
	
	//2.수량추가
	public void addItem() {
		if (menuNameList.size() <= 0) {
			System.out.println("현재 메뉴가 없습니다.");
			return;
		}
		java.util.Scanner sc = new java.util.Scanner(System.in);
    	boolean flag = true;
        while (flag) {
			System.out.println("재고현황");
			for(int j=0; j<menuNameList.size(); j++) {
				System.out.println((j+1)+"."+ menuNameList.get(j)+"  남은갯수 :  " + inventoryList.get(j)+"잔");
			}
        	System.out.println("-----------------------");
			System.out.println("수량추가 할 메뉴를 선택해주세요.>>");
			int selectNo=0;
			selectNo = sc.nextInt();
			if(menuNameList.size() <= (selectNo-1) || selectNo < 1) {
				selectNo=0;
				System.out.println("없는 메뉴입니다. 다시 선택하세요.");
				break;
			}
			System.out.println("수량추가 수를 선택해주세요>>");
			int addNo = sc.nextInt();
			if (addNo <= 0) {
				System.out.println("추가 불가능한 수 입니다. 다시 선택하세요");
				break;
			}
			inventoryList.set(selectNo-1, inventoryList.get(selectNo-1)+addNo);
			System.out.println("추가하신 개수는 " + addNo +"잔 입니다.");
			System.out.println(menuNameList.get(selectNo-1)+"의 개수는 "+inventoryList.get(selectNo-1) +"잔 입니다");
		flag = false;
        	break;
		}
  }


	//3.남은 재고 확인
	public void stock() {
		for(int i=0;i<menuNameList.size();i++){
			System.out.println(menuNameList.get(i)+ ", " + inventoryList.get(i)+"잔");
			}
	}
	//4.총 매출액 확인
	public void sales() {
		System.out.println("총 매출액은 " + saleMoney+"원 입니다.");
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
        	System.out.println("--------------------");
            System.out.println("어떤 업무를 선택하시겠습니까?");
            System.out.println("1.회원등록");
            System.out.println("2.금액충전하기");
            System.out.println("3.금액확인하기");
            System.out.println("4.메뉴선택");
            System.out.println("5.취소");
        	System.out.println("--------------------");
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
            	checkCustomer();	//메뉴선택하기
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
        	System.out.println("--------------------");
            System.out.println("어떤 업무를 선택하시겠습니까?");
            System.out.println("1.메뉴등록");
            System.out.println("2.수량추가");
            System.out.println("3.남은 재고확인");
            System.out.println("4.누적매출");
            System.out.println("5.고객명단");
            System.out.println("6.뒤로가기");
        	System.out.println("--------------------");
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
        	System.out.println("--------------------");
            System.out.println("1.고객용");
            System.out.println("2.업체용");
            System.out.println("3.종료");
        	System.out.println("--------------------");
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
 
public class StarCafe{
    public static void main(String[] args) {
        Cafe ca = new Cafe();
        ca.menupan();
        ca.who();
        
    }
}
