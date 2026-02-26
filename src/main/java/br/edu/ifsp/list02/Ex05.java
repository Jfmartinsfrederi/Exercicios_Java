package br.edu.ifsp.list02;

import org.jetbrains.annotations.NotNull;

import java.util.Scanner;

/*
    Você está responsável pelo bolo de aniversário da sua priminha e decidiu que o bolo terá uma vela para cada ano da
    idade total dela. Quando ela assopra as candles, ela só é capaz de apagar apenas as candles mais altas. Sua tarefa é fazer
    um programa que leia a idade A da sua sobrinha e a altura das candles. Após isso, seu programa deve imprimir a
    quantidade de candles que ela vai conseguir apagar.

    Por exemplo, se sua sobrina está fazendo 4 anos e o bolo possui 4 candles de tamanhos 4, 4, 1, 3, então ela só vai
    conseguir apagar as duas mais altas, de tamanho 4. Portanto, a resposta deve ser 2.

    ### Exemplos de entrada e saída:

    | Entrada               | Saída  |
    | -------               | ------ |
    | 4    4    4    1    3 | 2      |
    | 4    3    2    1    3 | 2      |

    Fonte: Adaptado de https://www.hackerrank.com/challenges/birthday-cake-candles/problem
    => Exercício gentilmente cedido pelos profs. Jorge Cutigi e Adenilso Simão (ICMC/USP)
 */
public class Ex05 {
    public static void main(String[] args) {
        //Leia o input
        //Crie uma variável do tipo deste arquivo. Exemplo: Ex02 ex = new Ex02();
        //Escreva o resultado da chamada do método compute() aqui
        final Ex05 ex05= new Ex05();
        final Scanner scanner=new Scanner(System.in);
        System.out.println("Digite a idade da sua sobrinha:");
        int age= (scanner.nextInt());
        int []candles=new int[age];
        System.out.printf("Digite %d números:",age);
        //candles[0]=age;
        int i;
        for (i = 1; i < candles.length; i++) {
            candles[i]=scanner.nextInt();

        }
        System.out.println(ex05.compute(candles));
    }

    int compute(@NotNull int[] velas) {
        //int output = -1;
        if (velas[0]<0) return -1;
        int i=0,maior=0,cont=0;
        while (i<velas.length){
            if (velas[i]>maior){
                maior=velas[i];
                cont=1;
            } else if (velas[i]==maior) {
                cont++;

            }


            i++;


        }
        return cont;




        //return output;
    }
}
