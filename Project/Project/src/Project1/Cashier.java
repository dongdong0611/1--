package Project1;

public class Cashier {
    private static final String IS_NOT_ENOUGH_MONEY = "지불 금액이 부족합니다..";
    private static final String CHANGES_MESSAGE = "잔돈: %d원 \n";

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
