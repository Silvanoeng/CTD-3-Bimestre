import java.util.Scanner;

public class Main2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Digite a dimensão N da sua matriz:");
        int nMatriz = sc.nextInt();
        int[][] matrizN = new int [nMatriz][nMatriz];

        boolean linha = false;
        int linhaAnterior = 0;
        int linhaAtual = 0;
        boolean coluna = false;
        int colunaAnterior = 0;
        int colunaAtual = 0;

        for (int li=0; li < matrizN.length; li++){
            for (int co = 0; co < matrizN.length; co++){
                System.out.println("Digite o valor para a posição (linha: " + li + " - coluna: " + co + "." );
                matrizN [li][co] = sc.nextInt();
            }

        }

        for (int li=0; li < matrizN.length; li++){
            colunaAtual=0;
            for (int co = 0; co < matrizN.length; co++){
                colunaAtual += matrizN [li][co];

            }
            if (li==0){
                colunaAnterior = colunaAtual;
            }
            if (colunaAnterior==colunaAtual){
                coluna=true;
            } else {
                coluna=false;
            }
        }

        for (int co=0; co < matrizN.length; co++){
            linhaAtual=0;
            for (int li = 0; li < matrizN.length; li++){
                linhaAtual += matrizN [co][li];
            }
            if (co==0){
                linhaAnterior = linhaAtual;
            }
            if (linhaAnterior==linhaAtual){
                linha=true;
            } else {
                linha=false;
            }
        }
        int x1=0;
        int x2=0;
        boolean linhaX = false;
        for (int co=0; co < matrizN.length; co++){
            x1 += matrizN[co][co];

        }

        for (int co=0; co < matrizN.length; co++) {
            int li = (matrizN.length-1);
            x2 += matrizN[co][li];
            li--;
        }
        if(x1==x2){
            linhaX=true;
        }
        if (linhaX && coluna && linha){
            System.out.println("quadrado mágico.");
        } else {
            System.out.println("quadrado não mágico.");
        }


    }
}
