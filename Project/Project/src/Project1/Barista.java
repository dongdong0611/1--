package Project1;

public class Barista {
    private static final String FINISHED_MAKE_COFFEE = "%s(��)�ϼ��Ǿ����ϴ�.\n";

    public void makeCoffee(String orderedCoffee) {
        System.out.printf(FINISHED_MAKE_COFFEE, orderedCoffee);
    }
}
