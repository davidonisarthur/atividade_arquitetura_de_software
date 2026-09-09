package com.exemplo.pagamento;

/**
 * Classe principal de demonstração prática.
 * 
 * Demonstra como diferentes implementações da interface ProcessadorPagamento
 * podem ser utilizadas pelo consumidor ServicoCheckout sem que ele precise
 * conhecer detalhes da implementação concreta.
 */
public class Main {

    public static void main(String[] args) {
        System.out.println("#################################################################");
        System.out.println("#  DEMONSTRAÇÃO DE DESACOPLAMENTO COM INTERFACES EM JAVA       #");
        System.out.println("#################################################################\n");

        // -------------------------------------------------------------
        // Cenário 1: Cliente 1 decide pagar com PIX
        // -------------------------------------------------------------
        ProcessadorPagamento pix = new PagamentoPix("contato@lojaexemplo.com.br");
        ServicoCheckout checkoutPix = new ServicoCheckout(pix);
        checkoutPix.finalizarPedido("PED-001", 189.90);

        // -------------------------------------------------------------
        // Cenário 2: Cliente 2 decide pagar com Cartão de Crédito
        // -------------------------------------------------------------
        // Note: O ServicoCheckout continua funcionando exatamente igual,
        // recebendo outra implementação sem mudar seu próprio código!
        ProcessadorPagamento cartao = new PagamentoCartaoCredito("**** **** **** 4321", 3);
        ServicoCheckout checkoutCartao = new ServicoCheckout(cartao);
        checkoutCartao.finalizarPedido("PED-002", 750.00);

        // -------------------------------------------------------------
        // Cenário 3: Cliente 3 decide pagar com Boleto Bancário
        // -------------------------------------------------------------
        // Demonstração do Princípio Aberto/Fechado (OCP):
        // Novo método adicionado ao sistema sem alterar o ServicoCheckout existente.
        ProcessadorPagamento boleto = new PagamentoBoleto();
        ServicoCheckout checkoutBoleto = new ServicoCheckout(boleto);
        checkoutBoleto.finalizarPedido("PED-003", 45.50);
    }
}
