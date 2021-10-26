import java.util.Scanner;

public class Main3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("1");
        int a = sc.nextInt();
        System.out.println("2");
        int b = sc.nextInt();
        System.out.println("3");
        int c = sc.nextInt();
        if ((a<b+c) && (b<a+c) && (c<a+b)) {
            if ((a==b) && (b==c)){
                System.out.println("Triângulo Equilátero");
            }else if((a==b)||(b==c)||(a==c)){
                System.out.println("Triângulo Isósceles");
            } else {
                System.out.println("Triângulo Escaleno");
            }
        }else {
            System.out.println("Não é possível formar um triângulo");
        }

    }
}
