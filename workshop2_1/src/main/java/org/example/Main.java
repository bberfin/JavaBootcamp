package org.example;


/*
Basit bir banka hesabı modellemek için bir program tasarlıyorsunuz.
Hesapta bir bakiye bulunmaktadır ve bu bakiye yatırma veya çekme işlemleriyle artırılabilir veya azaltılabilir.
Bakiye özelliği özel tutulmalı ve yalnızca getter ve setter yöntemleri aracılığıyla erişilebilir olmalıdır.
Ayrıca, hesap bir yapıcı yönteme sahip olmalı ve bakiye belirtilen bir miktarla başlatılmalıdır.
Para çekme işleminde bakiye yetersiz ise ekrana yetersiz bakiye yazdırınız.(System.out.println("yetersiz bakiye"))
Bu banka hesabı modelini uygulayan bir Java sınıfı yazın.
*/
public class Main {

    public static void main(String[] args) {

        BankAccount bankAccount = new BankAccount(1000);
        System.out.println("first balance: ");
        System.out.println(bankAccount.getBalance());

        bankAccount.depositMoney(500);
        System.out.println("balance after deposit: ");
        System.out.println(bankAccount.getBalance());

        bankAccount.withdrawMoney(100);
        System.out.println("balance after first withdraw: ");
        System.out.println(bankAccount.getBalance());

        bankAccount.withdrawMoney(2000);
        System.out.println("balance after second withdraw: ");
        System.out.println(bankAccount.getBalance());

    }
}