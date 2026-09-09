package com.exemplo.pagamento;

/**
 * Componente Consumidor: ServicoCheckout.
 * 
 * REQUISITO FUNDAMENTAL:
 * Esta classe depende EXCLUSIVAMENTE da interface 'ProcessadorPagamento'.
 * Ela não possui nenhum acoplamento com classes concretas como PagamentoPix,
 * PagamentoCartaoCredito ou PagamentoBoleto.
 * 
 * O meio de pagamento específico é fornecido externamente via Injeção de Dependência
 * (no construtor ou no método setter).
 */
public class ServicoCheckout {

    private final ProcessadorPagamento processadorPagamento;

    /**
     * Injeção de Dependência via Construtor.
     * 
     * @param processadorPagamento Qualquer implementação válida da interface ProcessadorPagamento.
     */
    public ServicoCheckout(ProcessadorPagamento processadorPagamento) {
        if (processadorPagamento == null) {
            throw new IllegalArgumentException("O processador de pagamento não pode ser nulo.");
        }
        this.processadorPagamento = processadorPagamento;
    }

    /**
     * Finaliza o pedido de compra.
     * Note que este método não sabe COMO o pagamento é processado, apenas confia
     * que o objeto que implementa a interface cumprirá o contrato #processar(valor, id).
     *
     * @param idPedido Identificador do pedido
     * @param valorTotal Valor total da compra
     */
    public void finalizarPedido(String idPedido, double valorTotal) {
        System.out.println("=================================================================");
        System.out.println(">> Iniciando Checkout do Pedido: " + idPedido);
        System.out.printf(">> Valor Total: R$ %.2f%n", valorTotal);
        System.out.println(">> Método Selecionado: " + processadorPagamento.getNomeMetodo());

        // Chamada polimórfica ao contrato da interface
        boolean sucesso = processadorPagamento.processar(valorTotal, idPedido);

        if (sucesso) {
            System.out.println(">> STATUS: Pedido " + idPedido + " finalizado e confirmado com sucesso!");
        } else {
            System.err.println(">> STATUS: Falha ao processar pagamento do pedido " + idPedido);
        }
        System.out.println("=================================================================\n");
    }
}
