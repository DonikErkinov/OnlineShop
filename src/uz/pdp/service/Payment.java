package uz.pdp.service;

import uz.pdp.model.User;

import java.util.Scanner;

public class Payment implements PaymentInterface {
    private Scanner scanner = new Scanner(System.in);
    private long cardNumber;
    private int expireDate;
    private int securityCode;

    @Override
    public void pay(User user) {

        System.out.println("Enter card number : ");
        System.out.print("|> ");
        cardNumber = scanner.nextLong();
        if (checkCardValid(cardNumber)) {
            System.out.println("Enter expire date : ");
            System.out.print("|> ");
            expireDate = scanner.nextInt();
            System.out.println("Enter security code : ");
            System.out.print("|> ");
            securityCode = scanner.nextInt();
            System.out.println("You bought successfully ✔ ");
            user.clearCart();
            System.out.println("Welcome to our shop 😊 ");
        }
        else System.out.println("Invalid card number ❌❌ Try again!");

    }
    @Override
    public boolean checkCardValid(long cardNumber) {
        int log = (int) Math.floor(Math.log10(cardNumber)) + 1;
        return log == 16;
    }
}
