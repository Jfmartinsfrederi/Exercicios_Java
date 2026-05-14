package application;

import Domain.DeclaracaoCompleta;
import Domain.DeclaracaoSimplificada;

public class CriarDeclaracoesService {
    private final DeclaracaoRepository repo;

    public CriarDeclaracoesService(DeclaracaoRepository repo) {
        this.repo = repo;
    }
    public void criarDeclaracoes(long id,double ganhoTributavel, double valorPago){
        if(id < 0) throw new IllegalArgumentException("Id não pode ser negativo");
        if(ganhoTributavel < 0) throw new IllegalArgumentException("Ganho tributável inválido: " + ganhoTributavel);
        if(valorPago < 0) throw new IllegalArgumentException("Valor pago inválido: " + valorPago);

        final DeclaracaoCompleta declaracaoCompleta = new DeclaracaoCompleta(id, ganhoTributavel, valorPago);
        final DeclaracaoSimplificada declaracaoSimplificada = new DeclaracaoSimplificada(id+1, ganhoTributavel, valorPago);

        repo.salvar(declaracaoCompleta);
        repo.salvar(declaracaoSimplificada);
    }

}
