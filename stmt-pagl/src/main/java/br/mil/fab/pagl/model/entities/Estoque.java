package br.mil.fab.pagl.model.entities;

import br.mil.fab.pagl.model.entities.enuns.TipoProduto;
import jakarta.persistence.*;

import java.io.Serializable;
import java.util.Calendar;
import java.util.Objects;

@Entity
@Table(name = "CAD_ESTOQUE")
public class Estoque implements Serializable {
    private static final long serialVersionUID=1L;

    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(name = "DATA_ENTRADA")
    private Calendar dataEntrada;
    @Column(name = "DATA_SAIDA")
    private Calendar dataSaida;
    @Column(name = "NUM_NF")
    private Long numeroNf;
    @Column(name = "NCM_SH")
    private Integer ncm_sh;
    @Column(name = "CST_CSON")
    private Integer cst_csosn;
    @Column(name = "CFOP")
    private Integer cfop;
    @Column(name = "VALOR_UNITARIO")
    private Double valorUnitario;
    @Column(name = "QUANTIDADE")
    private Long quantidade;
    @Column(name = "VALOR_TOTAL")
    private Double valorTotal;
    @Column(name = "PRODUTO")
    private String produto;
    @Column(name = "DATA_VALIDADE")
    private Calendar validade;
    @Column(name = "DATA_GARANTIA")
    private Calendar garantia;
    @Column(name = "FK_TIPO_PRODUTO")
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Estoque estoque = (Estoque) o;
        return Objects.equals(id, estoque.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
