package com.exemplo.pagamento;

import java.util.UUID;

/**
 * Implementação concreta 1: Processamento via PIX.
 * Implementa o contrato definido pela interface ProcessadorPagamento.
 */
public class PagamentoPix implements ProcessadorPagamento {

    private final String chavePixDestino;

    public PagamentoPix(String chavePixDestino) {
        this.chavePixDestino = chavePixDestino;
    }

    @Override
    public boolean processar(double valor, String identificadorPedido) {
        // Lógica específica de comunicação com o Banco Central / API PIX
        String codigoTransacaoPix = "PIX-" + UUID.randomUUID().toString().substring(0, 8).toUpperCase();

        System.out.println("  [PagamentoPix] Gerando QR Code PIX para a chave: " + chavePixDestino);
        System.out.println("  [PagamentoPix] Transação registrada: " + codigoTransacaoPix);
        System.out.printf("  [PagamentoPix] Cobrança de R$ %.2f aprovada instantaneamente para o pedido %s%n", valor, identificadorPedido);

        return true;
    }

    @Override
    public String getNomeMetodo() {
        return "PIX Instantâneo";
    }
}
