package br.com.danilomendes.interfaces;

public class PagamentoCartao implements PagamentoService {

    @Override
    public void processar(double valor) {
        System.out.println("Processando pagamento no cartão...");
        logTransacao(valor);
    }
}
