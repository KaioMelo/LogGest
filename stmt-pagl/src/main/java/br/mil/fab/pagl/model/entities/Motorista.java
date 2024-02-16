package br.mil.fab.pagl.model.entities;


import java.io.Serializable;
import java.util.Objects;

public class Motorista implements Serializable {
    private static final long serialVersionUID = 1L;

    private Integer id_motorista;
    private String nome_motorista;
    private Integer cnh;
    private String om;
    private String sessao;

    public Motorista() {
    }

    public Motorista(Integer id_motorista, String nome_motorista, Integer cnh, String om, String sessao) {
        this.id_motorista = id_motorista;
        this.nome_motorista = nome_motorista;
        this.cnh = cnh;
        this.om = om;
        this.sessao = sessao;
    }

    public Integer getId_motorista() {
        return id_motorista;
    }

    public void setId_motorista(Integer id_motorista) {
        this.id_motorista = id_motorista;
    }

    public String getNome_motorista() {
        return nome_motorista;
    }

    public void setNome_motorista(String nome_motorista) {
        this.nome_motorista = nome_motorista;
    }

    public Integer getCnh() {
        return cnh;
    }

    public void setCnh(Integer cnh) {
        this.cnh = cnh;
    }

    public String getOm() {
        return om;
    }

    public void setOm(String om) {
        this.om = om;
    }

    public String getSessao() {
        return sessao;
    }

    public void setSessao(String sessao) {
        this.sessao = sessao;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Motorista motorista = (Motorista) o;
        return Objects.equals(id_motorista, motorista.id_motorista) && Objects.equals(cnh, motorista.cnh);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id_motorista, cnh);
    }
}
