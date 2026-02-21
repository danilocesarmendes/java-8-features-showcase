package br.com.danilomendes.streams;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class ParallelStreamExample {

    public static void main(String[] args) {

        List<Integer> numeros = IntStream.rangeClosed(1, 10_000_000)
                .boxed()
                .toList();

        long inicio = System.currentTimeMillis();
        long count = numeros.stream()
                .filter(n -> n % 2 == 0)
                .count();
        long fim = System.currentTimeMillis();

        System.out.println("Count: " + count + " Time Streams: " + (fim - inicio));




        inicio = System.currentTimeMillis();

        count = numeros.parallelStream()
                .filter(n -> n % 2 == 0)
                .count();

        fim = System.currentTimeMillis();

        System.out.println("Count: " + count + " Time Parallel: " + (fim - inicio));

        /*
            🔥 Quando faz sentido usar?
            ✔️ Processamento pesado
            ✔️ CPU-bound
            ✔️ Grande volume de dados
            ✔️ Operações independentes
            ❌ Não usar quando:
            IO
            Banco de dados
            Estado mutável
            Operações pequenas
         */


        // Problema clássico com estado mutável (armadilha)
        List<Integer> listaA = new ArrayList<>();

        IntStream.rangeClosed(1, 1000)
                .parallel()
                .forEach(listaA::add); // PROBLEMA Isso pode gerar inconsistência.


        // Forma correta
        List<Integer> listaB =
                IntStream.rangeClosed(1, 1000)
                        .parallel()
                        .boxed()
                        .collect(Collectors.toList());


        IntStream.rangeClosed(1, 10)
                .parallel()
                .forEach(n ->
                        System.out.println("Thread parallel " + Thread.currentThread().getName())
                );

        IntStream.rangeClosed(1, 10)
                .asDoubleStream()
                .forEach(n ->
                        System.out.println("Thread streams " + Thread.currentThread().getName())
                );

    }
}
