package br.edu.ifsp.list01;

import java.util.Locale;
import java.util.Scanner;

/*
    Faça um programa que leia um conjunto de valores que correspondem as idades de pessoas de uma comunidade. Quando
    o valor fornecido for um número negativo, significa que não existem mais idades para serem lidas. Após a leitura,
    o programa deve informar:

    A média das idades das pessoas (com duas casas decimais)
    A quantidade de pessoas maiores de idade
    A porcentagem de pessoas idosas (considere quem uma pessoa idosa tem mais de 75 anos) (com duas casas decimais)

    Exemplos de entrada e saída:
    | Entrada             | Saída          |
    | -------             | ------         |
    | 10 20 30 80 -1      | 35.00 3 25.00% |
    | 25 30 45 -1         | 33.33 3 0.00%  |
    => Exercício gentilmente cedido pelos profs. Jorge Cutigi (IFSP/SCL) e Adenilso Simão (ICMC/USP)
*/
public class Ex09 {

    public static void main(String[] args) {
        //Leia o input
        //Crie uma variável do tipo deste arquivo. Exemplo: Ex02 ex = new Ex02();
        //Escreva o resultado da chamada do método compute() aqui
        Scanner scanner=new Scanner(System.in);
        final Ex09 ex09=new Ex09();
        System.out.println("Digite a quantidade de moradores na comunidade:");
        int qtdPessoas= scanner.nextInt();
        int[] pessoas=new int[qtdPessoas];
        int i;
        for (i=0;i<pessoas.length;i++){
            System.out.printf("Digite a idade do cidadão %d:",i+1);
            pessoas[i]= scanner.nextInt();

        }


        System.out.println(ex09.compute(pessoas));


    }

    String compute(int[] input) {
        //String output = null;
        Locale.setDefault(Locale.US);
        int maiores=0,i=0;
        double soma=0,idosos=0;
        while (input[i]>=0){
            if (input[i]>=0){
                if (input[i]>17){
                    maiores++;
                    if (input[i]>75) idosos++;

                }
                soma+=input[i];

            }
            else break;
            i++;



        }

        return String.format("%.2f %d %.2f%%",soma/(i),maiores,(idosos/(i))*100);






        //return output;
    }
}
