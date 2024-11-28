package br.mil.fab.pagl.model.entities;

import br.mil.fab.pagl.model.entities.enuns.TipoProduto;

import java.io.Serializable;
import java.util.Calendar;

public class Estoque implements Serializable {
    private static final long serialVersionUID=1L;

    private Long id;
    private Calendar dataEntrada;
    private Calendar dataSaida;
    private Long numeroNf;
    private Integer ncm_sh;
    private Integer cst_csosn;
    private Integer cfop;
    private Double valorUnitario;
    private Long quantidade;
    private Double valorTotal;
    private String produto;
    private Calendar validade;
    private Calendar garantia;
    private TipoProduto tipoProduto;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Calendar getDataEntrada() {
        return dataEntrada;
    }

    public void setDataEntrada(Calendar dataEntrada) {
        this.dataEntrada = dataEntrada;
    }

    public Calendar getDataSaida() {
        return dataSaida;
    }

    public void setDataSaida(Calendar dataSaida) {
        this.dataSaida = dataSaida;
    }

    public Long getNumeroNf() {
        return numeroNf;
    }

    public void setNumeroNf(Long numeroNf) {
        this.numeroNf = numeroNf;
    }

    public Integer getNcm_sh() {
        return ncm_sh;
    }

    public void setNcm_sh(Integer ncm_sh) {
        this.ncm_sh = ncm_sh;
    }

    public Integer getCst_csosn() {
        return cst_csosn;
    }

    public void setCst_csosn(Integer cst_csosn) {
        this.cst_csosn = cst_csosn;
    }

    public Integer getCfop() {
        return cfop;
    }

    public void setCfop(Integer cfop) {
        this.cfop = cfop;
    }

    public Double getValorUnitario() {
        return valorUnitario;
    }

    public void setValorUnitario(Double valorUnitario) {
        this.valorUnitario = valorUnitario;
    }

    public Long getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(Long quantidade) {
        this.quantidade = quantidade;
    }

    public Double getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(Double valorTotal) {
        this.valorTotal = valorTotal;
    }

    public String getProduto() {
        return produto;
    }

    public void setProduto(String produto) {
        this.produto = produto;
    }

    public Calendar getValidade() {
        return validade;
    }

    public void setValidade(Calendar validade) {
        this.validade = validade;
    }

    public Calendar getGarantia() {
        return garantia;
    }

    public void setGarantia(Calendar garantia) {
        this.garantia = garantia;
    }

    public TipoProduto getTipoProduto() {
        return tipoProduto;
    }

    public void setTipoProduto(TipoProduto tipoProduto) {
        this.tipoProduto = tipoProduto;
    }
}
