package org.example;

public class CustomerManager {

    private CheckService checkService;

    public CustomerManager(CheckService checkService) {
        this.checkService = checkService;
    }

    public void add(Customer customer) {
        if (checkService.isRealPerson(customer))
            System.out.println("müşteri başarıyla eklendi");
        else
            System.out.println("müşteri eklenemedi.");
    }
}
