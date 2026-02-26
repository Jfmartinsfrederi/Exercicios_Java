package br.edu.ifsp.list02;

import java.util.Scanner;

/*
    Leia um conjunto de cinco números inteiros não repetidos em uma única linha e os armazene em um vetor de 10 posições.
    A partir daí, leia um número por vez. Se o número ainda não estiver no conjunto, faça a inclusão após o último número.
    Caso ele esteja no conjunto, remova o número e libere espaço no array. A cada iteração imprima o vetor. O programa
    acaba quando o array ficar totalmente cheio ou vazio. Veja o exemplo na imagem anexa.

    Qualquer valor fora do domínio de entrada tem como saída esperada a String "Erro".
 */
public class Ex03 {
    public static void main(String[] args) {
        //Leia o input
        //Crie uma variável do tipo deste arquivo. Exemplo: Ex02 ex = new Ex02();
        //Escreva o resultado da chamada do método compute() aqui
        final Ex03 ex03= new Ex03();
        final Scanner scanner=new Scanner(System.in);
        int []cincoPrimeiros=new int[10];
        System.out.println("Digite 5 números:");
        int i;
        for (i = 0; i < 5; i++) {
            cincoPrimeiros[i]=scanner.nextInt();

        }
        System.out.println("Digite o tamanho do outro array:");
        int othersSize= scanner.nextInt();
        int []others=new int [othersSize];
        System.out.printf("Digite %d números:",othersSize);
        for (i = 0; i < othersSize; i++) {
            others[i]=scanner.nextInt();

        }
        System.out.println(ex03.compute(cincoPrimeiros,others));
    }

    String compute(int[] firstFive, int[] otherInts) {
        //String output = null;
        int tam=5,i=0,j,flag=1; // flag ==1 adiciona
        int verify=otherInts.length;
        String result= """
                """;
        for (j=0;j<tam;j++){
            //System.out.printf("%d",firstFive[j]);
            result+= "%d ".formatted(firstFive[j]);


        }
        result=result.trim();
        result+="\n";
        while (tam>0 && tam<10 && verify!=0){


            j=0;
            while (j<tam){
                if (otherInts[i]==firstFive[j]){
                    while (j<tam){
                        firstFive[j]=firstFive[j+1];
                        j++;
                    }
                    flag=0;
                    tam--;
                }
                else flag=1;

                j++;
            }
            if (flag==1){
                firstFive[tam]=otherInts[i];
                tam++;
            }
            for (j=0;j<tam;j++){
                //System.out.printf("%d",firstFive[j]);
                result+= "%d ".formatted(firstFive[j]);


            }
            result=result.trim();
            result+="\n";


            //System.out.println();
            i++;
            verify--;

        }
        result=result.trim();

        if (tam>0 && tam<10 && verify==0) return "Erro";
        else return result;


        //return output;
    }
}
