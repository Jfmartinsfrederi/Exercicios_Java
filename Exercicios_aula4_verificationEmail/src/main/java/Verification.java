public class Verification {
    public static boolean isEmail(String email){
        int i;
        boolean flag1=false,flag2=false;
        for (i=0;i<email.length() && !flag2;i++){
            if (email.charAt(i)=='@') flag1=true;

            if (email.charAt(i)=='.'){
                if (email.substring(i).equals(".com") && flag1) flag2=true;




            }
        }


        if (flag1 && flag2) return true;
        else return false;

    }

    public static int contWord(String word, String phrase){
        int i,j,contL,contW=0;
        for (i=0;i<phrase.length();i++){
            if (word.charAt(0)==phrase.charAt(i)){
                contL=0;
                for (j=0;j<word.length() && j+i<phrase.length();j++){
                    if (word.charAt(j)==phrase.charAt(i+j)){
                        contL++;
                    }
                }
                if (contL==word.length()) contW++;
            }
        }
        return contW;


    }
    public static int contWord2(String word, String phrase){
        int cont=0;
        String[] phrases=phrase.split(" ");
        for (String s : phrases) {
            if (s.equals(word)) cont++;

        }
        return cont;
    }

}
