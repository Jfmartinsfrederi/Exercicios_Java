package Domain;

import java.util.Map;
import java.util.TreeMap;
import java.util.stream.Collectors;

public final class DeclaracaoCompleta extends Declaracao{
    private final Map<Long,Gasto> gastos;

    public DeclaracaoCompleta(long id,double ganhoTributavel, double valorPago) {
        super(id,ganhoTributavel, valorPago);
        this.gastos = new TreeMap<>();
    }

    @Override
    public double getValorImposto() {
        double[] valores={22847.88, 33919.92, 45012.73, 55976.16};
        double[] percents={0.075,0.15,0.225,0.275};
        double ganho=getGanhoTributavel();
        double valor_imposto =0;
        for (int i= valores.length-1;i>0;i--){
            if (ganho>valores[i]){
                valor_imposto +=(ganho-valores[i])*percents[i];
                ganho=valores[i];
            }

        }



        return valor_imposto;
    }

    @Override
    public double getDespesaDedutivel() {
        double saude,educacao;

        saude=Math.min(GastoSaude.DEDUCAO_MAX_SAUDE,gastos.values().stream()
                .filter(g-> g instanceof GastoSaude )
                .mapToDouble(Gasto::getValor).sum());

        educacao=Math.min(GastoEducacao.DEDUCAO_MAX_EDUCACAO,gastos.values().stream()
                .filter(g-> g instanceof GastoEducacao )
                .mapToDouble(Gasto::getValor).sum() );

        return saude+educacao;
    }

    public void addGasto(Gasto gasto){
        if (gastos.containsKey(gasto.getId())) throw new EntityAlreadyExists("Gasto já cadastrado");
        gastos.put(gasto.getId(),gasto);

    }

    public void removeGasto(Gasto gasto){
        validIdGAsto(gasto);
        gastos.remove(gasto.getId());
    }

    private void validIdGAsto(Gasto gasto) {
        if (!gastos.containsKey(gasto.getId())) throw new EntityNoExists("Gasto não cadastrado");
    }

    public void editarGasto(Gasto gasto){
        validIdGAsto(gasto);
        gastos.replace(gasto.getId(), gasto);
    }

    public void listarGastos(){
        for (Gasto gasto : gastos.values()) {
            System.out.println(gasto);
        }
    }



    @Override
    public String toString() {
        return """
                %s 
                %s
                """.formatted(super.toString(),gastos.values().stream()
                .map(Gasto::toString).collect(Collectors.joining("\n")));
    }
}
