package lab12;

import lab12.task1.ATM;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");
        int AMOUNT=700;
        ATM atm = new ATM();
        atm.getMeMoney(AMOUNT);
    }
}