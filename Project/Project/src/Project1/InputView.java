package Project1;


import java.util.Scanner;

public class InputView {
    private InputView() { }

    private static final String MENU = "-----메뉴판-----\n 1: 아메리카노-2500원, 2: 카푸치노-3000원, 3: 라떼-3000원";
    private static final String ENTER_MENU_MESSAGE = "메뉴 번호를 입력해주세요.";
    private static final String ENTER_PAYMENT_MESSAGE = "지불 할 금액을 입력해주세요.";
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
