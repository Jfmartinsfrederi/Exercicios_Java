import Domain.FakeDeclaracaoRepository;
import application.*;

public class Main {
    void main(){
        DeclaracaoRepository repo = new FakeDeclaracaoRepository();

        final AdicionarGastoTributavelSrevice addGastoService = new AdicionarGastoTributavelSrevice(repo);
        final CriarDeclaracoesService criarDeclaracaoService = new CriarDeclaracoesService(repo);
        final CriarRelatorioDeclaracoesService relatorioService = new CriarRelatorioDeclaracoesService(repo);

        criarDeclaracaoService.criarDeclaracoes(1,50_000.0, 5_000.0);

        addGastoService.adicionarGasto(1,1, "Corote", "123", 3.59, TipoGasto.EDUCACAO, "IFSP");
        addGastoService.adicionarGasto(1,2, "Unimed", "312", 1_000.0, TipoGasto.SAUDE, "31231RDN");

        System.out.println(relatorioService.criarRelatorio(1));
    }
}
