package br.edu.ifsp.list03;

import java.util.Scanner;

/*
Implemente um programa que gere senhas provisórias a partir do nome do usuário, seguindo o mesmo
padrão dos exemplos a seguir:

EXEMPLO 1 Entrada: Java | Saída: J*Ja*Jav*Jav*Ja* J
EXEMPLO 2 Entrada: POOS3 | Saída: P*PO*POO*POOS*POOS*POO*PO*P
EXEMPLO 3 Entrada: KO | Saída: K*K
EXEMPLO 4 Entrada: O | Saída: Invalido
EXEMPLO 5 Entrada: | Saída: Invalido
*/
public class Ex01 {
    public static void main(String[] args) {
        //Leia o input
        //Crie uma variável do tipo deste arquivo. Exemplo: Ex02 ex = new Ex02();
        //Escreva o resultado da chamada do método compute() aqui
        final Ex01 ex01=new Ex01();
        final Scanner scanner=new Scanner(System.in);
        System.out.println("Digite uma palavra:");
        String word= scanner.nextLine();
        System.out.println(ex01.compute(word));
    }

    String compute(String input) {
        //String output = null;
        if (input==null) return "Invalido";
        if (input.length()>1){
            int i,j;
            StringBuilder sb= new StringBuilder();
            for (i=0;i<input.length();i++){
                for (j = 0; j < i; j++) {
                    sb.append(input.charAt(j));

                }
               if (i>0){
                   sb.append('*');
               }
            }
            for (i--;i>0;i--){
                for (j = 0; j < i; j++) {
                    sb.append(input.charAt(j));

                }
                if (i>1){
                    sb.append('*');
                }
            }
            String s= sb.toString();
            return s;

        }
        else return "Invalido";









        //return output;
    }
}
