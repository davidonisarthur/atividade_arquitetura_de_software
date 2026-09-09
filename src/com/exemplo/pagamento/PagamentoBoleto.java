package com.exemplo.pagamento;

import java.util.UUID;

/**
 * Implementação concreta 3 (Bônus): Processamento via Boleto Bancário.
 * Mostra como o sistema é extensível: novos métodos de pagamento podem ser adicionados
 * sem alterar nenhuma linha do componente consumidor (Princípio Aberto/Fechado - OCP).
 */
public class PagamentoBoleto implements ProcessadorPagamento {

    @Override
    public boolean processar(double valor, String identificadorPedido) {
        String linhaDigitavel = "34191.79001 01043.510047 91020.150008 5 " + UUID.randomUUID().hashCode();

        System.out.println("  [PagamentoBoleto] Gerando linha digitável: " + linhaDigitavel);
        System.out.printf("  [PagamentoBoleto] Boleto no valor de R$ %.2f gerado com vencimento para 3 dias úteis.%n", valor);

        return true;
    }

    @Override
    public String getNomeMetodo() {
        return "Boleto Bancário";
    }
}
