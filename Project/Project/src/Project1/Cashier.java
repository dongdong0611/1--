package Project1;

public class Cashier {
    private static final String IS_NOT_ENOUGH_MONEY = "���� �ݾ��� �����մϴ�..";
    private static final String CHANGES_MESSAGE = "�ܵ�: %d�� \n";

    private final Barista barista;

    public Cashier(Barista barista) {
        this.barista = barista;
    }

    public void takeOrder(int payment, int menuNumber) {
        Menu coffee = Menu.valueOf(menuNumber);
        validatePayAmount(payment, coffee.getPrice());
        getChanges(payment, coffee.getPrice());

        barista.makeCoffee(coffee.getCoffeeName());
    }

    private void validatePayAmount(int payment, int coffeePrice) {
        if (payment < coffeePrice) {
            throw new IllegalArgumentException(IS_NOT_ENOUGH_MONEY);
        }
    }

    private void getChanges(int payment, int coffeePrice) {
        System.out.printf(CHANGES_MESSAGE, payment - coffeePrice);
    }
}
