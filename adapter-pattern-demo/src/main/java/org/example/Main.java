package org.example;

public class Main {
    public static void main(String[] args) {

        PaymentManager paymentManager = new PaymentManager(new IsBankPosServiceAdapter());
        paymentManager.makePayment();

        PaymentManager paymentManager2 = new PaymentManager(new VakifBankPosServiceAdapter());
        paymentManager2.makePayment();
    }
}