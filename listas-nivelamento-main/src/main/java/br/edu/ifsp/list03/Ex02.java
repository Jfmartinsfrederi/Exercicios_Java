package br.edu.ifsp.list03;

import java.util.Scanner;

/*
Faça um programa que, dada uma String, encontra a primeira e a última substrings de tamanho K de acordo com a ordem
alfabética. Por exemplo, para a String “welcometojava” e K = 3; A substring “ava” é a primeira substring de tamanho
3 e “wel” é a última, considerando a ordem alfabética (saída: "ava wel"). Para dados de entrada inválidos, o programa
deverá imprimir uma String vazia.
 */
public class Ex02 {
    public static void main(String[] args) {
        //Leia o input
        //Crie uma variável do tipo deste arquivo. Exemplo: Ex02 ex = new Ex02();
        //Escreva o resultado da chamada do método compute() aqui
        final Ex02 ex02=new Ex02();
        final Scanner scanner=new Scanner(System.in);
        System.out.println("Digite uma palavra:");
        String word= scanner.nextLine();
        System.out.println("Digite um número:");
        int K= scanner.nextInt();
        scanner.close();
        System.out.println(ex02.compute(word,K));
    }

    String compute(String word, int number) {
        //String output = null;

        if (word.length()<number || number==0) return null ;


        int i=0,comeco=0,fim=0;
        char comecoTabela=word.charAt(i),finalTabela=word.charAt(i);
        for (i=0;i<word.length()-number+1;i++){
            if (word.charAt(i)<comecoTabela) {
                comecoTabela = word.charAt(i);
                comeco=i;
            }
            if (word.charAt(i)>finalTabela) {
                finalTabela = word.charAt(i);
                fim=i;
            }

        }
        StringBuilder sC=new StringBuilder();
        StringBuilder sF=new StringBuilder();


        for (i=0;i<number;i++) sC.append(word.charAt(comeco+i));


        for (i=0;i<number;i++) sF.append(word.charAt(fim+i));
        String c,f;
        c=sC.toString();
        f=sF.toString();


        return c+" "+f;




        //return output;
    }
}
