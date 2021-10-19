package com.dh.fastfood;

public abstract class Cardapio {
    private int idPedido;
    protected static int pedidosFeitos = 1;

    public Cardapio() {
        this.idPedido = pedidosFeitos++;
    }

    public void novoPedido(){
        System.out.printf("Novo pedido para montar: n° %d.\n",this.idPedido);
        montar();
        System.out.printf("Valor do pedido: R$%.2f.\n", calcularPreco());
        System.out.println("--------------------------------------------------");
    }
    public abstract void montar();
    public abstract double calcularPreco();
}
