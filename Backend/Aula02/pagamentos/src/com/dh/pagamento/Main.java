package com.dh.pagamento;


import com.dh.pagamento.service.TipoDeCartao;
import com.dh.pagamento.service.impl.CartaoDebito;
import java.time.LocalDate;

public class Main {

    public static void main(String[] args) {
        TipoDeCartao cd01 = new CartaoDebito(LocalDate.of(2022, 1, 25), 2000.00);

        cd01.pagamento("Débito", 1000.00);

    }
}
