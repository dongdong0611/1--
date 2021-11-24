package Report;

import java.util.ArrayList;

import Cafe.Cafe;
import Cafe.Customer;

public class Report {
	Cafe cafe = Cafe.getInstance();
	public static final String Line = "-----------------------------------------\n";
	public static final String Header = " 회원 번호 | 잔여금액 | 포인트  \n";
	public static final String Choice = "선택>";

	private StringBuffer buffer = new StringBuffer();

	public String getReport() {
		ArrayList<Customer> customerList = cafe.getCustomerList();

		for (Customer customer : customerList) {
			makeHeader(customer);
			makeBody(customer);
			makeFooter(customer);
		}
		return buffer.toString();
	}

	private void makeHeader(Customer customer) {
		buffer.append(Report.Line);
		buffer.append(Report.Header);
		buffer.append(Report.Line);

	}

	private void makeBody(Customer customer) {
		ArrayList<Customer> customerList = cafe.getCustomerList();
		
		for (int i = 0; i < customerList.size(); i++) {
			Customer customer1 = customerList.get(i);
			buffer.append(customer1.getCustomerNum());
			buffer.append("|");
			buffer.append(customer1.getBalance());
			buffer.append("원 |");
			buffer.append(customer1.getPoint());
			buffer.append("점 \n");
			buffer.append(Line);
		}
	}
	
	private void makeFooter(Customer customer) {
		buffer.append("\n");

	}


}
