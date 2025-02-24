package br.com.loggest.model.entities.enuns;

public enum TipoProduto {
    LITROS("LITROS"), PECAS("PECAS"), UNIDADE("UNIDADE"), CAIXA("CAIXA");

    TipoProduto(String tipoProduto) {
        this.tipoProduto = tipoProduto;
    }
    private String tipoProduto;
}
