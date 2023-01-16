package uz.pdp.service;

import uz.pdp.model.User;

public interface PaymentInterface {
    void pay(User user);
    boolean checkCardValid(long cardNumber);
}
