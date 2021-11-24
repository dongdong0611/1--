package Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

import Cafe.Cafe;
import Cafe.Customer;
import Cafe.Stock;
import Report.Report;

import java.util.Map.Entry;
import java.util.regex.Pattern;
import java.util.stream.Stream;

public class TestExample {
	private static Cafe cafe = Cafe.getInstance();
	private static ArrayList<Customer> customerList = new ArrayList<Customer>();
	Report report = new Report();

	static List<Stock> stockList = Arrays.asList(
			new Stock("커피가루", 5),
			new Stock("테이크아웃 컵", 10)
			);


	private static Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) {
	
		
		boolean run = true;
		while (run) {
			System.out.println("선택해 주세요");
			System.out.println(" 1. 음료판매 | 2. 회원관리 | 3.재고관리   ");
			System.out.print(Report.Choice);
			int choice = scanner.nextInt();
			if (choice == 1) {
				chooseMenu();
			} else if (choice == 2) {
				System.out.println(" 1. 회원등록  | 2. 회원조회 ");
				System.out.println(Report.Choice);
				int cs = scanner.nextInt();
				if (cs == 1) {
					createCustomer();
				} else if (cs == 2) {
					report();
				}else {
					run = false;
				}
			} else if (choice ==3){
				Stream<Stock> stream = stockList.stream();
				stream.forEach(s ->System.out.println(
						"물품명: " + s.getIngredients() +  " , 수량: " + s.getStockNum()));
		}else {
				run = false;
			}
		}
		System.out.println("시스템 종료합니다.");
	}

	public static void chooseMenu() {
		int customerNum = 0; 
		Customer findCustomer = null; 
		System.out.println(Report.Line);
		//정규식
		boolean run = true; 
		while(run) {
		String data = "^\\d{4}$";
		System.out.print(" 전화번호 뒤 4자리>  ");
		String num1 = scanner.next();
		boolean bl = Pattern.matches(data, num1);
		customerNum = Integer.parseInt(num1);
		if( bl == false ) {
			System.out.println("다시 입력해주세요.");
			
		}else {
				for(Customer c: customerList) {
					if(c.getCustomerNum() == customerNum ) {
						findCustomer = c; 
						run = false;
						break;
					}else {
						System.out.println("회원정보가 없습니다. ");
					}
				}
			}
		}
		Map<String, Integer> menu = new Hashtable<String, Integer>();
		menu.put("아메리카노", 1500);
		menu.put("카페라떼", 2000);
		Set<Entry<String, Integer>> coffee = menu.entrySet();
		Iterator<Entry<String, Integer>> coffeeMenu = coffee.iterator();
		int num = 0;

		while (coffeeMenu.hasNext()) {
			Entry<String, Integer> entry = coffeeMenu.next();
			String key = entry.getKey();
			int value = entry.getValue();
			num++;
			System.out.println(num + "  " + key + ": " + value);
		}

		System.out.println("메뉴를 선택하세요> ");
		int choice2 = scanner.nextInt();
		int i = 0;
		for (Map.Entry<String, Integer> entry : menu.entrySet()) {
			i++;
			if (i == choice2) {
				System.out.println(entry.getValue() + "원 입니다.");
				int balance = findCustomer.getBalance();
				int value = entry.getValue();
				balance -= value;
				double point = findCustomer.getPoint();
				point =  point + (double) value/10;
				findCustomer.setBalance(balance);
				findCustomer.setPoint(point);
				System.out.println(customerNum + "님의 남은 금액은 " + balance + "입니다.");
				findCustomer.toString();
				for (int j = 0; j<stockList.size(); j++) {
				int minusStock = stockList.get(j).getStockNum();
				minusStock -=1;
				stockList.get(j).setStockNum(minusStock);
				}
			
			}
		}
	}

	public static void createCustomer() {
		System.out.println("	   [회원 등록]		");
		System.out.println(Report.Line);
		System.out.print("전화번호 뒤 4자리를 입력하세요. > ");
		// 정규식
		int customerNum = scanner.nextInt();
		System.out.print("충전하실 금액을 입력하세요. >");
		int balance = scanner.nextInt();
		int point = 0;

		Customer customer = new Customer(customerNum, balance, point);
		customerList.add(customer);
		cafe.addCustomer(customer);
		System.out.println("회원 정보가 입력되었습니다. 감사합니다. ");
	}

	public static void report() {
		TestExample test = new TestExample();
		String report = test.report.getReport();
		System.out.println(report);
	}
	
	public static void stock() {
		List<Stock> stockList = Arrays.asList(
				new Stock("커피가루", 5),
				new Stock("테이크아웃 컵", 10)
				);
	
	Stream<Stock> stream = stockList.stream();
	stream.forEach(s ->System.out.println(
			"물품명: " + s.getIngredients() +  " 수량: " + s.getStockNum()));
	 
	}

}


