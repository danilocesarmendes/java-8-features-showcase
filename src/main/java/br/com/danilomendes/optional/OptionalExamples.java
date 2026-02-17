package br.com.danilomendes.optional;

import java.util.Optional;

public class OptionalExamples {

    public static void main(String[] args) {
        Optional<Usuario> usuario = Optional.of(new Usuario(new Endereco("Franca")));

        usuario
                .flatMap(Usuario::getEndereco)
                .map(Endereco::getCidade)
                .ifPresent(System.out::println);



        Optional<String> email = Optional.of("danilo@");
        String dominio = email
                .map(e -> e.split("@")[1])
                .orElse("dominio desconhecido");
        System.out.println(dominio);




    }


}
