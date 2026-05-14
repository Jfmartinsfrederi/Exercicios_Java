package Domain;

import DAO.Entidade;

public abstract sealed class  Declaracao implements Entidade<Long> permits DeclaracaoSimplificada, DeclaracaoCompleta {
    private final long id;
    private double ganhoTributavel;
    private double valorPago;

    public Declaracao(long id, double ganhoTributavel, double valorPago) {
        this.id = id;
        this.ganhoTributavel = ganhoTributavel;
        this.valorPago = valorPago;
    }

    public final double getValorAPagar(){
        return getValorImposto()-valorPago-getDespesaDedutivel();
    }

    public double getDespesaDedutivel(){
        return 0;
    }

    public abstract double getValorImposto();

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Declaracao that = (Declaracao) o;
        return id == that.id;
    }

    @Override
    public int hashCode() {
        return Long.hashCode(id);
    }

    @Override
    public Long getId() {
        return id;
    }

    public double getGanhoTributavel() {
        return ganhoTributavel;
    }

    public double getValorPago() {
        return valorPago;
    }

    @Override
    public String toString() {
        return "Declaracao{" +
                "id=" + id +
                ", ganhoTributavel=" + ganhoTributavel +
                ", valorPago=" + valorPago +
                '}';
    }
}
