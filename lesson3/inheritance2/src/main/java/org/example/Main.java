package org.example;

public class Main {
    public static void main(String[] args) {

        CustomerManager customerManager= new CustomerManager();
        customerManager.add(new DatabaseLogger());
        customerManager.add(new EmailLogger());
        customerManager.add(new FileLogger());
        customerManager.add(new SmsLogger());


    }
}