package br.com.bruno.simulador.model;

import br.com.bruno.simulador.exception.ErroNaParcelaException;

import java.math.BigDecimal;

public enum FormaPagamento {

    /*TAXA MDR 1,75%(0.0175)*/
    DEBITO{
        @Override
        public BigDecimal calculoJuros(BigDecimal valorSimulado, int parcelaDaVenda) throws ErroNaParcelaException {
            if(parcelaDaVenda != 1){
                throw new ErroNaParcelaException("Compras no débito, não podem ser parceladas");
            }
            BigDecimal valorCobrado = valorSimulado.multiply(taxaMdrDebito);
            return valorSimulado.subtract(valorCobrado);
        }
        /*TAXA DE MDR 3,19%(0.0319)  E TAXA F2 1,99(0.0199) EM CADA PARCELA A PARTIR DA SEGUNDA PARCELA */
    }, CREDITOSJUROS{
        @Override
        public BigDecimal calculoJuros(BigDecimal valorSimulado, int parcelaDaVenda) {
            if(parcelaDaVenda == 1){
                BigDecimal valorCobrado =  valorSimulado.multiply(taxaMdrCreditoSJuros);
                return valorSimulado.subtract(valorCobrado);
            }
            return calcula(valorSimulado, parcelaDaVenda,taxaMdrCreditoSJuros,taxaF2CreditoSJuros);
        }
        /*TAXA DE MDR 1,79%(0.0179) E TAXA F2 2,59(0.0259) EM CADA PARCELA A PARTIR DA SEGUNDA PARCELA */
    }, CREDITOCJUROS{
        @Override
        public BigDecimal calculoJuros(BigDecimal valorSimulado, int parcelaDaVenda) {
            if(parcelaDaVenda == 1){
                BigDecimal valorCobrado =  valorSimulado.multiply(taxaMdrCreditoCJuros);
                return valorSimulado.subtract(valorCobrado);
            }
            return calcula(valorSimulado, parcelaDaVenda,taxaMdrCreditoCJuros,taxaF2CreditoCJuros);
        }
    };

    private static BigDecimal calcula(BigDecimal valorSimulado, int parcelaDaVenda,BigDecimal taxaMdr, BigDecimal taxaF2) {
        BigDecimal calculaTaxaF2 = taxaMdr.multiply(BigDecimal.valueOf(parcelaDaVenda));
        BigDecimal totalDasTaxas = taxaF2.add(calculaTaxaF2);
        BigDecimal valorCobrado = valorSimulado.multiply(totalDasTaxas);
        return valorSimulado.subtract(valorCobrado);
    }

    private static BigDecimal taxaMdrDebito = BigDecimal.valueOf(0.0175);
    private static BigDecimal taxaMdrCreditoSJuros = BigDecimal.valueOf(0.0319);
    private static BigDecimal taxaMdrCreditoCJuros = BigDecimal.valueOf(0.0329);
    private static BigDecimal taxaF2CreditoSJuros =BigDecimal.valueOf(0.0199);
    private static BigDecimal taxaF2CreditoCJuros = BigDecimal.valueOf(0.0259);

    public abstract BigDecimal calculoJuros(BigDecimal valorSimulado, int parcelaDaVenda) throws ErroNaParcelaException;

}
