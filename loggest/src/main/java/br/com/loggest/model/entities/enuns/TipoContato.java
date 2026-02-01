package br.com.loggest.model.entities.enuns;

public enum TipoContato {

    TELEFONE(1,"TELEFONE"), CELULAR(1,"CELULAR");

    private int id;
    private String descricao;

    TipoContato(int id, String descricao) {
        this.id = id;
        this.descricao = descricao;
    }

    public int getId() {
        return id;
    }

    public String getDescricao() {
        return descricao;
    }
}
