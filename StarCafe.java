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
    

    	


    //1.ȸ������
    private static void accountrCreate() {
		System.out.println("-------------------");
		System.out.println("ȸ�����");
		System.out.println("-------------------");

		System.out.print("ȸ������ �̸��� �����ּ���: "); 
		customerName = scanner.next();
		customerNameList.add(customerName);
		System.out.print("�����Ͻ� �ݾ��� �Է��Ͽ��ּ���: "); 
		customerAccount = scanner.nextInt();
		customerAccountList.add(customerAccount);
		
		for(int i=0;i<customerNameList.size();i++){
			  customerNameList.get(i); 
			  customerAccountList.get(i);
			}
		
	}
    //2.�ݾ�����
    private static void moneyCharge() {

    	System.out.println("-------------------");
		System.out.println("�ݾ�����");
		System.out.println("-------------------");
		System.out.print("�̸� : "); 
		customerName = scanner.next();
		
		for(int i=0; i<customerNameList.size(); i++){
			if(customerNameList.get(i).equals(customerName)) {
				//�Է¹��� �̸��� ������ �� ȸ������ ����
				System.out.print("���� �ݾ�: ");
				customerAccount = scanner.nextInt();
				customerAccountList.set(i,customerAccountList.get(i)+customerAccount);
				
			}
			else {
				System.out.println("���� ȸ���Դϴ�.");
				return;
			}
		}
    }

    //3.�ݾ�Ȯ��
    private static void accountSee() {
    	System.out.println("--------------");
		System.out.println("�ݾ�Ȯ��");
		System.out.println("--------------");
		System.out.print("������: "); 
		String customerName = scanner.next();
		for(int i=0; i<customerNameList.size(); i++){
			if(customerNameList.get(i).equals(customerName)) {
				System.out.println(customerNameList.get(i)+" ���� �ܾ���"+ customerAccountList.get(i)+" �� �Դϴ�.");
			}
			else {
				System.out.println("���� ȸ���Դϴ�.");
				return;
			}
		} 
    }
    
    
    //4.�޴�����
	public void choiceMenu() {
		System.out.println("�޴�����.");
		System.out.print("������: "); 
		customerName = scanner.next();
		for(int i=0; i<customerNameList.size(); i++){
			if(customerNameList.get(i).equals(customerName)) {
				System.out.println(customerNameList.get(i)+" ���� �ܾ���"+ customerAccountList.get(i)+" �� �Դϴ�.");
				System.out.println("�޴���");
				for(int j=0; j<menuNameList.size(); j++) {
					System.out.println((j+1)+"."+ menuNameList.get(j)+"  ���� :  " + menuPriceList.get(j)+"��");
				}
				System.out.println("--------------------------------------");
				System.out.println("�޴��� �������ּ���.>>");
				int selectNo=0;
				selectNo = scanner.nextInt();
				for(int j=0; j<menuNameList.size(); j++) {
					if(selectNo==j+1) {
						if(customerAccountList.get(i)< menuPriceList.get(j)) {
						System.out.println(customerNameList.get(i)+"���� �ܾ��� �����մϴ�.");
						return;
						}else if(inventoryList.get(j)<=0) {
							System.out.println("�����Ǿ����ϴ�.");
							return;
						}
						System.out.println(menuNameList.get(j)+"�� �ֹ��ϼ̽��ϴ�.");
						System.out.println("������ " + menuPriceList.get(j)+"�� �Դϴ�.");
						customerAccountList.set(i, customerAccountList.get(i)-menuPriceList.get(j));
						inventoryList.set(j, inventoryList.get(j)-1);
						saleMoney += menuPriceList.get(j);
						System.out.println("���� �ܰ�� "+customerAccountList.get(i)+"�� �Դϴ�.");
					}
				}				
			}

		}

		
	}
	
	

	
	
	
	
	//1.�޴��߰�
	public void addMenu() {
		System.out.println("�߰��� �޴��� �̸��� �Է����ּ��� >>");
		menuName = scanner.next();
		menuNameList.add(menuName);
		
		System.out.println("�߰��� �޴��� ������ �Է����ּ��� >>");
		menuPrice = scanner.nextInt();
		menuPriceList.add(menuPrice);
		
		System.out.println("�߰��� �޴��� �ʱ� ������ �Է����ּ��� >>");
		inventory = scanner.nextInt();
		inventoryList.add(inventory);
		
		System.out.println(menuName+" �޴��� �߰��Ǿ����ϴ�.");
		//�ߺ� Ȯ��
//		for(int i=0; i<menuNameList.size(); i++){
//			if(!menuNameList.get(i).equals(menuName)) {
//				//�Է¹��� �޴��� ������ �߰�
//				System.out.println("�߰��� �޴��� ������ �Է����ּ��� >>");
//				menuPrice = scanner.nextInt();
//				menuPriceList.add(menuPrice);
//		
//				System.out.println("�߰��� �޴��� �ʱ� ������ �Է����ּ��� >>");
//				inventory = scanner.nextInt();
//				inventoryList.add(inventory);
//		
//				System.out.println(menuName+" �޴��� �߰��Ǿ����ϴ�.");
//				return;
//			}
//			else {
//				System.out.println(menuName+" �� �̹� �ִ� �޴��Դϴ�.");
//				return;
//			}
//		}
	}
	
	//2.�����߰�
	public void addItem() {
		System.out.println("������ �߰��� �޴��� �̸��� �Է����ּ���.>>");
		menuName = scanner.next();
		for(int i=0; i<=menuNameList.size(); i++){
			if(menuNameList.get(i).equals(menuName)) {
				System.out.print("��� �߰� ��: ");
				inventory = scanner.nextInt();
				inventoryList.set(i,inventoryList.get(i)+inventory);
			}
			else {
				System.out.println(menuName+" �� ���� �޴��Դϴ�.");

			}
		}
/*		int i;
		Iterator<String> it = menuNameList.iterator();
		while(it.hasNext()) {
			if(menuNameList.get(i).equals(menuName)) {
				System.out.print("��� �߰� ��: ");
				inventory = scanner.nextInt();
				inventoryList.set(i,inventoryList.get(i)+inventory);
			}
			else {
				System.out.println(menuName+" �� ���� �޴��Դϴ�.");
			}
		}*/


		
	}

	//3.���� ��� Ȯ��
	public void stock() {
		for(int i=0;i<menuNameList.size();i++){
			System.out.println(menuNameList.get(i)+ ", "+ menuPriceList.get(i) +"��, " + inventoryList.get(i)+"��");
			}
	}
	//4.�� ����� Ȯ��
	public void sales() {
		System.out.println("�� �������" + saleMoney+"�� �Դϴ�.");
	}
	//5.�����
	public void customerList() {
		for(int i=0;i<customerNameList.size();i++){
			System.out.println(customerNameList.get(i)+ ", "+ customerAccountList.get(i) +"��");
		}
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
            System.out.println("1.�޴����");
            System.out.println("2.�����߰�");
            System.out.println("3.���� ���Ȯ��");
            System.out.println("4.��������");
            System.out.println("5.�����");
            System.out.println("6.�ڷΰ���");
        	System.out.println("*********************");
            String ���� = sc.nextLine();          
            switch (����) {
            case "1":
                addMenu();		//�޴��߰�
                break;
            case "2":
                addItem();		//�����߰�
                break;
            case "3":			
                stock();		//���Ȯ��
                break;
            case "4":			
            	sales();		//����Ȯ��
            	break;
            case "5":
            	customerList();	//�����
            	break;
            case "6":			//���
                System.out.println("�̿����ּż� �����մϴ�");
                flag = false;
                break;
            default:
                System.out.println("�߸��� �Է��Դϴ�");
            }
        }
    }
    public void menupan(){
		menuNameList.add("���̽��Ƹ޸�ī��");
		menuPriceList.add(3000);
		inventoryList.add(10);
		menuNameList.add("������");
		menuPriceList.add(4000);
		inventoryList.add(15);
		menuNameList.add("�ٳ�����");
		menuPriceList.add(5000);
		inventoryList.add(15);
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
        ca.menupan();
        ca.who();
        
    }
}