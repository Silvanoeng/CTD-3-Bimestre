package com.dh.empresa;

import com.dh.empresa.service.impl.Afiliado;
import com.dh.empresa.service.impl.Estagiario;
import com.dh.empresa.service.impl.Funcionario;
import com.dh.empresa.service.Vendedor;

public class Main {
    public static void main(String[] args) {
        /*Mofidicar o main para testar a lógica com o template method */
        Funcionario func1 = new Funcionario("Pedro",2); func1.vender(2);
        Funcionario func2 = new Funcionario("Maria",1); func2.vender(1);

        Vendedor afi1 = new Afiliado("Ramon"); afi1.vender(4);
        Vendedor afi2 = new Afiliado("Paulo"); afi2.vender(1);
        Vendedor afi3 = new Afiliado("José");

        func1.addAfiliado(afi1);

        Vendedor est1 = new Estagiario("Silvano"); est1.vender(11);
        Vendedor est2 = new Estagiario("Lucas"); est2.vender(6);

        func1.mostrarCategoria();
        func2.mostrarCategoria();
        afi1.mostrarCategoria();
        afi2.mostrarCategoria();
        afi3.mostrarCategoria();

        est1.mostrarCategoria();
        est2.mostrarCategoria();
    }
}
