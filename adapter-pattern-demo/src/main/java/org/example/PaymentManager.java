package org.example;

public class PaymentManager {

    private PosService posService;

    public PaymentManager(PosService posService) {
        this.posService = posService;
    }

    public void makePayment() {
        if (posService.checkPayment()) {
            System.out.println("payment successful");
        } else {
            System.out.println("payment failure");
        }
    }
}
