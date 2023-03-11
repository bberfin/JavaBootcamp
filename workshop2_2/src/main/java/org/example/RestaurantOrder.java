package org.example;

public class RestaurantOrder {
    private int orderId;
    private String customerName;
    private double totalPrice;
    private boolean isDelivery;
    private boolean isPaid;

    public RestaurantOrder(int orderId, String customerName, double totalPrice, boolean isDelivery, boolean isPaid) {
        this.orderId = orderId;
        this.customerName = customerName;
        this.totalPrice = totalPrice;
        this.isDelivery = isDelivery;
        this.isPaid = isPaid;
    }

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }

    public boolean isDelivery() {
        return isDelivery;
    }

    public void setDelivery(boolean delivery) {
        isDelivery = delivery;
    }

    public boolean isPaid() {
        return isPaid;
    }

    public void setPaid(boolean paid) {
        isPaid = paid;
    }


    public void toPay() {
        if (isPaid)
            System.out.println("payment completed");
        else
            System.out.println("payment failed");
    }

    public void cancelOrder() {
        totalPrice = 0;
        isPaid = false;
        System.out.println("order canceled");
    }

    public void viewOrder() {
        System.out.println(
                "order id          : " + orderId + "\n"
                        + "customer name     : " + customerName + "\n"
                        + "total price       : " + totalPrice + "\n"
                        + "delivery status   : " + isDelivery + "\n"
                        + "is paid           : " + isPaid
        );
    }

    public void processOrder() {
        if (isDelivery) {
            if (isPaid) {
                System.out.println("order has been delivered");
            } else {
                System.out.println("pay first");
            }
        } else
            System.out.println("order can be taken from the restaurant");

    }


}
