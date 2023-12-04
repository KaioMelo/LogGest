package br.mil.fab.pagl.model;


import java.io.Serializable;
import java.util.Objects;

public class Veiculo implements Serializable {
    private static final long serialVersionUID = 1L;

    private Integer id_veiculo;
    private String tipo;
    private String modelo;
    private String rg_fab;
    private Integer volume;
    private String observacao;

    public Veiculo() {
    }

    public Veiculo(Integer id_veiculo, String tipo, String modelo, String rg_fab, Integer volume, String observacao) {
        this.id_veiculo = id_veiculo;
        this.tipo = tipo;
        this.modelo = modelo;
        this.rg_fab = rg_fab;
        this.volume = volume;
        this.observacao = observacao;
    }

    public Integer getId_veiculo() {
        return id_veiculo;
    }

    public void setId_veiculo(Integer id_veiculo) {
        this.id_veiculo = id_veiculo;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getRg_fab() {
        return rg_fab;
    }

    public void setRg_fab(String rg_fab) {
        this.rg_fab = rg_fab;
    }

    public Integer getVolume() {
        return volume;
    }

    public void setVolume(Integer volume) {
        this.volume = volume;
    }

    public String getObservacao() {
        return observacao;
    }

    public void setObservacao(String observacao) {
        this.observacao = observacao;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Veiculo veiculo = (Veiculo) o;
        return Objects.equals(id_veiculo, veiculo.id_veiculo);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id_veiculo);
    }
}
