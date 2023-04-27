package org.example;

public class EDevletServiceAdapter implements CheckService{

    EDevletService service = new EDevletService();

    @Override
    public boolean isRealPerson(Customer customer) {
        return service.check(customer);
    }
}
