package org.example;

public class EmployeeManager {

    private final Notification[] notifications;

    public EmployeeManager(Notification[] notifications) {
        this.notifications = notifications;
    }

    public void addEmployee(Employee employee) {
        System.out.println(employee.getName() + " added to the system");
        for (Notification notification : notifications)
            notification.sendNotify();
    }

    public void addMultiple(Employee[] employees) {
        for (Employee employee : employees)
            addEmployee(employee);
    }
}
