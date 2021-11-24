package Project1;

public class CoffeeShop {
    public static void main(String[] args) {
        Customer customer = new Customer();
        Cashier cashier = new Cashier(new Barista());

        InputView.getMenu();
        int menuNumber = InputView.enterMenuNumber();
        int payMoney = InputView.enterPayment();

        customer.order(menuNumber, payMoney, cashier);
    }
}
