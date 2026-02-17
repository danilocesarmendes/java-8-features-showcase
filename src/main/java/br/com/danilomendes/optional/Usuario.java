package br.com.danilomendes.optional;

import java.util.Optional;

public class Usuario {
    private Endereco endereco;

    public Usuario(Endereco endereco) {
        this.endereco = endereco;
    }

    public Optional<Endereco> getEndereco() {
        return Optional.ofNullable(endereco);
    }
}
