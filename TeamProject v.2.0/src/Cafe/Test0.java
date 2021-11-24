package Cafe;
import java.util.Scanner;
import Cafe.Coffee;
import Cafe.Customer;

public class Test0 {
	private static Customer[] customerAccount = new Customer[1000];
	private static Coffee[] coffeeMenu = new Coffee[1000];
    private static Scanner scanner = new Scanner(System.in);
    private static int sales = 0;
    

    public static void main(String[] args) {  	
    	
    	//�ʱ� �޴� ���
    	customerAccount[0] = new Customer(1234, 10000);
    	coffeeMenu[0] = new Coffee("�Ƹ޸�ī��", 3000, 100); 
    	
        //��/���� ����    	   	
    	boolean run = true;
		while(run) {
			System.out.println("----------------------------------------------------------");
			System.out.println("1.�� | 2.���� | 3. ����");
			System.out.println("----------------------------------------------------------");
			System.out.print("����> ");
			
			int selectNo = scanner.nextInt();
			
			if(selectNo == 1) {
				customerOrder();
			} else if(selectNo == 2) {
				storeManage();
			} else if(selectNo == 3) {
				run = false;
			} else {
				System.out.println("�ٽ� �����Ͻʽÿ�.");
			}
		}
		System.out.println("POS ����");
	}
    
