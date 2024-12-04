package lab12;

import lab12.task1.ATM;

public class Main {
    private static final int DEFAULT_AMOUNT = 700; 

    public static void main(String[] args) {
        System.out.println("Hello world!");
        int amount = DEFAULT_AMOUNT;
        ATM atm = new ATM();
        atm.getMeMoney(amount);
    }
}
