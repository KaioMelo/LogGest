package br.mil.fab.pagl.model;


import java.io.Serializable;
import java.util.Objects;

public class Veiculo implements Serializable {
    private static final long serialVersionUID = 1L;

    private Integer id_veiculo;
    private String rg_fab;
    private String placa;
    private String marca;
    private String modelo;

    public Veiculo() {
    }

    public Veiculo(Integer id_veiculo, String rg_fab, String placa, String marca, String modelo) {
        this.id_veiculo = id_veiculo;
        this.rg_fab = rg_fab;
        this.placa = placa;
        this.marca = marca;
        this.modelo = modelo;
    }

    public Integer getId_veiculo() {
        return id_veiculo;
    }

    public void setId_veiculo(Integer id_veiculo) {
        this.id_veiculo = id_veiculo;
    }

    public String getRg_fab() {
        return rg_fab;
    }

    public void setRg_fab(String rg_fab) {
        this.rg_fab = rg_fab;
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
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
