public class Main {
    static void main(String[] args) {
        System.out.println(NamingConventions.isFollowingConvention("idadeUsuario", NamingConventions.Conventions.VARIABLE));
        System.out.println(NamingConventions.isFollowingConvention("IdadeUsuario", NamingConventions.Conventions.VARIABLE));
        System.out.println(NamingConventions.isFollowingConvention("idade_usuario", NamingConventions.Conventions.VARIABLE));

        System.out.println(NamingConventions.isFollowingConvention("MAX_SIZE", NamingConventions.Conventions.CONSTANT));
        System.out.println(NamingConventions.isFollowingConvention("max_size", NamingConventions.Conventions.CONSTANT));
        System.out.println(NamingConventions.isFollowingConvention("MAX_SiZE", NamingConventions.Conventions.CONSTANT));

        System.out.println(NamingConventions.isFollowingConvention("Usuario", NamingConventions.Conventions.CLASS));
        System.out.println(NamingConventions.isFollowingConvention("usuario", NamingConventions.Conventions.CLASS));
        System.out.println(NamingConventions.isFollowingConvention("UsuarioSistema", NamingConventions.Conventions.CLASS));
        System.out.println(NamingConventions.isFollowingConvention("Usuario_sistema", NamingConventions.Conventions.CLASS));

        System.out.println(NamingConventions.fromConstToVariable("MAX_SIZE"));
        System.out.println(NamingConventions.fromConstToVariable("TOTAL_VALOR"));
        System.out.println(NamingConventions.fromConstToVariable("A"));
        System.out.println(NamingConventions.fromConstToVariable("MAX"));
        System.out.println(NamingConventions.fromConstToVariable("VALOR_TOTAL_COMPRA"));
        System.out.println(NamingConventions.fromConstToVariable("MAX_SIZE_MAX_SIZE"));

        System.out.println(NamingConventions.fromVariableToConst("maxSize"));
        System.out.println(NamingConventions.fromVariableToConst("totalValor"));
        System.out.println(NamingConventions.fromVariableToConst("a"));
        System.out.println(NamingConventions.fromVariableToConst("valorTotalCompra"));
        System.out.println(NamingConventions.fromVariableToConst("valor1Total"));
        System.out.println(NamingConventions.fromVariableToConst("contSpace"));

        System.out.println(NamingConventions.isValidJavaIdentifier("idade"));
        System.out.println(NamingConventions.isValidJavaIdentifier("_valor"));
        System.out.println(NamingConventions.isValidJavaIdentifier("$total"));
        System.out.println(NamingConventions.isValidJavaIdentifier("valor1"));

        System.out.println(NamingConventions.isValidJavaIdentifier("1valor"));
        System.out.println(NamingConventions.isValidJavaIdentifier("valor total"));
        System.out.println(NamingConventions.isValidJavaIdentifier("valor-total"));
        System.out.println(NamingConventions.isValidJavaIdentifier("@valor"));
        System.out.println(NamingConventions.isValidJavaIdentifier("class"));









    }
}
