
import java.util.Scanner;

public class Huahau {
        public static void main(String[] args) {
            final Scanner scanner=new Scanner(System.in);
            String palavra=scanner.nextLine();
            String vogais= "aeiou";
            StringBuilder apenasVogal= new StringBuilder();
            StringBuilder palindromo=new StringBuilder();
            int i,j;
            for (i=0;i<palavra.length();i++){
                for (j=0;j<vogais.length();j++){
                    if (palavra.charAt(i)==vogais.charAt(j)){
                        apenasVogal.append(palavra.charAt(i));

                    }
                }
            }


            String apenasVogalF=apenasVogal.toString();
            for (i=apenasVogalF.length()-1;i>=0;i--){
                palindromo.append(apenasVogalF.charAt(i));

            }
            String palindromoF=palindromo.toString();


            if (apenasVogalF.equals(palindromoF)) {
                System.out.println("S");
            }
            else {
                System.out.println("N");
            }
        }
    }

