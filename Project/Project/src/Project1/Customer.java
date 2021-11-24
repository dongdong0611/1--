package Project1;

public class Customer {

    public void order(int menuNumber, int money, Cashier cashier) {
        cashier.takeOrder(money, menuNumber);
    }
}
