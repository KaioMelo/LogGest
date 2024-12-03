package br.mil.fab.pagl.model.entities.enuns;

public enum TipoPessoa {
    PESSOA_FISICA("PESSOA_FISICA"), PESSOA_JURIDICA("PESSOA_JURIDICA");

    TipoPessoa(String tipoPessoa) {
        this.tipoPessoa = tipoPessoa;
    }
    private String tipoPessoa;
}
