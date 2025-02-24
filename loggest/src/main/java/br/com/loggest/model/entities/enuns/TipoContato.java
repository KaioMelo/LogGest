package br.com.loggest.model.entities.enuns;

public enum TipoContato {

    TELEFONE("TELEFONE"), CELULAR("CELULAR");

    TipoContato(String tipoContato) {this.tipoContato = tipoContato;}
    private String tipoContato;
}
