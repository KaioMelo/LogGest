package br.mil.fab.pagl.model.entities;


import java.io.Serializable;
import java.util.Calendar;
import java.util.Objects;

public class Veiculo implements Serializable {
    private static final long serialVersionUID = 1L;

    private Long id;
    private String marca;
    private String modelo;
    private Integer anoFabricacao;
    private Integer anoModelo;
    private Integer numeroChassi;
    private Integer numeroMotor;
    private String cor;
    private String placa;
    private String prefixo;
    private Calendar dataDeCompra;
    private Long valorDeCompra;
    private Calendar dataDeVenda;
    private Long valorDeVenda;
    private Documentos documentos;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public Integer getAnoFabricacao() {
        return anoFabricacao;
    }

    public void setAnoFabricacao(Integer anoFabricacao) {
        this.anoFabricacao = anoFabricacao;
    }

    public Integer getAnoModelo() {
        return anoModelo;
    }

    public void setAnoModelo(Integer anoModelo) {
        this.anoModelo = anoModelo;
    }

    public Integer getNumeroChassi() {
        return numeroChassi;
    }

    public void setNumeroChassi(Integer numeroChassi) {
        this.numeroChassi = numeroChassi;
    }

    public Integer getNumeroMotor() {
        return numeroMotor;
    }

    public void setNumeroMotor(Integer numeroMotor) {
        this.numeroMotor = numeroMotor;
    }

    public String getCor() {
        return cor;
    }

    public void setCor(String cor) {
        this.cor = cor;
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public String getPrefixo() {
        return prefixo;
    }

    public void setPrefixo(String prefixo) {
        this.prefixo = prefixo;
    }

    public Calendar getDataDeCompra() {
        return dataDeCompra;
    }

    public void setDataDeCompra(Calendar dataDeCompra) {
        this.dataDeCompra = dataDeCompra;
    }

    public Long getValorDeCompra() {
        return valorDeCompra;
    }

    public void setValorDeCompra(Long valorDeCompra) {
        this.valorDeCompra = valorDeCompra;
    }

    public Calendar getDataDeVenda() {
        return dataDeVenda;
    }

    public void setDataDeVenda(Calendar dataDeVenda) {
        this.dataDeVenda = dataDeVenda;
    }

    public Long getValorDeVenda() {
        return valorDeVenda;
    }

    public void setValorDeVenda(Long valorDeVenda) {
        this.valorDeVenda = valorDeVenda;
    }

}
