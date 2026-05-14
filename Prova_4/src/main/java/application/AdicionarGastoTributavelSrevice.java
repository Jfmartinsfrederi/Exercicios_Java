package application;

import Domain.DeclaracaoCompleta;
import Domain.Gasto;
import Domain.GastoEducacao;
import Domain.GastoSaude;

public class AdicionarGastoTributavelSrevice {
    private final DeclaracaoRepository repo;

    public AdicionarGastoTributavelSrevice(DeclaracaoRepository repo) {
        this.repo = repo;
    }

    public void adicionarGasto(long idDeclaracao,long id, String descricao, String cnpj, double valor, TipoGasto tipo, String adicional){
        if(id < 0 || idDeclaracao<0) throw new IllegalArgumentException("Id não pode ser negativo");
        if (valor<=0) throw new IllegalArgumentException("Valor não pode ser negativo");
        final DeclaracaoCompleta declaracao= (DeclaracaoCompleta) repo.buscarPorId(idDeclaracao)
                .orElseThrow(IllegalStateException::new);
        Gasto gasto= switch (tipo){
            case SAUDE -> new GastoSaude(id,descricao,valor,cnpj,adicional);
            case EDUCACAO -> new GastoEducacao(id,descricao,valor,cnpj,adicional);
        };
        declaracao.addGasto(gasto);
        repo.atualizar(declaracao);

    }
}
