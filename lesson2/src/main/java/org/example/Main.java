package org.example;

public class Main {
    public static void main(String[] args) {

        Product product1 = new Product(1, "IPhone 14", 30000, "Lorem ipsum", 10);

        Product product2 = new Product(2, "Samsung Galaxy S21", 20000, "Lorem ipsum", 10);

        Product product3 = new Product(3, "PS5", 15000, "Lorem ipsum", 15);

        Product[] products = {product1, product2, product3};

        for (Product product : products) {
            // System.out.println(product.getName() + " : " + product.getUnitPrice() + " after %" + product.getDiscount() + " discount: " + product.getUnitPriceAfterDiscount());
            System.out.println(product);
        }

    }
}