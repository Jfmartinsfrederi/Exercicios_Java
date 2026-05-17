package br.edu.ifsp.list01;

import java.util.Scanner;

/*
    Escrever um programa que, dado um ano válido qualquer, verifica se ele é bissexto ou não:

    São bissextos todos os anos múltiplos de 400, p. ex: 1600, 2000, 2400, 2800...
    São bissextos todos os múltiplos de 4 e não múltiplos de 100, p.ex: 1996, 2004, 2008, 2012, 2016…
    Não são bissextos os demais anos.
    Exemplos de entrada e saída esperada:

    Exemplo 1: Entrada = 1600 | Saída = Ano bissexto
    Exemplo 2: Entrada = 1997 | Saída = Ano nao bissexto
    Exemplo 3: Entrada = 2000 | Saída = Ano bissexto
    Exemplo 4: Entrada = 2016 | Saída = Ano bissexto
    Exemplo 5: Entrada = 0 | Saída = Erro
*/
public class Ex03 {

    public static void main(String[] args) {
        //Leia o input
        //Crie uma variável do tipo deste arquivo. Exemplo: Ex02 ex = new Ex02();
        //Escreva o resultado da chamada do método compute() aqui
        final Scanner scanner=new Scanner(System.in);
        final Ex03 ex03=new Ex03();
        System.out.println("Digite um ano:");
        final int ano= scanner.nextInt();
        scanner.close();
        System.out.println(ex03.compute(ano));

    }


    String compute(int input) {
        if (input==0) return "Erro";
        //String output = null;
        if (input % 400==0) return "Ano bissexto";
        else if (input % 4==0 && !(input % 100==0)) {
        return "Ano bissexto";

        } else return "Ano nao bissexto";
        //return output;
    }
}
