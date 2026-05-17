package application;

import Domain.Declaracao;

import java.util.Optional;

public interface DeclaracaoRepository {
    void salvar(Declaracao declaracao);
    void atualizar(Declaracao declaracao);
    void remover(Declaracao declaracao);
    void remover(Long id);
    Optional<Declaracao> buscarPorId(Long id);
}
