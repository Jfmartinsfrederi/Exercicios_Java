package br.edu.ifsp.list02;

import java.util.Scanner;

/*
    Faça um programa que leia um valor inteiro N. Após isso, leia dois vetores A e B de tamanho N. Em seguida, o programa
    deve criar um vetor C com os elementos de A e B intercalados.

    Exemplos de entrada e saída:

    | Entrada                 | Saída                         |
    | -------                 | ------                        |
    | 6                       | 5 10 6 20 3 30 8 40 2 50 0 60 |
    | 5 6 3 8 2 0             |                               |
    | 10 20 30 40 50 60       |                               |
      ---
    | 3                       | 1 1 2 1 3 1                   |
    | 1 2 3                   |                               |
    | 1 1 1                   |                               |

    => Exercício gentilmente cedido pelos profs. Jorge Cutigi e Adenilso Simão (ICMC/USP)
 */
public class Ex06 {
    public static void main(String[] args) {
        //Leia o input
        //Crie uma variável do tipo deste arquivo. Exemplo: Ex02 ex = new Ex02();
        //Escreva o resultado da chamada do método compute() aqui
        final Ex06 ex06= new Ex06();
        final Scanner scanner=new Scanner(System.in);
        System.out.println("Digite o tamanho dos arrays:");
        int N= (scanner.nextInt());
        int []A=new int[N];
        int []B=new int[N];
        int i;
        System.out.println("Digite os números do array A:");
        for (i=0;i<A.length;i++) A[i]=scanner.nextInt();
        System.out.println("Digite os números do array B:");
        for (i=0;i<B.length;i++) B[i]=scanner.nextInt();
        scanner.close();
        System.out.println(ex06.compute(A,B));

    }

    String compute(int[] arrayA, int[] arrayB) {
//       String output = null;
        int i=0,j=0;
        String result="";


        for (i=0;i<arrayA.length;i++){
                result+="%d ".formatted(arrayA[i]);
                result+="%d ".formatted(arrayB[j]);
            j++;

        }
        result=result.trim();
        return result;




//        return output;
    }
}
