package br.edu.ifsp.list01;

import java.util.Scanner;

/*
    Um motorista de Uber estipula o preço de uma determinada viagem dada a quantidade de quilômetros percorrida.
    Para viagens de até X km, é cobrado um valor R$ V1 por km. Acima de X km, é cobrado o valor R$ V2.
    Faça um programa que leia X, V1, V2 e a quantidade de quilômetros A da viagem e imprima o valor total
    com duas casas decimais.

    Exemplos de entrada e saída:
    Entrada    	Saída
    100         75.00
    1.50
    1.25
    50
    Entrada    	Saída
    100         187.50
    1.50
    1.25
    150
*/
public class Ex07 {

    public static void main(String[] args) {
        //Leia o input
        //Crie uma variável do tipo deste arquivo. Exemplo: Ex02 ex = new Ex02();
        //Escreva o resultado da chamada do método compute() aqui
        final Scanner scanner= new Scanner(System.in);
        final Ex07 ex07= new Ex07();
        System.out.println("Digite o limite:");
        final int X=scanner.nextInt();

        System.out.println("Digite o valor 1:");
        final double V1=scanner.nextDouble();
        System.out.println("Digite o valor 2:");
        final double V2=scanner.nextDouble();
        System.out.println("Digite a quantidade de Km percorrido:");
        final double A=scanner.nextDouble();
        scanner.close();
        System.out.println(ex07.compute(X,V1,V2,A));
    }

    double compute(int x, double v1, double v2, double a) {
        //double output = -0.1;
        if (a>x) return a*v2;

        else return a*v1;
        //return output;
    }
}
