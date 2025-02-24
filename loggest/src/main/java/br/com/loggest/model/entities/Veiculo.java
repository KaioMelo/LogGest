package br.com.loggest.model.entities;


import jakarta.persistence.*;

import java.io.Serializable;
import java.util.Calendar;
import java.util.Objects;

@Entity
@Table(name = "CAD_VEICULOS")
public class   Veiculo implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(name = "MARCA")
    private String marca;
    @Column(name = "MODELO")
    private String modelo;
    @Column(name = "ANO_FABRICACAO")
    private Integer anoFabricacao;
    @Column(name = "ANO_MODELO")
    private Integer anoModelo;
    @Column(name = "NUMERO_CHASSI")
    private Integer numeroChassi;
    @Column(name = "NUMERO_MOTOR")
    private Integer numeroMotor;
    @Column(name = "COR")
    private String cor;
    @Column(name = "PLACA")
    private String placa;
    @Column(name = "PREFIXO")
    private String prefixo;
    @Column(name = "DATA_COMPRA")
    private Calendar dataDeCompra;
    @Column(name = "VALOR COMPRA")
    private Long valorDeCompra;
    @Column(name = "DATA_VENDA")
    private Calendar dataDeVenda;
    @Column(name = "VALOR_VENDA")
    private Long valorDeVenda;
    @Column(name = "FK_CAD_DOCUMENTOS_ANEXOS")
    private DocumentosAnexos documentos;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Veiculo veiculo = (Veiculo) o;
        return Objects.equals(id, veiculo.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
