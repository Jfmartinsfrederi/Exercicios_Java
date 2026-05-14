package Domain;

public final class GastoEducacao extends Gasto {
    private String nomeInstituicao;
    public static final double DEDUCAO_MAX_EDUCACAO=2000;

    public GastoEducacao(long id, String descricao, double valor, String cnpj, String nomeInstituicao) {
        super(id, descricao, valor, cnpj);
        this.nomeInstituicao = nomeInstituicao;
    }

    @Override
    public String toString() {
        return  super.toString()+
                "GastoEducacao{" +
                "nomeInstituicao='" + nomeInstituicao + '\'' +
                '}';
    }
}
