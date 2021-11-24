package Project1;


import java.util.Scanner;

public class InputView {
    private InputView() { }

    private static final String MENU = "-----�޴���-----\n 1: �Ƹ޸�ī��-2500��, 2: īǪġ��-3000��, 3: ��-3000��";
    private static final String ENTER_MENU_MESSAGE = "�޴� ��ȣ�� �Է����ּ���.";
    private static final String ENTER_PAYMENT_MESSAGE = "���� �� �ݾ��� �Է����ּ���.";
    private static final Scanner sc = new Scanner(System.in);

    public static void getMenu() {
        System.out.println(MENU);
    }

    public static int enterMenuNumber() {
        System.out.println(ENTER_MENU_MESSAGE);
        return sc.nextInt();
    }

    public static int enterPayment() {
        System.out.println(ENTER_PAYMENT_MESSAGE);
        return sc.nextInt();
    }
}