    //��
    private static void customerOrder() {
    	boolean run1 = true;
		while(run1) {
			System.out.println("----------------------------------------------------------");
			System.out.println("1.����� | 2.�ݾ����� | 3. �ֹ� | 4. �ݾ�Ȯ�� | 5. ����");
			System.out.println("----------------------------------------------------------");
			System.out.print("����> ");
			
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
				System.out.println("�ٽ� �����Ͻʽÿ�.");
			}
		}
		System.out.println("�ȳ���������.");
    }
    
    //����
    private static void storeManage() {
    	boolean run2 = true;
		while(run2) {
			System.out.println("----------------------------------------------------------");
			System.out.println("1.�޴���� | 2.�����߰� | 3. �ܰ���� | 4. �������� | 5. ����� | 6.����");
			System.out.println("----------------------------------------------------------");
			System.out.print("����> ");
			
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
				System.out.println("�ٽ� �����Ͻʽÿ�.");
			}
		}
		System.out.println("������� ���α׷� ����");
    }
    
    //�����
    private static void customerRegister() {
		System.out.println("--------------");
		System.out.println("�����");
		System.out.println("--------------");

		boolean runTemp = true;
		int customerNo = 0;
		while(runTemp) {
			System.out.print("��ȭ��ȣ �� 4�ڸ� �Է����ֽʽÿ�: "); 
			int temp = scanner.nextInt();
			if((int)(Math.log10(temp)+1) != 4) {
				System.out.println("�Է����ֽ� ��ȣ�� 4�ڸ��� �ƴմϴ�.");
			} else {
				customerNo += temp;
				runTemp = false;
			}
		}		
		
		System.out.print("�ʱ�������: ");
		int customerBalance = scanner.nextInt();
				
		Customer newCustomer = new Customer(customerNo, customerBalance);
		for(int i=0; i<customerAccount.length; i++) {
			if(customerAccount[i] == null) {
				customerAccount[i] = newCustomer;
				System.out.println("���: �����°� �����Ǿ����ϴ�.");
				break;
			} 
		}		
	}
    
    //�ݾ�����
    private static void customerCharge() {
    	System.out.println("--------------");
		System.out.println("�ݾ�����");
		System.out.println("--------------");
		boolean runTemp = true;
		int customerNo = 0;
		while(runTemp) {
			System.out.print("��ȭ��ȣ �� 4�ڸ� �Է����ֽʽÿ�: "); 
			int temp = scanner.nextInt();
			if((int)(Math.log10(temp)+1) != 4) {
				System.out.println("�Է����ֽ� ��ȣ�� 4�ڸ��� �ƴմϴ�.");
			} else {
				customerNo += temp;
				runTemp = false;
			}
		}	
		System.out.print("������: ");
		int money = scanner.nextInt();
		Customer customer = findCustomer(customerNo);
		if(customer == null) {
			System.out.println("���: ���°� �����ϴ�.");
			return;
		}
		customer.setCustomerBalance(customer.getCustomerBalance() + money);
		System.out.println("���: ������ ���������� �Ϸ�Ǿ����ϴ�.");
    }
    
    //�ֹ�
       private static void customerBuy() {
    	System.out.println("--------------");
		System.out.println("�ֹ�");
		System.out.println("--------------");
		boolean runTemp = true;
		int customerNo = 0;
		while(runTemp) {
			System.out.print("��ȭ��ȣ �� 4�ڸ� �Է����ֽʽÿ�: "); 
			int temp = scanner.nextInt();
			if((int)(Math.log10(temp)+1) != 4) {
				System.out.println("�Է����ֽ� ��ȣ�� 4�ڸ��� �ƴմϴ�.");
			} else {
				customerNo += temp;
				runTemp = false;
			}
		}	
		Customer customer = findCustomer(customerNo);
		System.out.println("���� �ݾ��� " + customer.getCustomerBalance()+"���Դϴ�.");
		System.out.println();
		System.out.println("�޴��� �������ּ���");
		System.out.println("--------------");
		for(int i=0; i<coffeeMenu.length; i++) {
			Coffee order = coffeeMenu[i];
			if(order != null) {
				System.out.print((i+1)+"."+order.getCoffeeName());
				System.out.print("     ");
				System.out.print("����: "+order.getCoffeePrice());
				System.out.println();
			}
		}
		System.out.println("--------------");
		System.out.print("�޴� ����> ");
		int selectNo = scanner.nextInt();
		Coffee order = coffeeMenu[selectNo-1];
		runTemp = true;
		StringBuffer coffeeType = new StringBuffer();
		while(runTemp) {
			System.out.println("--------------");
			System.out.println("1. HOT | 2. ICE");
			System.out.println("--------------");
			System.out.print("HOT/ICE Ŀ�Ǹ� �������ּ���: ");
			int selectType = scanner.nextInt();
			if(selectType == 1) {
				coffeeType.append("HOT");
				runTemp = false;
			} else if(selectType == 2) {
				coffeeType.append("ICE");
				runTemp = false;
			} else {
				System.out.println("�ٽ� �������ּ���.");
			}
			
		}
		if(customer.getCustomerBalance()<order.getCoffeePrice()) {
			System.out.println("�ݾ��� �����մϴ�.");
			return;
		} else if(order.getCoffeeInventory()<= 0) {
			System.out.println("���� �Ǿ����ϴ�.");
			return;
		}
		System.out.println(coffeeType + " " +order.getCoffeeName()+"�� �ֹ��ϼ̽��ϴ�.");
		System.out.println("������ " + order.getCoffeePrice()+"�� �Դϴ�.");
		customer.setCustomerBalance(customer.getCustomerBalance()-order.getCoffeePrice());
		order.setCoffeeInventory(order.getCoffeeInventory()-1);
		sales += order.getCoffeePrice();
		System.out.println("���� �ܰ�� "+customer.getCustomerBalance()+"�� �Դϴ�.");
    }
    
    //�ݾ�Ȯ��
    private static void customerBalance() {
    	System.out.println("--------------");
		System.out.println("�ݾ�Ȯ��");
		System.out.println("--------------");
		boolean runTemp = true;
		int customerNo = 0;
		while(runTemp) {
			System.out.print("��ȭ��ȣ �� 4�ڸ� �Է����ֽʽÿ�: "); 
			int temp = scanner.nextInt();
			if((int)(Math.log10(temp)+1) != 4) {
				System.out.println("�Է����ֽ� ��ȣ�� 4�ڸ��� �ƴմϴ�.");
			} else {
				customerNo += temp;
				runTemp = false;
			}
		}	
		Customer customer = findCustomer(customerNo);
		if(customer == null) {
			System.out.println("���: ���°� �����ϴ�.");
			return;
		}
		System.out.println("���� �������� " + customer.getCustomerBalance() + "�Դϴ�.");
    }
    
    //�޴����
    private static void menuRegister() {
    	System.out.println("--------------");
		System.out.println("�޴����");
		System.out.println("--------------");

		System.out.print("�޴���: "); 
		String coffeeName = scanner.next();
		
		System.out.print("�޴�����: ");
		int coffeePrice = scanner.nextInt();
		
		System.out.print("�ʱ����: ");
		int coffeeInventory = scanner.nextInt();
		
		Coffee newMenu = new Coffee(coffeeName, coffeePrice, coffeeInventory);
		for(int i=0; i<coffeeMenu.length; i++) {
			if(coffeeMenu[i] == null) {
				coffeeMenu[i] = newMenu;
				System.out.println("���: �� �޴��� ��ϵǾ����ϴ�.");
				break;
			} 
		}		
    }
    
    //�����߰�
    private static void menuAddition() {
    	System.out.println("--------------");
		System.out.println("�����߰�");
		System.out.println("--------------");
		System.out.print("�޴��̸�: "); 
		String coffeeName = scanner.next();
		System.out.print("���� �߰� ��:");
		int addition = scanner.nextInt();
		Coffee menuItem = findCoffee(coffeeName);
		if(menuItem == null) {
			System.out.println("���: �ش� �޴� �������� �����ϴ�.");
			return;
		}
		menuItem.setCoffeeInventory(menuItem.getCoffeeInventory() + addition);
		System.out.println("���: ������ ���������� ������Ʈ �Ǿ����ϴ�.");
    }    
    
    //�ܰ����
    private static void menuInventory() {
    	System.out.println("--------------");
		System.out.println("�ܰ����");
		System.out.println("--------------");
		System.out.println("�޴�ǰ��         ����          �ܰ����");
		for(int i=0; i<coffeeMenu.length; i++) {
			Coffee menuItem = coffeeMenu[i];
			if(menuItem != null) {
				System.out.print(menuItem.getCoffeeName());
				System.out.print("     ");
				System.out.print(menuItem.getCoffeePrice()+"��");
				System.out.print("     ");
				System.out.print(menuItem.getCoffeeInventory()+"��");
				System.out.println();
			}
		}
    }
    
    //��������
    private static void accumulatedSales() {
    	System.out.println("�� ������ " + sales+"���Դϴ�.");
    }
    
    //�����
    private static void customerList() {
    	System.out.println("--------------");
		System.out.println("�����");
		System.out.println("--------------");
		System.out.println("����ȣ         �����ݾ� ");
		for(int i=0; i<customerAccount.length; i++) {
			Customer customer = customerAccount[i];
			if(customer != null) {
				System.out.print(customer.getCustomerNo());
				System.out.print("     ");
				System.out.print(customer.getCustomerBalance()+"��");
				System.out.println();
			}
		}
    }
    
    //findCustomer() ��ü ã��
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
    
  //findCoffee() ��ü ã��
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



