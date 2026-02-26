package br.edu.ifsp.list03;

import java.util.Scanner;

/*
Dada uma String arbitrária, faça um programa que imprima “Sim” se essa for palíndromo e “Nao”, caso contrário.
Palíndromo é uma frase ou palavra que pode ser lida, indiferentemente, da esquerda para a direita ou vice-versa.
Por exemplo, “arara” é um palíndromo. Considere como entrada apenas palavras com letras minúsculas.
 */
public class Ex03 {
    public static void main(String[] args) {
        //Leia o input
        //Crie uma variável do tipo deste arquivo. Exemplo: Ex02 ex = new Ex02();
        //Escreva o resultado da chamada do método compute() aqui
        final Ex03 ex03=new Ex03();
        final Scanner scanner=new Scanner(System.in);
        System.out.println("Digite uma palavra:");
        String word= scanner.nextLine();
        scanner.close();
        System.out.println(ex03.compute(word));
    }

    String compute(String input) {
        //String output = null;
        if (input==null) return "Sim";
        input=input.toLowerCase();
        input=input.replace(" ", "");

        StringBuilder palindromo=new StringBuilder();
        int i;
        for (i=input.length()-1;i>=0;i--) palindromo.append(input.charAt(i));

        for (i=0;i<palindromo.length()-1;i++){
            if (palindromo.charAt(i)!=input.charAt(i)) return "Nao";
        }
        return "Sim";



        //return output;
    }
}
