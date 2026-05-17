import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Period;

public class Main {
    static void main(String[] args) {

        long inicio = System.nanoTime();
        System.out.println(Verification.contWord("carro","eu gosto de carro"));
        System.out.println(Verification.contWord("carro","eu gosto de carrocarro"));
        System.out.println(Verification.contWord("carro","eu gosto de carro carro"));
        System.out.println(Verification.contWord("carro","eu gosto de carr"));
        System.out.println(Verification.contWord2("carro","eu gosto de carro"));
        System.out.println(Verification.contWord2("carro","eu gosto de carrocarro"));
        System.out.println(Verification.contWord2("carro","eu gosto de carro carro"));
        System.out.println(Verification.contWord2("carro","eu gosto de carr"));
        System.out.println(Verification.contWord2("carro","eu gosto de carro"));
        System.out.println(Verification.contWord2("carro","eu gosto de carrocarro"));
        System.out.println(Verification.contWord2("carro","eu gosto de carro carro"));
        System.out.println(Verification.contWord2("carro","eu gosto de carr"));
        long fim = System.nanoTime();
        System.out.println(fim-inicio);
        System.out.println();
        inicio = System.nanoTime();
        System.out.println(Verification.contWord("carro","eu gosto de carro"));
        System.out.println(Verification.contWord("carro","eu gosto de carrocarro"));
        System.out.println(Verification.contWord("carro","eu gosto de carro carro"));
        System.out.println(Verification.contWord("carro","eu gosto de carr"));
        System.out.println(Verification.contWord2("carro","eu gosto de carro"));
        System.out.println(Verification.contWord2("carro","eu gosto de carrocarro"));
        System.out.println(Verification.contWord2("carro","eu gosto de carro carro"));
        System.out.println(Verification.contWord2("carro","eu gosto de carr"));
        System.out.println(Verification.contWord2("carro","eu gosto de carro"));
        System.out.println(Verification.contWord2("carro","eu gosto de carrocarro"));
        System.out.println(Verification.contWord2("carro","eu gosto de carro carro"));
        System.out.println(Verification.contWord2("carro","eu gosto de carr"));
        fim = System.nanoTime();
        System.out.println(fim-inicio);


    }
}
