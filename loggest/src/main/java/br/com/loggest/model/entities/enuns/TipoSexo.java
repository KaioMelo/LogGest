package br.com.loggest.model.entities.enuns;

public enum TipoSexo {

    MASCULINO(1, "M"),
    FEMININO(2, "F");

    private int id;
    private String descricao;

    TipoSexo(int id, String descricao) {
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
