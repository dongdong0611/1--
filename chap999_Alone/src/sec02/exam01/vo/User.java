package sec02.exam01.vo;

public class User {
	private String phoneNumber;
	private String userName;
	private int cash;
	
	public User(String phoneNumber, String userName, int cash) {
		this.phoneNumber = phoneNumber;
		this.userName = userName;
		this.cash = cash;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public int getCash() {
		return cash;
	}

	public void setCash(int cash) {
		this.cash = cash;
	}

	@Override
	public String toString() {
		return "User [phoneNumber=" + phoneNumber + ", userName=" + userName + ", cash=" + cash + "]";
	}

}
