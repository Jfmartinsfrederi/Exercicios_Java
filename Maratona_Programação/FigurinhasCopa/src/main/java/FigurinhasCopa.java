import java.util.Scanner;

public class FigurinhasCopa {
    public static void main(String[] args) {
        final Scanner scanner=new Scanner(System.in);
        int N=scanner.nextInt();
        int C=scanner.nextInt();
        int M=scanner.nextInt();
        int[] X=new int[C];
        int[] Y=new int[M];
        int i, j, result=0;
        boolean flag = false;
        for (i=0;i<X.length;i++){
            X[i]=scanner.nextInt();
            result++;
        }
        for (i=0;i<Y.length;i++){
            Y[i]=scanner.nextInt();
        }
        for (i=0;i< X.length;i++){
            for (j=0;j< Y.length;j++){
                if (X[i]==Y[j]) flag=true;
            }
            if (flag==true) result--;
            flag=false;
        }
        System.out.println(result);
    }
}
