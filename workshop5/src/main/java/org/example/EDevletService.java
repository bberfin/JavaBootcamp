package org.example;

import java.util.Set;

public class EDevletService {

    Customer customer1 = new Customer("Berfin", "Açıkgöz", "11111111101");
    Customer custome2 = new Customer("Büşra", "Kızılateş", "11111111001");
    Customer customer3 = new Customer("Emre", "İnan", "11111111000");

    Set<Customer> eDevletKisiListesi = Set.of(customer1, custome2, customer3);

    public boolean check(Customer customer) {
        if (eDevletKisiListesi.contains(customer))
            return true;
        else
            return false;
    }
}
