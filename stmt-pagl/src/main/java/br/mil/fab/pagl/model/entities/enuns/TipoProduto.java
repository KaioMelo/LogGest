package br.mil.fab.pagl.model.entities.enuns;

public enum TipoProduto {
    LITROS("LITROS"), PECAS("LITROS"), UNIDADE("LITROS"), CAIXA("LITROS");

    TipoProduto(String tipoProduto) {
        this.tipoProduto = tipoProduto;
    }
    private String tipoProduto;
}
