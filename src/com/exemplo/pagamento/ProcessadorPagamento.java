package com.exemplo.pagamento;

/**
 * Interface que define o contrato para processamento de pagamentos.
 * 
 * Componentes de alto nível (consumidores) devem depender apenas desta
 * abstração, sem conhecer detalhes específicos de qualquer gateway ou meio de pagamento.
 */
public interface ProcessadorPagamento {

    /**
     * Processa a cobrança de um determinado valor para um pedido.
     *
     * @param valor O montante a ser cobrado.
     * @param identificadorPedido O código identificador do pedido.
     * @return true se o pagamento foi processado com sucesso; false caso contrário.
     */
    boolean processar(double valor, String identificadorPedido);

    /**
     * Retorna o nome amigável do meio de pagamento.
     *
     * @return Nome do método de pagamento.
     */
    String getNomeMetodo();
}
