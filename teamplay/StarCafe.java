package teamplay;

import Cafe.Coffee;
import Cafe.Customer;
import java.util.Scanner;
import java.util.*;
class Cafe {
    private static Scanner scanner = new Scanner(System.in);

    
	static ArrayList<Customer> customerlist = new ArrayList<Customer>();
//	static List<Menu> menuList = new ArrayList<Menu>();
	private static String customerName;
    private static int customerAccount = 0;
    
	private static String coffeeName;
    private static int coffeePrice = 0;
    
    private static int sales = 0;


    //1.회원생성
    private static void accountrCreate() {
		System.out.println("-------------------");
		System.out.println("회원등록");
		System.out.println("-------------------");

		System.out.print("회원님의 이름을 적어주세요: "); 
		customerName = scanner.next();
		
		customerlist.add(new Customer(customerName, customerAccount));

		
	}
    //2.금액충전
    private static void moneyCharge() {
		System.out.println("-------------------");
		System.out.println("금액충전");
		System.out.println("-------------------");
		System.out.print("이름 : "); 
		customerName = scanner.next();
		System.out.print("충전 금액: ");
		customerAccount = scanner.nextInt();
		Customer customer = findCustomer(customerName);
		if(customer == null) {
			System.out.println("존재하지않는 회원입니다.");
			return;
		}
		customer.setCustomerName(customer.getCustomerName() + customerAccount);
		System.out.println("충전이  완료되었습니다.");
    }
    
    
    //findCustomer() 회원 찾는 메소드
    private static Customer findCustomer(String customerName) {
    	Customer customer = null;
		for(Customer Customer : customerlist) {
			if(customer.equals(customerName)) {
				customer = Customer;
				break;
			}
		}
		return customer;
	}
    
    
    
    
    
    //3.금액확인
/*    private static void accountSee() {
    	System.out.println("--------------");
		System.out.println("금액확인");
		System.out.println("--------------");
		System.out.print("고객성함: "); 
		String customerName = scanner.next();
		Customer customer = findCustomer(customerName);
		if(customer == null) {
			System.out.println("존재하지않는 회원입니다.");
			return;
		}
		System.out.println(customer.getCustomerName()+"님의 총 충전금액은 " + customer.getCustomerAccount() + "입니다.");
    }*/
    
    
    //메뉴선택
	public void choiceMenu() {
		System.out.println("메뉴를 선택해주세요.");
		
	}
	
	//고객별 구매목록
	public void buyList() {
		System.out.println("구매목록을 보여드립니다.");
		
	}
	
	//총 매출액 확인
	public void sales() {
		System.out.println("총 매출액입니다.");
		
	}
	//남은 재고 확인
	public void stock() {

		
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
            System.out.println("1.고객별 구매목록");
            System.out.println("2.총 매출액");
            System.out.println("3.남은 재고확인");
            System.out.println("4.취소");
        	System.out.println("*********************");
            String 선택 = sc.nextLine();          
            switch (선택) {
            case "1":
                buyList();	//고객별 구매목록
                break;
            case "2":
                sales();		//매출액
                break;
            case "3":
                stock();		//재고확인
                break;
            case "4":			//취소
                System.out.println("이용해주셔서 감사합니다");
                flag = false;
                break;
            default:
                System.out.println("잘못된 입력입니다");
            }
        }
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
        ca.who();
    }
}