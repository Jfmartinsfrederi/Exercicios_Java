public class NamingConventions {
    public enum Conventions {CLASS,VARIABLE,METHOD,CONSTANT}
    public static boolean isFollowingConvention(String phrase, Conventions convention){
        int i;
        switch (convention){
            case CLASS, METHOD:
                if (Character.isLowerCase(phrase.charAt(0))) return false;
                for (i=0; i < phrase.length(); i++) {
                     if (phrase.charAt(i)=='_') return false;

                }
                return true;
            case CONSTANT:
                for (i=0;i<phrase.length();i++){
                    if (Character.isLowerCase(phrase.charAt(i))) return false;
                }
                return true;
            case VARIABLE:
                if (Character.isUpperCase(phrase.charAt(0))) return false;
                for (i=0; i < phrase.length(); i++) {
                    if (phrase.charAt(i)=='_') return false;

                }
                return true;
            case null, default: return false;

        }
    }
  public static String  fromConstToVariable(String phrase){
        if (!NamingConventions.isFollowingConvention(phrase,Conventions.CONSTANT)) return "";
        StringBuilder builder= new StringBuilder(phrase.toLowerCase());
      for (int i = 0; i < builder.length(); i++) {

          if (builder.charAt(i)=='_'){
              builder.deleteCharAt(i);
             if (i+1<builder.length()){
                 builder.insert(i,Character.toUpperCase(builder.charAt(i)));
                 builder.deleteCharAt(i+1);

             }
          }


      }
      return builder.toString();
  }
    public static String fromVariableToConst(String phrase){
        if (!isFollowingConvention(phrase,Conventions.VARIABLE)) return "";
        StringBuilder builder= new StringBuilder(phrase);
        for (int i = 0; i < builder.length(); i++) {

            if (Character.isUpperCase(builder.charAt(i))){

                if (i+1<builder.length()){
                    builder.insert(i,'_');
                    i++;


                }
            }
        }
        return builder.toString().toUpperCase();
    }
    public static boolean isValidJavaIdentifier(String phrase){
        if (Character.isDigit(phrase.charAt(0))) return false;
        for (int i = 0; i < phrase.length(); i++) {
            if (phrase.charAt(i)==' ') return false;

        }
        return true;

    }


}
