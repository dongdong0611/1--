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


    //1.ȸ������
    private static void accountrCreate() {
		System.out.println("-------------------");
		System.out.println("ȸ�����");
		System.out.println("-------------------");

		System.out.print("ȸ������ �̸��� �����ּ���: "); 
		customerName = scanner.next();
		
		customerlist.add(new Customer(customerName, customerAccount));

		
	}
    //2.�ݾ�����
    private static void moneyCharge() {
		System.out.println("-------------------");
		System.out.println("�ݾ�����");
		System.out.println("-------------------");
		System.out.print("�̸� : "); 
		customerName = scanner.next();
		System.out.print("���� �ݾ�: ");
		customerAccount = scanner.nextInt();
		Customer customer = findCustomer(customerName);
		if(customer == null) {
			System.out.println("���������ʴ� ȸ���Դϴ�.");
			return;
		}
		customer.setCustomerName(customer.getCustomerName() + customerAccount);
		System.out.println("������  �Ϸ�Ǿ����ϴ�.");
    }
    
    
    //findCustomer() ȸ�� ã�� �޼ҵ�
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
    
    
    
    
    
    //3.�ݾ�Ȯ��
/*    private static void accountSee() {
    	System.out.println("--------------");
		System.out.println("�ݾ�Ȯ��");
		System.out.println("--------------");
		System.out.print("������: "); 
		String customerName = scanner.next();
		Customer customer = findCustomer(customerName);
		if(customer == null) {
			System.out.println("���������ʴ� ȸ���Դϴ�.");
			return;
		}
		System.out.println(customer.getCustomerName()+"���� �� �����ݾ��� " + customer.getCustomerAccount() + "�Դϴ�.");
    }*/
    
    
    //�޴�����
	public void choiceMenu() {
		System.out.println("�޴��� �������ּ���.");
		
	}
	
	//���� ���Ÿ��
	public void buyList() {
		System.out.println("���Ÿ���� �����帳�ϴ�.");
		
	}
	
	//�� ����� Ȯ��
	public void sales() {
		System.out.println("�� ������Դϴ�.");
		
	}
	//���� ��� Ȯ��
	public void stock() {

		
	}
	
	
	
	
	
	
 //	����
    public void customers() {
    	java.util.Scanner sc = new java.util.Scanner(System.in);
    	boolean flag = true;
        while (flag) {
        	System.out.println("*********************");
            System.out.println("� ������ �����Ͻðڽ��ϱ�?");
            System.out.println("1.ȸ����� 2.�ݾ������ϱ� 3.�ݾ�Ȯ���ϱ�  4.�޴����� 5.���");
        	System.out.println("*********************");
            String stringInput = sc.nextLine();          
            switch (stringInput) {
            case "1":
            	accountrCreate();		//ȸ������
                break;
            case "2":
                moneyCharge();		//�ݾ� �����ϱ�
                break;
            case "3":
                accountSee();		//�ݾ� Ȯ���ϱ�
                break;
            case "4":
                choiceMenu();	//�޴������ϱ�
                break;
            case "5":
                System.out.println("�̿����ּż� �����մϴ�");
                flag = false;
                break;
            default:
                System.out.println("�߸��� �Է��Դϴ�");
            }
        }
    }
 //	��ü��
    public void cafe() {
    	java.util.Scanner sc = new java.util.Scanner(System.in);
    	boolean flag = true;
        while (flag) {
        	System.out.println("*********************");
            System.out.println("� ������ �����Ͻðڽ��ϱ�?");
            System.out.println("1.���� ���Ÿ��");
            System.out.println("2.�� �����");
            System.out.println("3.���� ���Ȯ��");
            System.out.println("4.���");
        	System.out.println("*********************");
            String ���� = sc.nextLine();          
            switch (����) {
            case "1":
                buyList();	//���� ���Ÿ��
                break;
            case "2":
                sales();		//�����
                break;
            case "3":
                stock();		//���Ȯ��
                break;
            case "4":			//���
                System.out.println("�̿����ּż� �����մϴ�");
                flag = false;
                break;
            default:
                System.out.println("�߸��� �Է��Դϴ�");
            }
        }
    }
//	ó�������Ҷ� ��ü������ �������� Ȯ���ϱ� ����
    public void who() {
    	java.util.Scanner sc = new java.util.Scanner(System.in);
    	boolean flag = true;
        while (flag) {
        	System.out.println("*********************");
            System.out.println("1.���� 2.��ü�� 3.����");
        	System.out.println("*********************");
            String stringInput = sc.nextLine();
            switch (stringInput) {
            case "1":
                customers();							//����
                break;
            case "2":
                cafe();									//ī���
                break;
            case "3":
                System.out.println("�̿����ּż� �����մϴ�");
                flag = false;
                break;
            default:
                System.out.println("�߸��� �Է��Դϴ�");
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