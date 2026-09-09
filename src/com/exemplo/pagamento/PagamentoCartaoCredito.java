package com.exemplo.pagamento;

import java.util.UUID;

/**
 * Implementação concreta 2: Processamento via Cartão de Crédito.
 * Implementa o contrato definido pela interface ProcessadorPagamento.
 */
public class PagamentoCartaoCredito implements ProcessadorPagamento {

    private final String numeroCartaoMascarado;
    private final int parcelas;

    public PagamentoCartaoCredito(String numeroCartaoMascarado, int parcelas) {
        this.numeroCartaoMascarado = numeroCartaoMascarado;
        this.parcelas = Math.max(1, parcelas);
    }

    @Override
    public boolean processar(double valor, String identificadorPedido) {
        // Lógica específica de operadora de cartão de crédito (antifraude, adquirente)
        String autorizacao = "AUTH-CC-" + UUID.randomUUID().toString().substring(0, 8).toUpperCase();

        System.out.println("  [PagamentoCartaoCredito] Comunicando com a adquirente do cartão final " + numeroCartaoMascarado);
        System.out.println("  [PagamentoCartaoCredito] Análise de risco/antifraude: APROVADO");
        System.out.printf("  [PagamentoCartaoCredito] Transação de R$ %.2f parcelada em %dx de R$ %.2f%n",
                valor, parcelas, (valor / parcelas));
        System.out.println("  [PagamentoCartaoCredito] Código de autorização: " + autorizacao);

        return true;
    }

    @Override
    public String getNomeMetodo() {
        return "Cartão de Crédito (" + parcelas + "x)";
    }
}
