package org.example;

public class EmailNotification implements Notification {
    @Override
    public void sendNotify() {
        System.out.println(" /email sent");
    }
}
