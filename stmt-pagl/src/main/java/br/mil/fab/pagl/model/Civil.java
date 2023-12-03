package br.mil.fab.pagl.model;

import jakarta.persistence.Entity;

@Entity
public class Civil extends Motorista{
    private String nome_civil;
    private Integer rg;
    private String empresa;

    public Civil() {
    }

    public Civil(Integer id_motorista, Integer cnh, String nome_civil, Integer rg, String empresa) {
        super(id_motorista, cnh);
        this.nome_civil = nome_civil;
        this.rg = rg;
        this.empresa = empresa;
    }

    public String getNome_civil() {
        return nome_civil;
    }

    public void setNome_civil(String nome_civil) {
        this.nome_civil = nome_civil;
    }

    public Integer getRg() {
        return rg;
    }

    public void setRg(Integer rg) {
        this.rg = rg;
    }

    public String getEmpresa() {
        return empresa;
    }

    public void setEmpresa(String empresa) {
        this.empresa = empresa;
    }
}
