import java.util.Scanner;

public class Robo {
    static void main() {
        final Scanner scanner= new Scanner(System.in);
        int L=scanner.nextInt();
        int C =scanner.nextInt();
        int A=scanner.nextInt();
        int B =scanner.nextInt();
        int[] posicoes= {-1, 0, 0, -1, 0, 1, 1, 0};
        int i,j;

        int [][] matriz=new int[L][C];

        for (i=0;i<L;i++){
            for (j=0; j< C; j++){
                matriz[i][j]=scanner.nextInt();
            }
        }
        A--;B--;
        if (A<0 || B<0) System.out.println("Erro");
        boolean flag=true;
        while (flag){
            flag=false;
            for (i=0;i<posicoes.length-1;i+=2){
               if (A+posicoes[i]>=0 && A+posicoes[i]<L && B+posicoes[i+1]>=0 && B+posicoes[i+1]<C){
                    if (matriz[A+posicoes[i]][B+posicoes[i+1]]==1){
                        matriz[A][B]=0;
                        A=A+posicoes[i];
                        B=B+posicoes[i+1];
                        flag=true;

                    }
                }
            }

        }

        System.out.printf("%d %d\n",A+1,B+1);


    }
}
