package org.example;

public class Main {
    public static void main(String[] args) {

        CustomerManager customerManager = new CustomerManager(new Logger[]{new FileLogger(), new DatabaseLogger()});
        customerManager.add();
    }
}