package com.dh.pagamento.service;

import java.time.LocalDate;

public abstract class TipoDeCartao {
    private LocalDate dataVencimento;
    

    public void pagamento(String tipo, double valor){

        if (vadidaData()) {
            if (tipo.equals("Crédito")) {
                processadorCredito(valor);
            } else {
                processadorDebito(valor);
            }
        } else {
            System.out.println("O cartão vencido.");
        }
    }
    public abstract void processadorCredito(double valor);
    public abstract void processadorDebito(double valor);

    public boolean vadidaData() {
        if (this.dataVencimento.isAfter(LocalDate.now())){
            return true;
        }
        return false;
    }
}
