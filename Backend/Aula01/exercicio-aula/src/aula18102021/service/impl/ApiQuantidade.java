package aula18102021.service.impl;

public class ApiQuantidade {
    public int desconto(int quantidade) {
        if (quantidade>11) {
            return 15;
        }
        return 0;
    }
}
