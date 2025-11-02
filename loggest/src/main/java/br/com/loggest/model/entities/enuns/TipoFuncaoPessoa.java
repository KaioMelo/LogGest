package br.com.loggest.model.entities.enuns;

public enum TipoFuncaoPessoa {
    ADMINISTRADOR(1, "ADMINISTRADOR"),
    FUNCIONARIO(2, "FUNCIONARIO"),
    CLIENTE(3,"CLIENTE"),
    FORNECEDOR(4,"FORNECEDOR");

    private int id;
    private String descricao;

    TipoFuncaoPessoa(int id, String descricao) {
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
