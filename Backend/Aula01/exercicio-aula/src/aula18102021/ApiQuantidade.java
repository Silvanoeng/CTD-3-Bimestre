package aula18102021;

public class ApiQuantidade {
    public int desconto(int quantidade) {
        if (quantidade>11) {
            return 15;
        }
        return 0;
    }
}
