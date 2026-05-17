package application;

import Domain.Declaracao;

public class CriarRelatorioDeclaracoesService {
    private final DeclaracaoRepository repo;

    public CriarRelatorioDeclaracoesService(DeclaracaoRepository repo) {
        this.repo = repo;
    }
    public String criarRelatorio (long id){
        if(id < 0) throw new IllegalArgumentException("Id não pode ser negativo");
        final Declaracao completa = repo.buscarPorId(id).orElseThrow(IllegalStateException::new);
        final Declaracao simplificada = repo.buscarPorId(id+1).orElseThrow(IllegalStateException::new);

        return simplificada + "\n\n" + completa;
    }
}
