package br.com.danilomendes.interfaces;

public interface PagamentoService {

    void processar(double valor);

    default void logTransacao(double valor) {
        System.out.println("Transação processada no valor de: " + valor);
    }

}
