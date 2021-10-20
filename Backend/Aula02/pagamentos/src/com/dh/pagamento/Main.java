package com.dh.pagamento;


import com.dh.pagamento.service.TipoDeCartao;
import com.dh.pagamento.service.impl.CartaoCredito;
import com.dh.pagamento.service.impl.CartaoDebito;
import java.time.LocalDate;

public class Main {

    public static void main(String[] args) {
        TipoDeCartao cd01 = new CartaoDebito(LocalDate.of(2022, 1, 25), 2000.00);
        cd01.pagamento("Débito", 1100.00);
        cd01.pagamento("Crédito", 1000.00);
        cd01.pagamento("Débito", 1000.00);

        System.out.println("-------------------------------------");

        TipoDeCartao cc01 = new CartaoCredito(LocalDate.of(2022, 5, 15), 1000.00);
        cc01.pagamento("Crédito", 150.00);
        cc01.pagamento("Débito", 150.00);
        cc01.pagamento("Crédito", 900.00);

    }
}
