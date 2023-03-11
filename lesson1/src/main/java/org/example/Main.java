package org.example;

public class Main {
    public static void main(String[] args) {

        Product product1 = new Product();
        product1.id = 1;
        product1.name = "telephone";
        product1.unitPrice = 12000;
        product1.description = "Lorem ipsum";

        Product product2 = new Product();
        product2.id = 2;
        product2.name = "computer";
        product2.unitPrice = 15000;
        product2.description = "Lorem ipsum";

        Product product3 = new Product();
        product3.id = 3;
        product3.name = "Xbox";
        product3.unitPrice = 10000;
        product3.description = "Lorem ipsum";

        Product[] products = {product1, product2, product3};

        for (Product product : products) {
            System.out.println(product.id + "-" + product.name + "(" + product.unitPrice + "-" + product.description + ")");
        }
    }
}