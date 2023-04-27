package org.example;

public class VakifBankPosServiceAdapter implements PosService{
    @Override
    public boolean checkPayment() {
        VakifbankPosService vakifbankPosService = new VakifbankPosService();
        return vakifbankPosService.ode();
    }
}
