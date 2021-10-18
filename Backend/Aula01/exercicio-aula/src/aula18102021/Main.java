package aula18102021;

public class Main {
    public static void main(String[] args) {

        IFachadaDesconto teste = new FachadaDesconto();
        Cartao c1 = new Cartao("1234567","Star Bank");
        Produto p1 = new Produto("Coca-Cola", "Lata");
        Produto p2 = new Produto("Coca-Cola", "Garafa");
        System.out.println(teste.desconto(c1,p1,15));
        System.out.println(teste.desconto(c1,p1,10));
        System.out.println(teste.desconto(c1,p2,10));

    }
}
