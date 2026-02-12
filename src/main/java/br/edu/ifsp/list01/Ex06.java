package br.edu.ifsp.list01;

import java.util.Scanner;

/*
    Sabe-se que uma lata de tinta tem um custo C e é capaz de pintar uma área de M metros quadrados.
    Faça um programa que leia a largura L, a altura A de uma parede, o valor C de uma lata de tinta e
    o rendimento M desta lata. Após isso, imprima quantas latas de tintas são necessárias e o custo
    total (com duas casas decimais). Assuma que não é possível comprar lata de tinta fracionada.

    Exemplos de entrada e saída:
    Entrada   	Saída
    4           4 20.00
    3
    5
    3

    Entrada	    Saída
    10.0        3 15.00
    2.0
    5.0
    7
*/
public class Ex06 {

    public static void main(String[] args) {
        //Leia o input
        //Crie uma variável do tipo deste arquivo. Exemplo: Ex02 ex = new Ex02();
        //Escreva o resultado da chamada do método compute() aqui
        final Scanner scanner= new Scanner(System.in);
        final Ex06 ex06= new Ex06();
        System.out.println("Digite a largura da parede:");
        final double L=scanner.nextDouble();

        System.out.println("Digite a altura da parede:");
        final double A=scanner.nextDouble();
        System.out.println("Digite o valor da lata:");
        final double C=scanner.nextDouble();
        System.out.println("Digite o rendimento:");
        final double M=scanner.nextDouble();
        scanner.close();
        System.out.println(ex06.compute(L,A,C,M));
    }

    String compute(double L, double a, double c, double m) {
        //String output = null;
        double area=L*a;
        int cont=0;
        while (area>0){
            area-=m;
            cont++;

        }
        return String.format("%d %.2f",cont,cont*c);
        //return output;
    }
}
