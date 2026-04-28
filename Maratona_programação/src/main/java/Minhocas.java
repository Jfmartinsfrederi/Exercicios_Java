import java.util.Scanner;

public class Minhocas {
    public static void main(String[] args) {
        final Scanner scanner= new Scanner(System.in);
        int N=scanner.nextInt();
        int M=scanner.nextInt();
        int i,j,maior=0,soma;

        int [][] matriz=new int[N][M];

        for (i=0;i<N;i++){
            for (j=0;j<M;j++){
                matriz[i][j]=scanner.nextInt();
            }
        }
        for (i=0;i<N;i++){
            soma=0;
            for (j=0;j<M;j++){
                soma+=matriz[i][j];
            }
            if (soma>maior) maior=soma;
        }
        for (j=0;j<M;j++){
            soma=0;
            for (i=0;i<N;i++){
                soma+=matriz[i][j];
            }
            if (soma>maior) maior=soma;
        }
        System.out.println(maior);
    }
}