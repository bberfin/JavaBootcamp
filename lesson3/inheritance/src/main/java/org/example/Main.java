package org.example;

public class Main {
    public static void main(String[] args) {
        UserManager userManager = new UserManager();
        Applicant user1 = new Applicant(1, "songul", "acikgoz", "11122233345");
        Applicant user2 = new Applicant(2, "tuba", "acikgoz", "22233344456");
        Instructor user3 = new Instructor(3, "berfin", "acikgoz", "kodlamaio");

        User[] users= {user1, user2, user3};
        userManager.addMultiple(users);

    }
}