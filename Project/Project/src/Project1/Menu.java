package Project1;

import java.util.Arrays;

public enum Menu {
    AMERICANO(1, "�Ƹ޸�ī��", 2500),
    CAPPUCCINO(2, "īǪġ��", 3000),
    LATTE(3, "��", 3000);

    private final int menuNumber;
    private final String coffeeName;
    private final int price;
  
    Menu(int menuNumber, String coffeeName, int price) {
        this.menuNumber = menuNumber;
        this.coffeeName = coffeeName;
        this.price = price;
    }

    public int getMenuNumber() {
        return menuNumber;
    }

    public int getPrice() {
        return price;
    }

    public String getCoffeeName() {
        return coffeeName;
    }

    public static Menu valueOf(int menuNumber) {
        return Arrays.stream(values())
                .filter(e -> e.getMenuNumber() == menuNumber)
                .findFirst()
                .orElseThrow(() ->
                        new IllegalArgumentException("��ȿ�� �޴� ��ȣ�� �ƴմϴ�."));
    }
}
