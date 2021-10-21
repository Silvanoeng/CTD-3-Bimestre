package com.dh.empresa;

public class Main {
    public static void main(String[] args) {
        /*Mofidicar o main para testar a lógica com o template method */
        Funcionario func1 = new Funcionario("Pedro",2); func1.vender(2);
        Funcionario func2 = new Funcionario("Maria",1); func2.vender(1);

        Vendedor afi1 = new Afiliado("Ramon"); afi1.vender(4);
        Vendedor afi2 = new Afiliado("Paulo"); afi2.vender(1);
        Vendedor afi3 = new Afiliado("José");

        func1.addAfiliado(afi1);

        func1.mostrarCategoria();
        func2.mostrarCategoria();
        afi1.mostrarCategoria();
        afi2.mostrarCategoria();
        afi3.mostrarCategoria();
    }
}
