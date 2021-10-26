import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

public class Main4 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Escreva o texto abaixo:");
        String texto = sc.nextLine();
        String textoSemEsp = texto.replaceAll("[^\\w]","");
        textoSemEsp = textoSemEsp.toLowerCase();
        int totalLetras = textoSemEsp.length();
        System.out.println("Resultado");
        System.out.println("Total de letras: "+totalLetras);
        List<Character> letras = new ArrayList<>();
        List<Double> contador = new ArrayList<>();
        for (int i=0; i<totalLetras; i++){
            if (letras==null) {
                letras.add(textoSemEsp.charAt(i));
                contador.add(1.00);
            } else {
                if (letras.contains(textoSemEsp.charAt(i))){
                    Character letraAtual = textoSemEsp.charAt(i);
                    int lugar = letras.indexOf(letraAtual);
                    Double salvaNum = contador.get(lugar);
                    salvaNum++;
                    contador.set(lugar,salvaNum);

                } else {
                    letras.add(textoSemEsp.charAt(i));
                    contador.add(1.00);
                }
            }
        }

        for (int i=0; i<letras.size();i++){
            double porc =100*(contador.get(i)/totalLetras);
            System.out.printf( "%s = %.2f%s\n",letras.get(i) , porc, "%" );
        }

    }
}
