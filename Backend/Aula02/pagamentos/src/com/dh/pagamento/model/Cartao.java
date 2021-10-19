package com.dh.pagamento.model;

import com.dh.pagamento.service.TipoDeCartao;

import java.time.LocalDate;

public class Cartao {
    private int idCartao;
    private LocalDate dataVencimento;
    private static int numeroCartaoCriado=0;
    private TipoDeCartao tipo;

    public Cartao(LocalDate dataVencimento, TipoDeCartao tipo) {
        this.idCartao=Cartao.numeroCartaoCriado++;
        this.dataVencimento = dataVencimento;
        this.tipo = tipo;
    }

    public LocalDate getDataVencimento() {
        return dataVencimento;
    }

    public void setDataVencimento(LocalDate dataVencimento) {
        this.dataVencimento = dataVencimento;
    }
}
