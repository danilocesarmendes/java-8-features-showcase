package br.com.danilomendes.interfaces;

public class Pagamento {

    public static void  main(String[] args) {
        PagamentoService pagamento = new PagamentoCartao();
        pagamento.processar(500);


        PagamentoService pagamentoPix = new PagamentoPix();
        pagamentoPix.processar(400);
    }
}
