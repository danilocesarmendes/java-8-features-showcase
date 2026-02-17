package br.com.danilomendes.streams;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Pedido {

    private String cliente;
    private List<String> produtos;
    private BigDecimal valor;
    private boolean pago;

    public Pedido(String cliente, List<String> produtos, BigDecimal valor, boolean pago) {
        this.cliente = cliente;
        this.produtos = produtos;
        this.valor = valor;
        this.pago = pago;
    }

    public String getCliente() {
        return cliente;
    }

    public List<String> getProdutos() {
        return produtos;
    }

    public BigDecimal getValor() {
        return valor;
    }

    public boolean isPago() {
        return pago;
    }


    public static void main(String[] args) {

        List<Pedido> pedidos = List.of(
                new Pedido("Danilo", List.of("Notebook", "Mouse"), new BigDecimal("5000"), true),
                new Pedido("Maria", List.of("Teclado"), new BigDecimal("300"), false),
                new Pedido("João", List.of("Monitor", "Cabo HDMI"), new BigDecimal("1200"), true),
                new Pedido("Danilo", List.of("Headset"), new BigDecimal("800"), false)
        );

        //Filtro
        List<Pedido> pagos = pedidos.stream()
                .filter(Pedido::isPago)
                .toList();
        pagos.forEach(p -> System.out.println(p.getCliente()));

        System.out.println("===================================");

        //Map
        List<String> clientes = pedidos.stream()
                .map(Pedido::getCliente)
                .toList();

        clientes.forEach(System.out::println);
        System.out.println("===================================");

        List<String> todosProdutos = pedidos.stream()
                .flatMap(p -> p.getProdutos().stream())
                .toList();

        todosProdutos.forEach(System.out::println);
        System.out.println("===================================");


        BigDecimal total = pedidos.stream()
                .map(Pedido::getValor)
                .reduce(BigDecimal.ZERO, BigDecimal::add);

        System.out.println("Total: " + total);
        System.out.println("===================================");


        Map<String, List<Pedido>> pedidosPorCliente =
                pedidos.stream()
                        .collect(Collectors.groupingBy(Pedido::getCliente));

        pedidosPorCliente.forEach((cliente, lista) ->
                System.out.println(cliente + " -> " + lista.size()));
        System.out.println("===================================");


        Map<String, Long> quantidadePorCliente =
                pedidos.stream()
                        .collect(Collectors.groupingBy(
                                Pedido::getCliente,
                                Collectors.counting()
                        ));
        System.out.println("===================================");

        Map<Boolean, List<Pedido>> particionado =
                pedidos.stream()
                        .collect(Collectors.partitioningBy(Pedido::isPago));

        System.out.println("Pagos: " + particionado.get(true).size());
        System.out.println("Não pagos: " + particionado.get(false).size());
        System.out.println("===================================");

        Map<String, BigDecimal> totalPagoPorCliente =
                pedidos.stream()
                        .filter(Pedido::isPago)
                        .collect(Collectors.groupingBy(
                                Pedido::getCliente,
                                Collectors.mapping(
                                        Pedido::getValor,
                                        Collectors.reducing(BigDecimal.ZERO, BigDecimal::add)
                                )
                        ));

        totalPagoPorCliente.forEach((cliente, totalPago) ->
                System.out.println(cliente + " pagou " + totalPago));


    }
}

