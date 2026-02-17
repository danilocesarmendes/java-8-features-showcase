package br.com.danilomendes.interfaces;

public class PagamentoPix implements PagamentoService {

    @Override
    public void processar(double valor) {
        System.out.println("Processando PIX...");
        logTransacao(valor);
    }

    @Override
    public void logTransacao(double valor) {
        System.out.println("PIX confirmado no valor: " + valor);
    }

}
