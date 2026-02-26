package br.edu.ifsp.list03;

import java.util.Scanner;

/*
Dada duas Strings A e B, faça um programa que imprima “Sim” se A e B são anagramas e “Nao”, caso contrário.
Um anagrama é a transposição de letras de palavra ou frase para formar outra palavra ou frase diferente.
Por exemplo, as palavras “roma” e “amor” são anagramas. Considere como entrada apenas palavras com letras minúsculas.
 */
public class Ex04 {
    public static void main(String[] args) {
        //Leia o ‘input’
        //Crie uma variável do tipo deste arquivo. Exemplo: Ex02 ex = new Ex02();
        //Escreva o resultado da chamada do método compute() aqui
        final Ex04 ex04=new Ex04();
        final Scanner scanner=new Scanner(System.in);
        System.out.println("Digite uma palavra:");
        String A= scanner.nextLine();
        System.out.println("Digite seu anagrama:");
        String B= scanner.nextLine();
        scanner.close();
        System.out.println(ex04.compute(A,B));
    }

    String compute(String wordA, String wordB) {
        //String output = null;
        wordA=wordA.toLowerCase();
        wordB=wordB.toLowerCase();
        wordA=wordA.replace(" ", "");

        wordB=wordB.replace(" ", "");

        if (wordA.length()!=wordB.length()) return "Nao";
        int contA=0,contB=0,i,j;
        for (i=0;i<wordA.length();i++){
            contA=0; contB=0;
            for (j=0;j<wordA.length();j++){
                if (wordA.charAt(i)==wordA.charAt(j)) contA++;

                if (wordA.charAt(i)==wordB.charAt(j)) contB++;

            }
            if (contA!=contB) return "Nao";

        }
        return "Sim";




        //return output;
    }
}
