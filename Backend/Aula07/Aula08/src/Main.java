import java.util.Scanner;

public class Main {
    static String reverse(String original) {
        return new StringBuilder(original).reverse().toString();
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Escreva uma palavra, vamos verificar se ela é palíndromo ou não:");
        String palavra = sc.next();
        String palavraInvertida = Main.reverse(palavra);

        if (palavra.equals(palavraInvertida)){
            System.out.println("Sim, esta palavra é um palíndromo.");
        } else {
            System.out.println("Não, esta palavra não é um palíndromo.");
        }
        System.out.println(palavraInvertida);

    }
}
