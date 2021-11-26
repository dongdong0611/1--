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
		int x=0;
		for(int i=0; i<customerNameList.size(); i++){
			if(customerNameList.get(i).equals(customerName)) {
				//�Է¹��� �̸��� ������ �� ȸ������ ����
				System.out.print("���� �ݾ�: ");
				customerAccount = scanner.nextInt();
				customerAccountList.set(i,customerAccountList.get(i)+customerAccount);
				System.out.println(customerNameList.get(i)+"���� ���� �� �ܾ���"+ customerAccountList.get(i) +"�� �Դϴ�");
				break;
			}
			else {
				x++;
				continue;
			}
		}
		if(x==customerNameList.size()){
			System.out.println(customerName+" �� ���� ����Դϴ�.");
		}
    }
    


    

    //3.�ݾ�Ȯ��
    public void accountSee() {
		System.out.println("������>>>"); 
		customerName = scanner.next();
    	int x=0;
		for(int i=0; i<customerNameList.size(); i++){
			if(customerNameList.get(i).equals(customerName)){
				System.out.println(customerNameList.get(i)+" ���� �ܾ���"+ customerAccountList.get(i)+" �� �Դϴ�.");
				break;
			}
				else {
					x++;
					continue;
			}
		}
		if(x==customerNameList.size()){
			System.out.println("���� ȸ���Դϴ�.");
		}
	}
    
    
    //3.��Ȯ��
    public void checkCustomer() {
    	java.util.Scanner sc = new java.util.Scanner(System.in);
    	boolean flag = true;
        while (flag) {
        	System.out.print("������: "); 
    		customerName = scanner.next();
    		for(int i=0; i<customerNameList.size(); i++){
    			if(customerNameList.get(i).equals(customerName)) {
    				System.out.println(customerNameList.get(i)+" ���� �ܾ���"+ customerAccountList.get(i)+" �� �Դϴ�.");
    				orderCustomerIndex = i;
    				orderCustomerAccount += customerAccountList.get(i);
    				choiceMenu();
    				flag = false;
    				break;
    			} 	
    			System.out.println("���� ���Դϴ�. �ٽ� �Է����ּ���.");
    
    		}
        }
    }
    
	public void choiceMenu() {
		java.util.Scanner sc = new java.util.Scanner(System.in);
    	boolean flag = true;
        while (flag) {
        	System.out.println("*********************");
        	System.out.println("�޴��ֹ�");
            System.out.println("1.��ٱ��Ͽ� �޴��߰� 2.��ٱ��Ͽ��� �޴����� 3.��ٱ��� Ȯ�� 4.��� 5.���" );
        	System.out.println("*********************");
            String stringInput = sc.nextLine();
            switch (stringInput) {
            case "1":
                addOrder();							//�޴��߰�
                break;
            case "2":
                deleteOrder();									//�޴�����
                break;
            case "3":
            	checkOrder();				//�޴�Ȯ��
            	break;
           case "4":
              checkOrder();				//���
              System.out.println("�̴�� �����Ͻðڽ��ϱ�? 1.�� 2. �ƴϿ�");  
              String finalInput = sc.nextLine();
              switch (finalInput) {
              case "1":
            	  customerAccountList.set(orderCustomerIndex, customerAccountList.get(orderCustomerIndex)-orderMenuPrice.stream().mapToInt(Integer::intValue).sum());
            	  System.out.println("������ �Ϸ�Ǿ����ϴ�.");
            	  System.out.println("���� ���� �ܾ��� " + customerAccountList.get(orderCustomerIndex)+"�� �Դϴ�." );
            	  System.out.println("�����մϴ�.");
            	  orderCustomerIndex = -1;
            	  orderCustomerAccount = 0;
            	  orderMenuName.removeAll(orderMenuName);
            	  orderMenuPrice.removeAll(orderMenuPrice);
            	  flag = false;
            	  break;
              case "2":
            	  System.out.println("���� ����ϼ̽��ϴ�.");
            	  continue;
              } 
              break;
           case "5":
        	    flag = false;
           default:
                System.out.println("�߸��� �Է��Դϴ�");
            }
        }
		}		
   
	//4.1 �޴��߰�
	public void addOrder() {
		java.util.Scanner sc = new java.util.Scanner(System.in);
    	boolean flag = true;
        while (flag) {
			System.out.println("�޴���");
			for(int j=0; j<menuNameList.size(); j++) {
				System.out.println((j+1)+"."+ menuNameList.get(j)+"  ���� :  " + menuPriceList.get(j)+"��");
			}
			System.out.println("--------------------------------------");
			System.out.println("�޴��� �������ּ���.>>");
			int selectNo=0;
			selectNo = sc.nextInt();
			
				if(inventoryList.get(selectNo-1)>0 && orderMenuPrice.stream().mapToInt(Integer::intValue).sum()+menuPriceList.get(selectNo-1) <= orderCustomerAccount) {
							orderMenuName.add(menuNameList.get(selectNo-1));
							orderMenuPrice.add(menuPriceList.get(selectNo-1));
							inventoryList.set(selectNo-1, inventoryList.get(selectNo-1)-1);
							System.out.println(menuNameList.get(selectNo-1)+"�� ��ٱ��Ͽ� �����̽��ϴ�.");
							System.out.println("���� ��ٱ��� �����ݾ��� �� " + orderMenuPrice.stream().mapToInt(Integer::intValue).sum()+"�� �Դϴ�.");
							System.out.println();
							flag = false;
							break;
						} else if(inventoryList.get(selectNo-1)<=0){
							System.out.println("���� �Ǿ����ϴ�.");
							flag = false;
							break;
						} else if (orderMenuPrice.stream().mapToInt(Integer::intValue).sum()+menuPriceList.get(selectNo-1) > orderCustomerAccount){
							System.out.println("�ܾ��� �����մϴ�.");
							flag = false;
							break;
						}
				}
				
				
			}
			
   			
  
	//4.2 �޴�����
    public void deleteOrder() {
 		java.util.Scanner sc = new java.util.Scanner(System.in);
     	boolean flag = true;
     	if(orderMenuName.size() != 0 ) {
         while (flag) {
 			System.out.println("���� ��ٱ���");
 			for(int j=0; j<orderMenuName.size(); j++) {
 				System.out.println((j+1)+"."+ orderMenuName.get(j)+"  ���� :  " + orderMenuPrice.get(j)+"��");
 			}
 			System.out.println("���� ��ٱ��� �����ݾ��� �� " + orderMenuPrice.stream().mapToInt(Integer::intValue).sum()+"�� �Դϴ�.");
 			System.out.println("--------------------------------------");
 			System.out.println("���� �޴��� �������ּ���.>>");
 			int selectNo=0;
 			selectNo = sc.nextInt();
 				System.out.println(orderMenuName.get(selectNo-1)+"�� ��ٱ��Ͽ��� �����ϴ�.");
 				inventoryList.set(menuNameList.indexOf(orderMenuName.get(selectNo-1)), inventoryList.get(selectNo-1)+1); 
 				orderMenuName.remove(orderMenuName.get(selectNo-1));
 				orderMenuPrice.remove(orderMenuPrice.get(selectNo-1)); 								
 				System.out.println("���� ��ٱ��� �����ݾ��� �� " + orderMenuPrice.stream().mapToInt(Integer::intValue).sum()+"�� �Դϴ�.");
 				System.out.println();
 				flag = false;
 				break;
         } 
 		} else {
 			System.out.println("���� ��ٱ��Ͽ� �ƹ��͵� �����ϴ�.");
 			return;
 		}
 			}
 			
    //4.3 �޴�Ȯ��
    public void checkOrder() {
    	java.util.Scanner sc = new java.util.Scanner(System.in);
     	boolean flag = true;
     	if(orderMenuName.size() != 0 ) {
         	System.out.println("���� ��ٱ���");
 			for(int j=0; j<orderMenuName.size(); j++) {
 				System.out.println((j+1)+"."+ orderMenuName.get(j)+"  ���� :  " + orderMenuPrice.get(j)+"��");
 			}
 			System.out.println("���� ��ٱ��� �����ݾ��� �� " + orderMenuPrice.stream().mapToInt(Integer::intValue).sum()+"�� �Դϴ�.");
 			System.out.println("--------------------------------------");
 			return;
 			} else {
  			System.out.println("���� ��ٱ��Ͽ� �ƹ��͵� �����ϴ�.");
  			return;
  		}
 		}
 			
    
	
	
	//1.�޴��߰�
	public void addMenu() {
		int x=0;
		System.out.println("�߰��� �޴��� �̸��� �Է����ּ��� >>");
		menuName = scanner.next();
		for(int i=0; i<menuNameList.size(); i++){
			if(menuNameList.get(i).equals(menuName)){
				System.out.println(menuName+"�� �̹� �ִ� �޴��Դϴ�.");
				break;
			}
				else {
					x++;
				continue;
			}
		}
		if(x==menuNameList.size()){
			menuNameList.add(menuName);
			
			System.out.println("�߰��� �޴��� ������ �Է����ּ��� >>");
			menuPrice = scanner.nextInt();
			menuPriceList.add(menuPrice);
	
			System.out.println("�߰��� �޴��� �ʱ� ������ �Է����ּ��� >>");
			inventory = scanner.nextInt();
			inventoryList.add(inventory);
			
			System.out.println(menuName+" �޴��� �߰��Ǿ����ϴ�.");
		}
	}
	
	//2.�����߰�
	public void addItem() {
		int x=0;
		System.out.println("������ �߰��� �޴��� �̸��� �Է����ּ���.>>");
		menuName = scanner.next();

		for(int i=0; i<menuNameList.size(); i++){
			if(menuNameList.get(i).equals(menuName)){
				System.out.print("��� �߰� ��: ");
				inventory = scanner.nextInt();
				inventoryList.set(i,inventoryList.get(i)+inventory);		
				System.out.println(menuNameList.get(i)+"�� ������"+inventoryList.get(i) +"�� �Դϴ�");
				break;
			}
				else {
					x++;
				continue;
			}
		}
		if(x==menuNameList.size()){
			System.out.println(menuName+" �� ���� �޴��Դϴ�.");
		}
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
            	checkCustomer();	//�޴������ϱ�
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
 
public class StarCafe{
    public static void main(String[] args) {
        Cafe ca = new Cafe();
        ca.menupan();
        ca.who();
        
    }
}