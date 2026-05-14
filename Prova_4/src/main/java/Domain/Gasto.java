package Domain;

import java.util.Objects;

public abstract sealed class Gasto permits GastoSaude, GastoEducacao {
    private long id;
    private String descricao;
    private double valor;
    private String cnpj;

    public Gasto(long id, String descricao, double valor, String cnpj) {
        if (!isValidGasto(id,descricao,valor,cnpj)) return;
        this.id = id;
        this.descricao = descricao;
        this.valor = valor;
        this.cnpj = cnpj;

    }

    private boolean isValidGasto(long id, String descricao, double valor, String cnpj) {
        if (valor<=0) throw new RuntimeException("values must be grather than 0");
        if (descricao.isBlank() || cnpj.isBlank()) throw new RuntimeException("values ust be not blank");
        return true;
    }


    public long getId() {
        return id;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Gasto gasto = (Gasto) o;
        return id == gasto.id;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }

    @Override
    public String toString() {
        return "Gasto{" +
                "id=" + id +
                ", descricao='" + descricao + '\'' +
                ", valor=" + valor +
                ", cnpj='" + cnpj + '\'' +
                '}';
    }

    public String getDescricao() {
        return descricao;
    }

    public double getValor() {
        return valor;
    }

    public String getCnpj() {
        return cnpj;
    }
}
