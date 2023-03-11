package org.example;

public class Main {
    public static void main(String[] args) {

        for (int i = 1; i < 1000; i++) {
            int sum = 0;
            for (int z = 1; z < i; z++) {
                if (i % z == 0) {
                    sum += z;
                }
            }
            if (sum == i) {
                System.out.println(i);
            }
        }

    }
}