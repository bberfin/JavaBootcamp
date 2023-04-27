package org.example;

public class Main {
    public static void main(String[] args) {

        Customer customer_unreal = new Customer("Tuba", "Taşdemir", "11100011101");
        Customer customer_real = new Customer("Berfin", "Açıkgöz", "11111111101");

        CustomerManager customerManager = new CustomerManager(new EDevletServiceAdapter());

        customerManager.add(customer_unreal);
        customerManager.add(customer_real);
    }
}